package com.example.logic.GameObjects;

import com.example.logic.SuperClasses.Assets;
import com.example.logic.SuperClasses.SwitchDashObject;

import java.util.LinkedList;
import java.util.Queue;

public class Player extends SwitchDashObject {

    /**
     * CLASE PLAYER
     * Llevará el comportamiento de un player y sus atributos
     */

    private Queue <Color> _playerColors;

    /**
     * Constructora de la clase
     * @param iniPosX posición X inicial
     * @param iniPosY posición Y inicial
     */
    public Player(float iniPosX, float iniPosY){
        super(iniPosX, iniPosY, Assets._blackPlayerSprite, Assets._whitePlayerSprite);

        _blackSp = Assets._blackPlayerSprite;
        _whiteSp = Assets._whitePlayerSprite;

        _playerColors = new LinkedList<Color>();
        _playerColors.add(Color.BLACK);
        _playerColors.add(Color.WHITE);

        _color = Color.BLACK;
        _currentSprite = _blackSp;
    }

    /**
     * Actualiza la lógica del player, en nuestro juego de momento no hace nada
     * @param deltaTime deltaTime del juego
     */
    public void update(float deltaTime) {
        super.update(deltaTime);
    }

    /**
     * Pinta el player en pantalla
     */
    @Override
    public void present() {
        if(_color == Color.BLACK)
            _blackSp.drawImageXCentered((int)_posY);
        else
            _whiteSp.drawImageXCentered((int)_posY);
    }

    /**
     * Podría proporcionar una funcionalidad de pausa si fuera necesario
     */
    @Override
    public void pause() {
        super.pause();
    }

    /**
     * Podría proporcionar una funcionalidad de reanudar si fuera necesario
     */
    @Override
    public void resume() {
        super.resume();
    }

    /**
     * Podría proporcionar una funcionalidad de liberar recursos si fuera necesario
     */
    @Override
    public void dispose() {
        super.dispose();
    }

    /**
     * Cambia el color actual del player
     */
    public void changePlayerColor(){
        Color c = _playerColors.poll();
        _playerColors.add(c);
        _color = _playerColors.element();

        if(_color == Color.BLACK)
            _currentSprite = _blackSp;
        else
            _currentSprite = _whiteSp;
    }

    /**
     * Devuelve el color que tiene el player
     * @return color actual del player
     */
    public Color getPlayerColor(){
        return _playerColors.element();
    }
}
