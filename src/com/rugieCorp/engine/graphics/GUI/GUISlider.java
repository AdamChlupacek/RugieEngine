package com.rugieCorp.engine.graphics.GUI;

import com.rugieCorp.engine.Input;
import com.rugieCorp.engine.graphics.GUI.skin.Skin;
import com.rugieCorp.engine.graphics.GUI.skin.SliderTexture;
import com.rugieCorp.engine.graphics.render.Square;
import com.rugieCorp.engine.util.dt.Vector2f;

import static org.lwjgl.opengl.GL11.*;

/**
 * User: Adam Chlupacek
 * Date: 27/04/14
 * Time: 11:45
 * Package: com.rugieCorp.engine.graphics.GUI
 */
public class GUISlider extends GUIPressAble {

    private Square bob;
    private Square slider;

    private SliderTexture sliderTexture;

    private float length;
    private Vector2f sliderPosition;

    public GUISlider(String id, Vector2f position, Vector2f size, Skin skin) {
        super(id, position, size);

        this.sliderTexture = skin.getSliderTexture();

        this.length = 200;
        this.sliderPosition = position;

        this.slider = new Square(length,6);
        this.slider.setTexture(sliderTexture.getTexture());
        this.slider.setTextureCoor(sliderTexture.getSliderNormal());


        this.bob = new Square(getSize().getX(),getSize().getY());
        this.bob.setTexture(sliderTexture.getTexture());
        this.bob.setTextureCoor(sliderTexture.getBobNormal());

    }

    @Override
    public void render() {
        glPushMatrix();
        {
            glTranslatef(sliderPosition.getX(), sliderPosition.getY() + (getSize().getX() - 6)/2, 0);
            slider.render();
        }
        glPopMatrix();
        glPushMatrix();
        {
            glTranslatef(getPosition().getX(),getPosition().getY(),0);
            bob.render();
        }
        glPopMatrix();
    }

    @Override
    public void hoverOver() {
        bob.setTextureCoor(sliderTexture.getBobHover());
    }

    @Override
    public void grabbed() {
        bob.setTextureCoor(sliderTexture.getBobGrabbed());

        float posDifference = Input.getMousePosition().getX() - getPosition().getX() - getSize().getX()/2;
        if (posDifference != 0)
            setPosition(getPosition().add(new Vector2f(posDifference,0)));
    }

    @Override
    public void onExit() {
        bob.setTextureCoor(sliderTexture.getBobNormal());
    }

    @Override
    public void grabRelease() {
        bob.setTextureCoor(sliderTexture.getBobNormal());
    }

    //TODO: create a new object??
    public void setLength(float length){
        this.length = length;
        this.slider.setSx(length);
    }

    @Override
    public void setPosition(Vector2f position) {
        if (!(position.getX() + getSize().getX() > sliderPosition.getX() + length) && !(position.getX() < sliderPosition.getX())){
            super.setPosition(position);
        }else if(position.getX() + getSize().getX() > sliderPosition.getX() + length ){
            super.setPosition(new Vector2f(sliderPosition.getX() + length - getSize().getX(),position.getY()));
        }else if (position.getX() < sliderPosition.getX()){
            super.setPosition(new Vector2f(sliderPosition.getX(),position.getY()));
        }

    }

    public float getPercentage(){
        return (getPosition().subtract(sliderPosition).getX())/ (length - getSize().getX());
    }
}
