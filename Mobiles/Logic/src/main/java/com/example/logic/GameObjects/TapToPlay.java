package com.example.logic.GameObjects;

import com.example.engine.Utils.Sprite;
import com.example.logic.Assets;
import com.example.logic.GameObject;

public class TapToPlay extends GameObject {

    Sprite _tapToPlay = Assets._tapToPlaySprite;
    private float _alpha = 1;
    boolean increasing = false;

    float alphaChangeVel = 1.5f;

    public TapToPlay(float iniPosX, float iniPosY){
        super(iniPosX, iniPosY);
    }


    public void update(float deltaTime){

        if(increasing)increaseAlpha(deltaTime);
            else decreaseAlpha(deltaTime);
    }

    public void present(float deltaTime){
            _tapToPlay.drawImageAlpha((int)_posX, (int)_posY,_alpha);
    }

    public void decreaseAlpha(float deltaTime){

        _alpha -= alphaChangeVel * deltaTime;
        if(_alpha <= 0) {
            increasing = true;
            _alpha = 0;
        }


    }

    public void increaseAlpha(float deltaTime){

        _alpha += alphaChangeVel * deltaTime;
        if(_alpha >= 1) {
            increasing = false;
            _alpha = 1;
        }
    }
}
