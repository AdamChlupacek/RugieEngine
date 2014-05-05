package com.rugieCorp.engine.graphics.GUI;

import com.rugieCorp.engine.util.dt.Vector2f;

/**
 * User: Adam Chlupacek
 * Date: 26/04/14
 * Time: 16:31
 * Package: com.rugieCorp.engine.graphics.GUI
 */
public class GUI {

    private Vector2f position;
    private Vector2f size;
    private String id;

    public GUI(String id, Vector2f position, Vector2f size) {
        this.position = position;
        this.size = size;
        this.id = id;
    }

    public void getInput(){

    }

    public void update(){

    }

    public void render() {

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

    public String getId() {
        return id;
    }

    protected GUI getThis(){
        return this;
    }
}
