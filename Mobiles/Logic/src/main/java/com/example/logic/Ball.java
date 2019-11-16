package com.example.logic;

import com.example.engine.Graphics;
import com.example.engine.Sprite;

public class Ball extends GameObject {

    enum BallColor {
        BLACK,
        WHITE
    }

    private float _velY = 10f;
    private BallColor _color;

    public Ball(float iniPosX, float iniPosY, Graphics g, Sprite s) {
        super(iniPosX, iniPosY, g, s);
        System.out.println("PosIni: " + _iniPosY);
    }

    public void update(float deltaTime){
        movement();
    }

    public void present(float deltaTime){
        _sprite.drawImageXCentered((int)_posY);
    }

    public void pause(){}
    public void resume(){}

    public void dispose(){}

    private void movement(){
        _posY += _velY;

        /*
        if (_posY > 1920)
        {
            _posY = _iniPosY;
            System.out.println("Pos: " + _posY);
        }*/
    }
}
