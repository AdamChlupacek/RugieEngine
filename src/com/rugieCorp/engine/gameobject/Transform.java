package com.rugieCorp.engine.gameobject;

import com.rugieCorp.engine.util.dt.Vector2f;

/**
 * User: Adam Chlupacek
 * Date: 20/04/14
 * Time: 00:11
 * Package: com.rugieCorp.engine.gameobject
 */
public class Transform {

    private Vector2f position;
    private Vector2f size;


    public Transform() {
        this.position = new Vector2f(0,0);
        this.size = new Vector2f(1,1);
    }

    public Vector2f getPosition() {
        return position;
    }

    public void setPosition(Vector2f position) {
        this.position = position;
    }

    public Vector2f getSize() {
        return size;
    }

    public void setSize(Vector2f size) {
        this.size = size;
    }
}
