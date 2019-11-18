package com.example.logic;

import com.example.engine.Game;
import com.example.engine.Graphics;
import com.example.engine.Input;
import com.example.engine.Sprite;
import com.example.engine.State;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GameOverState extends State {
    Graphics _graphics;
    Game _game;

    // ARROWS
    Arrows arrows_1;
    Arrows arrows_2;
    float arrowsOffset_Y = Assets._backgroundArrowsImg.getHeight();
    Deque<Arrows> arrowsQueue;

    // BACKGROUND_COLOR
    BackgroundColor _backgroudnColor;
    Sprite _blackBand =  Assets._blackBandSprite;

    // INSTRUCTIONS SPRITES
    Sprite _gameOver;
    Sprite _tapToPlay;

    int _gameOverPosY;
    int _tapToPlayPosY;

    public GameOverState(Game game) {
        super(game);
        _game = game;
        _graphics = _game.getGraphics();

        arrows_1 = new Arrows(0,0, _graphics);
        arrows_2 = new Arrows(0,arrows_1.getPosY() - arrowsOffset_Y, _graphics);

        arrowsQueue = new LinkedList<Arrows>();
        arrowsQueue.add(arrows_1);
        arrowsQueue.add(arrows_2);

        _backgroudnColor = new BackgroundColor(0,0, _graphics);
        _backgroudnColor.setNewBackgroundColor();

        _gameOver = Assets._gameOverSprite;
        _gameOverPosY = 400;

        _tapToPlay = Assets._tapToPlaySprite;
        _tapToPlayPosY = 1500;
    }

    @Override
    public void update(float deltaTime) {
        arrowsBackgroundUpdate(deltaTime);
        getInput();
    }

    @Override
    public void present(float deltaTime) {
        _graphics.clear(_backgroudnColor.getBackgroundColor());
        _backgroudnColor.present(deltaTime);

        arrowsBackgroundPresent(deltaTime);
        menuPresent(deltaTime);

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

    private void menuPresent(float deltaTime){
        _gameOver.drawImageXCentered(_gameOverPosY);
        _tapToPlay.drawImageXCentered(_tapToPlayPosY);
    }

    private void getInput() {
        List<Input.TouchEvent> touchEvents = _game.getInput().getTouchEvents();
        for (int i = 0; i < touchEvents.size(); i++) {
            Input.TouchEvent event = touchEvents.get(i);

            if (event._type == Input.EventType.TOUCH_DOWN) {
                _game.setState(new InstructionsState(_game));
            }
        }
    }
}
