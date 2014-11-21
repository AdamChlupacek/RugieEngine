package com.rugieCorp.engine.level;


import com.rugieCorp.engine.Engine;
import com.rugieCorp.engine.error.RugieError;
import com.rugieCorp.engine.gameobject.Transform;
import com.rugieCorp.engine.graphics.*;
import com.rugieCorp.engine.level.tile.Tile;
import com.rugieCorp.engine.util.ImgDecode;
import com.rugieCorp.engine.util.ResourceLoader;
import com.rugieCorp.engine.util.dt.Vector2f;
import com.rugieCorp.engine.util.dt.Vector3f;
import com.rugieCorp.engine.graphics.shader.BasicShader;
import com.rugieCorp.engine.util.dt.Vector4f;

import java.awt.image.BufferedImage;

/**
 * User: Adam Chlupacek
 * Date: 11/04/14
 * Time: 13:32
 * Package: com.rugieCorp.engine.level
 */
public class TiledLevel extends Level {

    private Integer[] mapTiles;
    private Mesh mapMesh;

    private static Texture texture = ResourceLoader.loadTexture("texture/tiles");

    private int row = 8;
    private int column = 8;

    private Transform transform;
    private Material material;

    public TiledLevel(String lvlName, String path) {
        super("level");
        BufferedImage bfImg = ResourceLoader.loadImage("level/"+path);
        init(bfImg.getWidth(),bfImg.getHeight());

        mapTiles = ImgDecode.getImageData(bfImg);
        this.transform = new Transform();
        this.transform.setScale(64,64,0);

        this.material = new Material(texture);
    }

    @Override
    public void update() {
        if (Engine.getMainCamera().changed()){
            recreateMesh();
        }
    }

    @Override
    public void render(){

        BasicShader.getInstance().bind();
        BasicShader.getInstance().updateUniforms(transform, material, new Vector4f(0,0,0,0));
        if (mapMesh == null)
            recreateMesh();

        mapMesh.draw();

    }

    private void recreateMesh(){
        if (mapMesh != null) mapMesh.delete();
        float offsetX = Engine.getMainCamera().getOffsetX();
        float offsetY = Engine.getMainCamera().getOffsetY();

        int x0 = (int)offsetX / Tile.SIZE;
        int x1 = x0 + Window.getWidth()  / Tile.SIZE + 1;
        int y0 = (int)offsetY / Tile.SIZE;
        int y1 = y0 + Window.getHeight()  / Tile.SIZE + 2;

        if (x0 < 0) x0 = 0;
        if (y0 < 0) y0 = 0;

        if (x1 > getSx() - 1) x1 = getSx();
        if (y1 > getSy() - 1) y1 = getSy();

        transform.setTranslation(x0 * Tile.SIZE, y0 * Tile.SIZE, 0);

        Vertex[] vertexes = new Vertex[(x1 - x0) * (y1 - y0) * 4];
        int[] indices = new int[(x1 - x0) * (y1 - y0) * 6];

        for (int y = y0; y < y1; y++){
            for (int x = x0;x < x1; x++){
                if (x < 0 || y < 0 || x > getSx() - 1 || y > getSy() - 1) continue;
                if (Tile.tiles.containsKey(mapTiles[y * getSx() + x])){

                    Vector2f texPos = Tile.tiles.get(mapTiles[y * getSx() + x]).getTexPos();

                    vertexes[0 + (y - y0)*(x1 - x0)*4 + (x - x0)*4] = new Vertex(new Vector3f(0 + (x - x0),0 + (y - y0),0), new Vector2f(texPos.getX()/column, texPos.getY()/row + 1f/column));
                    vertexes[1 + (y - y0)*(x1 - x0)*4 + (x - x0)*4] = new Vertex(new Vector3f(1 + (x - x0),0 + (y - y0),0), new Vector2f(texPos.getX()/column + 1f/column, texPos.getY()/row + 1f/column));
                    vertexes[2 + (y - y0)*(x1 - x0)*4 + (x - x0)*4] = new Vertex(new Vector3f(1 + (x - x0),1 + (y - y0),0), new Vector2f(texPos.getX()/column + 1f/column, texPos.getY()/row));
                    vertexes[3 + (y - y0)*(x1 - x0)*4 + (x - x0)*4] = new Vertex(new Vector3f(0 + (x - x0),1 + (y - y0),0), new Vector2f(texPos.getX()/column, texPos.getY()/row));

                    indices[0 + (y - y0)*(x1 - x0)*6 + (x - x0)*6] = 0 + (y - y0)*(x1 - x0)*4 + (x - x0)*4;
                    indices[1 + (y - y0)*(x1 - x0)*6 + (x - x0)*6] = 3 + (y - y0)*(x1 - x0)*4 + (x - x0)*4;
                    indices[2 + (y - y0)*(x1 - x0)*6 + (x - x0)*6] = 2 + (y - y0)*(x1 - x0)*4 + (x - x0)*4;
                    indices[3 + (y - y0)*(x1 - x0)*6 + (x - x0)*6] = 2 + (y - y0)*(x1 - x0)*4 + (x - x0)*4;
                    indices[4 + (y - y0)*(x1 - x0)*6 + (x - x0)*6] = 1 + (y - y0)*(x1 - x0)*4 + (x - x0)*4;
                    indices[5 + (y - y0)*(x1 - x0)*6 + (x - x0)*6] = 0 + (y - y0)*(x1 - x0)*4 + (x - x0)*4;

                }else {
                    new RugieError(this, "Tile with color: " + mapTiles[y * getSx() + x] + " not found").show();
                }
            }
        }

        this.mapMesh = new Mesh(vertexes,indices);

    }

    @Override
    public Tile getTile(int x, int y) {
        return Tile.tiles.get(mapTiles[y*getSy() + x]);
    }

}
