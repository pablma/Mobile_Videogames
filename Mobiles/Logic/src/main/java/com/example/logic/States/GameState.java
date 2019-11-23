package com.example.logic.States;


import com.example.engine.Abstract_Classes.State;
import com.example.engine.Interfaces.Game;
import com.example.engine.Interfaces.Graphics;
import com.example.engine.Interfaces.Input;
import com.example.engine.Utils.Sprite;
import com.example.logic.SuperClasses.GameManager;
import com.example.logic.GameObjects.Arrows;
import com.example.logic.SuperClasses.Assets;
import com.example.logic.GameObjects.BackgroundColor;
import com.example.logic.GameObjects.Ball;
import com.example.logic.GameObjects.BlackBands;
import com.example.logic.GameObjects.Player;
import com.example.logic.GameObjects.Score;
import com.example.logic.SuperClasses.SwitchDashObject;
import com.example.logic.GameObjects.WhiteFlash;
import com.example.logic.SuperClasses.ParticleSystem;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


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
    BlackBands _blackBands;

    //POINTS
    Score _score;

    //EFFECTS
    WhiteFlash _whiteFlash;
    WhiteFlash _deadWhiteFlash;

    // PARTICLE SYSTEM
    ParticleSystem _particleSystem;

    //Game Over Sprite
    Sprite _gameOverSprite;
    int _gameOverPosY;

    int _auxCounter;

    int _arrowsOffSetY;

    private Timer _timer;
    int _delayTime;
    boolean _gameOver = false;

    /**
     * Constructora de la clase, inicializa los atributos
     * @param game referencia a game para acceder a sus métodos
     */
    public GameState(Game game) {
        super(game);
        _game = game;
        _graphics = _game.getGraphics();


        _arrowsOffSetY = _graphics.getLogicHeight() - Assets._backgroundArrowsSprite.getHeight();
        arrows_1 = new Arrows(0, _arrowsOffSetY);

        ball_1 = new Ball(_graphics.getLogicWidth() / 2 - (Assets._blackBallSprite.getWidth() / 2), 0);
        ball_2 = new Ball(_graphics.getLogicWidth() / 2 - (Assets._blackBallSprite.getWidth() / 2), ball_1.getPosY() - ballOffset_Y);
        ball_3 = new Ball(_graphics.getLogicWidth() / 2 - (Assets._blackBallSprite.getWidth() / 2), ball_2.getPosY() - ballOffset_Y);
        ball_4 = new Ball(_graphics.getLogicWidth() / 2 - (Assets._blackBallSprite.getWidth() / 2), ball_3.getPosY() - ballOffset_Y);
        ball_5 = new Ball(_graphics.getLogicWidth() / 2 - (Assets._blackBallSprite.getWidth() / 2), ball_4.getPosY() - ballOffset_Y);
        ball_6 = new Ball(_graphics.getLogicWidth() / 2 - (Assets._blackBallSprite.getWidth() / 2), ball_5.getPosY() - ballOffset_Y);

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
        _deadWhiteFlash = new WhiteFlash(0,0);

        _particleSystem = new ParticleSystem(0, 0);
        _blackBands = new BlackBands();

        _gameOverSprite = Assets._gameOverSprite;
        _gameOverPosY = 400;

        _auxCounter = 0;

        _timer = new Timer();
        _delayTime = 2000;

    }

    /**
     * Actualiza la lógica de todos los elementos en pantalla del estado
     * @param deltaTime deltaTime
     */
    @Override
    public void update(float deltaTime) {

        getInput();
        ballsUpdate(deltaTime);
        _particleSystem.update(deltaTime);
        arrowsBackgroundUpdate(deltaTime);
        increasingVelLogic();

        _whiteFlash.update(deltaTime);
        if(_gameOver)
            _deadWhiteFlash.update(deltaTime);
    }

    /**
     * Pinta en pantalla todos los objetos del estado
     */
    @Override
    public void present() {

        _graphics.clear(_backgroudnColor.getBackgroundColor());
        _backgroudnColor.present();

        arrowsBackgroundPresent();
        ballsPresent();

        if(!_gameOver)
            playerPresent();


        _particleSystem.present();
        _score.present();

        _whiteFlash.present();
        if(_gameOver)
            _deadWhiteFlash.present();

        _blackBands.present();
    }

    /**
     * Podría proporcionar una funcionalidad de pausa si fuera necesario
     */
    @Override
    public void pause() {
    }

    /**
     * Podría proporcionar una funcionalidad de reanudar si fuera necesario
     */
    @Override
    public void resume() {

    }

    /**
     * Podría proporcionar una funcionalidad de liberar recursos si fuera necesario
     */
    @Override
    public void dispose() {
    }

    /**
     * Actualiza la lógica de las flechas de fondo
     * @param deltaTime deltaTime
     */
    private void arrowsBackgroundUpdate(float deltaTime){
        arrows_1.update(deltaTime);
        if(arrows_1.getPosY() > 0){
            arrows_1.setPosY(arrows_1.getPosY() - Assets._backgroundArrowsSprite.getHeight()/5);
        }
    }

    /**
     * Pinta las flechas de fondo en pantalla
     */
    private void arrowsBackgroundPresent(){
        arrows_1.present();
    }

    /**
     * Actualiza la lógica de las pelotas detectando si colisionan con el player y respawneándolas nuevamente
     * @param deltaTime deltaTime
     */
    private void ballsUpdate(float deltaTime){
        for (int i = 0; i < balls.size(); i++) {
            Ball b = balls.pop();
            b.update(deltaTime);

            if(!_gameOver)
                if(topCollision(b, _player))
                {
                    if(sameColorObjects(b, _player))
                    {
                        _particleSystem.generateParticles(b.getPosX(), b.getPosY(), b.getColor());
                        b.setPosY(balls.getLast().getPosY() - ballOffset_Y);
                        b.selectColor(balls.getLast().getColor());
                        _score.updateScore();
                        _auxCounter++;
                    }
                    else {
                        gameOver();
                    }
                }
            balls.add(b);
        }
    }

    /**
     * Pinta las flechas pelotas en pantalla
     */
    private void ballsPresent(){
        for(int i = 0; i < balls.size(); i++)
        {
            Ball b = balls.pop();
            b.present();
            balls.add(b);
        }
    }

    /**
     * Pinta en pantalla el sprite del player
     */
    private void playerPresent() {
        _player.present();
    }

    /**
     * Método encargado de registrar las acciones del jugador y cargar nuevos estados de juego
     */
    private void getInput() {
        List<Input.TouchEvent> touchEvents = _game.getInput().getTouchEvents();
        for (int i = 0; i < touchEvents.size(); i++) {
            Input.TouchEvent event = touchEvents.get(i);

            if (event._type == Input.EventType.TOUCH_DOWN) {
                _player.changePlayerColor();
            }
        }
    }

    /**
     * Comprueba si dos objetos han colisionado
     * @param obj1 objeto 1 que colisiona
     * @param obj2 objeto 2 que colisiona
     * @return true si su posición es igual
     */
    private boolean objectsColliding(SwitchDashObject obj1, SwitchDashObject obj2){
        boolean b = false;

        if(obj1.getPosX() >= obj2.getPosX() && obj1.getPosY() >= obj2.getPosY())
            b = true;

        return b;
    }

    /**
     * Comprueba si dos objetos han colisionado por sus extremos del eje y
     * @param obj1 objeto 1 que colisiona
     * @param obj2 objeto 2 que colisiona
     * @return true si han entrado en colisión por arriba
     */
    private boolean topCollision(SwitchDashObject obj1, SwitchDashObject obj2) {
        boolean b = false;

        if(obj1.getPosY() + obj1.getSprite().getHeight() >= obj2.getPosY())
            b = true;

        return b;
    }

    /**
     * Comprueba si dos objetos son del mismo color
     * @param obj1 objeto 1
     * @param obj2 objeto 2
     * @return true si son del mismo color
     */
    private boolean sameColorObjects(SwitchDashObject obj1, SwitchDashObject obj2){
        boolean b = false;

        if(obj1.getColor() == obj2.getColor())
            b = true;

        return b;
    }

    /**
     * Comprueba si se han alcanzado los puntos necesarios para incrementar la velocidad de las pelotas y las felchas y si es así, la aumenta
     */
    private void increasingVelLogic(){
        if(_auxCounter >= GameManager.getInstance().getPointsToIncreaseVel()){

            arrows_1.increaseVel(GameManager.getInstance().getIncVelY());

            for(int i = 0; i < balls.size(); i++)
            {
                Ball b = balls.pop();
                b.increaseVel(GameManager.getInstance().getIncVelY());
                balls.add(b);
            }
            _auxCounter = 0;
        }
    }

    /**
     * Salva la puntuación y la velocidad de las flechas para mostrarlo en la pantalla de gameover
     * Además carga un nuevo estado gameover
     */
    private void gameOver(){

        GameManager.getInstance().saveScore(_score.getScore());
        GameManager.getInstance().saveArrowsGameOverVel(arrows_1.getArrowsYVel());
        _gameOver = true;
        delayedChangeStateCaller();
    }

    /**
     * Permite llamar a una fución tras un período de tiempo determinado
     */
    public synchronized void delayedChangeStateCaller() {
        this._timer.cancel(); //this will cancel the current task. if there is no active task, nothing happens
        this._timer = new Timer();

        TimerTask action = new TimerTask() {
            public void run() {
                _game.setState(new GameOverState(_game));
            }
        };

        this._timer.schedule(action, _delayTime); //this starts the task
    }

}
