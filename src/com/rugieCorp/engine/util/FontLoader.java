package com.rugieCorp.engine.util;

import com.rugieCorp.engine.graphics.font.BitmapFont;

/**
 * User: Adam Chlupacek
 * Date: 27/04/14
 * Time: 00:28
 * Package: com.rugieCorp.engine.util
 */
public class FontLoader {

    public static BitmapFont font;

    public static void populateFonts(){
        font = new BitmapFont("font");
    }

}
