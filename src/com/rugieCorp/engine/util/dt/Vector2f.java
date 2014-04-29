package com.rugieCorp.engine.util.dt;

/**
 * User: Adam Chlupacek
 * Date: 01/03/14
 * Time: 22:12
 * Package: com.rugieCorp.engine.util.dt
 */
public class Vector2f {

    private float x;
    private float y;

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2f add(Vector2f v){
        return new Vector2f(x+v.getX(),y+v.getY());
    }

    public Vector2f subtract(Vector2f v){
        return new Vector2f(x-v.getX(),y-v.getY());
    }

    public Vector2f multiply(int index){
        return new Vector2f(x*index,y*index);
    }

    public Vector2f divide(int index){
        return new Vector2f(x/index,y/index);
    }

    public double length(){
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }

    public Vector2f invert(){
        return new Vector2f(-x,-y);
    }

    public Vector2i toVectori(){
        return new Vector2i((int)x,(int)y);
    }

    public String toString(){
        return "(" + x + ";" + y + ")";
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
