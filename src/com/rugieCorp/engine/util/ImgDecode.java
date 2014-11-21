package com.rugieCorp.engine.util;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;

/**
 * User: Adam Chlupacek
 * Date: 11/04/14
 * Time: 13:57
 * Package: com.rugieCorp.engine.util
 */
public class ImgDecode {

    public static Integer[] getImageData(BufferedImage image) {

        final byte[] pixels = ((DataBufferByte)image.getRaster().getDataBuffer()).getData();
        final int width = image.getWidth();
        final int height = image.getHeight();
        final boolean hasAlphaChannel = image.getAlphaRaster() != null;

        Integer[] result = new Integer[height * width];

        if (hasAlphaChannel){
            for (int pixel = 0, row = height - 1, col = 0; pixel < pixels.length; pixel += 4) {
                int argb = 0;
                argb += (((int)pixels[pixel] & 0xff) << 24); // alpha
                argb += ((int)pixels[pixel + 1] & 0xff); // blue
                argb += (((int)pixels[pixel + 2] & 0xff) << 8); // green
                argb += (((int)pixels[pixel + 3] & 0xff) << 16); // red
                result[row * width + col] = argb;
                col++;
                if (col == width) {
                    col = 0;
                    row--;
                }
            }
        }else {
            for (int pixel = 0, row = height - 1, col = 0; pixel < pixels.length; pixel += 3) {
                int argb = 0;
                argb += -16777216; // 255 alpha
                argb += ((int) pixels[pixel] & 0xff); // blue
                argb += (((int) pixels[pixel + 1] & 0xff) << 8); // green
                argb += (((int) pixels[pixel + 2] & 0xff) << 16); // red
                result[row * width + col] = argb;
                col++;
                if (col == width) {
                    col = 0;
                    row--;
                }
            }
        }

        return result;
    }
}
