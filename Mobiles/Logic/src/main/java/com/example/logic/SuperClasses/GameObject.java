package com.example.logic.SuperClasses;

public class GameObject {

    /**
     *
     */
    protected   float _iniPosX, _iniPosY;
    protected float _posX, _posY;

    public GameObject(float iniPosX, float iniPosY){
        _iniPosX = iniPosX;
        _iniPosY = iniPosY;
        _posX = _iniPosX;
        _posY = _iniPosY;
    }

    public void update(float deltaTime){}
    public void present(){}

    public void pause(){}
    public void resume(){}

    public void dispose(){}

    public float getPosX() { return _posX;}
    public float getPosY() { return _posY;}

    public void setPosX(float value) { _posX = value;}
    public void setPosY(float value) { _posY = value;}
}
