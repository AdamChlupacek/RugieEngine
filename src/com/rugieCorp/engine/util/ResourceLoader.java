package com.rugieCorp.engine.util;


import com.rugieCorp.engine.graphics.Texture;
import com.rugieCorp.engine.graphics.TextureLoader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * User: Adam Chlupacek
 * Date: 11/04/14
 * Time: 13:35
 * Package: com.rugieCorp.engine.util
 */
public class ResourceLoader {


    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(new FileInputStream("res/" + path + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Texture loadTexture(String path){
      return TextureLoader.loadTexture(loadImage(path));
    }



}
