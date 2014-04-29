package com.rugieCorp.engine.error;

import java.util.Objects;

/**
 * User: Adam Chlupacek
 * Date: 11/04/14
 * Time: 14:24
 * Package: com.rugieCorp.engine.error
 */
public class RugieError {

    private Object obj;
    private String message;


    public RugieError(Object obj, String message) {
        this.obj = obj;
        this.message = message;
    }

    public void show(){
        System.err.println("[RUGIE ERROR] " +message);
    }
}
