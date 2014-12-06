package com.rugieCorp.worldRPG.game.components;

import com.rugieCorp.engine.Engine;
import com.rugieCorp.engine.gameobject.component.GameComponent;
import com.rugieCorp.engine.graphics.GUI.GUIFillBar;
import com.rugieCorp.engine.util.dt.Vector2f;

/**
 * Created with IntelliJ IDEA.
 * User: adamchlupacek
 * Date: 28/11/14
 * Time: 15:41
 */
public class StatComponent extends GameComponent{

  private boolean player = false;

  public StatComponent(String name, boolean player) {
    super(name);
    this.player = player;
  }

  @Override
  public void init() {
    if (player)
      Engine.getScreen().addGUI(new GUIFillBar("playerHealt", new Vector2f(20,400),new Vector2f(200,20)));
  }

  @Override
  public void update() {

  }
}
