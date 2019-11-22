package com.example.logic;

import com.example.logic.GameObjects.SwitchDashObject;

import java.util.Random;

public class Particle extends SwitchDashObject {

    /**
     * CLASE PARTÍCULA
     * Contiene los atributos y métodos necesarios para crear partículas animadas
     */

    private float _speedX;   // Velocidad X de las partículas
    private float _speedY;  // Velocidad Y de las partículas
    private float _gravity = 6500f;  // Fuerza de la gravedad
    private float _alpha = 1f;  // Alpha d elas partículas
    private float _alphaDecreasingVel = 1.5f;   // Velocidad con la que decrece el alfa


    /**
     * Contructora de la clase
     * @param iniPosX posición X inicial del objeto
     * @param iniPosY posición Y inicial del objeto
     * @param color color del objeto
     */
    public Particle(float iniPosX, float iniPosY, Color color, float speedX, float speedY) {
        super(iniPosX, iniPosY, Assets._blackBallSprite, Assets._whiteBallSprite);
        _color = color;
        _speedX = speedX;
        _speedY = speedY;
    }

    /**
     * Método update encargado de actualizar la posición y el alpha de las partículas
     * @param deltaTime deltaTime del juego
     */
    @Override
    public void update(float deltaTime) {
        _posX += _speedX * deltaTime;
        _posY += _speedY * deltaTime;

        _speedY += _gravity * deltaTime;
        System.out.println("Speed: " + _speedY);
        _alpha -= _alphaDecreasingVel * deltaTime;
    }

    /**
     * Método present encargado de pintar la partícula de blancno o nego, según su color
     * @param deltaTime
     */
    @Override
    public void present(float deltaTime) {
        if(_color == Color.BLACK)
            _blackSp.drawImageResizedAlpha((int)_posX, (int)_posY, _blackSp.getWidth() / 2, _blackSp.getHeight() / 2, _alpha);
        else
            _whiteSp.drawImageResizedAlpha((int)_posX, (int)_posY, _whiteSp.getWidth() / 2, _whiteSp.getHeight() / 2, _alpha);
    }

    /**
     * Método noVisible que devuelve true si la partícula no es visible
     * @return
     */
    public boolean noVisible(){
        boolean b = false;

        if(_alpha <= 0)
            b = true;

        return b;
    }


}
