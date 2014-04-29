package com.rugieCorp.engine.graphics;

/**
 * User: Adam Chlupacek
 * Date: 11/04/14
 * Time: 14:32
 * Package: com.rugieCorp.engine.graphics
 */
public class Color {

    public static final Color WHITE =   new Color(0xFFFFFFFF);
    public static final Color BLACK =   new Color(0xFF000000);
    public static final Color ORANGE =  new Color(0xFFFFB300);
    public static final Color YELLOW =  new Color(0xFFFFFF00);
    public static final Color RED =     new Color(0xFFFF0000);
    public static final Color GREEN =   new Color(0xFF00FF00);
    public static final Color BLUE =    new Color(0xFF0000FF);

    private int color;

    /**
     *
     *
     *
     *
     * @param hex hexadecimal value for the colour: should be in form: 0x .. .. .. .. Where first two elements are ALPHA, second two are RED
     *            third two are GREEN and last two are BLUE
     */

    public Color(int hex) {
        this.color = hex;
    }

    public int getColor() {
        return color;
    }
}
