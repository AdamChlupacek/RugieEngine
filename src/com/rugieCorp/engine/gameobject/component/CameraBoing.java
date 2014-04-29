package com.rugieCorp.engine.gameobject.component;

import com.rugieCorp.engine.Engine;
import com.rugieCorp.engine.graphics.GUI.GUILabel;
import com.rugieCorp.engine.graphics.screen.Window;
import com.rugieCorp.engine.util.dt.Vector2f;


/**
 * User: Adam Chlupacek
 * Date: 01/03/14
 * Time: 22:11
 * Package: com.rugieCorp.worldRPG
 */
public class CameraBoing extends GameComponent implements Camera{

    private Vector2f offset;

    private int bound;

    private GUILabel pLabel;

    public CameraBoing(int bound) {
        super("camera");
        offset = new Vector2f(-Window.getWidth()/2,-Window.getHeight()/2);

        this.bound = bound;

    }

    @Override
    public void updateDep(){
        offset.add(new Vector2f(-parent.getPosition().getX(),-parent.getPosition().getY()));

        this.pLabel = new GUILabel("pLabel",new Vector2f(10,770),new Vector2f(200,30),"");
        Engine.getScreen().addGUI(this.pLabel);
    }

    @Override
    public void update() {
        pLabel.setText("X: " + offset.getX() + " Y: " + offset.getY());
    }

    public void move(int x, int y){
        if (moveCheck()){
            offset = offset.add(new Vector2f(x,y));
        }
    }

    private boolean moveCheck(){

        if (parent.getPosition().getX() < offset.getX() + bound) return true;
        if (parent.getPosition().getX() + parent.getSize().getX() > offset.getX() + Window.getWidth() - bound) return true;
        if (parent.getPosition().getY() < offset.getY() + bound) return true;
        if (parent.getPosition().getY() + parent.getSize().getY()  > offset.getY() + Window.getHeight() - bound) return true;

        return false;
    }

    public float getOffsetX() {
        return offset.getX();
    }

    public float getOffsetY() {
        return offset.getY();
    }

    public void setOffset(Vector2f offset) {

        this.offset = offset;
    }
}
