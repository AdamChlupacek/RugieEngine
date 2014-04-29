package com.rugieCorp.test;

import com.rugieCorp.engine.graphics.Color;
import com.rugieCorp.engine.util.ImgDecode;
import com.rugieCorp.engine.util.ResourceLoader;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import java.net.URL;

/**
 * User: Adam Chlupacek
 * Date: 11/04/14
 * Time: 15:55
 * Package: com.rugieCorp.test
 */
public class ITest {


    public static void main(String[] args) throws LWJGLException {
        URL location = ITest.class.getProtectionDomain().getCodeSource().getLocation();
        System.out.println(location.getFile());
        System.out.println(0xFFFF00FF);
        System.out.println(0x00FFFFFF);
        System.out.println(ImgDecode.getImageData(ResourceLoader.loadTiledLevel("level"))[1]);

        System.out.println(Color.BLACK.getColor());
        System.out.println(0xFF000000);

    }
}
