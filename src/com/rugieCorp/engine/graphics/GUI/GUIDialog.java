package com.rugieCorp.engine.graphics.GUI;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.rugieCorp.engine.Engine;
import com.rugieCorp.engine.Input;
import com.rugieCorp.engine.event.EventInput;
import com.rugieCorp.engine.event.EventMouse;
import com.rugieCorp.engine.gameobject.Transform;
import com.rugieCorp.engine.graphics.GUI.skin.Skin;
import com.rugieCorp.engine.graphics.Material;
import com.rugieCorp.engine.graphics.MeshManager;
import com.rugieCorp.engine.graphics.shader.SpriteVSShader;
import com.rugieCorp.engine.util.ResourceLoader;
import com.rugieCorp.engine.util.dt.Vector2f;
import com.rugieCorp.engine.util.dt.Vector3f;
import com.rugieCorp.engine.util.dt.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;

/**
 * User: Adam Chlupacek
 * Date: 27/04/14
 * Time: 23:36
 * Package: com.rugieCorp.engine.graphics.GUI
 */
public class GUIDialog extends GUIPressAble {

    private static GUIDialog lastDialog;

    private EventBus childBus;

    private float topBarHeight;
    private Vector2f pressPosition;

    private List<GUI> children;

    private boolean drag;
    private boolean active;

    private Transform topTransform;
    private Material material = new Material(ResourceLoader.loadTexture("texture/baseTex"));
    public GUIDialog(String id, Vector2f position, Vector2f size, Skin skin) {
        super(id, position, size);
        this.children = new ArrayList<GUI>();
        this.childBus = new EventBus(getId() +":ChildBus");
        this.topBarHeight = 30;
        this.drag = false;

        this.topTransform = new Transform();
        this.topTransform.setPos(getPosition().add(new Vector3f(0,getScale().getY()-topBarHeight,0)));
        this.topTransform.setScale(getScale().getX(), topBarHeight, 0);
        //TODO: skin implementation

        active = false;

        GUIButton close = new GUIButton(getId() +":Close","",new Vector2f(getPosition().getX() + 5 ,getPosition().getY() + getScale().getY() - 15),new Vector2f(10,10),skin);

        close.setAction(new Action() {
            @Override
            public void go() {
                Engine.getScreen().removeGUI(getThis());
                System.out.println("Pressed");
            }
        });

        this.addChild(close);

    }

    @Subscribe
    public void childrenInput(EventInput eventInput) {
        if (active)
            if (eventInput instanceof EventMouse)
                childBus.post(eventInput);
    }

    @Override
    public void update() {

        for (GUI child:children){
            child.update();
        }
    }

    @Override
    public void render(){

        Transform adjustT = getTransform().copy();
        adjustT.setScale(getScale().getX(),getScale().getY() - topBarHeight,0);
        SpriteVSShader.getInstance().bind();
        SpriteVSShader.getInstance().updateUniforms(adjustT, material,new Vector4f(0,0,1,1));
        MeshManager.squareMesh.draw();

        SpriteVSShader.getInstance().bind();
        SpriteVSShader.getInstance().updateUniforms(topTransform, material,new Vector4f(0,0,1,1));
        MeshManager.squareMesh.draw();


        for (GUI child:children){
            child.render();
        }
    }

    @Override
    public void mouseDown(EventMouse eventMouse) {
        if (eventMouse.getPosition().getY() > getPosition().getY() + getScale().getY() - topBarHeight){
            drag = true;
            pressPosition = eventMouse.getPosition().sub(getPosition().getXY());
        }

        if (active){
            eventMouse.setGUIMouseTaken(true);
        }

        if (!eventMouse.isGUIMouseTaken()){
            Engine.getScreen().setLast(this);

            for (GUI gui: Engine.getScreen().getGUILayer()){
                if (gui instanceof GUIDialog)
                    ((GUIDialog) gui).setActive(false);
            }

            active = true;
            lastDialog = this;
        }

    }

    @Override
    public void grabbed(EventMouse eventMouse) {
        if (drag && active){
            Vector2f posDifference = eventMouse.getPosition().sub(pressPosition);
            movePosChildren(posDifference);
            setPosition(posDifference);
            this.topTransform.setPos(getPosition().add(new Vector3f(0,getScale().getY()-topBarHeight,0)));
            pressPosition = eventMouse.getPosition().sub(getPosition().getXY());
        }
    }

    @Override
    public void grabRelease(EventMouse eventMouse) {
        drag = false;
    }

    private void movePosChildren(Vector2f vector2f){
        for (GUI child:children){
            child.setPosition(vector2f.add(child.getPosition().sub(getPosition()).getXY()));
        }
    }

    public void addChild(GUI gui){
        children.add(gui);
        childBus.register(gui);
    }

    public void setActive(boolean active){
        this.active = active;
    }
}
