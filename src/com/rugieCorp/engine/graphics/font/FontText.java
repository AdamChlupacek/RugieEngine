package com.rugieCorp.engine.graphics.font;


import com.rugieCorp.engine.gameobject.Transform;
import com.rugieCorp.engine.graphics.Material;
import com.rugieCorp.engine.graphics.Mesh;
import com.rugieCorp.engine.graphics.Vertex;
import com.rugieCorp.engine.graphics.shader.FontShader;
import com.rugieCorp.engine.util.dt.Vector2f;
import com.rugieCorp.engine.util.dt.Vector3f;
import org.lwjgl.opengl.Display;


/**
 * User: Adam Chlupacek
 * Date: 04/05/14
 * Time: 23:53
 * Package: com.rugieCorp.engine.graphics.font
 */
public class FontText {

    private BitmapFont font;
    private int size;
    private String text;
    private Mesh mesh;

    private Transform transform;

    public FontText(BitmapFont font, int size) {
        this.font = font;
        this.size = size;

        this.transform = new Transform();
        this.transform.setScale((float)size/ Display.getWidth(),(float)size/Display.getHeight(),0);
        text = "place holder";
    }

    public void setText(String text){
        if (!this.text.equals(text)){
            this.text = text;
            recreateMesh();
        }
    }

    private void recreateMesh() {

        Vertex[] vertexes = new Vertex[text.length() * 4];
        int[] indices = new int[6 * text.length()];


        float lastX = 0;

        for(int i=0; i<text.length(); i++){
            Glyph glyph = font.getGlyph((int)text.charAt(i));

            vertexes[0 + i*4] = new Vertex(new Vector3f(lastX -(float)glyph.getOffX()/size,-(float)glyph.getOffY()/size,0),                                                         new Vector2f((float)glyph.getX()/512,(float)(glyph.getY() + glyph.getYs())/512));
            vertexes[1 + i*4] = new Vertex(new Vector3f(lastX -(float)glyph.getOffX()/size,(float)glyph.getYs()/size -(float)glyph.getOffY()/size,0),                                 new Vector2f((float)glyph.getX()/512,(float)glyph.getY()/512));
            vertexes[2 + i*4] = new Vertex(new Vector3f((float)glyph.getXs()/size + lastX -(float)glyph.getOffX()/size,(float)glyph.getYs()/size -(float)glyph.getOffY()/size,0),     new Vector2f((float)(glyph.getX() + glyph.getXs())/512, (float)glyph.getY()/512));
            vertexes[3 + i*4] = new Vertex(new Vector3f((float)glyph.getXs()/size + lastX -(float)glyph.getOffX()/size,-(float)glyph.getOffY()/size,0),                             new Vector2f((float)(glyph.getX() + glyph.getXs())/512, (float)(glyph.getY() + glyph.getYs())/512));

            indices[0 + i*6] = 0 + i*4;
            indices[1 + i*6] = 3 + i*4;
            indices[2 + i*6] = 2 + i*4;
            indices[3 + i*6] = 2 + i*4;
            indices[4 + i*6] = 1 + i*4;
            indices[5 + i*6] = 0 + i*4;

            lastX += (float)glyph.getAdvX()/size;

        }

        this.mesh = new Mesh(vertexes,indices);
    }

    public void draw(float x, float y){
        transform.setTranslation(x,y,0);
        FontShader.getInstance().bind();
        FontShader.getInstance().updateUniforms(transform,new Material(font.getTexture(),new Vector3f(1,1,1)));

        mesh.draw();
    }
}
