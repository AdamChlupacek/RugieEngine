package com.rugieCorp.engine.gameobject.component;

import com.rugieCorp.engine.gameobject.GameObject;

/**
 * User: Adam Chlupacek
 * Date: 19/04/14
 * Time: 13:09
 * Package: com.rugieCorp.engine.gameobject.component
 */
@Deprecated
public interface Collider {

    public static final int BOTTOM = 0;
    public static final int TOP = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;

    public void collide();

    /**
     *
     * Method to get collision sides length for given collider
     *
     * @return an array with collision sides
     */
    public float[] getCollSide();

    public boolean isCollided();
    public GameObject getCollisionObject();


}
