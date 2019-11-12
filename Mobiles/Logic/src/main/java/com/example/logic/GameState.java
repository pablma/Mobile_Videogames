package com.example.logic;


import com.example.engine.State;
import com.example.engine.Game;
import com.example.engine.Graphics;
import com.example.engine.Image;
import com.example.engine.Input;

import java.util.List;
import java.util.Queue;


public class GameState extends State { // debería de ir en la lógica

    Graphics g;
    Image img;
    Image img1;
    Image img2;
    Image img3;
    Game _game;
    Image _player;


    float scale = 1f;


    public GameState(Game game) {
        super(game);


        _game = game;

        g = _game.getGraphics();
        //img = g.newImage("backgrounds.png");

        img1 = g.newImage("arrowsBackground.png");
        img = g.newImage("backgrounds.png");
        _player = g.newImage("players.png");

    }

    @Override
    public void update(float deltaTime) {

        List<Input.TouchEvent> touchEvents = _game.getInput().getTouchEvents();
        for (int i = 0; i < touchEvents.size(); i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event._type == Input.EventType.TOUCH_DOWN) {
                System.out.println("Click with mouse key: " + event._id);
                img1 = img;
            }
        }



    }

    @Override
    public void present(float deltaTime) {

        g.clear(0xffff00ff);

        g.drawBackground(img,0,0,img.getWidth() / 9, img.getHeight());
        g.drawImageCentered(img1, 0, 0,0,0, img1.getWidth(), img1.getHeight(), scale);
        g.drawImageCentered(_player, 0, 950, 0, _player.getHeight() / 2, _player.getWidth(), _player.getHeight(), 1);

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
