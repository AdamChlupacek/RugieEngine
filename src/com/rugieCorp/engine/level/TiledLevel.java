package com.rugieCorp.engine.level;


import com.rugieCorp.engine.Engine;
import com.rugieCorp.engine.error.RugieError;
import com.rugieCorp.engine.graphics.screen.Window;
import com.rugieCorp.engine.level.tile.Tile;
import com.rugieCorp.engine.util.ImgDecode;
import com.rugieCorp.engine.util.ResourceLoader;

import java.awt.image.BufferedImage;

import static org.lwjgl.opengl.GL11.*;

/**
 * User: Adam Chlupacek
 * Date: 11/04/14
 * Time: 13:32
 * Package: com.rugieCorp.engine.level
 */
public class TiledLevel extends Level {

    private Integer[] mapTiles;

    public TiledLevel(String lvlName, String path) {
        super("level");
        BufferedImage bfImg = ResourceLoader.loadTiledLevel(path);
        init(bfImg.getWidth(),bfImg.getHeight());

        mapTiles = ImgDecode.getImageData(bfImg);
    }

    @Override
    public void render(){

        float offsetX = Engine.getMainCamera().getOffsetX();
        float offsetY = Engine.getMainCamera().getOffsetY();

        int x0 = (int)offsetX / Tile.SIZE;
        int x1 = x0 + Window.getWidth()  / Tile.SIZE + 1;
        int y0 = (int)offsetY / Tile.SIZE;
        int y1 = y0 + Window.getHeight()  / Tile.SIZE + 2;

        for (int y = y0; y < y1; y++){
            for (int x = x0;x < x1; x++){
                if (x < 0 || y < 0 || x > getSx() - 1 || y > getSy() - 1) continue;
                if (Tile.tiles.containsKey(mapTiles[y * getSx() + x])){
                    glPushMatrix();
                    {
                        glTranslatef(x * Tile.SIZE, y * Tile.SIZE,0);
                        Tile.tiles.get(mapTiles[y * getSx() + x]).render();
                    }
                    glPopMatrix();
                }else {
                    new RugieError(this, "Tile with color: " + mapTiles[y * getSx() + x] + " not found").show();
                }
            }
        }
    }


    @Override
    public Tile getTile(int x, int y) {
        return Tile.tiles.get(mapTiles[y*getSy() + x]);
    }
}
