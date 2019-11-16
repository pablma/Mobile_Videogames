package com.example.logic;


import com.example.engine.Rect;
import com.example.engine.Sprite;
import com.example.engine.State;
import com.example.engine.Game;
import com.example.engine.Graphics;
import com.example.engine.Image;
import com.example.engine.Input;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class GameState extends State { // debería de ir en la lógica

    Graphics _graphics;

    Game _game;

    int blackBalPosY = 0;

    Sprite _blackBallSp;
    Sprite _greenBackgroundSp;
    Sprite _backgroundArrows;

    Ball ball_1;
    Ball ball_2;
    Ball ball_3;
    Ball ball_4;
    Ball ball_5;
    Ball ball_6;

    float ballOffset_Y = 395f;

    Deque<Ball> balls;

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

        Assets._backgroundArrowsImg = _graphics.newImage("arrowsBackground.png");
        Assets._backgroundArrowsRect = new Rect(0,0, Assets._backgroundArrowsImg.getWidth(), Assets._backgroundArrowsImg.getHeight());

        _backgroundArrows = new Sprite(_graphics, Assets._backgroundArrowsImg, Assets._backgroundArrowsRect);

        ball_1 = new Ball(0, 0, _graphics, _blackBallSp);
        ball_2 = new Ball(0, ball_1.getPosY() - ballOffset_Y, _graphics, _blackBallSp);
        ball_3 = new Ball(0, ball_2.getPosY() - ballOffset_Y, _graphics, _blackBallSp);
        ball_4 = new Ball(0, ball_3.getPosY() - ballOffset_Y, _graphics, _blackBallSp);
        ball_5 = new Ball(0, ball_4.getPosY() - ballOffset_Y, _graphics, _blackBallSp);
        ball_6 = new Ball(0, ball_5.getPosY() - ballOffset_Y, _graphics, _blackBallSp);

        balls = new LinkedList<Ball>();
        balls.add(ball_1);
        balls.add(ball_2);
        balls.add(ball_3);
        balls.add(ball_4);
        balls.add(ball_5);
        balls.add(ball_6);

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

        for (int i = 0; i < balls.size(); i++)
        {
            Ball b = balls.pop();
            b.update(deltaTime);

            if(b.getPosY() > 1920)
                b.setPosY(balls.getLast()._posY - ballOffset_Y);

            balls.add(b);
        }


    }

    @Override
    public void present(float deltaTime) {

        _graphics.clear(0xffff00ff);


        _greenBackgroundSp.drawImageAsBackground();
        _backgroundArrows.drawImageXCentered(0);
        _blackBallSp.drawImage(200,400);

        for(int i = 0; i < balls.size(); i++)
        {
            Ball b = balls.pop();
            b.present(deltaTime);
            balls.add(b);
        }

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
