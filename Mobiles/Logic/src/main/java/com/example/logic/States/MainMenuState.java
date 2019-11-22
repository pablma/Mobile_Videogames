package com.example.logic.States;

import com.example.engine.Interfaces.Game;
import com.example.engine.Interfaces.Graphics;
import com.example.engine.Interfaces.Input;
import com.example.engine.Utils.Sprite;
import com.example.engine.Abstract_Classes.State;
import com.example.logic.GameObjects.Arrows;
import com.example.logic.SuperClasses.Assets;
import com.example.logic.GameObjects.BackgroundColor;
import com.example.logic.GameObjects.BlackBands;
import com.example.logic.GameObjects.OptionsButton;
import com.example.logic.GameObjects.SoundButton;
import com.example.logic.GameObjects.TapToPlay;

import java.util.List;

public class MainMenuState extends State {

    /**
     * CLASE MAIN_MENU_STATE
     * Implementa la funcionalidad del menú principal del juego
     */

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

    /**
     * Constructora de la clase
     * @param game referencia la juego para poder acceder a sus atributos
     */
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

    /**
     * Método que se encargará de actualizar la lógica de los objetos del menú prinipal
     * @param deltaTime deltaTime
     */
    @Override
    public void update(float deltaTime) {
        getInput();
        arrowsBackgroundUpdate(deltaTime);
        menuUpdate(deltaTime);
    }

    /**
     * Método que se encargará de presentar todos los objetos del menú en pantalla
     */
    @Override
    public void present() {
        _graphics.clear(_backgroudnColor.getBackgroundColor());
        _backgroudnColor.present();

        arrowsBackgroundPresent();

        menuPresent();
        buttonsPresent();

        _blackBands.present();

    }

    /**
     * Método que aporta la funcionalidad de pausa
     */
    @Override
    public void pause() {

    }

    /**
     * Método que aporta la funcionalidad de reanudar
     */
    @Override
    public void resume() {

    }

    /**
     * Método que libera recursos
     */
    @Override
    public void dispose() {

    }

    /**
     * Método que actualiza la lógica de las flechas del fondo
     * @param deltaTime
     */
    private void arrowsBackgroundUpdate(float deltaTime){

        arrows_1.update(deltaTime);
        if(arrows_1.getPosY() > 0){
            arrows_1.setPosY(arrows_1.getPosY() - Assets._backgroundArrowsSprite.getHeight()/5);
        }
    }

    /**
     * Método que pinta en pantalla las flechas del fondo
     */
    private void arrowsBackgroundPresent(){
        arrows_1.present();
    }

    /**
     * Método que pinta en pantalla el logo y el tap to play
     */
    private void menuPresent(){
        _logo.drawImageXCentered(_logoPosY);
        _tapToPlay.present();
    }

    /**
     * Método que actualiza la lógica del sprite tapToPlay
     * @param deltaTime
     */
    private void menuUpdate(float deltaTime){
        _tapToPlay.update(deltaTime);
    }

    /**
     * Método encargado de pintar todos los botones en pantalla
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
