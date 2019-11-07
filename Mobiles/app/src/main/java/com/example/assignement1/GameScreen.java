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

    public GameScreen(Game game) {
        super(game);
        g = _game.getGraphics();
        img = g.newImage("backgrounds.png");

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void present(float deltaTime) {

        g.drawImage(img, 0, 0, 0,0, img.getWidth() / 9, img.getHeight());


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
