package com.example.logic.States;

import com.example.engine.Interfaces.Game;
import com.example.engine.Interfaces.Graphics;
import com.example.engine.Interfaces.Input;
import com.example.engine.Utils.Sprite;
import com.example.engine.Abstract_Classes.State;
import com.example.logic.GameObjects.Arrows;
import com.example.logic.Assets;
import com.example.logic.GameObjects.BackgroundColor;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MainMenuState extends State {

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

    // MAIN MENU SPRITES
    Sprite _logo;
    Sprite _tapToPlay;

    int _logoPosY;
    int _tapToPlayPosY;


    public MainMenuState(Game game) {
        super(game);
        _game = game;
        _graphics = _game.getGraphics();

        arrows_1 = new Arrows(0,0);
        arrows_2 = new Arrows(0,arrows_1.getPosY() - arrowsOffset_Y);

        arrowsQueue = new LinkedList<Arrows>();
        arrowsQueue.add(arrows_1);
        arrowsQueue.add(arrows_2);

        _backgroudnColor = new BackgroundColor(0,0);
        _backgroudnColor.setNewBackgroundColor();

        _logo = Assets._switchDashLogoSprite;
        _logoPosY = 500;

        _tapToPlay = Assets._tapToPlaySprite;
        _tapToPlayPosY = 1000;

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
                a.setPosY(arrowsQueue.getLast().getPosY() - arrowsOffset_Y);
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
        _logo.drawImageXCentered(_logoPosY);
        _tapToPlay.drawImageXCentered(_tapToPlayPosY);
    }

    private void getInput() {
        List<Input.TouchEvent> touchEvents = _game.getInput().getTouchEvents();
        for (int i = 0; i < touchEvents.size(); i++) {
            Input.TouchEvent event = touchEvents.get(i);

            if (event._type == Input.EventType.TOUCH_DOWN) {
                if(event._y > _logoPosY && event._y < _logoPosY + _logo.getHeight()){
                    if(event._x > 540 - _logo.getWidth()/2 &&event._x < 540 + _logo.getWidth()/2){
                        System.out.println("YEEEEEEEEEYYYYYY!!!!");
                    }
                }
                //_game.setState(new InstructionsState(_game));
            }
        }
    }
}
