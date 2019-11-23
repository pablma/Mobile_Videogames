package com.example.logic.GameObjects;

import com.example.engine.Utils.Sprite;
import com.example.logic.SuperClasses.Assets;
import com.example.logic.SuperClasses.GameObject;

public class TapToPlay extends GameObject {

    /**
     * CLASE TAP TO PLAY
     * Es la encargada de hacer que el sprite tap to play parpadee en las pantallas en als que está colocado
     */

    Sprite _tapToPlay = Assets._tapToPlaySprite;
    private float _alpha = 1;
    boolean increasing = false;

    float alphaChangeVel = 1.5f;    // Velocidad a la que se va a disminuir o aumentar el alpha

    /**
     * Constructora de la clase
     * @param iniPosX posición X inicial
     * @param iniPosY posición Y inicial
     */
    public TapToPlay(float iniPosX, float iniPosY){
        super(iniPosX, iniPosY);
    }

    /**
     * Actualiza el alpha del sprite, aumentándolo o disminuyéndolo
     * @param deltaTime deltaTime del juego
     */
    public void update(float deltaTime){

        if(increasing)increaseAlpha(deltaTime);
            else decreaseAlpha(deltaTime);
    }

    /**
     * Pinta el sprite en pantalla
     */
    public void present(){
            _tapToPlay.drawImageAlpha((int)_posX, (int)_posY,_alpha);
    }

    /**
     * Disminuye el alpha del sprite teniendo en cuenta de que si es <= 0 debe empezar a aumentarlo
     * @param deltaTime deltaTime del juego
     */
    public void decreaseAlpha(float deltaTime){

        _alpha -= alphaChangeVel * deltaTime;
        if(_alpha <= 0) {
            increasing = true;
            _alpha = 0;
        }
    }

    /**
     * Aumenta el alpha del sprite teniendo en cuenta de que si es >= 1 debe empezar a disminuirlo
     * @param deltaTime deltaTime del juego
     */
    public void increaseAlpha(float deltaTime){

        _alpha += alphaChangeVel * deltaTime;
        if(_alpha >= 1) {
            increasing = false;
            _alpha = 1;
        }
    }
}
