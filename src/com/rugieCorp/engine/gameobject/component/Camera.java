package com.rugieCorp.engine.gameobject.component;

import com.rugieCorp.engine.util.dt.Matrix4f;

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

    public Matrix4f getViewProjection();

    public boolean changed();
}
