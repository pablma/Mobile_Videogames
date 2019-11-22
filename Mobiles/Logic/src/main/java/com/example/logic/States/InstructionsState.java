package com.example.logic.States;

import com.example.engine.Interfaces.Game;
import com.example.engine.Interfaces.Graphics;
import com.example.engine.Interfaces.Input;
import com.example.engine.Utils.Sprite;
import com.example.engine.Abstract_Classes.State;
import com.example.logic.GameObjects.Arrows;
import com.example.logic.Assets;
import com.example.logic.GameObjects.BackgroundColor;
import com.example.logic.GameObjects.ExitButton;
import com.example.logic.GameObjects.TapToPlay;
import com.example.logic.GameObjects.WhiteFlash;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InstructionsState extends State {
    Graphics _graphics;
    Game _game;

    // ARROWS
    Arrows arrows_1;

    // BACKGROUND_COLOR
    BackgroundColor _backgroudnColor;
    Sprite _blackBand =  Assets._blackBandSprite;

    // INSTRUCTIONS SPRITES
    Sprite _howToPlay;
    Sprite _instructions;


    TapToPlay _tapToPlay;

    //BUTTONS
    ExitButton _exitButton;

    WhiteFlash _whiteFlash;

    int _howToPlayPosY;
    int _instructionsPosY;
    int _tapToPlayPosY;

    int _arrowsOffSetY = 1920 - Assets._backgroundArrowsSprite.getHeight();

    public InstructionsState(Game game) {
        super(game);
        _game = game;
        _graphics = _game.getGraphics();

        arrows_1 = new Arrows(0, _arrowsOffSetY);

        _backgroudnColor = new BackgroundColor(0,0);
        _backgroudnColor.setOldBackgroudnColor();

        _howToPlay = Assets._howToPlaySprite;
        _howToPlayPosY = 400;

        _instructions = Assets._instructionsSprite;
        _instructionsPosY = 850;


        _tapToPlayPosY = 1500;
        _tapToPlay = new TapToPlay(1080/2 - Assets._tapToPlaySprite.getWidth()/2, _tapToPlayPosY);


        _whiteFlash = new WhiteFlash(0,0);

        _exitButton = new ExitButton(1080/2 + 470 - Assets._questionSprite.getWidth(),200, _game);
    }

    @Override
    public void update(float deltaTime) {

        getInput();
        arrowsBackgroundUpdate(deltaTime);
        menuUpdate(deltaTime);
        _whiteFlash.update(deltaTime);

    }

    @Override
    public void present(float deltaTime) {
        _graphics.clear(_backgroudnColor.getBackgroundColor());
        _backgroudnColor.present(deltaTime);

        arrowsBackgroundPresent(deltaTime);
        menuPresent(deltaTime);

        buttonsPresent(deltaTime);

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
        arrows_1.update(deltaTime);
        if(arrows_1.getPosY() > 0){
            arrows_1.setPosY(arrows_1.getPosY() - Assets._backgroundArrowsSprite.getHeight()/5);
        }
    }

    private void arrowsBackgroundPresent(float deltaTime){
        arrows_1.present(deltaTime);
    }

    private void menuPresent(float deltaTime){
        _howToPlay.drawImageXCentered(_howToPlayPosY);
        _instructions.drawImageXCentered(_instructionsPosY);
        _tapToPlay.present(deltaTime);
    }

    private void menuUpdate(float deltaTime){
        _tapToPlay.update(deltaTime);
    }

    private void buttonsPresent(float deltaTime){
        _exitButton.present(deltaTime);
    }

    private void getInput() {
        List<Input.TouchEvent> touchEvents = _game.getInput().getTouchEvents();
        for (int i = 0; i < touchEvents.size(); i++) {
            Input.TouchEvent event = touchEvents.get(i);

            if (event._type == Input.EventType.TOUCH_DOWN) {
                if(_exitButton.buttonBehaviour(event)){}
                else
                    _game.setState(new GameState(_game));
            }
        }
    }
}
