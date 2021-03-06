package com.rugieCorp.engine.graphics.GUI;

import com.rugieCorp.engine.gameobject.Transform;
import com.rugieCorp.engine.util.dt.Vector2f;
import com.rugieCorp.engine.util.dt.Vector3f;

/**
 * User: Adam Chlupacek
 * Date: 26/04/14
 * Time: 16:31
 * Package: com.rugieCorp.engine.graphics.GUI
 */
public class GUI {

    private Transform transform;
    private String id;

    public GUI(String id, Vector2f position, Vector2f size) {
        this.transform = new Transform();
        this.transform.setTranslation(position.getX(), position.getY(), 0);
        this.transform.setScale(size.getX(),size.getY(),0);
        this.id = id;
    }

    public void update(){

    }

    public void render() {

    }

    public Vector3f getPosition() {
        return transform.getPos();
    }

    public void setPosition(Vector2f position) {
        this.transform.setTranslation(position.getX(),position.getY(),0);
    }

    public Vector3f getScale() {
        return transform.getScale();
    }

    public void setScale(Vector2f size) {
        this.transform.setScale(size.getX(),size.getY(),0);
    }

    public String getId() {
        return id;
    }

    public Transform getTransform() {
        return transform;
    }

    //Cheat method, to get reference to this object from inner classes and inner class implementations.
    protected GUI getThis(){
        return this;
    }
}
