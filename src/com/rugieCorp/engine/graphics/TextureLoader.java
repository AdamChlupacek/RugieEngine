package com.rugieCorp.engine.graphics;

import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;


import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL12;

import static org.lwjgl.opengl.GL11.*;

public class TextureLoader {

  //Storage for loaded textures
  private static Map<String, Texture> textures = new HashMap<>();

  private static final int BYTES_PER_PIXEL = 4;//3 for RGB, 4 for RGBA

  /**
   * Creates a 2D texture for openGL from BufferedImage
   * @param image the BufferedImage to be used for the texture
   * @param name name under which will the texture be known
   * @return returns a texture
   */
  public static Texture loadTexture(BufferedImage image, String name){

    if (textures.containsKey(name)){
      return  textures.get(name);
    }

    int[] pixels = new int[image.getWidth() * image.getHeight()];
    image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());

    ByteBuffer buffer = BufferUtils.createByteBuffer(image.getWidth() * image.getHeight() * BYTES_PER_PIXEL); //4 for RGBA, 3 for RGB

    for(int y = 0; y < image.getHeight(); y++){
      for(int x = 0; x < image.getWidth(); x++){
        int pixel = pixels[y * image.getWidth() + x];
        buffer.put((byte) ((pixel >> 16) & 0xFF));     // Red component
        buffer.put((byte) ((pixel >> 8) & 0xFF));      // Green component
        buffer.put((byte) (pixel & 0xFF));               // Blue component
        buffer.put((byte) ((pixel >> 24) & 0xFF));    // Alpha component. Only for RGBA
      }
    }

    buffer.flip(); //FOR THE LOVE OF GOD DO NOT FORGET THIS

    // You now have a ByteBuffer filled with the color data of each pixel.
    // Now just create a texture ID and bind it. Then you can load it using
    // whatever OpenGL method you want, for example:

    int textureID = glGenTextures(); //Generate texture ID
    glBindTexture(GL_TEXTURE_2D, textureID); //Bind texture ID

    //Setup wrap mode
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE);

    //Setup texture scaling filtering
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

    //Send texel data to OpenGL
    glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, image.getWidth(), image.getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);

    //Return the texture ID so we can bind it later again
    Texture temp = new Texture(textureID);
    //Stores the texture under a key for easier loading in the future;
    textures.put(name,temp);

    return temp;
  }
}