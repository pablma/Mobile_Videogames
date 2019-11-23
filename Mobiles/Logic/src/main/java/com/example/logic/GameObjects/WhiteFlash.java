package com.example.logic.GameObjects;

import com.example.engine.Utils.Sprite;
import com.example.logic.SuperClasses.Assets;
import com.example.logic.SuperClasses.GameObject;

public class WhiteFlash extends GameObject {

    /**
     * CLASE WHITE_FLASH
     * Se encarga de hacer que el efecto de flash aparezca cada vez que se cambia a otro estadod e juego
     */

    private Sprite _whitePNGSprite = Assets._whitePNGSprite;
    private float _alpha = 1;
    float alphaChangeVel = 1.5f;    // Velocidad a la que se va a disminuir el alpha

    /**
     * Constructora de la clase
     * @param iniPosX posición X inicial
     * @param iniPosY posición Y inicial
     */
    public WhiteFlash(float iniPosX, float iniPosY){
        super(iniPosX, iniPosY);
    }

    /**
     * Actualiza el alpha del sprite, disminuyéndolo
     * @param deltaTime deltaTime del juego
     */
    public void update(float deltaTime){
        if(_alpha > 0) decreaseAlpha(deltaTime);
    }

    /**
     * Pinta el flash en pantalla
     */
    public void present(){
        _whitePNGSprite.drawImageAsBackgroundAlpha(_alpha);
    }

    /**
     * Método que va disminuyendo el alpha del sprite a una velocidad determinada
     * @param deltaTime deltaTime del juego
     */
    public void decreaseAlpha(float deltaTime){

        _alpha -= alphaChangeVel * deltaTime;
        if(_alpha <= 0)
            _alpha = 0;

    }
}
