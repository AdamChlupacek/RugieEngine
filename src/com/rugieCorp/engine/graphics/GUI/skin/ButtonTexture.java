package com.rugieCorp.engine.graphics.GUI.skin;

import org.newdawn.slick.opengl.Texture;

/**
 * User: Adam Chlupacek
 * Date: 26/04/14
 * Time: 17:14
 * Package: com.rugieCorp.engine.graphics.render
 */
public class ButtonTexture {

    private Texture texture;

    private float[] normal, down, hover;

    public ButtonTexture(Texture texture, float[] normal, float[] down, float[] hover) {
        this.texture = texture;
        this.normal = normal;
        this.down = down;
        this.hover = hover;
    }

    public Texture getTexture() {
        return texture;
    }

    public float[] getNormal() {
        return normal;
    }

    public float[] getDown() {
        return down;
    }

    public float[] getHover() {
        return hover;
    }
}
