package com.rugieCorp.worldRPG.game.screen;

import com.rugieCorp.engine.gameobject.component.CameraBoing;
import com.rugieCorp.engine.Engine;
import com.rugieCorp.engine.gameobject.GameObject;
import com.rugieCorp.engine.gameobject.component.ColliderSquare;
import com.rugieCorp.engine.gameobject.component.MoveController;
import com.rugieCorp.engine.gameobject.component.RectangleRender;
import com.rugieCorp.engine.graphics.Screen;
import com.rugieCorp.engine.level.TiledLevel;
import com.rugieCorp.engine.util.ResourceLoader;
import com.rugieCorp.engine.util.dt.Vector3f;
import com.rugieCorp.engine.graphics.Material;
import com.rugieCorp.worldRPG.game.components.StatComponent;

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

        Material material = new Material(ResourceLoader.loadTexture("texture/baseTex"));


        GameObject player = new GameObject("player");
        player.setScale(new Vector3f(64, 64 ,0));
        player.setPosition(new Vector3f(70, 70, 0));
        player.addComponent(new CameraBoing(0, 1280, 0, 800, 1, -1));
        player.addComponent(new MoveController(1));
        player.addComponent(new ColliderSquare());
        player.addComponent(new RectangleRender(material));
        player.addComponent(new StatComponent("playerHealt",true));

        Engine.setMainCamera((CameraBoing)player.getComponent("camera"));

        addToRoot(player);

        GameObject something = new GameObject("something");
        something.setScale(new Vector3f(64, 64,0));
        something.addComponent(new ColliderSquare());

        something.addComponent(new RectangleRender(material));
        something.setPosition(new Vector3f(150, 150,0));

        addToRoot(something);


    }
}
