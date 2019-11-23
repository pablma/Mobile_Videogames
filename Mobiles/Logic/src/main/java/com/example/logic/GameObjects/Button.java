package com.example.logic.GameObjects;

import com.example.engine.Interfaces.Game;
import com.example.engine.Interfaces.Input;
import com.example.logic.SuperClasses.GameObject;

public class Button extends GameObject {

    /**
     * CLASE BUTTON
     * Es la encargada de definir los atributos y métodos que serán comunes para el resto de botones
     */

    Game _game;

    /**
     * Constructora de la clase
     * @param iniPosX posición X inicial
     * @param iniPosY posición Y inicial
     * @param game referencia  a game para poder usar sus métodos
     */
    public Button(float iniPosX, float iniPosY, Game game){
        super(iniPosX, iniPosY);
        _game = game;
    }

    /**
     * Informa de si se ha pulsado un botón y se encarga de realizar la acción correspondiente
     * @param event evento que llega
     * @return true si se ha pulsado el botón
     */
    public boolean buttonBehaviour(Input.TouchEvent event){
        return false;
    }


}
