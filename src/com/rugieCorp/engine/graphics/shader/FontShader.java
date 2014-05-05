package com.rugieCorp.engine.graphics.shader;

import com.rugieCorp.engine.Engine;
import com.rugieCorp.engine.gameobject.Transform;
import com.rugieCorp.engine.util.dt.Matrix4f;
import com.rugieCorp.engine.graphics.Material;

/**
 * User: Adam Chlupacek
 * Date: 05/05/14
 * Time: 00:47
 * Package: com.rugieCorp.test
 */
public class FontShader extends Shader {

    private static final FontShader instance = new FontShader();

    public static FontShader getInstance(){
        return instance;
    }

    public FontShader() {
        super();


        addVertexShaderFromFile("Font-Vertex.vrs");
        addFragmentShaderFromFile("Font-Fragment.frs");

        compileShader();

        addUniform("transform");
        addUniform("color");
    }


    public void updateUniforms(Transform transform, Material material){

        Matrix4f worldMatrix = transform.getTransformation();
        Matrix4f projectedMatrix = Engine.getMainCamera().getViewProjection().mul(worldMatrix);

        material.getTexture().bind();

        setUniform("transform", projectedMatrix);
        setUniform("color", material.getColor());
    }
}
