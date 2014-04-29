package com.rugieCorp.engine.util;

import com.rugieCorp.engine.Engine;
import com.rugieCorp.engine.error.RugieError;
import com.rugieCorp.engine.gameobject.GameObject;
import com.rugieCorp.engine.graphics.GUI.GUI;
import com.rugieCorp.engine.util.dt.Vector2f;

import java.util.List;

/**
 * User: Adam Chlupacek
 * Date: 01/03/14
 * Time: 23:08
 * Package: com.rugieCorp.worldRPG
 */
public class Search {

    public static GameObject getGameObjectyById(String name){
        GameObject root = Engine.getScreen().getRoot();

        return searchLoop(root.getChildren(),name);
    }


    private static GameObject searchLoop(List<GameObject> gameObjects, String name){

        GameObject temp = null;

        for(GameObject go:gameObjects){
            if (go.getId().equals(name)){
                return go;
            }else {
                temp = searchLoop(go.getChildren(),name);
            }

            if (temp != null){
                return  temp;
            }
        }
        new RugieError(new Search(), "Could not find GameObject with id: " + name).show();
        return temp;
    }

    public static GUI getGUIById(String id){
        for (GUI gui: Engine.getScreen().getGUILayer()){
            if (gui.getId().equals(id))
                return gui;
        }
        new RugieError(new Object(),"could not find a GUI with id: " + id + ", will return an empty gui").show();
        return new GUI("ERROR_EMPTY",new Vector2f(0,0),new Vector2f(0,0));
    }


}
