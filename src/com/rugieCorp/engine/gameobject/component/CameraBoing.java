package com.rugieCorp.engine.gameobject.component;

import com.rugieCorp.engine.graphics.Window;
import com.rugieCorp.engine.util.dt.Matrix4f;
import com.rugieCorp.engine.util.dt.Vector3f;


/**
 * User: Adam Chlupacek
 * Date: 01/03/14
 * Time: 22:11
 * Package: com.rugieCorp.worldRPG
 */
public class CameraBoing extends GameComponent implements Camera{

    private int bound = 200;

    private Vector3f pos;
    private Vector3f forward;
    private Vector3f up;

    private Matrix4f projection;

    private boolean changed;

    public CameraBoing(float left, float right, float bottom, float top, float near, float far) {
        super("camera");

        this.changed = false;

        this.pos = new Vector3f(-300,-300,0);
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
        return changed;
    }

    @Override
    public void init(){
    }

    //TODO: might bug out
    @Override
    public void getInput() {
        changed = false;
    }

    public void move(int x, int y){
        if (moveCheck()){
            pos = pos.add(new Vector3f(x,y,0));
            changed = true;
        }
    }

    private boolean moveCheck(){

        if (parent.getPosition().getX() < pos.getX() + bound) return true;
        if (parent.getPosition().getX() + parent.getScale().getX() > pos.getX() + Window.getWidth() - bound) return true;
        if (parent.getPosition().getY() < pos.getY() + bound) return true;
        if (parent.getPosition().getY() + parent.getScale().getY()  > pos.getY() + Window.getHeight() - bound) return true;

        return false;
    }

    public float getOffsetX() {
        return pos.getX();
    }

    public float getOffsetY() {
        return pos.getY();
    }

}
