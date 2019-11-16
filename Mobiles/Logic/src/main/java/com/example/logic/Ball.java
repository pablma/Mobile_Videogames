package com.example.logic;

import com.example.engine.Graphics;
import com.example.engine.Sprite;

public class Ball extends GameObject {

    private float _velY = 10f;

    public Ball(float iniPosX, float iniPosY, Graphics g, Sprite s) {
        super(iniPosX, iniPosY, g, s);
    }

    public void update(float deltaTime){
        _posY += _velY;

        if (_posY > 1920)
            _posY = _iniPosY;
    }

    public void present(float deltaTime){
        _sprite.drawImageXCentered((int)_posY);
    }

    public void pause(){}
    public void resume(){}

    public void dispose(){}
}
