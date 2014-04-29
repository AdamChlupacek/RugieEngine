package com.rugieCorp.engine.gameobject.component;

import com.rugieCorp.engine.Input;
import com.rugieCorp.engine.graphics.render.Square;
import com.rugieCorp.engine.util.dt.Vector2i;
import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;

/**
 * User: Adam Chlupacek
 * Date: 19/04/14
 * Time: 14:12
 * Package: com.rugieCorp.engine.gameobject.component
 */
public class RectangleRender extends GameComponent {

    private Square square;

    public RectangleRender(String name) {
        super(name);
    }

    public RectangleRender() {
        this("rectangleRender");
    }

    @Override
    public void updateDep(){
        square = new Square(parent.getSize().getX(),parent.getSize().getY());
    }

    @Override
    public void render(){
        glPushMatrix();
        {
            glTranslatef(parent.getPosition().getX(),parent.getPosition().getY(),0);
            square.render();
        }
        glPopMatrix();
    }

    public void setTexture(Texture texture){
        setTexture(texture,0,0,1,1);
    }

    public void setTexture(Texture texture, float tx, float ty, float mx, float my){
        square.setTexture(texture,tx,ty,mx,my);
    }

}
