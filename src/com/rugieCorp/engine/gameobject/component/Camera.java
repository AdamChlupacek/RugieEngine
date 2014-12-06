package com.rugieCorp.engine.gameobject.component;

import com.rugieCorp.engine.util.dt.Matrix4f;

/**
 * User: Adam Chlupacek
 * Date: 20/04/14
 * Time: 00:38
 * Package: com.rugieCorp.engine.gameobject.component
 */

/**
 * An interface for camera
 */
public interface Camera {

  /**
   * Moving camera
   * @param x move by in x direction
   * @param y move by in y direction
   */
  public void move(int x, int y);

  /**
   * Getter for the position of camera in x direction
   * @return x direction
   */
  public float getOffsetX();

  /**
   * Getter for the position of camera in y direction
   * @return y direction
   */
  public float getOffsetY();

  /**
   * Projection view (frustum) for the camera,
   * @return projection view of the camera
   */
  public Matrix4f getViewProjection();

  /**
   * If the camera changed its position
   */
  public boolean changed();
}
