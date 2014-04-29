package com.rugieCorp.engine.graphics.GUI;

import com.rugieCorp.engine.Input;
import com.rugieCorp.engine.util.dt.Vector2f;
import com.rugieCorp.engine.util.dt.Vector2i;


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

    @Override
    public void getInput() {
        Vector2i mousePos = Input.getMousePosition();

        boolean x = mousePos.getX() > getPosition().getX() && mousePos.getX() < getPosition().getX() + getSize().getX();
        boolean y = mousePos.getY() > getPosition().getY() && mousePos.getY() < getPosition().getY() + getSize().getY();

        if (x && y){
            hoverOver();
            wasOver = true;
            if (Input.getMouseDown(0)){
                mouseDown();
            }else if (Input.getMouseUp(0)){
                mouseUp();
                grabbed = false;
            }
            if(Input.getMouse(0)){
                grabbed = true;
                mousePress();
            }
            if (Input.getMouseDown(1)){
                mouseDownR();
            }else if (Input.getMouseUp(1)){
                mouseUpR();
                grabbed = false;
            }
        }else if (wasOver){
            onExit();
            wasOver = false;
        }

        if (Input.getMouseUp(0)){
            grabbed = false;
            grabRelease();
        }

        if (grabbed){
            grabbed();
        }
    }

    private void mouseUpR() {

    }

    private void mouseDownR() {

    }

    public void hoverOver(){

    }

    public void mouseDown(){

    }

    public void mouseUp(){

    }

    public void onExit(){

    }

    public void mousePress(){

    }

    public void grabbed(){

    }

    public void grabRelease() {

    }

}
