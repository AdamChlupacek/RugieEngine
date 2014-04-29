package com.rugieCorp.engine.graphics.render;

import com.rugieCorp.engine.error.RugieError;
import com.rugieCorp.engine.util.FontLoader;
import com.rugieCorp.engine.util.dt.Vector2f;
import org.newdawn.slick.*;
import org.newdawn.slick.util.ResourceLoader;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.util.Map;

import static org.lwjgl.opengl.GL11.*;

/**
 * User: Adam Chlupacek
 * Date: 26/04/14
 * Time: 18:24
 * Package: com.rugieCorp.engine.graphics.render
 */
public class Text {

    private TrueTypeFont font;

    private Vector2f textOffset;
    private org.newdawn.slick.Color slickColor;

    public Text() {

        this.slickColor = org.newdawn.slick.Color.white;

        this.textOffset = new Vector2f(5,5);

        this.font = FontLoader.fonts.get("arial24");
    }

    public void render(String text){
        glPushMatrix();
        {
            glRotatef(180, 1, 0, 0);
            font.drawString(textOffset.getX(), textOffset.getY(), text, slickColor);
        }
        glPopMatrix();
    }

    public void setSlickColor(org.newdawn.slick.Color slickColor) {
        this.slickColor = slickColor;
    }

    public void setTextOffset(Vector2f textOffset) {
        this.textOffset = textOffset;
    }

    public int getTextWidth(String text){
        return font.getWidth(text);
    }

    public int getTextHeight(){
        return font.getHeight();
    }

    public void setFont(String key){
        if (FontLoader.fonts.containsKey(key)){
            font = FontLoader.fonts.get(key);
        }else {
            new RugieError(this,"Font: " + key + " not found, probably not loaded?").show();
        }
    }
}
