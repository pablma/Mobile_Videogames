package com.example.logic;

import com.example.engine.Graphics;
import com.example.engine.Sprite;

public class GameObject {
    protected   float _iniPosX, _iniPosY;
    protected float _posX, _posY;

    protected Graphics _graphics;
    protected Sprite _sprite;

    public GameObject(float iniPosX, float iniPosY, Graphics g, Sprite s){
        _iniPosX = iniPosX;
        _iniPosY = iniPosY;
        _posX = _iniPosX;
        _posY = _iniPosY;

        _graphics = g;
        _sprite = s;
    }

    public void update(float deltaTime){}
    public void present(float deltaTime){}

    public void pause(){}
    public void resume(){}

    public void dispose(){}
}
