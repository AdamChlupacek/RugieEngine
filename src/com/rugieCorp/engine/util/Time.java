package com.rugieCorp.engine.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: Rugnarog the Mighty!
 * Date: 9/11/13
 * Time: 1:51 PM
 * Created for my own pleasure please do not use it in any way without permission, I guess I would not do anything to you even if you would, but you know, be nice! :D
 */
public class Time {
    private static final long SECOND = 1000000000L;

    public static double getTime(){
        return (double)System.nanoTime()/(double)SECOND;
    }

    public static String getTime24H(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
