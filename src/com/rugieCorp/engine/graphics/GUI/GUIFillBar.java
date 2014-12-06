package com.rugieCorp.engine.graphics.GUI;

import com.rugieCorp.engine.gameobject.Transform;
import com.rugieCorp.engine.graphics.Material;
import com.rugieCorp.engine.graphics.MeshManager;
import com.rugieCorp.engine.graphics.shader.SpriteVSShader;
import com.rugieCorp.engine.util.ResourceLoader;
import com.rugieCorp.engine.util.dt.Vector2f;
import com.rugieCorp.engine.util.dt.Vector3f;
import com.rugieCorp.engine.util.dt.Vector4f;

/**
 * Created with IntelliJ IDEA.
 * User: adamchlupacek
 * Date: 28/11/14
 * Time: 15:47
 */

//TODO: FINISH!
public class GUIFillBar extends GUI {

  //TODO: Skin implementation
  private Material material = new Material(ResourceLoader.loadTexture("texture/baseTex"), new Vector3f(0,0,1));
  private Material material1 = new Material(ResourceLoader.loadTexture("texture/baseTex"), new Vector3f(1,0,0));

  private Transform barTrans;

  public GUIFillBar(String id, Vector2f position, Vector2f size) {
    super(id, position, size);
    this.barTrans = getTransform().copy();
    Vector3f scale  = getScale();
    this.barTrans.setScale(scale.getX()/2,scale.getY(),scale.getZ());
  }

  @Override
  public void update() {
    super.update();
    this.barTrans.setPos(getTransform().getPos());
  }

  @Override
  public void render() {

    SpriteVSShader.getInstance().bind();
    SpriteVSShader.getInstance().updateUniforms(getTransform(),material,new Vector4f(0,0,1,1));
    MeshManager.squareMesh.draw();
    SpriteVSShader.getInstance().updateUniforms(barTrans,material1,new Vector4f(0,0,1,1));
    MeshManager.squareMesh.draw();
  }
}
