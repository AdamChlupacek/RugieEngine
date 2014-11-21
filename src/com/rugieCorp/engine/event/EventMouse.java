package com.rugieCorp.engine.event;

import com.rugieCorp.engine.util.dt.Vector2f;

/**
 * User: Adam Chlupacek
 * Date: 30/05/14
 * Time: 11:32
 * Package: com.rugieCorp.engine.event
 */
public class EventMouse extends EventInput {

    private int button;

    private boolean press;
    private boolean up;
    private boolean down;

    private boolean GUIMouseTaken;

    private Vector2f position;

    public EventMouse(int button, boolean press, boolean up, boolean down, Vector2f position) {
        this.button = button;
        this.press = press;
        this.up = up;
        this.down = down;
        this.position = position;
        this.GUIMouseTaken = false;
    }

    public int getButton() {
        return button;
    }

    public boolean isPress() {
        return press;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public Vector2f getPosition() {
        return position;
    }

    public boolean isGUIMouseTaken() {
        return GUIMouseTaken;
    }

    public void setGUIMouseTaken(boolean GUIMouseTaken) {
        this.GUIMouseTaken = GUIMouseTaken;
    }
}
