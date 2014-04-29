package com.rugieCorp.engine.graphics.GUI;

import com.rugieCorp.engine.graphics.GUI.skin.Skin;
import com.rugieCorp.engine.graphics.GUI.skin.TickTexture;
import com.rugieCorp.engine.graphics.render.Square;
import com.rugieCorp.engine.graphics.render.Text;
import com.rugieCorp.engine.util.dt.Vector2f;

import static org.lwjgl.opengl.GL11.*;


/**
 * User: Adam Chlupacek
 * Date: 26/04/14
 * Time: 20:31
 * Package: com.rugieCorp.engine.graphics.GUI
 */
public class GUITick extends GUIPressAble {

    private boolean checked;
    private String content;

    private Text text;
    private Square square;
    private Square tick;

    private TickTexture tickTexture;

    public GUITick(String id, Vector2f position, Vector2f size, String text, Skin skin) {
        super(id, position, size);

        this.text = new Text();
        this.text.setTextOffset(new Vector2f(getSize().getX() + 5,- 7 -getSize().getY()));

        this.content = text;

        this.tickTexture = skin.getTickTexture();

        this.square = new Square(size.getX(),size.getY());
        this.square.setTexture(tickTexture.getTexture());
        this.square.setTextureCoor(tickTexture.getNormal());

        this.tick = new Square(size.getX(),size.getY());
        this.tick.setTexture(tickTexture.getTexture());
        this.tick.setTextureCoor(tickTexture.getCheck());
    }


    @Override
    public void render() {
        glPushMatrix();
        {
            glTranslatef(getPosition().getX(),getPosition().getY(),0);
            square.render();
            if (checked){
                tick.render();
            }
            text.render(content);
        }
        glPopMatrix();
    }

    @Override
    public void onExit() {
        square.setTextureCoor(tickTexture.getNormal());
    }

    @Override
    public void hoverOver() {
        square.setTextureCoor(tickTexture.getHover());
    }

    @Override
    public void mouseUp() {
        checked = !checked;
    }
}
