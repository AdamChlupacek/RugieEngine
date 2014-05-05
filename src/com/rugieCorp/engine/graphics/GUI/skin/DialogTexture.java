package com.rugieCorp.engine.graphics.GUI.skin;

import org.newdawn.slick.opengl.Texture;

/**
 * User: Adam Chlupacek
 * Date: 30/04/14
 * Time: 14:02
 * Package: com.rugieCorp.engine.graphics.GUI.skin
 */
public class DialogTexture {

    private ButtonTexture closeButton;

    private Texture texture;

    private float[] top, body, activeTop;

    public DialogTexture(Texture texture, float[] top, float[] body, float[] activeTop, ButtonTexture closeButton) {
        this.texture = texture;
        this.top = top;
        this.body = body;
        this.activeTop = activeTop;
        this.closeButton = closeButton;
    }

    public Texture getTexture() {
        return texture;
    }

    public float[] getActiveTop() {
        return activeTop;
    }

    public float[] getBody() {
        return body;
    }

    public float[] getTop() {
        return top;
    }

    public ButtonTexture getCloseButton() {
        return closeButton;
    }
}
