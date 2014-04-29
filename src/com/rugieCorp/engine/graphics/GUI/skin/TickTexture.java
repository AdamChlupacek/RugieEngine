package com.rugieCorp.engine.graphics.GUI.skin;

import org.newdawn.slick.opengl.Texture;

/**
 * User: Adam Chlupacek
 * Date: 26/04/14
 * Time: 20:33
 * Package: com.rugieCorp.engine.graphics.GUI.skin
 */
public class TickTexture {

    private Texture texture;

    private float[] normal, hover, check;

    public TickTexture(Texture texture, float[] normal, float[] hover, float[] check) {
        this.texture = texture;
        this.normal = normal;
        this.check = check;
        this.hover = hover;
    }

    public Texture getTexture() {
        return texture;
    }

    public float[] getNormal() {
        return normal;
    }

    public float[] getHover() {
        return hover;
    }

    public float[] getCheck() {
        return check;
    }
}
