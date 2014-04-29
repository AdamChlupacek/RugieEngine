package com.rugieCorp.engine.graphics.GUI;

import com.rugieCorp.engine.graphics.render.Text;
import com.rugieCorp.engine.util.dt.Vector2f;
import org.newdawn.slick.Color;

import static org.lwjgl.opengl.GL11.*;

/**
 * User: Adam Chlupacek
 * Date: 26/04/14
 * Time: 18:43
 * Package: com.rugieCorp.engine.graphics.GUI
 */
public class GUILabel extends GUI {

    private Text text;
    private String content;

    public GUILabel(String id, Vector2f position, Vector2f size, String text) {
        super(id, position, size);

        this.text = new Text();
        this.text.setSlickColor(Color.white);
        this.text.setTextOffset(new Vector2f(10, -getSize().getY()));

        this.content = text;
    }

    @Override
    public void render() {
        glPushMatrix();
        {
            glTranslatef(getPosition().getX(),getPosition().getY(),0);
            text.render(content);
        }
        glPopMatrix();
    }

    public void setText(String text) {
        this.content = text;
    }

    public void setFont(String key){
        text.setFont(key);
    }

    public void setColor(Color color) {
        text.setSlickColor(color);
    }
}
