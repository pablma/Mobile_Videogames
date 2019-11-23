package com.example.logic.GameObjects;

import com.example.engine.Interfaces.Game;
import com.example.engine.Interfaces.Input;
import com.example.engine.Utils.Sprite;
import com.example.logic.SuperClasses.Assets;
import com.example.logic.States.InstructionsState;

public class OptionsButton extends Button {

    /**
     * CLASE OPTIONS_BUTTON
     * Encargado de llevarnos al menú de instrucciones cuando lo pulsamos
     */

    Sprite _optionsSprite =  Assets._questionSprite;

    /**
     * Constructora de la clase
     * @param iniPosX posición X inicial
     * @param iniPosY posición Y inicial
     * @param game referencia  a game para poder usar sus métodos
     */
    public OptionsButton(float iniPosX, float iniPosY, Game game){
        super(iniPosX, iniPosY, game);
    }

    /**
     * Pinta el botón en pantalla
     */
    public void present(){
        _optionsSprite.drawImage((int)_iniPosX, (int)_iniPosY);
    }

    /**
     * Nos lleva al menú de instrucciones si se pulsa
     * @param event evento que llega
     * @return true si se ha pulsado
     */
    public boolean buttonBehaviour(Input.TouchEvent event) {
        if(event._y > _iniPosY && event._y < _iniPosY + _optionsSprite.getHeight()){
            if(event._x >_iniPosX && event._x < _iniPosX + _optionsSprite.getWidth()){
                _game.setState(new InstructionsState(_game));
                return true;
            }
        }
        return false;
    }
}
