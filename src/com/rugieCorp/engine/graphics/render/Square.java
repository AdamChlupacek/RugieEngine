package com.rugieCorp.engine.graphics.render;



import com.rugieCorp.engine.util.ResourceLoader;
import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;

/**
 * User: Rugnarog the Mighty!
 * Date: 10/29/13
 * Time: 1:27 PM
 */
public class Square {

    private float sx;
    private float sy;

    private float tPosX;
    private float tPosY;
    private float tMoveX;
    private float tMoveY;

    private Texture texture = ResourceLoader.loadTexture("baseTex");

    public Square(float sx, float sy) {
        this.sx = sx;
        this.sy = sy;

        this.tPosX = 0;
        this.tPosY = 0;
        this.tMoveX = 1;
        this.tMoveY = 1;
    }

    public void render(){
        texture.bind();


        glColor4f(1f,1f,1f,1f);

        glBegin(GL_QUADS);
        {
            glTexCoord2f(tPosX, tPosY + tMoveY);            glVertex2f(0,0);
            glTexCoord2f(tPosX + tMoveX, tPosY + tMoveY);   glVertex2f(sx,0);
            glTexCoord2f(tPosX + tMoveX, tPosY);            glVertex2f(sx,sy);
            glTexCoord2f(tPosX, tPosY);                     glVertex2f(0,sy);

        }
        glEnd();
    }

    public void setTexture(Texture texture){
        setTexture(texture,0,0,1,1);
    }

    public void setTexture(Texture texture, float tPosX, float tPosY, float tMoveX, float tMoveY) {
        this.texture = texture;

        this.tPosX = tPosX;
        this.tPosY = tPosY;
        this.tMoveX = tMoveX;
        this.tMoveY = tMoveY;

    }

    public void setTextureCoor(float[] coor){
        this.tPosX = coor[0];
        this.tPosY = coor[1];
        this.tMoveX = coor[2];
        this.tMoveY = coor[3];
    }

    public void setSx(float sx){
        this.sx = sx;
    }
}
