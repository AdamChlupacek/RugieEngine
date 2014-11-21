package com.rugieCorp.engine.graphics.GUI.skin;

import com.rugieCorp.engine.graphics.Texture;
import com.rugieCorp.engine.util.dt.Vector4f;

/**
 * User: Adam Chlupacek
 * Date: 30/04/14
 * Time: 14:02
 * Package: com.rugieCorp.engine.graphics.GUI.skin
 */
public class DialogTexture {


    private Texture texture;

    private Vector4f top, body, activeTop;

    public DialogTexture(Texture texture, Vector4f top, Vector4f body, Vector4f activeTop) {
        this.texture = texture;
        this.top = top;
        this.body = body;
        this.activeTop = activeTop;
    }

    public Texture getTexture() {
        return texture;
    }

    public Vector4f getActiveTop() {
        return activeTop;
    }

    public Vector4f getBody() {
        return body;
    }

    public Vector4f getTop() {
        return top;
    }

}
