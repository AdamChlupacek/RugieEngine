package com.rugieCorp.engine.graphics.GUI;

import com.rugieCorp.engine.Engine;
import com.rugieCorp.engine.Input;
import com.rugieCorp.engine.graphics.GUI.skin.Skin;
import com.rugieCorp.engine.graphics.render.Square;
import com.rugieCorp.engine.util.dt.Vector2f;
import com.rugieCorp.engine.util.dt.Vector2i;

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

    private float topBarHeight;
    private Vector2i pressPosition;

    private Square top;
    private Square body;

    private List<GUI> children;

    private boolean drag;
    private boolean active;

    public GUIDialog(String id, Vector2f position, Vector2f size, Skin skin) {
        super(id, position, size);

        this.children = new ArrayList<GUI>();

        this.topBarHeight = 30;
        this.drag = false;

        this.top = new Square(size.getX(),topBarHeight);
        this.body = new Square(size.getX(), size.getY() - topBarHeight);

        //TODO: skin implementation

        active = false;

        GUIButton close = new GUIButton(getId() +":Close","",new Vector2f(getPosition().getX() + 5 ,getPosition().getY() + getSize().getY() - 15),new Vector2f(10,10),skin);

        close.setAction(new Action() {
            @Override
            public void go() {
                Engine.getScreen().removeGUI(getThis());
                System.out.println("Pressed");
            }
        });

        this.children.add(close);
    }

    @Override
    public void getInput() {
        //To update pressable class
        super.getInput();
        if (active)
            for (GUI child:children){
                child.getInput();
            }
    }

    @Override
    public void update() {

        for (GUI child:children){
            child.update();
        }
    }

    @Override
    public void render() {
        glPushMatrix();
        {
            glTranslatef(getPosition().getX(), getPosition().getY(),0);
            body.render();
            glTranslatef(0,getSize().getY() - topBarHeight,0);
            top.render();
        }
        glPopMatrix();

        for (GUI child:children){
            child.render();
        }
    }

    @Override
    public void mouseDown() {
        //TODO: bit different this pls
        if (Input.getMousePosition().getY() > getPosition().getY() + getSize().getY() - topBarHeight){
            drag = true;
            pressPosition = Input.getMousePosition().subtract(getPosition().toVectori());
        }

        if (!active){
            GUI lastDia = Engine.getScreen().getLastDialog();
            if (lastDia!= this){
                lastDia.getInput();
            }

        }else {
            Input.mouseDownTaken = true;
        }

        if (!Input.mouseDownTaken){
            Engine.getScreen().setLast(this);

            for (GUI gui: Engine.getScreen().getGUILayer()){
                if (gui instanceof GUIDialog)
                    ((GUIDialog) gui).setActive(false);
            }

            active = true;
        }

    }

    @Override
    public void grabbed() {
        if (drag && active){
            Vector2i posDifference = Input.getMousePosition().subtract(pressPosition);
            movePosChildren(posDifference.toVectorf());
            setPosition(posDifference.toVectorf());
            pressPosition = Input.getMousePosition().subtract(getPosition().toVectori());
        }
    }

    @Override
    public void grabRelease() {
        drag = false;
    }

    private void movePosChildren(Vector2f vector2f){
        for (GUI child:children){
            child.setPosition(vector2f.add(child.getPosition().subtract(getPosition())));
        }
    }

    public void addChild(GUI gui){
        children.add(gui);
    }

    public void setActive(boolean active){
        this.active = active;
    }
}
