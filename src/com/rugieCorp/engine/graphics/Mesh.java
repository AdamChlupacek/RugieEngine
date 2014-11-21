package com.rugieCorp.engine.graphics;

import com.rugieCorp.engine.util.dt.Vector3f;
import org.lwjgl.opengl.GL15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

/**
 * User: Adam Chlupacek
 * Date: 16/03/14
 * Time: 12:57
 * Package: com.base.engine
 */
public class Mesh {

    private int vbo;
    private int vao;
    private int ibo;
    private int size;

    public Mesh(String fileName){
        initMeshData();
        loadMesh(fileName);
    }

    public Mesh(Vertex[] vertices, int[] indices){
        initMeshData();

        addVertices(vertices, indices);
    }

    private void initMeshData(){
        vbo = glGenBuffers();
        ibo = glGenBuffers();
        vao = glGenVertexArrays();
        size = 0;
    }

    private void addVertices(Vertex[] vertices, int[] indices){

        size = indices.length;
        glBindVertexArray(vao);

        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        GL15.glBufferData(GL_ARRAY_BUFFER, Util.createFlippedBuffer(vertices), GL_STATIC_DRAW);

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,Util.createFlippedBuffer(indices), GL_STATIC_DRAW);
    }

    public void draw(){

        glEnableVertexAttribArray(0);
        glEnableVertexAttribArray(1);

        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0,3,GL_FLOAT,false,Vertex.SIZE * 4,0);
        glVertexAttribPointer(1,2,GL_FLOAT,false,Vertex.SIZE * 4,12);

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glDrawElements(GL_TRIANGLES, size, GL_UNSIGNED_INT, 0);

        glDisableVertexAttribArray(0);
        glDisableVertexAttribArray(1);

    }

    public void delete(){
        glDeleteBuffers(vbo);
        glDeleteBuffers(ibo);
    }


    private void loadMesh(String fileName){
        String[] splitArray = fileName.split("\\.");
        String ext = splitArray[splitArray.length - 1];

        if (!ext.equals("obj")){
            System.err.println("Error: file format not supported for mesh data: " + fileName);
            new Exception().printStackTrace();
            System.exit(1);
        }

        List<Vertex> vertices = new ArrayList<Vertex>();
        List<Integer> indices = new ArrayList<Integer>();


        BufferedReader meshReader;

        try{
            meshReader = new BufferedReader(new FileReader("./res/models/" + fileName));
            String line;

            while ((line = meshReader.readLine()) != null){

                String[] tokens = line.split(" ");
                tokens = Util.removeEmptyStrings(tokens);

                if (tokens.length == 0 || tokens[0].equals("#")){
                    continue;
                }else if (tokens[0].equals("v")){
                    vertices.add(new Vertex(new Vector3f(Float.valueOf(tokens[1]),
                            Float.valueOf(tokens[2]),
                            Float.valueOf(tokens[3])
                    )));
                }else if (tokens[0].equals("f")){
                    indices.add(Integer.valueOf(tokens[1].split("/")[0]) - 1);
                    indices.add(Integer.valueOf(tokens[2].split("/")[0]) - 1);
                    indices.add(Integer.valueOf(tokens[3].split("/")[0]) - 1);

                    if (tokens.length > 4){
                        indices.add(Integer.valueOf(tokens[1].split("/")[0]) - 1);
                        indices.add(Integer.valueOf(tokens[3].split("/")[0]) - 1);
                        indices.add(Integer.valueOf(tokens[4].split("/")[0]) - 1);
                    }
                }
            }

            meshReader.close();

            Vertex[] vertexData = new Vertex[vertices.size()];
            vertices.toArray(vertexData);

            Integer[] indexData = new Integer[indices.size()];
            indices.toArray(indexData);

            addVertices(vertexData, Util.toIntArray(indexData));

        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }

}
