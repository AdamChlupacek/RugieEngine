package com.rugieCorp.worldRPG.game.screen;

import com.rugieCorp.engine.Engine;
import com.rugieCorp.engine.gameobject.GameObject;
import com.rugieCorp.engine.gameobject.component.CameraStationary;
import com.rugieCorp.engine.gameobject.component.RectangleRender;
import com.rugieCorp.engine.graphics.GUI.*;
import com.rugieCorp.engine.graphics.GUI.skin.*;
import com.rugieCorp.engine.graphics.Material;
import com.rugieCorp.engine.graphics.Screen;
import com.rugieCorp.engine.graphics.Window;
import com.rugieCorp.engine.util.FontLoader;
import com.rugieCorp.engine.util.ResourceLoader;
import com.rugieCorp.engine.util.dt.Vector2f;
import com.rugieCorp.engine.util.dt.Vector4f;

/**
 * User: Adam Chlupacek
 * Date: 20/04/14
 * Time: 00:35
 * Package: com.rugieCorp.worldRPG.game.screen
 */
public class MainMenu extends Screen {

    public MainMenu() {

        Engine.setMainCamera(new CameraStationary(0, Window.getWidth(),0,Window.getHeight(),1,-1));

        ButtonTexture bt = new ButtonTexture(ResourceLoader.loadTexture("texture/button"),
                           new Vector4f(0,0,242f/256,31f/256),          //Normal state
                           new Vector4f(0,31f/256,242f/256,31f/256),    //Down state
                           new Vector4f(0,62f/256,242f/256,31f/256)     //Hover state
        );

        TickTexture tt = new TickTexture(ResourceLoader.loadTexture("texture/tick"),
                         new Vector4f(0,0,64f/128,64f/128),
                         new Vector4f(64f/128,0,64f/128,64f/128),
                         new Vector4f(0,64f/128,64f/128,64f/128)
        );

        InputTexture it = new InputTexture(ResourceLoader.loadTexture("texture/inputButton"),
                          new Vector4f(0,0,201f/256,33f/126),
                          new Vector4f(0,32.25f/126,201f/256,33f/126),
                          new Vector4f(0,65f/126,201f/256,33f/126)
        );

        SliderTexture st = new SliderTexture(ResourceLoader.loadTexture("texture/slider"),
                           new Vector4f(0,11f/256, 65f/256, 65f/256),
                           new Vector4f(130f/256,11f/256, 65f/256, 65f/256),
                           new Vector4f(65f/256,11f/256, 65f/256, 65f/256),
                           new Vector4f(0,0,201f/256,11f/256)
        );

        Skin skin = new Skin("MainSkin");
        skin.setButtonTexture(bt);
        skin.setTickTexture(tt);
        skin.setInputTexture(it);
        skin.setSliderTexture(st);

        GUIButton button1 = new GUIButton("button1","Game",new Vector2f(550,500), new Vector2f(200,35),skin);
        button1.setAction(new Action() {
            @Override
            public void go() {
                Engine.setScreen(new TestGame());
            }
        });
        addGUI(button1);

        GUIButton button2 = new GUIButton("button2","Tutorial",new Vector2f(550,460), new Vector2f(200,35),skin);
        addGUI(button2);

        GUIButton button3 = new GUIButton("button3","Options",new Vector2f(550,420), new Vector2f(200,35),skin);
        addGUI(button3);

        GUIButton button4 = new GUIButton("button4","Credit",new Vector2f(550,380), new Vector2f(200,35),skin);
        button4.setAction(new Action() {
            @Override
            public void go() {
                FontLoader.font.printGlyphs();
            }
        });
        addGUI(button4);

        GUIButton button5 = new GUIButton("button5","Exit",new Vector2f(550,340), new Vector2f(200,35),skin);
        button5.setAction(new Action() {
            @Override
            public void go() {
                //Engine.getScreen().getEngine().stop();
            }
        });
        addGUI(button5);

        GUILabel label = new GUILabel("version", new Vector2f(1150,5),new Vector2f(150,20),"Rugie engine v0.1.0");
        label.setSize(14);
        addGUI(label);

//        GUI checkBox = new GUITick("check",new Vector2f(100,100),new Vector2f(25,25),"Test",skin);
//        addGUI(checkBox);
//
//        GUI input = new GUITextInput("input",new Vector2f(100,150),new Vector2f(200,32),skin);
//        addGUI(input);
//
        GUISlider slider = new GUISlider("slider", new Vector2f(100,200),new Vector2f(16,16),skin);
        addGUI(slider);


        GUIDialog dialog = new GUIDialog("dialog", new Vector2f(100,300),new Vector2f(300,200),skin);
        GUILabel testlabel = new GUILabel("testlabel",new Vector2f(100,350),new Vector2f(200,30),"YOLO for ever");
        dialog.addChild(testlabel);

        addGUI(dialog);

        GUIDialog dialog2 = new GUIDialog("dialog2", new Vector2f(200,300),new Vector2f(300,200),skin);
        GUILabel testlabel2 = new GUILabel("testlabel2",new Vector2f(200,350),new Vector2f(200,30),"YOLO for ever2");
        dialog2.addChild(testlabel2);
        dialog2.setActive(true);

        addGUI(dialog2);

    }
}
