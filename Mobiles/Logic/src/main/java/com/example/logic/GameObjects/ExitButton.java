package com.example.logic.GameObjects;

import com.example.engine.Interfaces.Game;
import com.example.engine.Interfaces.Input;
import com.example.engine.Utils.Sprite;
import com.example.logic.Assets;
import com.example.logic.States.InstructionsState;
import com.example.logic.States.MainMenuState;

public class ExitButton extends Button {

    Sprite _exitSprite =  Assets._crossSprite;

    public ExitButton(float iniPosX, float iniPosY, Game game){
        super(iniPosX, iniPosY, game);
    }


    public void present(float deltaTime){
        _exitSprite.drawImage((int)_iniPosX, (int)_iniPosY);
    }

    public boolean buttonBehaviour(Input.TouchEvent event) {
        if(event._y > _iniPosY && event._y < _iniPosY + _exitSprite.getHeight()){
            if(event._x >_iniPosX && event._x < _iniPosX + _exitSprite.getWidth()){
                _game.setState(new MainMenuState(_game));
                return true;
            }
        }
        return false;
    }
}

