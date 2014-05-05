package com.rugieCorp.engine.gameobject.component;

import com.rugieCorp.engine.graphics.Material;
import com.rugieCorp.engine.graphics.Mesh;
import com.rugieCorp.engine.graphics.Vertex;
import com.rugieCorp.engine.graphics.shader.BasicShader;
import com.rugieCorp.engine.graphics.shader.Shader;
import com.rugieCorp.engine.util.dt.Vector2f;
import com.rugieCorp.engine.util.dt.Vector3f;
import org.newdawn.slick.opengl.Texture;

/**
 * User: Adam Chlupacek
 * Date: 19/04/14
 * Time: 14:12
 * Package: com.rugieCorp.engine.gameobject.component
 */
public class RectangleRender extends GameComponent {

    private Mesh mesh;
    private Material material;

    private Shader shader = BasicShader.getInstance();

    public RectangleRender(Material material) {
        super("rectangleRender");

        this.material = material;

        Vertex[] vertexes = new Vertex[]{
                new Vertex(new Vector3f(0,0,0),new Vector2f(0,1)),
                new Vertex(new Vector3f(1,0,0),new Vector2f(1,1)),
                new Vertex(new Vector3f(1,1,0),new Vector2f(1,0)),
                new Vertex(new Vector3f(0,1,0),new Vector2f(0,0))
        };

        int[] indices = new int[]{
                0,1,2,
                2,3,0
        };

        this.mesh = new Mesh(vertexes,indices);
    }

    @Override
    public void init(){
    }

    @Override
    public void render(){
        shader.bind();
        shader.updateUniforms(getParent().getTransform(),material);

        mesh.draw();
    }

    public void setTexture(Texture texture){
        material.setTexture(texture);
    }

}
