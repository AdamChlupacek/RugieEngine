package com.rugieCorp.engine.graphics.screen;

import com.rugieCorp.engine.graphics.GUI.GUILabel;
import com.rugieCorp.engine.graphics.render.Line;
import com.rugieCorp.engine.graphics.render.Square;
import com.rugieCorp.engine.util.ResourceLoader;
import com.rugieCorp.engine.util.dt.Vector2f;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

/**
 * User: Adam Chlupacek
 * Date: 11/04/14
 * Time: 12:01
 * Package: com.rugieCorp.engine.graphics.screen
 */
public class Window {

    public static void createDisplay() {

        try {
            Display.setDisplayMode(new DisplayMode(1280, 800));
            Display.create();
            System.out.println("Window: " + Display.getWidth() + "*" + Display.getHeight());

        } catch (LWJGLException e) {
            e.printStackTrace();
        }
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glEnable(GL_TEXTURE_2D);
        glDisable(GL_DEPTH_TEST);

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, Display.getWidth(),0, Display.getHeight(), -1,1);
        glMatrixMode(GL_MODELVIEW);
        glClearColor(0,0,0,1);

        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        glClear(GL_COLOR_BUFFER_BIT);
        glLoadIdentity();

        glPushMatrix();
        {
            glTranslatef(320,100,0);
            Square screenStart = new Square(600,600);
            screenStart.setTexture(ResourceLoader.loadTexture("lolz/doge"));
            screenStart.render();
        }
        glPopMatrix();
        Display.update();

        try {
            Keyboard.create();
            Mouse.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

    public static void setTitle(String name){
        Display.setTitle(name);
    }

    public static boolean isCloseRequested(){
        return Display.isCloseRequested();
    }

    public static void render(){
        Display.update();
    }

    public static void dispose(){
        Display.destroy();
        Keyboard.destroy();
        Mouse.destroy();
    }

    public static int getWidth() {
        return Display.getWidth();
    }

    public static int getHeight(){
        return Display.getHeight();
    }
}
