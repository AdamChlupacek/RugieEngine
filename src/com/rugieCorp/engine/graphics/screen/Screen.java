package com.rugieCorp.engine.graphics.screen;

import com.rugieCorp.engine.Engine;
import com.rugieCorp.engine.gameobject.GameObject;
import com.rugieCorp.engine.gameobject.component.Camera;
import com.rugieCorp.engine.graphics.GUI.GUI;
import com.rugieCorp.engine.graphics.GUI.GUIDialog;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.glTranslatef;

/**
 * User: Adam Chlupacek
 * Date: 11/04/14
 * Time: 11:30
 * Package: com.rugieCorp.engine.graphics.screen
 */
public class Screen{

    //TODO: change to gameObject + component style of engine

    private GameObject root = new GameObject("root");
    private List<GUI> guiLayer = new ArrayList<GUI>();

    private List<GUI> addGuiLayer = new ArrayList<GUI>();
    private List<GUI> removeGuiLayer = new ArrayList<GUI>();

    private Engine engine;

    public void getInput(float delta) {
        for(GUI gui:guiLayer){
            gui.getInput();
        }
        root.getInputAll();
    }

    public void update(float delta) {
        for(GUI gui:guiLayer){
            gui.update();
        }

        if(!removeGuiLayer.isEmpty()){
            guiLayer.removeAll(removeGuiLayer);
            removeGuiLayer.clear();
        }

        if(!addGuiLayer.isEmpty()){
            guiLayer.addAll(addGuiLayer);
            addGuiLayer.clear();
        }

        root.updateAll();
    }

    public void render() {
        Camera camera = Engine.getMainCamera();
        glTranslatef(-camera.getOffsetX(),-camera.getOffsetY(),0);
        root.renderAll();
        glTranslatef(camera.getOffsetX(),camera.getOffsetY(),0);
        for(GUI gui:guiLayer){
            gui.render();
        }
    }

    public void addToRoot(GameObject gameObject){
        root.addChild(gameObject);
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public GameObject getRoot(){
        return root;
    }

    public void addGUI(GUI gui){
        addGuiLayer.add(gui);
    }

    public void removeGUI(GUI gui){
        removeGuiLayer.add(gui);
    }

    public List<GUI> getGUILayer() {
        return guiLayer;
    }

    public void setLast(GUI gui){
        removeGUI(gui);
        addGUI(gui);
    }

    public GUI getLastDialog() {

        GUI lastDialog = null;

        for (GUI gui: guiLayer){
            if (gui instanceof GUIDialog)
                lastDialog = gui;
        }

        return lastDialog;
    }
}
