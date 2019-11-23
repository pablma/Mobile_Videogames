package com.example.logic.GameObjects;

import com.example.engine.Utils.Sprite;
import com.example.logic.SuperClasses.Assets;
import com.example.logic.SuperClasses.GameObject;

public class Arrows extends GameObject {

    /**
     * CLASE ARROWS
     * Lleva la lógica y el present de las flechas en movimiento que aparecerán en pantalla
     */

    private float _velY = 430f;//0.2f;
    Sprite backgroundArrowsSprite =  Assets._backgroundArrowsSprite;

    /**
     * Constructora de la clase
     * @param iniPosX posición X inicial
     * @param iniPosY posición Y inicial
     */
    public Arrows(float iniPosX, float iniPosY) {
        super(iniPosX, iniPosY);
    }

    /**
     * Actualiiza la lógica de las flechas
     * @param deltaTime deltaTime del juego
     */
    public void update(float deltaTime){
        movement(deltaTime);
    }

    /**
     * Pinta el sprite en pantalla
     */
    public void present(){
        backgroundArrowsSprite.drawImageXCenteredAlpha((int)_posY, 0.2f);
    }

    /**
     * Podría proporcionar una funcionalidad de pausa si fuera necesario
     */
    public void pause(){}

    /**
     * Podría proporcionar una funcionalidad de reanudar si fuera necesario
     */
    public void resume(){}

    /**
     * Podría proporcionar una funcionalidad de liberar recursos si fuera necesario
     */
    public void dispose(){}

    /**
     * Lógica de las flechas, incrementa su velocidad para que vayan bajando
     * @param deltatime deltaTime del juego
     */
    private void movement(float deltatime){
        _posY += _velY * deltatime;
    }

    /**
     * Incrementa la velocidad de las flechas una cantidad determinada
     * @param increasement cantidad que se quiere aumentar la velocidad
     */
    public void increaseVel(float increasement) {
        _velY += increasement;
        System.out.println("arrrow");
    }

    /**
     * Sirve para obtener la velocidad de las flechas en el eje Y
     * @return float con la velocidad en el eje Y de las flechas
     */
    public float getArrowsYVel(){
        return _velY;
    }

    /**
     * Sirve para hacer que la velocidad de las flechas sea igual a una velocidad determinada
     * @param velY velocidad que se quiere como la nueva velocidad de las flechas
     */
    public void setArrowsYVel(float velY){
        _velY = velY;
    }
}
