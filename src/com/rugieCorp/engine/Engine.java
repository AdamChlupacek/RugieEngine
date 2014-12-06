package com.rugieCorp.engine;

import com.google.common.eventbus.EventBus;
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

  //The current screen that is being displayed
  private static Screen screen;

  //Running flag
  private boolean running = false;

  //Delta time of one frame
  private double frameTime;

  //Current Camera that is used to display scene to user
  private static Camera mainCamera;

  //Main event bus
  private static EventBus mainBus;


  /**
   * Creates engine with all necessary components. Including a blank screen
   * @param title the title to be displayed at the top of the screen
   * @param fps desired fps lock of the app
   */
  public Engine(String title, int fps) {
    Window.createDisplay();
    Window.setTitle(title);
    this.frameTime = (float)1/fps;

    screen = new Screen();
    mainBus = new EventBus();

    MeshManager.createMeshes();
    FontLoader.populateFonts();
  }

  /**
   * Getter for the main camera,
   * Can be NULL at start!
   * @return main camera
   */
  public static Camera getMainCamera() {
    return mainCamera;
  }

  /**
   * Starts the engine
   */
  public void start(){
    running = true;
    run();
  }

  /**
   * Stops the engine
   */
  public void stop(){
    running = false;
  }

  /**
   * Run method of the engine, including the main loop
   */
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

  /**
   * Disposing of all loaded resources, not to hog any memory space
   */
  private void cleanUp(){
    Window.dispose();
  }

  /**
   * Getter for current screen
   * @return current screen
   */
  public static Screen getScreen(){
    return screen;
  }

  /**
   * Setter for current screen
   * @param screen screen to be set as current;
   */
  public static void setScreen(Screen screen) {
    Engine.screen.dispose();
    Engine.screen = screen;
    Engine.screen.getRoot().updateDepsAll();
  }

  /**
   * Setter for main camera
   * @param mainCamera camera to be used as main camera
   */
  public static void setMainCamera(Camera mainCamera) {
    Engine.mainCamera = mainCamera;
  }
}
