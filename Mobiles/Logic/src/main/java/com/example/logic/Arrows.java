package com.example.logic;

import com.example.engine.Graphics;
import com.example.engine.Sprite;

public class Arrows extends GameObject {

    private float _velY = 20f;

    public Arrows(float iniPosX, float iniPosY, Graphics g, Sprite s) {
        super(iniPosX, iniPosY, g, s);
    }

    public void update(float deltaTime){
        movement(deltaTime);
    }

    public void present(float deltaTime){
        _sprite.drawImageXCentered((int)_posY);
    }

    public void pause(){}
    public void resume(){}

    public void dispose(){}

    private void movement(float deltatime){
        _posY += _velY;
    }
}
