package com.rugieCorp.engine.graphics;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created with IntelliJ IDEA.
 * User: adamchlupacek
 * Date: 21/11/14
 * Time: 20:54
 */
public class Texture {

  private int id;

  public Texture(int id) {
    this.id = id;
  }

  public void bind() {
    glBindTexture(GL_TEXTURE_2D,id);
  }
}
