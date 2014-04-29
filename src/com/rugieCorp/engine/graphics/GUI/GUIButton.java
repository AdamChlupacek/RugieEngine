package com.rugieCorp.engine.graphics.GUI;

import com.rugieCorp.engine.graphics.GUI.skin.Skin;
import com.rugieCorp.engine.graphics.GUI.skin.ButtonTexture;
import com.rugieCorp.engine.graphics.render.Square;
import com.rugieCorp.engine.graphics.render.Text;
import com.rugieCorp.engine.util.dt.Vector2f;

import static org.lwjgl.opengl.GL11.*;

/**
 * User: Adam Chlupacek
 * Date: 20/04/14
 * Time: 00:36
 * Package: com.rugieCorp.engine.graphics.GUI
 */
public class GUIButton extends GUIPressAble{

    private Square button;
    private ButtonTexture buttonTexture;

    private Text text;
    private String content;

    private Action action;

    /**
     *
     * @param id the id of the element, which can be used to reference to it later
     * @param text the text of the element
     * @param position position of the element
     * @param size the size of the element
     * @param skin the gui skin for the element from which is the texture for the button taken
     */
    public GUIButton(String id, String text, Vector2f position, Vector2f size, Skin skin) {
        super(id, position, size);

        this.button = new Square(getSize().getX(),getSize().getY());
        this.buttonTexture = skin.getButtonTexture();
        this.button.setTexture(buttonTexture.getTexture());
        this.button.setTextureCoor(buttonTexture.getNormal());

        this.text = new Text();
        this.text.setTextOffset(new Vector2f(30,-getSize().getY()));
        this.content = text;
    }

    public void render(){
        glPushMatrix();
        {
            glTranslatef(getPosition().getX(),getPosition().getY(),0);
            button.render();
            text.render(content);
        }
        glPopMatrix();
    }

    @Override
    public void hoverOver(){
        button.setTextureCoor(buttonTexture.getHover());
    }

    @Override
    public void mousePress(){
        button.setTextureCoor(buttonTexture.getDown());
    }

    @Override
    public void mouseUp(){
        if (action != null)
            action.go();
    }

    @Override
    public void onExit(){
        button.setTextureCoor(buttonTexture.getNormal());
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
