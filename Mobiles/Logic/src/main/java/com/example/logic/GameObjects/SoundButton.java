package com.example.logic.GameObjects;

import com.example.engine.Interfaces.Game;
import com.example.engine.Interfaces.Input;
import com.example.engine.Utils.Sprite;
import com.example.logic.SuperClasses.Assets;

public class SoundButton extends Button {

    /**
     * CLASE SOUND_BUTTON
     * Es la encargada de mutear o hacer sonar la música del juego,
     * puesto que no hemos implementado sonidos, simplemente actualiza el sprite del botón
     */

    Sprite soundOnSprite =  Assets._soundOnSprite;
    Sprite soundOffSprite =  Assets._soundOffSprite;

    private boolean on = true;

    /**
     * Constructora de la clase
     * @param iniPosX posición X inicial
     * @param iniPosY posición Y inicial
     * game referencia  a game para poder usar sus métodos
     */
    public SoundButton(float iniPosX, float iniPosY, Game game){
        super(iniPosX, iniPosY, game);
    }

    /**
     * Pinta el sprite correspondiente del botón en pantalla
     */
    public void present(){
        if(on)
            soundOnSprite.drawImage((int)_iniPosX, (int)_iniPosY);
        else
            soundOffSprite.drawImage((int)_iniPosX, (int)_iniPosY);

    }

    /**
     * Cambia el estado del botón que nos indica si el audio está muteado o sonando
     * @param event evento que llega
     * @return true si se ha pulsado
     */
    public boolean buttonBehaviour(Input.TouchEvent event) {
        if(event._y > _iniPosY && event._y < _iniPosY + soundOnSprite.getHeight()){
            if(event._x >_iniPosX && event._x < _iniPosX + soundOnSprite.getWidth()){
                on = !on;
                return true;
            }
        }
        return false;
    }
}
