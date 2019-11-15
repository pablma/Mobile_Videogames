package com.example.logic;


import com.example.engine.Rect;
import com.example.engine.Sprite;
import com.example.engine.State;
import com.example.engine.Game;
import com.example.engine.Graphics;
import com.example.engine.Image;
import com.example.engine.Input;

import java.util.List;
import java.util.Queue;


public class GameState extends State { // debería de ir en la lógica

    Graphics _graphics;

    Game _game;

    int blackBalPosY = 0;

    Sprite _blackBallSp;
    Sprite _greenBackgroundSp;



    public GameState(Game game) {
        super(game);
        _game = game;
        _graphics = _game.getGraphics();

        Assets._blackBallImg = _graphics.newImage("balls.png");
        Assets._blackBallRect = new Rect(0,  Assets._blackBallImg.getHeight() / 2,
                Assets._blackBallImg.getWidth() / 10,  Assets._blackBallImg.getHeight() / 2);

        _blackBallSp = new Sprite(_graphics, Assets._blackBallImg, Assets._blackBallRect);

        Assets._greenBackgroundImg = _graphics.newImage("backgrounds.png");
        Assets._greenBackgroundRect = new Rect(0,0,
                Assets._greenBackgroundImg.getWidth() / 9, Assets._greenBackgroundImg.getHeight());

        _greenBackgroundSp = new Sprite(_graphics, Assets._greenBackgroundImg, Assets._greenBackgroundRect);
    }

    @Override
    public void update(float deltaTime) {

        blackBalPosY += 200 * deltaTime;

        if(blackBalPosY > 1920) blackBalPosY = 0;

        List<Input.TouchEvent> touchEvents = _game.getInput().getTouchEvents();
        for (int i = 0; i < touchEvents.size(); i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event._type == Input.EventType.TOUCH_DOWN) {
                System.out.println("Click with mouse key: " + event._id);
            }
        }
    }

    @Override
    public void present(float deltaTime) {

        _graphics.clear(0xffff00ff);

        //_blackBallSp.drawImage(10,10);
        _greenBackgroundSp.drawImageAsBackground();
        _blackBallSp.drawImageXCentered(500);

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
