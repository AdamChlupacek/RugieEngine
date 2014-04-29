package com.rugieCorp.engine.graphics.render;

import static org.lwjgl.opengl.GL11.*;

/**
 * User: Adam Chlupacek
 * Date: 26/04/14
 * Time: 22:19
 * Package: com.rugieCorp.engine.graphics.render
 */
public class Line {

    private float xe,ye;

    public Line(float xe, float ye) {
        this.xe = xe;
        this.ye = ye;
    }

    public void render(){
        glPushMatrix();
        {
            glDisable(GL_TEXTURE_2D);
            glColor4f(0f,0f,0f,1f);
            glBegin(GL_LINES);
            {
                glVertex2f(1,1);
                glVertex2f(xe,ye);
            }
            glEnd();
            glEnable(GL_TEXTURE_2D);
        }
        glPopMatrix();
    }
}
