package com.rugieCorp.engine.graphics.GUI.skin;

import org.newdawn.slick.opengl.Texture;

/**
 * User: Adam Chlupacek
 * Date: 26/04/14
 * Time: 22:27
 * Package: com.rugieCorp.engine.graphics.GUI.skin
 */
public class InputTexture {

    private Texture texture;

    private float[] normal, hover, active;

    public InputTexture(Texture texture, float[] normal, float[] hover, float[] active) {
        this.texture = texture;
        this.normal = normal;
        this.active = active;
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

    public float[] getActive() {
        return active;
    }

}
