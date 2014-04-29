package com.rugieCorp.engine.gameobject;

import com.rugieCorp.engine.error.RugieError;
import com.rugieCorp.engine.gameobject.component.GameComponent;
import com.rugieCorp.engine.util.dt.Vector2f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.lwjgl.opengl.GL11.*;

/**
 * User: Adam Chlupacek
 * Date: 17/04/14
 * Time: 22:39
 * Package: com.rugieCorp.engine.gameobject
 */
public class GameObject {

    private List<GameObject> children;
    private List<GameComponent> components;

    private Transform transform;

    private String id;

    public GameObject(String id){

        children = new ArrayList<GameObject>();
        components = new ArrayList<GameComponent>();

        transform = new Transform();

        //TODO: Better id system
        this.id = id;

    }

    public void getInputAll(){

        getInput();

        for (GameObject child: children){
            child.getInputAll();
        }
    }

    public void updateAll(){

        update();

        for (GameObject child: children){
            child.updateAll();
        }
    }

    public void renderAll(){
        render();

        for (GameObject child: children){
            child.renderAll();
        }
    }

    public void getInput(){
        for (GameComponent component:components){
            component.getInput();
        }
    }

    public void update(){
        for (GameComponent component:components){
            component.update();
        }
    }

    public void render(){
        for (GameComponent component:components){
            component.render();
        }
    }

    public void updateDepsAll(){
        updateDeps();

        for (GameObject child: children){
            child.updateDepsAll();
        }
    }

    public void updateDeps(){
        for (GameComponent component:components){
            component.updateDep();
        }
    }

    public void onSizeChange(){}

    public void addComponent(GameComponent component){
        component.setParent(this);
        components.add(component);
    }

    public void addChild(GameObject gameObject){
        children.add(gameObject);
    }

    public List<GameObject> getChildren() {
        return children;
    }

    public Vector2f getPosition() {
        return transform.getPosition();
    }

    public GameComponent getComponent(String key){
        for (GameComponent component:components){
            if (component.getName().equals(key)){
                return component;
            }
        }
        new RugieError(this, "Could not find gameComponent: " + key).show();
        return new GameComponent("MENOTEXIST");
    }

    public boolean hasComponent(String key){
        for (GameComponent component:components){
            if (component.getName().equals(key)) return true;
        }
        return false;
    }

    public void setPosition(Vector2f position) {
        this.transform.setPosition(position);
    }

    public Vector2f getSize(){
        return transform.getSize();
    }

    public void setSize(Vector2f size){
        this.transform.setSize(size);
        onSizeChange();
    }

    public void setSize(int sx, int sy){
        setSize(new Vector2f(sx,sy));
    }

    public String getId() {
        return id;
    }
}
