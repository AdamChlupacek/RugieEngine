package com.rugieCorp.engine.level;

import com.rugieCorp.engine.gameobject.component.GameComponent;
import com.rugieCorp.engine.level.tile.Tile;

/**
 * User: Adam Chlupacek
 * Date: 11/04/14
 * Time: 13:31
 * Package: com.rugieCorp.engine
 */
public abstract class Level extends GameComponent {

    private int sx,sy;

    public Level(String name) {
        super(name);
    }

    protected void init(int sx, int sy){
        this.sx = sx;
        this.sy = sy;
    }

    public int getSx() {
        return sx;
    }

    public int getSy() {
        return sy;
    }

    public abstract Tile getTile(int x, int y);
}
