package com.example.assignement1;

import com.example.androidengine.Game;
import com.example.engine.Graphics;
import com.example.engine.Image;
import com.example.engine.Input;
import com.example.engine.Screen;

import java.util.List;

public class GameScreen extends Screen {

    Graphics g;
    Image img;
    Image img1;
    Image img2;

    float scale = 2f;

    int x = 0;
    int y1 ;
    int y2;


    public GameScreen(Game game) {
        super(game);
        g = _game.getGraphics();
        img = g.newImage("backgrounds.png");

        img1 = g.newImage("backgrounds.png");
        img2 = g.newImage("backgrounds.png");


        y1 = -100;
        y2 = 0;
    }

    @Override
    public void update(float deltaTime) {

    }


    @Override
    public void present(float deltaTime) {
        g.drawBackground(img,0,0,img.getWidth() / 9, img.getHeight());

        g.drawImageCentered(img1, x, y1,0,0, img1.getWidth(), img1.getHeight(), scale);
        g.drawImageCentered(img2, x, y2,0,0, img2.getWidth(), img2.getHeight(), scale);

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
