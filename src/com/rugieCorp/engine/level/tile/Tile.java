package com.rugieCorp.engine.level.tile;

import com.rugieCorp.engine.gameobject.Transform;
import com.rugieCorp.engine.graphics.Color;
import com.rugieCorp.engine.graphics.Mesh;
import com.rugieCorp.engine.graphics.Vertex;
import com.rugieCorp.engine.graphics.shader.BasicShader;
import com.rugieCorp.engine.graphics.shader.Shader;
import com.rugieCorp.engine.util.dt.Vector2f;
import com.rugieCorp.engine.util.dt.Vector3f;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Adam Chlupacek
 * Date: 11/04/14
 * Time: 13:33
 * Package: com.rugieCorp.engine.level.tile
 */
public class Tile {

    public static final int SIZE = 64;
//    private static Texture texture = ResourceLoader.loadTexture("tiles");

    public static Map<Integer, Tile> tiles = new HashMap<Integer, Tile>();

    public static Tile tileA = new Tile(Color.BLACK,"TILEA",true,1,0);
    public static Tile tileB = new Tile(Color.GREEN,"TILEB",false,0,1);

    private static Mesh mesh;
    private static Shader shader = BasicShader.getInstance();

    private Color color;
    private String name;
    private boolean solid;

    private Vector2f texPos;

    public Tile(Color color, String name,boolean solid, float texX, float texY) {
        this.color = color;
        this.name = name;
        this.solid = solid;
        this.texPos = new Vector2f(texX,texY);
        tiles.put(color.getColor(),this);

        //TODO: Check if mesh square by square is less efficient

        Vertex[] vertexes = new Vertex[]{
                new Vertex(new Vector3f(0,0,0),new Vector2f(0,1)),
                new Vertex(new Vector3f(1,0,0),new Vector2f(1,1)),
                new Vertex(new Vector3f(1,1,0),new Vector2f(1,0)),
                new Vertex(new Vector3f(0,1,0),new Vector2f(0,0))
        };

        int[] indices = new int[]{
                0,1,2,
                2,3,0
        };

        mesh = new Mesh(vertexes,indices);
    }




    public void render(Transform transform){

        mesh.draw();
    }

    public Vector2f getTexPos(){
        return texPos;
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
