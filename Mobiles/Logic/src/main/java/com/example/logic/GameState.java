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

    // ARROWS
    Arrows arrows_1;
    Arrows arrows_2;

    // BALLS
    Ball ball_1;
    Ball ball_2;
    Ball ball_3;
    Ball ball_4;
    Ball ball_5;
    Ball ball_6;

    float ballOffset_Y = 395f;
    float arrowsOffset_Y = Assets._backgroundArrowsImg.getHeight();

    Deque<Ball> balls;
    Deque<Arrows> arrowsQueue;

    // PLAYER
    Player _player;

    //BACKGROUND_COLOR
    BackgroundColor _backgroudnColor;
    Sprite _blackBand =  Assets._blackBandSprite;



    public GameState(Game game) {
        super(game);
        _game = game;
        _graphics = _game.getGraphics();

        arrows_1 = new Arrows(0,0, _graphics);
        arrows_2 = new Arrows(0,arrows_1.getPosY() - arrowsOffset_Y, _graphics);

        arrowsQueue = new LinkedList<Arrows>();
        arrowsQueue.add(arrows_1);
        arrowsQueue.add(arrows_2);

        ball_1 = new Ball(0, 0, _graphics);
        ball_2 = new Ball(0, ball_1.getPosY() - ballOffset_Y, _graphics);
        ball_3 = new Ball(0, ball_2.getPosY() - ballOffset_Y, _graphics);
        ball_4 = new Ball(0, ball_3.getPosY() - ballOffset_Y, _graphics);
        ball_5 = new Ball(0, ball_4.getPosY() - ballOffset_Y, _graphics);
        ball_6 = new Ball(0, ball_5.getPosY() - ballOffset_Y, _graphics);

        balls = new LinkedList<Ball>();
        balls.add(ball_1);
        balls.add(ball_2);
        balls.add(ball_3);
        balls.add(ball_4);
        balls.add(ball_5);
        balls.add(ball_6);

        _player = new Player(0, 1200f, _graphics);

        _backgroudnColor = new BackgroundColor(0,0, _graphics);
    }

    @Override
    public void update(float deltaTime) {

        List<Input.TouchEvent> touchEvents = _game.getInput().getTouchEvents();
        for (int i = 0; i < touchEvents.size(); i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event._type == Input.EventType.TOUCH_DOWN) {
                _player.changePlayerColor();
            }
        }

        arrowsBackgroundUpdate(deltaTime);
        ballsUpdate(deltaTime);
        playerUpdate(deltaTime);

    }

    @Override
    public void present(float deltaTime) {


        _graphics.clear(_backgroudnColor.getBackgroundColor());

        _backgroudnColor.present(deltaTime);

        //NO BORRARPLEASE
        //_blackBand.drawImageAsBottomRightBand();
        //_blackBand.drawImageAsUpperLeftBand();

        arrowsBackgroundPresent(deltaTime);
        ballsPresent(deltaTime);
        playerPresent(deltaTime);


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

    private void arrowsBackgroundUpdate(float deltaTime){
        for (int i = 0; i < arrowsQueue.size(); i++)
        {
            Arrows a = arrowsQueue.pop();

            if(a.getPosY() > 1920)
                a.setPosY(arrowsQueue.getLast()._posY - arrowsOffset_Y);
            arrowsQueue.add(a);

            a.update(deltaTime);
        }
    }

    private void arrowsBackgroundPresent(float deltaTime){
        for(int i = 0; i < arrowsQueue.size(); i++)
        {
            Arrows a = arrowsQueue.pop();
            a.present(deltaTime);
            arrowsQueue.add(a);
        }
    }

    private void ballsUpdate(float deltaTime){
        for (int i = 0; i < balls.size(); i++)
        {
            Ball b = balls.pop();
            b.update(deltaTime);

            if(b.getPosY() > 1920)
            {
                b.setPosY(balls.getLast()._posY - ballOffset_Y);
                b.selectBallColor(balls.getLast().getBallColor());
            }
            balls.add(b);
        }
    }

    private void ballsPresent(float deltaTime){
        for(int i = 0; i < balls.size(); i++)
        {
            Ball b = balls.pop();
            b.present(deltaTime);
            balls.add(b);
        }
    }

    private void playerUpdate(float deltaTime) {

    }

    private void playerPresent(float deltaTime) {
        _player.present(deltaTime);
    }

}
