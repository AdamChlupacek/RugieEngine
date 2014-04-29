package com.rugieCorp.engine.graphics.GUI.skin;

import org.newdawn.slick.opengl.Texture;

/**
 * User: Adam Chlupacek
 * Date: 27/04/14
 * Time: 12:04
 * Package: com.rugieCorp.engine.graphics.GUI.skin
 */
public class SliderTexture {

    private Texture texture;

    private float[] bobNormal, bobHover, bobGrabbed, sliderNormal;

    public SliderTexture(Texture texture, float[] bobNormal, float[] bobHover, float[] bobGrabbed, float[] sliderNormal) {
        this.texture = texture;
        this.bobNormal = bobNormal;
        this.bobHover = bobHover;
        this.bobGrabbed = bobGrabbed;
        this.sliderNormal = sliderNormal;
    }

    public Texture getTexture() {
        return texture;
    }

    public float[] getBobNormal() {
        return bobNormal;
    }

    public float[] getBobHover() {
        return bobHover;
    }

    public float[] getBobGrabbed() {
        return bobGrabbed;
    }

    public float[] getSliderNormal() {
        return sliderNormal;
    }
}
