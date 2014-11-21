package com.rugieCorp.engine.graphics.shader;

import com.rugieCorp.engine.Engine;
import com.rugieCorp.engine.gameobject.Transform;
import com.rugieCorp.engine.graphics.Material;
import com.rugieCorp.engine.util.dt.Matrix4f;
import com.rugieCorp.engine.util.dt.Vector4f;

/**
 * User: Adam Chlupacek
 * Date: 06/05/14
 * Time: 12:26
 * Package: com.rugieCorp.engine.graphics.shader
 */
public class GUIShader extends Shader {

    private static final GUIShader instance = new GUIShader();

    public static GUIShader getInstance(){
        return instance;
    }

    public GUIShader() {
        super();

        addVertexShaderFromFile("GUI-Vertex.vrs");
        addFragmentShaderFromFile("GUI-Fragment.frs");

        addUniform("transform");
        addUniform("color");
        addUniform("textPos");
    }

    @Override
    public void updateUniforms(Transform transform, Material material, Vector4f texPos) {

        Matrix4f worldMatrix = transform.getTransformation();
        Matrix4f projectedMatrix = Engine.getMainCamera().getViewProjection().mul(worldMatrix);

        material.getTexture().bind();

        setUniform("transform", projectedMatrix);
        setUniform("color", material.getColor());
        setUniform("texPos",texPos);
    }
}
