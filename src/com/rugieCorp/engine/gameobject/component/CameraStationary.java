package com.rugieCorp.engine.gameobject.component;

import com.rugieCorp.engine.util.dt.Vector2f;

/**
 * User: Adam Chlupacek
 * Date: 20/04/14
 * Time: 00:37
 * Package: com.rugieCorp.engine.gameobject.component
 */
public class CameraStationary extends GameComponent implements Camera {

    private Vector2f offset;

    public CameraStationary() {
        super("camera");

        offset = new Vector2f(0,0);
    }

    @Override
    public void move(int x, int y) {}

    @Override
    public float getOffsetX() {
        return offset.getX();
    }

    @Override
    public float getOffsetY() {
        return offset.getY();
    }
}
