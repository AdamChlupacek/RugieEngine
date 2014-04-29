package com.rugieCorp.engine.util.dt;

/**
 * User: Adam Chlupacek
 * Date: 01/03/14
 * Time: 22:12
 * Package: com.rugieCorp.engine.util.dt
 */
public class Vector2i {

    private int x;
    private int y;

    public Vector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2i add(Vector2i v){
        return new Vector2i(x+v.getX(),y+v.getY());
    }

    public Vector2i subtract(Vector2i v){
        return new Vector2i(x-v.getX(),y-v.getY());
    }

    public Vector2i multiply(int index){
        return new Vector2i(x*index,y*index);
    }

    public Vector2i divide(int index){
        return new Vector2i(x/index,y/index);
    }

    public double length(){
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }

    public Vector2i invert(){
        return new Vector2i(-x,-y);
    }

    public Vector2f toVectorf(){
        return new Vector2f(x,y);
    }

    public String toString(){
        return "(" + x + ";" + y + ")";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
