package com.rugieCorp.engine.event;

/**
 * User: Adam Chlupacek
 * Date: 30/05/14
 * Time: 11:25
 * Package: com.rugieCorp.engine.event
 */
public class EventKey extends EventInput {

    private int key;

    private boolean press;
    private boolean down;
    private boolean up;

    public EventKey(int key, boolean press, boolean down, boolean up) {
        this.key = key;
        this.press = press;
        this.down = down;
        this.up = up;
    }

    public int getKey() {
        return key;
    }

    public boolean isPress() {
        return press;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isUp() {
        return up;
    }
}
