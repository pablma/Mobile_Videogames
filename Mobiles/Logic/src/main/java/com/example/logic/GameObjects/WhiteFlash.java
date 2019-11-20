package com.example.logic.GameObjects;

import com.example.engine.Utils.Sprite;
import com.example.logic.Assets;
import com.example.logic.GameObject;

public class WhiteFlash extends GameObject {

    private Sprite _whitePNGSprite = Assets._whitePNGSprite;
    private float _alpha = 1;

    public WhiteFlash(float iniPosX, float iniPosY){
        super(iniPosX, iniPosY);
    }


    public void update(float deltaTime){
        decreaseAlpha(deltaTime);
    }

    public void present(float deltaTime){
        if(_alpha >= 0)
            _whitePNGSprite.drawImageAsBackgroundAlpha(_alpha);
    }

    public void decreaseAlpha(float deltaTime){
        if(_alpha > 0)
            _alpha -= 0.15;
    }
}
