package com.rugieCorp.engine.graphics.shader;


import com.rugieCorp.engine.Engine;
import com.rugieCorp.engine.gameobject.Transform;
import com.rugieCorp.engine.util.dt.Matrix4f;
import com.rugieCorp.engine.graphics.Material;

/**
 * User: Adam Chlupacek
 * Date: 18/03/14
 * Time: 21:56
 * Package: com.base.engine
 */
public class BasicShader extends Shader {

    private static final BasicShader instance = new BasicShader();

    public static BasicShader getInstance(){
        return instance;
    }

    public BasicShader(){
        super();

        addVertexShaderFromFile("basicVertex.vrs");
        addFragmentShaderFromFile("basicFragment.frs");
        compileShader();

        addUniform("transform");
        addUniform("color");
    }

    @Override
    public void updateUniforms(Transform transform, Material material){

        Matrix4f worldMatrix = transform.getTransformation();
        Matrix4f projectedMatrix = Engine.getMainCamera().getViewProjection().mul(worldMatrix);

        material.getTexture().bind();

        setUniform("transform", projectedMatrix);
        setUniform("color", material.getColor());
    }

}
