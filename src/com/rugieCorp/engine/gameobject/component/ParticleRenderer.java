package com.rugieCorp.engine.gameobject.component;

import com.rugieCorp.engine.graphics.Particle;
import com.rugieCorp.engine.util.dt.Vector2f;
import org.newdawn.slick.opengl.Texture;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.lwjgl.opengl.GL11.*;

/**
 * User: Adam Chlupacek
 * Date: 30/04/14
 * Time: 14:04
 * Package: com.rugieCorp.engine.gameobject.component
 */
public class ParticleRenderer extends GameComponent {

    private List<Particle> particles;

    public ParticleRenderer(String name, int number, int maxLife, Texture texture) {
        super("particleRenderer:"+name);
        this.particles = new ArrayList<Particle>(number);

        Random r = new Random();

        for (int i = 0; i<number;i++){
            particles.add(new Particle(new Vector2f(10,10),1 + r.nextInt(maxLife),texture));
        }
    }

    @Override
    public void update() {
        for(Particle p:particles){
            p.update();
        }
    }

    @Override
    public void render() {
        glPushMatrix();
        {
            glTranslatef(getParent().getPosition().getX(),getParent().getPosition().getY(),0);

            for(Particle p:particles){
                p.render();
            }
        }
        glPopMatrix();
    }
}
