package com.rugieCorp.engine.graphics.shader;



import com.rugieCorp.engine.gameobject.Transform;
import com.rugieCorp.engine.util.dt.Matrix4f;
import com.rugieCorp.engine.util.dt.Vector2f;
import com.rugieCorp.engine.util.dt.Vector3f;
import com.rugieCorp.engine.graphics.Material;
import com.rugieCorp.engine.graphics.Util;
import com.rugieCorp.engine.util.dt.Vector4f;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL32.GL_GEOMETRY_SHADER;

/**
 * User: Adam Chlupacek
 * Date: 16/03/14
 * Time: 13:27
 * Package: com.base.engine
 */
public class Shader {

    private int program;

    private HashMap<String,Integer> uniforms;

    public Shader(){
        program = glCreateProgram();
        uniforms = new HashMap<String, Integer>();

        if (program == 0){
            System.err.println("Shader creation failed, could not find valid memory location in constructor");
            System.exit(1);
        }
    }

    public void bind(){
        glUseProgram(program);
    }

    public void updateUniforms(Transform transform, Material material, Vector4f texPos){

    }

    public void addUniform(String uniform){
        int uniformLocation = glGetUniformLocation(program,uniform);

        if (uniformLocation == 0xFFFFFFFF){
            System.err.println("Could not find uniform: " + uniform);
            new Exception().printStackTrace();
            System.exit(1);
        }

        uniforms.put(uniform,uniformLocation);
    }

    public void addVertexShaderFromFile(String text){
        addProgram(loadShader(text),GL_VERTEX_SHADER);
    }

    public void addVertexShader(String text){
        addProgram(text,GL_VERTEX_SHADER);
    }

    public void addFragmentShaderFromFile(String text){
        addProgram(loadShader(text),GL_FRAGMENT_SHADER);
    }

    public void addFragmentShader(String text){
        addProgram(text,GL_FRAGMENT_SHADER);
    }

    public void addGeometryShaderFromFile(String text){
        addProgram(loadShader(text),GL_GEOMETRY_SHADER);
    }

    public void addGeometryShader(String text){
        addProgram(text,GL_GEOMETRY_SHADER);
    }

    public void compileShader(){
        glLinkProgram(program);

        if (glGetProgrami(program, GL_LINK_STATUS) == 0){
            System.err.println(glGetProgramInfoLog(program,1024));
            System.exit(1);
        }

        glValidateProgram(program);

        if (glGetProgrami(program, GL_VALIDATE_STATUS) == 0){
            System.err.println(glGetProgramInfoLog(program,1024));
            System.exit(1);
        }

    }

    private void addProgram(String text, int type){

        int shader = glCreateShader(type);

        if (shader == 0){
            System.err.println("Shader creation failed, could not find valid memory location when adding shader");
            System.exit(1);
        }

        glShaderSource(shader,text);
        glCompileShader(shader);

        if (glGetShaderi(shader, GL_COMPILE_STATUS) == 0){
            System.err.println(glGetShaderInfoLog(shader,1024));
            System.exit(1);
        }

        glAttachShader(program,shader);
    }

    public void setUniformi(String uniformName, int value){
        glUniform1i(uniforms.get(uniformName), value);
    }
    public void setUniformf(String uniformName, float value){
        glUniform1f(uniforms.get(uniformName), value);
    }
    public void setUniform(String uniformName, Vector2f value){
        glUniform2f(uniforms.get(uniformName), value.getX(), value.getY());
    }
    public void setUniform(String uniformName, Vector3f value){
        glUniform3f(uniforms.get(uniformName), value.getX(), value.getY(), value.getZ());
    }
    public void setUniform(String uniformName, Vector4f value){
        glUniform4f(uniforms.get(uniformName), value.getX(), value.getY(), value.getZ(),value.getW());
    }
    public void setUniform(String uniformName, Matrix4f value){
        glUniformMatrix4(uniforms.get(uniformName), true, Util.createFlippedBuffer(value));
    }


    private static String loadShader(String fileName){
        StringBuilder shaderSource = new StringBuilder();

        BufferedReader shaderReader;

        try{
            shaderReader = new BufferedReader(new FileReader("./res/shader/" + fileName));
            String line;

            while ((line = shaderReader.readLine()) != null){
                shaderSource.append(line).append("\n");
            }

            shaderReader.close();
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }


        return shaderSource.toString();
    }

}
