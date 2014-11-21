package test;

import com.google.common.eventbus.EventBus;
import com.rugieCorp.engine.Engine;
import com.rugieCorp.engine.gameobject.component.CameraStationary;
import com.rugieCorp.engine.graphics.Window;
import com.rugieCorp.engine.graphics.font.FontText;
import com.rugieCorp.engine.util.FontLoader;
import com.rugieCorp.engine.util.Logger;
import com.rugieCorp.worldRPG.game.screen.MainMenu;

/**
 * User: Adam Chlupacek
 * Date: 23/05/14
 * Time: 12:44
 * Package: com.rugieCorp.worldRPG.game
 */
public class TEST {

    public static void main(String[] args){
        EventBus bus = new EventBus("testBus");

        bus.register(new TestListener("Listener1"));
        bus.register(new TestListener("Listener2"));

        bus.post(new TestEvent("YOLO"));

        Logger.info("YOLO lives");
    }
}
