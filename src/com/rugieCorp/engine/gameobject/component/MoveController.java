package com.rugieCorp.engine.gameobject.component;

import com.google.common.eventbus.Subscribe;
import com.rugieCorp.engine.Input;
import com.rugieCorp.engine.event.EventKey;
import com.rugieCorp.engine.util.dt.Vector2f;
import com.rugieCorp.engine.util.dt.Vector3f;

/**
 * User: Adam Chlupacek
 * Date: 18/04/14
 * Time: 15:03
 * Package: com.rugieCorp.engine.gameobject.component
 */
public class MoveController extends GameComponent {

    private int speed;

    private Collider collider;
    private Camera camera;

    public MoveController(int speed) {
        super("moveController");
        this.speed = speed;


    }

    @Override
    public void init(){
        collider = (Collider)parent.getComponent("collider");
        camera = (Camera)parent.getComponent("camera");
    }

  /**
   * Check for move
   * @param eventKey
   */
    @Subscribe
    public void move(EventKey eventKey){

        if (eventKey.isPress()){

            if (eventKey.getKey() == Input.KEY_D){
                move(1, 0);
            }

            if (eventKey.getKey() == Input.KEY_A){
                move(-1, 0);
            }

            if (eventKey.getKey() == Input.KEY_S){
                move(0, -1);
            }

            if (eventKey.getKey() == Input.KEY_W){
                move(0,1);
            }
        }
    }

    public void move(int x, int y){
        Vector3f origP = parent.getPosition();
        parent.setPosition(parent.getPosition().add(new Vector3f(x * speed, y * speed,0)));
        collider.collide();
        if (collider != null && collider.isCollided()){
            parent.setPosition(origP);
        }
        camera.move(x, y);
    }
}
