package com.rugieCorp.engine.graphics.GUI;

import com.rugieCorp.engine.Input;
import com.rugieCorp.engine.graphics.GUI.skin.InputTexture;
import com.rugieCorp.engine.graphics.GUI.skin.Skin;
import com.rugieCorp.engine.util.Delay;
import com.rugieCorp.engine.util.dt.Vector2f;

import static org.lwjgl.opengl.GL11.*;

/**
 * User: Adam Chlupacek
 * Date: 26/04/14
 * Time: 22:23
 * Package: com.rugieCorp.engine.graphics.GUI
 */
public class GUITextInput extends GUIPressAble {

    private boolean active;

//    private Square square;
//    private Text text;
//    private Line line;
    private Delay lineDelay;
    private Delay displayDelay;

    private InputTexture inputTexture;


    private String content;

    public GUITextInput(String id, Vector2f position, Vector2f size, Skin skin) {
        super(id, position, size);

        this.inputTexture = skin.getInputTexture();

//        this.square = new Square(size.getX(),size.getY());
//        this.square.setTexture(this.inputTexture.getTexture());
//        this.square.setTextureCoor(this.inputTexture.getNormal());
//
//        this.text = new Text();
//        this.text.setTextOffset(new Vector2f(5, - getSize().getY()));
//        this.text.setSlickColor(Color.black);
//
//        this.line = new Line(0,this.text.getTextHeight() - 9);
//        this.lineDelay = new Delay(0.5f);
//        this.displayDelay = new Delay(0.4f);
//
//        this.content = "";
    }

    @Override
    public void getInput() {
        if (Input.getMouseDown(Input.LEFT_MB)){
            active = false;
            Input.record = false;
//            square.setTextureCoor(inputTexture.getNormal());
        }

        super.getInput();

        if (active){
            Character c = Input.getKeyPressed();
            if (c != null && Character.isAlphabetic(c))
                content += c;
        }

    }

    @Override
    public void render() {
        glPushMatrix();
        {
            glTranslatef(getPosition().getX(),getPosition().getY(), 0);
//            square.render();
//            text.render(content);

            if (lineDelay.isOver()){
                displayDelay.start();
            }
            if (active && !displayDelay.isOver()){
//                glTranslatef(text.getTextWidth(content) + 8,2,0);
//                line.render();
            }else if (displayDelay.isOver()){
                lineDelay.start();
            }


        }
        glPopMatrix();
    }

    @Override
    public void hoverOver() {
        if(!active){
//            square.setTextureCoor(inputTexture.getHover());
        }
    }

    @Override
    public void mouseDown() {
        active = true;
        Input.record = true;
//        square.setTextureCoor(inputTexture.getActive());
        lineDelay.start();
    }

    @Override
    public void onExit() {
        if (!active){
//            square.setTextureCoor(inputTexture.getNormal());
        }
    }
}
