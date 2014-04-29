package com.rugieCorp.engine.util;

/**
 * User: Adam Chlupacek
 * Date: 27/04/14
 * Time: 00:04
 * Package: com.rugieCorp.engine.util
 */
public class Delay {

    private double length;
    private double start;

    public Delay(double length) {
        this.length = length;
        this.start = -1;
    }

    public void start(){
        if (start == -1){
            start = Time.getTime();
        }
    }

    public boolean isOver(){
        if (length < Time.getTime() - start){
            start = -1;
            return true;
        }
        return false;
    }

    public void stop(){
        start = -1;
    }
}
