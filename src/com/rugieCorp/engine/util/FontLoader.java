package com.rugieCorp.engine.util;

import org.newdawn.slick.TrueTypeFont;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Adam Chlupacek
 * Date: 27/04/14
 * Time: 00:28
 * Package: com.rugieCorp.engine.util
 */
public class FontLoader {

    public static Map<String, TrueTypeFont> fonts;
    private static Font awtFont24 = new Font("Arial Black", Font.PLAIN, 24);
    private static TrueTypeFont arial24 = new TrueTypeFont(awtFont24,true);

    private static Font awtArial12 = new Font("Arial", Font.PLAIN, 12);
    private static TrueTypeFont arial12 = new TrueTypeFont(awtArial12,true);

    public static void populateFonts(){
        fonts = new HashMap<String, TrueTypeFont>();
        fonts.put("arial24",arial24);
        fonts.put("arial12",arial12);
    }

}
