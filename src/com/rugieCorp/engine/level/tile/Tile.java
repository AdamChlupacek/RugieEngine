package com.rugieCorp.engine.level.tile;

import com.rugieCorp.engine.graphics.Color;
import com.rugieCorp.engine.graphics.render.Square;
import com.rugieCorp.engine.util.ResourceLoader;
import org.newdawn.slick.opengl.Texture;

import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.opengl.GL11.*;

/**
 * User: Adam Chlupacek
 * Date: 11/04/14
 * Time: 13:33
 * Package: com.rugieCorp.engine.level.tile
 */
public class Tile {

    public static final int SIZE = 64;
    private static Texture texture = ResourceLoader.loadTexture("tiles");


    public static Map<Integer, Tile> tiles = new HashMap<Integer, Tile>();

    public static Tile tileA = new Tile(Color.BLACK,"TILEA",true,1,0);
    public static Tile tileB = new Tile(Color.GREEN,"TILEB",false,0,1);



    private Color color;
    private String name;
    private Square square;

    private boolean solid;

    public Tile(Color color, String name,boolean solid, int textureX, int textureY) {
        this.color = color;
        this.name = name;
        this.solid = solid;


        this.square = new Square(SIZE,SIZE);
        this.square.setTexture(texture, (float)textureX * (float)SIZE/512, (float)textureY * (float)SIZE/512, (float)SIZE/512, (float)SIZE/512);

        tiles.put(color.getColor(),this);
    }




    public void render(){
        glPushMatrix();
        {
            square.render();
        }
        glPopMatrix();
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public boolean isSolid() {
        return solid;
    }
}
