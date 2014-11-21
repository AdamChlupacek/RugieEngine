package com.rugieCorp.engine.graphics;


import com.rugieCorp.engine.graphics.Vertex;
import com.rugieCorp.engine.util.dt.Matrix4f;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Adam Chlupacek
 * Date: 16/03/14
 * Time: 13:02
 * Package: com.base.engine
 */
public class Util {

    public static FloatBuffer createFloatBuffer(int size){
        return BufferUtils.createFloatBuffer(size);
    }

    public static IntBuffer createIndBuffer(int size){
        return BufferUtils.createIntBuffer(size);
    }

    public static IntBuffer createFlippedBuffer(int... values){
        IntBuffer buffer = createIndBuffer(values.length);

        buffer.put(values);
        buffer.flip();

        return buffer;

    }


    public static FloatBuffer createFlippedBuffer(Vertex[] vertices){
        FloatBuffer buffer = createFloatBuffer(vertices.length*Vertex.SIZE);

        for (int i = 0; i<vertices.length;i++){
            buffer.put(vertices[i].getPos().getX());
            buffer.put(vertices[i].getPos().getY());
            buffer.put(vertices[i].getPos().getZ());
            buffer.put(vertices[i].getTextCoord().getX());
            buffer.put(vertices[i].getTextCoord().getY());
        }

        buffer.flip();

        return buffer;
    }


    public static FloatBuffer createFlippedBuffer(Matrix4f value){
        FloatBuffer floatBuffer = createFloatBuffer(4*4);
        for (int i = 0; i<4;i++){
            for (int j = 0; j<4;j++){
                floatBuffer.put(value.get(i,j));
            }
        }

        floatBuffer.flip();

        return floatBuffer;
    }

    public static String[] removeEmptyStrings(String[] data) {

        List<String> result = new ArrayList<String>();

        for (int i = 0; i< data.length; i++){
            if (!data[i].equals("")){
                result.add(data[i]);
            }
        }

        String[] res = new String[result.size()];
        result.toArray(res);

        return res;
    }

    public static int[] toIntArray(Integer[] data) {
        int[] result = new int[data.length];

        for (int i =0; i<data.length; i++){
            result[i] = data[i].intValue();
        }

        return result;
    }
}
