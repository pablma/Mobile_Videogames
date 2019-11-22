package com.example.logic.GameObjects;

import com.example.engine.Utils.Sprite;
import com.example.logic.SuperClasses.Assets;
import com.example.logic.SuperClasses.GameObject;

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

    public void present(){
            _whitePNGSprite.drawImageAsBackgroundAlpha(_alpha);
    }

    public void decreaseAlpha(float deltaTime){

        _alpha -= alphaChangeVel * deltaTime;
        if(_alpha <= 0)
            _alpha = 0;

    }
}
