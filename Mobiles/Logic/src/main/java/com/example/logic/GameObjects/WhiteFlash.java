package com.example.logic.GameObjects;

import com.example.engine.Utils.Sprite;
import com.example.logic.Assets;
import com.example.logic.GameObject;

public class WhiteFlash extends GameObject {

    private Sprite _whitePNGSprite = Assets._whitePNGSprite;
    private float _alpha = 1;
    float alphaChangeVel = 1.5f;

    public WhiteFlash(float iniPosX, float iniPosY){
        super(iniPosX, iniPosY);
    }


    public void update(float deltaTime){
        if(_alpha>0) decreaseAlpha(deltaTime);
    }

    public void present(float deltaTime){
            _whitePNGSprite.drawImageAsBackgroundAlpha(_alpha);
    }

    public void decreaseAlpha(float deltaTime){

        _alpha -= alphaChangeVel * deltaTime;
        if(_alpha <= 0)
            _alpha = 0;

    }
}
