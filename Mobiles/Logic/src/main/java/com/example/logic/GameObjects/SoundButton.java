package com.example.logic.GameObjects;

import com.example.engine.Interfaces.Game;
import com.example.engine.Interfaces.Input;
import com.example.engine.Utils.Sprite;
import com.example.logic.Assets;

public class SoundButton extends Button {


    Sprite soundOnSprite =  Assets._soundOnSprite;
    Sprite soundOffSprite =  Assets._soundOffSprite;

    private boolean on = true;

    public SoundButton(float iniPosX, float iniPosY, Game game){
        super(iniPosX, iniPosY, game);
    }


    public void present(float deltaTime){
        if(on)
            soundOnSprite.drawImage((int)_iniPosX, (int)_iniPosY);
        else
            soundOffSprite.drawImage((int)_iniPosX, (int)_iniPosY);

    }

    @Override
    public void buttonBehaviour(Input.TouchEvent event) {
        if(event._y > _iniPosY && event._y < _iniPosY + soundOnSprite.getHeight()){
            if(event._x >_iniPosX && event._x < _iniPosX + soundOnSprite.getWidth()){
                on = !on;
            }
        }
    }
}
