package com.rugieCorp.engine.graphics.shader;

import com.rugieCorp.engine.Engine;
import com.rugieCorp.engine.gameobject.Transform;
import com.rugieCorp.engine.graphics.Material;
import com.rugieCorp.engine.util.dt.Matrix4f;
import com.rugieCorp.engine.util.dt.Vector4f;

/**
 * User: Adam Chlupacek
 * Date: 23/05/14
 * Time: 11:28
 * Package: com.rugieCorp.engine.graphics.shader
 */
public class SpriteVSShader extends Shader {

    private static final SpriteVSShader instance = new SpriteVSShader();

    public static SpriteVSShader getInstance(){
        return instance;
    }

    public SpriteVSShader() {
        super();

        addVertexShaderFromFile("spriteVSVertex.vrs");
        addFragmentShaderFromFile("spriteVSFragment.frs");

        compileShader();

        addUniform("transform");
        addUniform("color");
        addUniform("texAdjust");
    }

    @Override
    public void updateUniforms(Transform transform, Material material, Vector4f texPos) {

        Matrix4f worldMatrix = transform.getTransformation();
        Matrix4f projectedMatrix = Engine.getMainCamera().getViewProjection().mul(worldMatrix);

        material.getTexture().bind();

        setUniform("transform", projectedMatrix);
        setUniform("color", material.getColor());
        setUniform("texAdjust",texPos);
    }
}
