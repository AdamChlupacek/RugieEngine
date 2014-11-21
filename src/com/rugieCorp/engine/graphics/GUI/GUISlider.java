package com.rugieCorp.engine.graphics.GUI;

import com.rugieCorp.engine.Input;
import com.rugieCorp.engine.event.EventMouse;
import com.rugieCorp.engine.gameobject.Transform;
import com.rugieCorp.engine.graphics.GUI.skin.Skin;
import com.rugieCorp.engine.graphics.GUI.skin.SliderTexture;
import com.rugieCorp.engine.graphics.MeshManager;
import com.rugieCorp.engine.graphics.shader.SpriteVSShader;
import com.rugieCorp.engine.util.dt.Vector2f;
import com.rugieCorp.engine.util.dt.Vector3f;
import com.rugieCorp.engine.util.dt.Vector4f;
import org.lwjgl.util.vector.Vector;

import static org.lwjgl.opengl.GL11.*;

/**
 * User: Adam Chlupacek
 * Date: 27/04/14
 * Time: 11:45
 * Package: com.rugieCorp.engine.graphics.GUI
 */
public class GUISlider extends GUIPressAble {

    private SliderTexture sliderTexture;

    private float length;

    private Transform lineTransform;

    private Vector4f texPos;

    public GUISlider(String id, Vector2f position, Vector2f size, Skin skin) {
        super(id, position, size);

        this.sliderTexture = skin.getSliderTexture();

        this.length = 200;

        this.texPos = sliderTexture.getBobNormal();

        this.lineTransform = new Transform();
        this.lineTransform.setTranslation(position.getX(),position.getY(),0);
        this.lineTransform.setScale(this.length,10,0);

    }

    @Override
    public void render() {

        SpriteVSShader.getInstance().bind();
        SpriteVSShader.getInstance().updateUniforms(lineTransform,sliderTexture.getMaterial(),sliderTexture.getSliderNormal());
        MeshManager.squareMesh.draw();

        SpriteVSShader.getInstance().bind();
        SpriteVSShader.getInstance().updateUniforms(getTransform(),sliderTexture.getMaterial(),texPos);
        MeshManager.squareMesh.draw();
    }

    @Override
    public void hoverOver(EventMouse eventMouse) {
        texPos = sliderTexture.getBobHover() ;
    }

    @Override
    public void grabbed(EventMouse eventMouse) {
        texPos = sliderTexture.getBobGrabbed();

        float posDifference = eventMouse.getPosition().getX() - getPosition().getX() - getScale().getX()/2;
        if (posDifference != 0)
            setPosition(getPosition().add(new Vector3f(posDifference,0,0)).getXY());
    }

    @Override
    public void onExit(EventMouse eventMouse) {
        texPos = sliderTexture.getBobNormal();
    }

    @Override
    public void grabRelease(EventMouse eventMouse) {
        texPos = sliderTexture.getBobNormal();
    }

    public void setLength(float length){
        this.length = length;
//        this.slider.setSx(length);
    }

    @Override
    public void setPosition(Vector2f position) {
        if (!(position.getX() + getScale().getX() > lineTransform.getPos().getX() + length) && !(position.getX() < lineTransform.getPos().getX())){
            super.setPosition(position);
        }else if(position.getX() + getScale().getX() > lineTransform.getPos().getX() + length ){
            super.setPosition(new Vector2f(lineTransform.getPos().getX() + length - getScale().getX(),position.getY()));
        }else if (position.getX() < lineTransform.getPos().getX()){
            super.setPosition(new Vector2f(lineTransform.getPos().getX(),position.getY()));
        }

    }

    public float getPercentage(){
        return (getPosition().sub(lineTransform.getPos()).getX())/ (length - getScale().getX());
    }
}
