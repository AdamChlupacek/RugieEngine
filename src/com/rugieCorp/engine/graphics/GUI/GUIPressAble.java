package com.rugieCorp.engine.graphics.GUI;

import com.google.common.eventbus.Subscribe;
import com.rugieCorp.engine.Input;
import com.rugieCorp.engine.event.EventInput;
import com.rugieCorp.engine.event.EventMouse;
import com.rugieCorp.engine.util.dt.Vector2f;


/**
 * User: Adam Chlupacek
 * Date: 26/04/14
 * Time: 16:57
 * Package: com.rugieCorp.engine.graphics.GUI
 */
public class GUIPressAble extends GUI {

    private boolean wasOver = false;
    private boolean grabbed = false;

    public GUIPressAble(String id,Vector2f position, Vector2f size) {
        super(id, position, size);
    }

    @Subscribe
    public void input(EventMouse eventMouse){
        if (eventMouse.getButton() == Input.LEFT_MB){
            Vector2f mousePos = eventMouse.getPosition();

            boolean x = mousePos.getX() > getPosition().getX() && mousePos.getX() < getPosition().getX() + getScale().getX();
            boolean y = mousePos.getY() > getPosition().getY() && mousePos.getY() < getPosition().getY() + getScale().getY();

            if (x && y){
                if(!wasOver){
                    mouseEnter(eventMouse);
                }
                hoverOver(eventMouse);
                wasOver = true;
                if (eventMouse.isDown()){
                    mouseDown(eventMouse);
                }else if (eventMouse.isUp()){
                    mouseUp(eventMouse);
                    grabbed = false;
                }
                if(eventMouse.isPress()){
                    grabbed = true;
                    mousePress(eventMouse);
                }
            }else if (wasOver){
                onExit(eventMouse);
                wasOver = false;
            }

            if (eventMouse.isUp()){
                grabbed = false;
                grabRelease(eventMouse);
            }

            if (grabbed){
                grabbed(eventMouse);
            }
        }
    }

    public void mouseEnter(EventMouse eventMouse) {

    }

    public void hoverOver(EventMouse eventMouse){

    }

    public void mouseDown(EventMouse eventMouse){

    }

    public void mouseUp(EventMouse eventMouse){

    }

    public void onExit(EventMouse eventMouse){

    }

    public void mousePress(EventMouse eventMouse){

    }

    public void grabbed(EventMouse eventMouse){

    }

    public void grabRelease(EventMouse eventMouse) {

    }

}
