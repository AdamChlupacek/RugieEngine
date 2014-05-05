package com.rugieCorp.engine.gameobject.component;

import com.rugieCorp.engine.Engine;
import com.rugieCorp.engine.error.RugieError;
import com.rugieCorp.engine.gameobject.GameObject;
import com.rugieCorp.engine.level.Level;
import com.rugieCorp.engine.level.tile.Tile;

/**
 * User: Adam Chlupacek
 * Date: 19/04/14
 * Time: 13:28
 * Package: com.rugieCorp.engine.gameobject.component
 */
public class ColliderSquare extends GameComponent implements Collider {

    private float sx, sy;

    private Level level;
    private boolean collides;

    public ColliderSquare() {
        super("collider");

        collides = false;
    }

    @Override
    public void init(){
        for (GameObject go:Engine.getScreen().getRoot().getChildren()){
            if (go.hasComponent("level")){
                level = (Level)go.getComponent("level");
            }
        }

        sy = parent.getScale().getY();
        sx = parent.getScale().getX();
    }

    @Override
    public void collide() {
        collides = false;
        for (GameObject go: Engine.getScreen().getRoot().getChildren()){
            if (!go.equals(parent)) {
                if (go.hasComponent("collider")){
                    GameComponent collider = go.getComponent("collider");

                    float[] colsB = ((Collider)collider).getCollSide();

                    if (colsB.length == 1){

                        boolean colX = parent.getPosition().getX() < collider.getParent().getPosition().getX() + colsB[0] && parent.getPosition().getX() + sx > collider.getParent().getPosition().getX() - colsB[0];
                        boolean colY = parent.getPosition().getY() < collider.getParent().getPosition().getY() + colsB[0] && parent.getPosition().getY() + sy > collider.getParent().getPosition().getY() - colsB[0];

                        //TODO: Circle collision
                        //return colX || colY;
                    }

                    if (colsB.length == 2){

                        float left0, left1;
                        float right0, right1;
                        float top0, top1;
                        float bottom0, bottom1;

                        left0 = parent.getPosition().getX();
                        right0 = parent.getPosition().getX() + sx;
                        top0 = parent.getPosition().getY() + sy;
                        bottom0 = parent.getPosition().getY();

                        left1 = collider.getParent().getPosition().getX();
                        right1 = collider.getParent().getPosition().getX() + colsB[0];
                        top1 = collider.getParent().getPosition().getY() + colsB[1];
                        bottom1 = collider.getParent().getPosition().getY();

                        if (top0 <= bottom1) continue;
                        if (bottom0 >= top1) continue;
                        if (right0 <= left1) continue;
                        if (left0 >= right1) continue;


                        collides = true;
                    }else {
                        new RugieError(this,"Number of collides sides is not expected: " + colsB.length).show();
                    }
                }
            }
        }

        if (!collides && level != null)
            collides = levelCollide();



    }

    @Override
    public float[] getCollSide() {
        return new float[]{sx,sy};
    }

    @Override
    public boolean isCollided() {
        return collides;
    }

    @Override
    public GameObject getCollisionObject() {
        return null;
    }


    private boolean levelCollide(){

        int x0 = (int)parent.getPosition().getX() / Tile.SIZE - 1;
        int y0 = (int)parent.getPosition().getY() / Tile.SIZE - 1;

        int x1 = (int)(parent.getPosition().getX() + sx)/ Tile.SIZE + 1;
        int y1 = (int)(parent.getPosition().getY() + sy)/ Tile.SIZE + 1;

        for (int y = y0; y<y1;y++){
            for (int x = x0; x<x1;x++){
                if (x < 0 || y < 0 || x > level.getSx() - 1 || y > level.getSy() - 1) continue;
                Tile tile= level.getTile(x,y);

                if (!tile.isSolid()) continue;

                float left0 = parent.getPosition().getX();
                float right0 = parent.getPosition().getX() + sx;
                float top0 = parent.getPosition().getY() + sy;
                float bottom0 = parent.getPosition().getY();

                float left1 = x * Tile.SIZE;
                float right1 = x * Tile.SIZE + Tile.SIZE;
                float top1 = y * Tile.SIZE + Tile.SIZE;
                float bottom1 = y * Tile.SIZE;

                if (top0 <= bottom1) continue;
                if (bottom0 >= top1) continue;
                if (right0 <= left1) continue;
                if (left0 >= right1) continue;

                return true;
            }
        }

        return false;
    }

}
