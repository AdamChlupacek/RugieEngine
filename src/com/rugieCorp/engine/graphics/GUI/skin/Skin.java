package com.rugieCorp.engine.graphics.GUI.skin;

/**
 * User: Adam Chlupacek
 * Date: 20/04/14
 * Time: 23:56
 * Package: com.rugieCorp.engine.graphics.GUI
 */
public class Skin {

    private ButtonTexture buttonTexture;
    private TickTexture tickTexture;
    private InputTexture inputTexture;
    private SliderTexture sliderTexture;

    private String name;

    public Skin(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    /**
     * Buttons
     */

    public ButtonTexture getButtonTexture() {
        return buttonTexture;
    }

    public void setButtonTexture(ButtonTexture buttonTexture) {
        this.buttonTexture = buttonTexture;
    }

    public TickTexture getTickTexture() {
        return tickTexture;
    }

    public void setTickTexture(TickTexture tickTexture) {
        this.tickTexture = tickTexture;
    }

    public InputTexture getInputTexture() {
        return inputTexture;
    }

    public void setInputTexture(InputTexture inputTexture) {
        this.inputTexture = inputTexture;
    }

    public SliderTexture getSliderTexture() {
        return sliderTexture;
    }

    public void setSliderTexture(SliderTexture sliderTexture) {
        this.sliderTexture = sliderTexture;
    }
}
