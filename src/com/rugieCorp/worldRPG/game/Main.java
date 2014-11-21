package com.rugieCorp.worldRPG.game;


import com.rugieCorp.engine.Engine;
import com.rugieCorp.engine.Input;
import com.rugieCorp.engine.event.DeadEventListener;
import com.rugieCorp.worldRPG.game.screen.MainMenu;
import com.rugieCorp.worldRPG.game.screen.TestGame;

import java.lang.reflect.Method;

/**
 * User: Adam Chlupacek
 * Date: 10/18/13
 * Time: 11:43 AM
 */
public class Main {

    public static void main(String[] args){
        /// --------

        //Input.inputBus.register(new DeadEventListener());

        /// --------
        Engine engine = new Engine("Game",1000);
        Engine.setScreen(new MainMenu());

        engine.start();

    }
}
