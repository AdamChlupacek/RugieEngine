package com.rugieCorp.engine.graphics.GUI;

import com.rugieCorp.engine.event.EventMouse;
import com.rugieCorp.engine.graphics.GUI.skin.Skin;
import com.rugieCorp.engine.graphics.GUI.skin.ButtonTexture;
import com.rugieCorp.engine.graphics.Mesh;
import com.rugieCorp.engine.graphics.MeshManager;
import com.rugieCorp.engine.graphics.Vertex;
import com.rugieCorp.engine.graphics.shader.BasicShader;
import com.rugieCorp.engine.graphics.shader.FontShader;
import com.rugieCorp.engine.graphics.shader.GUIShader;
import com.rugieCorp.engine.graphics.shader.SpriteVSShader;
import com.rugieCorp.engine.util.FontLoader;
import com.rugieCorp.engine.util.dt.Vector2f;
import com.rugieCorp.engine.graphics.font.*;
import com.rugieCorp.engine.util.dt.Vector3f;
import com.rugieCorp.engine.util.dt.Vector4f;

import static org.lwjgl.opengl.GL11.*;

/**
 * User: Adam Chlupacek
 * Date: 20/04/14
 * Time: 00:36
 * Package: com.rugieCorp.engine.graphics.GUI
 */
public class GUIButton extends GUIPressAble{

    private ButtonTexture buttonTexture;
    private FontText content;
    private Vector4f currentTex;

    private Action action;

    /**
     *
     * @param id the id of the element, which can be used to reference to it later
     * @param text the text of the element
     * @param position position of the element
     * @param scale the size of the element
     * @param skin the gui skin for the element from which is the texture for the button taken
     */
    public GUIButton(String id, String text, Vector2f position, Vector2f scale, Skin skin) {
        super(id, position, scale);

        this.buttonTexture = skin.getButtonTexture();
        this.content = new FontText(FontLoader.font,32);
        this.content.setText(text);

        this.currentTex = this.buttonTexture.getNormal();

    }

    public void render(){
        SpriteVSShader.getInstance().bind();
        SpriteVSShader.getInstance().updateUniforms(getTransform(),buttonTexture.getMaterial(),currentTex);
        MeshManager.squareMesh.draw();
        content.draw(getPosition().getX() + 10,getPosition().getY() + 5);
    }

    @Override
    public void hoverOver(EventMouse eventMouse){
        this.currentTex = this.buttonTexture.getHover();
    }

    @Override
    public void mousePress(EventMouse eventMouse){
        this.currentTex = this.buttonTexture.getDown();
    }

    @Override
    public void mouseUp(EventMouse eventMouse){
        if (action != null)
            action.go();
    }

    @Override
    public void onExit(EventMouse eventMouse){
        this.currentTex = this.buttonTexture.getNormal();
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
