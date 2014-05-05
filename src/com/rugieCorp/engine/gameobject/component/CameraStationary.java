package com.rugieCorp.engine.gameobject.component;

import com.rugieCorp.engine.util.dt.Matrix4f;
import com.rugieCorp.engine.util.dt.Vector2f;
import com.rugieCorp.engine.util.dt.Vector3f;

/**
 * User: Adam Chlupacek
 * Date: 20/04/14
 * Time: 00:37
 * Package: com.rugieCorp.engine.gameobject.component
 */
public class CameraStationary extends GameComponent implements Camera {

    private Vector3f pos;
    private Vector3f forward;
    private Vector3f up;

    private Matrix4f projection;

    public CameraStationary(float left, float right, float bottom, float top, float near, float far) {
        super("camera");
        this.pos = new Vector3f(0,0,0);
        this.forward = new Vector3f(0,0,1).normalize();
        this.up = new Vector3f(0,1,0).normalize();

        projection = new Matrix4f().initOrthographic(left, right, bottom, top, near, far);
    }

    @Override
    public Matrix4f getViewProjection(){
        Matrix4f cameraRotation = new Matrix4f().initRotation(forward, up);
        Matrix4f cameraTranslation = new Matrix4f().initTranslation(-pos.getX(), -pos.getY(), -pos.getZ());

        return projection.mul(cameraRotation.mul(cameraTranslation));
    }

    @Override
    public boolean changed() {
        return false;
    }

    @Override
    public void move(int x, int y) {}

    @Override
    public float getOffsetX() {
        return pos.getX();
    }

    @Override
    public float getOffsetY() {
        return pos.getY();
    }

}
