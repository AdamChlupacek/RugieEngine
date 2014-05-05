package com.rugieCorp.engine.util;

import com.oracle.javafx.jmx.json.JSONReader;
import com.oracle.javafx.jmx.json.impl.JSONStreamReaderImpl;
import com.rugieCorp.engine.Input;
import com.rugieCorp.engine.level.TiledLevel;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import sun.org.mozilla.javascript.internal.json.JsonParser;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Adam Chlupacek
 * Date: 11/04/14
 * Time: 13:35
 * Package: com.rugieCorp.engine.util
 */
public class ResourceLoader {


    public static BufferedImage loadTiledLevel(String path){
        try {
            return ImageIO.read(new FileInputStream("res/level/" + path + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Texture loadTexture(String path){
        try {
            return TextureLoader.getTexture("png", new FileInputStream("res/" + path + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}
