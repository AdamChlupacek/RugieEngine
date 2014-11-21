package com.rugieCorp.engine.graphics;

import com.rugieCorp.engine.util.dt.Vector2f;
import com.rugieCorp.engine.util.dt.Vector3f;

/**
 * User: Adam Chlupacek
 * Date: 16/03/14
 * Time: 12:55
 * Package: com.base.engine
 */
public class Vertex {

    public static final int SIZE = 5;

    private Vector3f pos;
    private Vector2f textCoord;

    public Vertex(Vector3f pos) {
        this(pos,new Vector2f(0,0));
    }

    public Vertex(Vector3f pos, Vector2f textCoord){
        this.pos = pos;
        this.textCoord = textCoord;
    }

    public Vector3f getPos() {
        return pos;
    }

    public void setPos(Vector3f pos) {
        this.pos = pos;
    }

    public static int getSize() {
        return SIZE;
    }

    public Vector2f getTextCoord() {
        return textCoord;
    }

    public void setTextCoord(Vector2f textCoord) {
        this.textCoord = textCoord;
    }

}
