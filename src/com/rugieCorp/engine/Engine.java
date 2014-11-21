package com.rugieCorp.engine;

import com.rugieCorp.engine.gameobject.component.Camera;
import com.rugieCorp.engine.graphics.MeshManager;
import com.rugieCorp.engine.graphics.Screen;
import com.rugieCorp.engine.graphics.Window;
import com.rugieCorp.engine.util.FontLoader;
import com.rugieCorp.engine.util.Time;

import static org.lwjgl.opengl.GL11.*;

/**
 * User: Adam Chlupacek
 * Date: 11/04/14
 * Time: 12:02
 * Package: com.rugieCorp.engine
 */
public class Engine {

    private static Screen screen;

    private boolean running = false;
    private double frameTime;
    private static Camera mainCamera;

    public Engine(String title, int fps) {
        Window.createDisplay();
        Window.setTitle(title);
        this.frameTime = (float)1/fps;

        screen = new Screen();

        MeshManager.createMeshes();
        FontLoader.populateFonts();
    }

    public static Camera getMainCamera() {
        return mainCamera;
    }

    public void start(){
        running = true;

        run();
    }

    public void stop(){
        running = false;
    }

    private void run(){
        int frames = 0;
        double frameCounter = 0;

        double lastTime = Time.getTime();
        double unprocessedTime = 0;


        while (running){

            boolean render = false;

            double startTime = Time.getTime();
            double passedTime = startTime - lastTime;
            lastTime = startTime;

            unprocessedTime += passedTime;
            frameCounter += passedTime;

            while (unprocessedTime > frameTime){

                render = true;

                unprocessedTime -= frameTime;

                if (Window.isCloseRequested())
                    stop();

                Input.update();

                screen.update((float)frameTime);

                if (frameCounter >= 1.0){
                    System.out.println("FPS: " + frames);
                    frames = 0;
                    frameCounter = 0;
                }
            }

            if (render){
                glClearColor(0.7f, 0.7f, 0.7f, 1.0f);
                glClear(GL_COLOR_BUFFER_BIT);
//                glLoadIdentity();
                screen.render();
                Window.render();
                frames++;
            }else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        cleanUp();
    }

    private void cleanUp(){
        Window.dispose();
    }

    public static Screen getScreen(){
        return screen;
    }

    public static void setScreen(Screen screen) {
        Engine.screen.dispose();
        Engine.screen = screen;
        Engine.screen.getRoot().updateDepsAll();
    }

    public static void setMainCamera(Camera mainCamera) {
        Engine.mainCamera = mainCamera;
    }
}
