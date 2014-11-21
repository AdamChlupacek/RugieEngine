package com.rugieCorp.engine.gameobject.component;

import com.rugieCorp.engine.gameobject.GameObject;

/**
 * User: Adam Chlupacek
 * Date: 17/04/14
 * Time: 22:43
 * Package: com.rugieCorp.engine.gameobject.component
 */
public class GameComponent {

    protected GameObject parent;
    private String name;

    public void update(){}
    public void render(){}

    public void init(){}

    public GameComponent(String name) {
        this.name = name;
    }

    public void setParent(GameObject parent){
        this.parent = parent;
    }

    public GameObject getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }
}
