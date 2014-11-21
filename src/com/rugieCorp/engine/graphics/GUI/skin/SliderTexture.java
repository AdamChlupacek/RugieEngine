package com.rugieCorp.engine.graphics.GUI.skin;

import com.rugieCorp.engine.graphics.Material;
import com.rugieCorp.engine.graphics.Texture;
import com.rugieCorp.engine.util.dt.Vector4f;

/**
 * User: Adam Chlupacek
 * Date: 27/04/14
 * Time: 12:04
 * Package: com.rugieCorp.engine.graphics.GUI.skin
 */
public class SliderTexture {

    private Vector4f bobNormal, bobHover, bobGrabbed, sliderNormal;
    private Material material;

    public SliderTexture(Texture texture, Vector4f bobNormal, Vector4f bobHover, Vector4f bobGrabbed, Vector4f sliderNormal) {
        this.bobNormal = bobNormal;
        this.bobHover = bobHover;
        this.bobGrabbed = bobGrabbed;
        this.sliderNormal = sliderNormal;
        this.material = new Material(texture);
    }

    public Vector4f getBobNormal() {
        return bobNormal;
    }

    public Vector4f getBobHover() {
        return bobHover;
    }

    public Vector4f getBobGrabbed() {
        return bobGrabbed;
    }

    public Vector4f getSliderNormal() {
        return sliderNormal;
    }

    public Material getMaterial() {
        return material;
    }
}
