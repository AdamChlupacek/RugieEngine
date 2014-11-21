package com.rugieCorp.engine.graphics.GUI.skin;

import com.rugieCorp.engine.graphics.Texture;
import com.rugieCorp.engine.util.dt.Vector4f;

/**
 * User: Adam Chlupacek
 * Date: 26/04/14
 * Time: 22:27
 * Package: com.rugieCorp.engine.graphics.GUI.skin
 */
public class InputTexture {

    private Texture texture;

    private Vector4f normal, hover, active;

    public InputTexture(Texture texture, Vector4f normal, Vector4f hover, Vector4f active) {
        this.texture = texture;
        this.normal = normal;
        this.active = active;
        this.hover = hover;
    }

    public Texture getTexture() {
        return texture;
    }

    public Vector4f getNormal() {
        return normal;
    }

    public Vector4f getHover() {
        return hover;
    }

    public Vector4f getActive() {
        return active;
    }

}
