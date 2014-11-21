package com.rugieCorp.engine.graphics.GUI;

import com.rugieCorp.engine.graphics.font.FontText;
import com.rugieCorp.engine.util.FontLoader;
import com.rugieCorp.engine.util.dt.Vector2f;

/**
 * User: Adam Chlupacek
 * Date: 26/04/14
 * Time: 18:43
 * Package: com.rugieCorp.engine.graphics.GUI
 */
public class GUILabel extends GUI {

    private FontText text;

    public GUILabel(String id, Vector2f position, Vector2f size, String text) {
        super(id, position, size);

        this.text = new FontText(FontLoader.font,24);
        this.text.setText(text);

    }

    @Override
    public void render() {
        text.draw(getPosition().getX(),getPosition().getY());
    }

    public void setText(String text) {
        this.text.setText(text);
    }

    public void setSize(int size){
        text.setSize(size);
    }

}
