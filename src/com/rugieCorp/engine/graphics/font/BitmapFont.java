package com.rugieCorp.engine.graphics.font;

import com.rugieCorp.engine.graphics.Texture;
import com.rugieCorp.engine.util.ResourceLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Adam Chlupacek
 * Date: 04/05/14
 * Time: 22:58
 * Package: com.rugieCorp.engine.graphics.font
 */
public class BitmapFont {

    private Map<Integer,Glyph> glyphs;

    private Texture texture;
    private String name;
    private int size;


    public BitmapFont(Map<Integer, Glyph> glyphs, Texture texture, String name) {
        this.glyphs = glyphs;
        this.texture = texture;
        this.name = name;
    }

    public BitmapFont(String path) {

        glyphs = new HashMap<Integer, Glyph>();

        BufferedReader fontReader;

        try{
            fontReader = new BufferedReader(new FileReader("./res/font/" + path + ".fnt"));
            String line;

            while ((line = fontReader.readLine()) != null){

                String[] lineSplit = line.split(" ");

                if (lineSplit[0].equals("info")){
                    this.name = lineSplit[1].substring(5);
                    size = Integer.valueOf(lineSplit[2].substring(5));
                    System.out.println("info detected");
                }else if (lineSplit[0].equals("char")){
                    glyphs.put(Integer.valueOf(lineSplit[1].substring(3)),new Glyph(
                            Integer.valueOf(lineSplit[2].substring(2)),
                            Integer.valueOf(lineSplit[3].substring(2)),
                            Integer.valueOf(lineSplit[4].substring(6)),
                            Integer.valueOf(lineSplit[5].substring(7)),
                            Integer.valueOf(lineSplit[6].substring(8)),
                            Integer.valueOf(lineSplit[7].substring(8)),
                            Integer.valueOf(lineSplit[8].substring(9))
                    ));
                }else if(lineSplit[0].equals("page")){
                    texture = ResourceLoader.loadTexture("font/" + lineSplit[2].split("\"")[1].split("\\.")[0]);
                    System.out.println("page detected");
                }

            }

            fontReader.close();
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    public Glyph getGlyph(Integer key){
        return glyphs.get(key);
    }

    public void printGlyphs(){
        for (Map.Entry<Integer,Glyph> entry: glyphs.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
    }

    public Texture getTexture() {
        return texture;
    }

    public int getSize() {
        return size;
    }
}
