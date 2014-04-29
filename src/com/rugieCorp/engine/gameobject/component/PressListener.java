package com.rugieCorp.engine.gameobject.component;

import com.rugieCorp.engine.Input;
import com.rugieCorp.engine.util.dt.Vector2i;

/**
 * User: Adam Chlupacek
 * Date: 20/04/14
 * Time: 00:48
 * Package: com.rugieCorp.engine.graphics.GUI
 */
public class PressListener extends GameComponent {

    private PressAction action;

    public PressListener() {
        super("pressListener");
    }

    @Override
    public void getInput(){

        Vector2i mousePos = Input.getMousePosition();

        boolean x = mousePos.getX() > parent.getPosition().getX() && mousePos.getX() < parent.getPosition().getX() + parent.getSize().getX();
        boolean y = mousePos.getY() > parent.getPosition().getY() && mousePos.getY() < parent.getPosition().getY() + parent.getSize().getY();

        if (x && y && Input.getMouseUp(Input.LEFT_MB)){
            if (action != null){
                action.pressed();
            }
        }
    }

    public void addAction(PressAction pressAction){
        action = pressAction;
    }
}
