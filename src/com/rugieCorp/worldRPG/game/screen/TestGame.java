package com.rugieCorp.worldRPG.game.screen;

import com.rugieCorp.engine.gameobject.component.CameraBoing;
import com.rugieCorp.engine.Engine;
import com.rugieCorp.engine.gameobject.GameObject;
import com.rugieCorp.engine.gameobject.component.ColliderSquare;
import com.rugieCorp.engine.gameobject.component.MoveController;
import com.rugieCorp.engine.gameobject.component.RectangleRender;
import com.rugieCorp.engine.graphics.GUI.GUILabel;
import com.rugieCorp.engine.graphics.screen.Screen;
import com.rugieCorp.engine.level.TiledLevel;
import com.rugieCorp.engine.util.dt.Vector2f;

/**
 * User: Adam Chlupacek
 * Date: 11/04/14
 * Time: 12:28
 * Package: com.rugieCorp.worldRPG.game.screen
 */
public class TestGame extends Screen {

    public TestGame(){

        GameObject levelObject = new GameObject("level");
        levelObject.addComponent(new TiledLevel("level1","level"));

        addToRoot(levelObject);

        GameObject player = new GameObject("player");
        player.setSize(new Vector2f(64,64));
        player.setPosition(new Vector2f(70,70));
        player.addComponent(new CameraBoing(200));
        player.addComponent(new MoveController(1));
        player.addComponent(new ColliderSquare());
        player.addComponent(new RectangleRender());

        Engine.setMainCamera((CameraBoing)player.getComponent("camera"));

        addToRoot(player);


        GameObject something = new GameObject("something");
        something.setSize(new Vector2f(100,100));
        something.addComponent(new ColliderSquare());
        something.addComponent(new RectangleRender());
        something.setPosition(new Vector2f(100,150));

        addToRoot(something);


    }
}
