package com.rugieCorp.engine.gameobject.component;

/**
 * User: Adam Chlupacek
 * Date: 20/04/14
 * Time: 00:38
 * Package: com.rugieCorp.engine.gameobject.component
 */
public interface Camera {

    public void move(int x, int y);

    public float getOffsetX();

    public float getOffsetY();
}
