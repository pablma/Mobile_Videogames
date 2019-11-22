package com.example.logic.States;

import com.example.engine.Interfaces.Game;
import com.example.engine.Interfaces.Graphics;
import com.example.engine.Interfaces.Input;
import com.example.engine.Utils.Sprite;
import com.example.engine.Abstract_Classes.State;
import com.example.logic.SuperClasses.GameManager;
import com.example.logic.GameObjects.Arrows;
import com.example.logic.SuperClasses.Assets;
import com.example.logic.GameObjects.BackgroundColor;
import com.example.logic.GameObjects.BlackBands;
import com.example.logic.GameObjects.OptionsButton;
import com.example.logic.GameObjects.PointsString;
import com.example.logic.GameObjects.Score;
import com.example.logic.GameObjects.SoundButton;
import com.example.logic.GameObjects.TapToPlay;
import com.example.logic.GameObjects.WhiteFlash;

import java.util.List;

public class GameOverState extends State {

    /**
     * CLASE GAME_OVER_STATE
     * Implementa el estado de game over, donde se le da la posibilidad al player de iniciar una nueva partida
     */

    Graphics _graphics;
    Game _game;

    // ARROWS
    Arrows arrows_1;

    // BACKGROUND_COLOR
    BackgroundColor _backgroudnColor;
    BlackBands _blackBands;

    // INSTRUCTIONS SPRITES
    Sprite _gameOver;


    TapToPlay _tapToPlay;

    //SCORE
    Score _score;
    PointsString pointsString;

    //EFFECTS
    WhiteFlash _whiteFlash;

    //BUTTONS
    SoundButton _soundButton;
    OptionsButton _optionButton;

    int _gameOverPosY;
    int _tapToPlayPosY;
    int _arrowsOffSetY = 1920 - Assets._backgroundArrowsSprite.getHeight();

    /**
     * Constructora de la clase
     * @param game referencia a game para poder acceder a sus métodos
     */
    public GameOverState(Game game) {
        super(game);
        _game = game;
        _graphics = _game.getGraphics();

        arrows_1 = new Arrows(0, _arrowsOffSetY);


        _backgroudnColor = new BackgroundColor(0,0);
        _backgroudnColor.setNewBackgroundColor();

        _gameOver = Assets._gameOverSprite;
        _gameOverPosY = 400;


        _tapToPlayPosY = 1500;
        _tapToPlay = new TapToPlay(1080/2 - Assets._tapToPlaySprite.getWidth()/2, _tapToPlayPosY);


        _score = new Score(1080 / 2 - (int)(0.5 * Assets._oneSprite.getWidth()), 1920 / 2);
        _score.setScore(GameManager.getInstance().getScore());

        pointsString = new PointsString(1080 / 2 - (int)(2.5 * Assets._P_Sprite.getWidth()), 1920 / 2 + 150);

        _whiteFlash = new WhiteFlash(0,0);

        _soundButton = new SoundButton(1080/2 - 470,200, _game);
        _optionButton = new OptionsButton(1080/2 + 470 - Assets._questionSprite.getWidth(),200, _game);

        arrows_1.setArrowsYVel(GameManager.getInstance().getArrowsGameOverVel());
        _blackBands = new BlackBands();
    }

    /**
     * Actualiza la lógica d etodos los elementos en pantalla del estado
     * @param deltaTime deltaTime
     */
    @Override
    public void update(float deltaTime) {

        getInput();
        arrowsBackgroundUpdate(deltaTime);
        menuUpdate(deltaTime);
        _whiteFlash.update(deltaTime);

    }

    /**
     * Pinta en pantalla todos los objetos del estado
     */
    @Override
    public void present() {
        _graphics.clear(_backgroudnColor.getBackgroundColor());
        _backgroudnColor.present();

        arrowsBackgroundPresent();
        menuPresent();

        pointsString.present();
        _score.present();
        buttonsPresent();

        _whiteFlash.present();
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
     * Actualiza la lógica del sprite de Tap to Play
     * @param deltaTime deltaTime
     */
    private void menuUpdate(float deltaTime){
        _tapToPlay.update(deltaTime);
    }

    /**
     * Pinta en pantalla los sprites de gameover y tap to play
     */
    private void menuPresent(){
        _gameOver.drawImageXCentered(_gameOverPosY);
        _tapToPlay.present();
    }

    /**
     * Pinta los botones en pantalla
     */
    private void buttonsPresent(){
        _soundButton.present();
        _optionButton.present();
    }

    /**
     * Método encargado de registrar las acciones del jugador y cargar nuevos estados de juego
     */
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
