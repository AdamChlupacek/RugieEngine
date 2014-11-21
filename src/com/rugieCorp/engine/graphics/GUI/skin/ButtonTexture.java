package com.rugieCorp.engine.graphics.GUI.skin;

import com.rugieCorp.engine.graphics.Material;
import com.rugieCorp.engine.graphics.Texture;
import com.rugieCorp.engine.util.dt.Vector4f;

/**
 * User: Adam Chlupacek
 * Date: 26/04/14
 * Time: 17:14
 * Package: com.rugieCorp.engine.graphics.render
 */
public class ButtonTexture {

    private Material material;

    private Vector4f normal, down, hover;

    public ButtonTexture(Texture texture, Vector4f normal, Vector4f down, Vector4f hover) {
        this.material = new Material(texture);
        this.normal = normal;
        this.down = down;
        this.hover = hover;
    }

    public Material getMaterial() {
        return material;
    }

    public Vector4f getNormal() {
        return normal;
    }

    public Vector4f getDown() {
        return down;
    }

    public Vector4f getHover() {
        return hover;
    }
}
