package com.example.logic.GameObjects;

import com.example.engine.Utils.Sprite;
import com.example.logic.Assets;
import com.example.logic.GameObject;

public class Arrows extends GameObject {

    private float _velY = 20f;
    Sprite backgroundArrowsSprite =  Assets._backgroundArrowsSprite;

    public Arrows(float iniPosX, float iniPosY) {
        super(iniPosX, iniPosY);
    }

    public void update(float deltaTime){
        movement(deltaTime);
    }

    public void present(float deltaTime){
        backgroundArrowsSprite.drawImageXCentered((int)_posY);
    }

    public void pause(){}
    public void resume(){}

    public void dispose(){}

    private void movement(float deltatime){
        _posY += _velY;
    }
}