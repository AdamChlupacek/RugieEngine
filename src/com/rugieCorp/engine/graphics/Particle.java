package com.rugieCorp.engine.graphics;

import com.rugieCorp.engine.util.Delay;
import com.rugieCorp.engine.util.dt.Vector2f;


/**
 * User: Adam Chlupacek
 * Date: 30/04/14
 * Time: 14:05
 * Package: com.rugieCorp.engine.graphics
 */
public class Particle {

    private Delay life;
    //private Square square;

    private boolean dead;

    public Particle(Vector2f size, float life, Texture texture) {
        //this.square = new Square(size.getX(),size.getY());
        this.life = new Delay(life);

        //this.square.setTexture(texture);
        this.dead = false;
    }

    public void update(){
        if (life.isOver()){
            dead = true;
        }
    }

    public void render(){
        if (!life.isStarted())
            life.start();
        //square.render();
    }

    public boolean isDead() {
        return dead;
    }
}
