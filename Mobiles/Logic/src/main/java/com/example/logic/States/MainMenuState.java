package com.example.logic.States;

import com.example.engine.Interfaces.Game;
import com.example.engine.Interfaces.Graphics;
import com.example.engine.Interfaces.Input;
import com.example.engine.Utils.Sprite;
import com.example.engine.Abstract_Classes.State;
import com.example.logic.GameObjects.Arrows;
import com.example.logic.Assets;
import com.example.logic.GameObjects.BackgroundColor;
import com.example.logic.GameObjects.BlackBands;
import com.example.logic.GameObjects.OptionsButton;
import com.example.logic.GameObjects.SoundButton;
import com.example.logic.GameObjects.TapToPlay;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MainMenuState extends State {

    Graphics _graphics;
    Game _game;

    // ARROWS
    Arrows arrows_1;

    // BACKGROUND_COLOR
    BackgroundColor _backgroudnColor;

    BlackBands _blackBands;

    // MAIN MENU SPRITES
    Sprite _logo;

    TapToPlay _tapToPlay;

    //BUTTONS
    SoundButton _soundButton;
    OptionsButton _optionButton;

    int _logoPosY;
    int _tapToPlayPosY;

    int _arrowsOffSetY = 1920 - Assets._backgroundArrowsSprite.getHeight();


    public MainMenuState(Game game) {
        super(game);
        _game = game;
        _graphics = _game.getGraphics();

        arrows_1 = new Arrows(0, _arrowsOffSetY);

        _backgroudnColor = new BackgroundColor(0,0);
        _backgroudnColor.setNewBackgroundColor();

        _logo = Assets._switchDashLogoSprite;
        _logoPosY = 500;

        _tapToPlayPosY = 1000;
        _tapToPlay = new TapToPlay(1080/2 - Assets._tapToPlaySprite.getWidth()/2, _tapToPlayPosY);

        _soundButton = new SoundButton(1080/2 - 470,200, _game);
        _optionButton = new OptionsButton(1080/2 + 470 - Assets._questionSprite.getWidth(),200, _game);

        _blackBands = new BlackBands();

    }

    @Override
    public void update(float deltaTime) {
        getInput();
        arrowsBackgroundUpdate(deltaTime);
        menuUpdate(deltaTime);
    }

    @Override
    public void present(float deltaTime) {
        _graphics.clear(_backgroudnColor.getBackgroundColor());
        _backgroudnColor.present(deltaTime);

        arrowsBackgroundPresent(deltaTime);

        menuPresent(deltaTime);
        buttonsPresent(deltaTime);

        _blackBands.present(deltaTime);

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

        arrows_1.update(deltaTime);
        if(arrows_1.getPosY() > 0){
            arrows_1.setPosY(arrows_1.getPosY() - Assets._backgroundArrowsSprite.getHeight()/5);
        }
    }

    private void arrowsBackgroundPresent(float deltaTime){
        arrows_1.present(deltaTime);
    }

    private void menuPresent(float deltaTime){
        _logo.drawImageXCentered(_logoPosY);
        _tapToPlay.present(deltaTime);
    }

    private void menuUpdate(float deltaTime){
        _tapToPlay.update(deltaTime);
    }

    private void buttonsPresent(float deltaTime){
        _soundButton.present(deltaTime);
        _optionButton.present(deltaTime);
    }


    private void getInput() {
        List<Input.TouchEvent> touchEvents = _game.getInput().getTouchEvents();
        for (int i = 0; i < touchEvents.size(); i++) {
            Input.TouchEvent event = touchEvents.get(i);

            if (event._type == Input.EventType.TOUCH_DOWN) {
                if(_soundButton.buttonBehaviour(event)){}
                else if(_optionButton.buttonBehaviour(event)){}
                else
                    _game.setState(new GameState(_game));
            }
        }
    }
}
