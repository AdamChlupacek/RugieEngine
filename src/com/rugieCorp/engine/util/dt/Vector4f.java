package com.rugieCorp.engine.util.dt;

/**
 * User: Adam Chlupacek
 * Date: 23/05/14
 * Time: 11:50
 * Package: com.rugieCorp.engine.util.dt
 */
public class Vector4f {

    private float x;
    private float y;
    private float z;
    private float w;

    public Vector4f(float x, float y, float z,float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public float getW() {
        return w;
    }
}
