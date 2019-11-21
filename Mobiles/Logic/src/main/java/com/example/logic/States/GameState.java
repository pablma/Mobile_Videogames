package com.example.logic.States;


import com.example.engine.Utils.Sprite;
import com.example.engine.Abstract_Classes.State;
import com.example.engine.Interfaces.Game;
import com.example.engine.Interfaces.Graphics;
import com.example.engine.Interfaces.Input;
import com.example.logic.GameManager;
import com.example.logic.GameObjects.Arrows;
import com.example.logic.Assets;
import com.example.logic.GameObjects.BackgroundColor;
import com.example.logic.GameObjects.Ball;
import com.example.logic.GameObjects.Player;
import com.example.logic.GameObjects.Score;
import com.example.logic.GameObjects.SwitchDashObject;
import com.example.logic.GameObjects.WhiteFlash;
import com.example.logic.ParticleSystem;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class GameState extends State { // debería de ir en la lógica

    Graphics _graphics;
    Game _game;

    // ARROWS
    Arrows arrows_1;
    Arrows arrows_2;
    float arrowsOffset_Y = Assets._backgroundArrowsImg.getHeight();
    Deque<Arrows> arrowsQueue;

    // BALLS
    Ball ball_1;
    Ball ball_2;
    Ball ball_3;
    Ball ball_4;
    Ball ball_5;
    Ball ball_6;

    float ballOffset_Y = 395f;

    Deque<Ball> balls;

    // PLAYER
    Player _player;

    //BACKGROUND_COLOR
    BackgroundColor _backgroudnColor;
    Sprite _blackBand =  Assets._blackBandSprite;

    //POINTS
    Score _score;

    //EFFECTS
    WhiteFlash _whiteFlash;

    // PARTICLE SYSTEM
    ParticleSystem _particleSystem;


    public GameState(Game game) {
        super(game);
        _game = game;
        _graphics = _game.getGraphics();

        arrows_1 = new Arrows(0,0);
        arrows_2 = new Arrows(0,arrows_1.getPosY() - arrowsOffset_Y);

        arrowsQueue = new LinkedList<Arrows>();
        arrowsQueue.add(arrows_1);
        arrowsQueue.add(arrows_2);

        ball_1 = new Ball(0, 0);
        ball_2 = new Ball(0, ball_1.getPosY() - ballOffset_Y);
        ball_3 = new Ball(0, ball_2.getPosY() - ballOffset_Y);
        ball_4 = new Ball(0, ball_3.getPosY() - ballOffset_Y);
        ball_5 = new Ball(0, ball_4.getPosY() - ballOffset_Y);
        ball_6 = new Ball(0, ball_5.getPosY() - ballOffset_Y);

        balls = new LinkedList<Ball>();
        balls.add(ball_1);
        balls.add(ball_2);
        balls.add(ball_3);
        balls.add(ball_4);
        balls.add(ball_5);
        balls.add(ball_6);

        _player = new Player(0, 1200f);

        _score = new Score(850, 200);

        _backgroudnColor = new BackgroundColor(0,0);
        _backgroudnColor.setNewBackgroundColor();

        _whiteFlash = new WhiteFlash(0,0);
    }

    @Override
    public void update(float deltaTime) {

        getInput();
        playerUpdate(deltaTime);
        ballsUpdate(deltaTime);
        arrowsBackgroundUpdate(deltaTime);
        _whiteFlash.update(deltaTime);
    }

    @Override
    public void present(float deltaTime) {

        _graphics.clear(_backgroudnColor.getBackgroundColor());
        _backgroudnColor.present(deltaTime);

        arrowsBackgroundPresent(deltaTime);
        ballsPresent(deltaTime);
        playerPresent(deltaTime);
        _score.present();

        _whiteFlash.present(deltaTime);

        _blackBand.drawImageAsBottomRightBand();
        _blackBand.drawImageAsUpperLeftBand();
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
                a.setPosY(arrowsQueue.getLast().getPosY() - arrowsOffset_Y);


            a.update(deltaTime);


            if(_score.isTimeToIncreaseVel())
                a.increaseVel(GameManager.getInstance().getIncVelY());
            arrowsQueue.add(a);
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
        for (int i = 0; i < balls.size(); i++) {
            Ball b = balls.pop();
            b.update(deltaTime);

            if(topCollision(b, _player))
            {
                if(sameColorObjects(b, _player))
                {
                    b.setPosY(balls.getLast().getPosY() - ballOffset_Y);
                    b.selectColor(balls.getLast().getColor());
                    _score.updateScore();
                }
                else {
                    GameManager.getInstance().saveScore(_score.getScore());
                    _game.setState(new GameOverState(_game));
                }
            }

            if(_score.isTimeToIncreaseVel())
                b.increaseVel(GameManager.getInstance().getIncVelY());
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

    private void getInput() {
        List<Input.TouchEvent> touchEvents = _game.getInput().getTouchEvents();
        for (int i = 0; i < touchEvents.size(); i++) {
            Input.TouchEvent event = touchEvents.get(i);

            if (event._type == Input.EventType.TOUCH_DOWN) {
                _player.changePlayerColor();
            }
        }
    }

    private boolean objectsColliding(SwitchDashObject obj1, SwitchDashObject obj2){
        boolean b = false;

        if(obj1.getPosX() >= obj2.getPosX() && obj1.getPosY() >= obj2.getPosY())
            b = true;

        return b;
    }

    private boolean topCollision(SwitchDashObject obj1, SwitchDashObject obj2) {
        boolean b = false;

        if(obj1.getPosY() + obj1.getSprite().getHeight() >= obj2.getPosY())
            b = true;

        return b;
    }

    private boolean sameColorObjects(SwitchDashObject obj1, SwitchDashObject obj2){
        boolean b = false;

        if(obj1.getColor() == obj2.getColor())
            b = true;

        return b;
    }


}
