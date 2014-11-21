package com.rugieCorp.engine.util;

/**
 * User: Adam Chlupacek
 * Date: 30/05/14
 * Time: 11:04
 * Package: com.rugieCorp.engine.util
 */
public class Logger {

    public static void info(String text){
        System.out.println(Time.getTime24H() + " [INFO] " + text);
    }

    public static void error(String text){
        System.out.println(Time.getTime24H() + " [ERROR] " + text);
    }
}
