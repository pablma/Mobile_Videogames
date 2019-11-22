package com.example.logic.GameObjects;

import com.example.engine.Interfaces.Game;
import com.example.engine.Interfaces.Input;
import com.example.engine.Utils.Sprite;
import com.example.logic.SuperClasses.Assets;
import com.example.logic.States.InstructionsState;

public class OptionsButton extends Button {


    Sprite _optionsSprite =  Assets._questionSprite;

    public OptionsButton(float iniPosX, float iniPosY, Game game){
        super(iniPosX, iniPosY, game);
    }


    public void present(){
        _optionsSprite.drawImage((int)_iniPosX, (int)_iniPosY);
    }

    public boolean buttonBehaviour(Input.TouchEvent event) {
        if(event._y > _iniPosY && event._y < _iniPosY + _optionsSprite.getHeight()){
            if(event._x >_iniPosX && event._x < _iniPosX + _optionsSprite.getWidth()){
                _game.setState(new InstructionsState(_game));
                return true;
            }
        }
        return false;
    }
}
