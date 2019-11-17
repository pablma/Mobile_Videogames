package com.example.logic;

import com.example.engine.Graphics;
import com.example.engine.Sprite;

public class GameObject {
    protected   float _iniPosX, _iniPosY;
    protected float _posX, _posY;

    protected Graphics _graphics;

    public GameObject(float iniPosX, float iniPosY, Graphics g){
        _iniPosX = iniPosX;
        _iniPosY = iniPosY;
        _posX = _iniPosX;
        _posY = _iniPosY;

        _graphics = g;
    }

    public void update(float deltaTime){}
    public void present(float deltaTime){}

    public void pause(){}
    public void resume(){}

    public void dispose(){}

    public float getPosX() { return _posX;}
    public float getPosY() { return _posY;}

    public void setPosX(float value) { _posX = value;}
    public void setPosY(float value) { _posY = value;}
}
