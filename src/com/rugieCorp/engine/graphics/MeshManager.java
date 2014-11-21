package com.rugieCorp.engine.graphics;

import com.rugieCorp.engine.util.dt.Vector2f;
import com.rugieCorp.engine.util.dt.Vector3f;

/**
 * User: Adam Chlupacek
 * Date: 06/05/14
 * Time: 12:39
 * Package: com.rugieCorp.engine.graphics
 */
public class MeshManager {

    public static Mesh squareMesh;

    public static void createMeshes(){

        Vertex[] vertexes = new Vertex[]{
                new Vertex(new Vector3f(0,0,0),new Vector2f(0,1)),
                new Vertex(new Vector3f(1,0,0),new Vector2f(1,1)),
                new Vertex(new Vector3f(1,1,0),new Vector2f(1,0)),
                new Vertex(new Vector3f(0,1,0),new Vector2f(0,0))
        };

        int[] indices = new int[]{
                0,1,2,
                2,3,0
        };

        squareMesh = new Mesh(vertexes,indices);
    }

}
