package com.example.logic;


import com.example.engine.Screen;
import com.example.engine.Game;
import com.example.engine.Graphics;
import com.example.engine.Image;
import com.example.engine.Input;
import com.example.engine.Screen;

import java.util.List;


public class GameScreen extends Screen { // debería de ir en la lógica

    Graphics g;
    Image img;
    Image img1;
    Image img2;
    Game GAMEs;

    float scale = 2f;

    int x = 0;
    int y1 ;
    int y2;


    public GameScreen(Game game) {
        super(game);

        GAMEs = _game;
        g = _game.getGraphics();
        img = g.newImage("backgrounds.png");

        img1 = g.newImage("backgrounds.png");
        img2 = g.newImage("backgrounds.png");

        y1 = -100;
        y2 = y1 - (int)(img2.getHeight() * scale) + 1;
    }

    @Override
    public void update(float deltaTime) {
        List<Input.TouchEvent> touchEvents = GAMEs.getInput().getTouchEvents();
        for (int i = 0; i < touchEvents.size(); i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event._type == Input.EventType.TOUCH_DOWN) {
                System.out.println("Click with mouse key: " + event._id);
            }
        }
    }


    @Override
    public void present(float deltaTime) {
        //g.drawBackground(img,0,0,img.getWidth() / 9, img.getHeight());

        //g.drawImageCentered(img1, x, y1,0,0, img1.getWidth(), img1.getHeight(), scale);
        //g.drawImageCentered(img2, x, y2,0,0, img2.getWidth(), img2.getHeight(), scale);

        Graphics g = GAMEs.getGraphics();
        g.clear(0xffff00ff);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
