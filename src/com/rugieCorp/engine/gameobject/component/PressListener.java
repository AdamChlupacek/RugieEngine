package com.rugieCorp.engine.gameobject.component;

import com.rugieCorp.engine.Input;
import com.rugieCorp.engine.util.dt.Vector2f;

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


    public void addAction(PressAction pressAction){
        action = pressAction;
    }
}
