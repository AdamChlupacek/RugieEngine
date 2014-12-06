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

  /**
   * Load a buffered image from a .png file
   * @param path path to the file, relative to "res/" folder
   * @return the loaded buffered image;
   */
    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(new FileInputStream("res/" + path + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

  /**
   * Creates a texture from .png file at give path
   * @param path path to the file, relative to "res/" folder
   * @return Texture made from the .png file
   */
    public static Texture loadTexture(String path){
      return TextureLoader.loadTexture(loadImage(path), path);
    }

}
