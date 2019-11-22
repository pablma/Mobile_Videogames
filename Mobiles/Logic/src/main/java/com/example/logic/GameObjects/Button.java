package com.example.logic.GameObjects;

import com.example.engine.Interfaces.Game;
import com.example.engine.Interfaces.Input;
import com.example.logic.GameObject;

public class Button extends GameObject {

    Game _game;
    public Button(float iniPosX, float iniPosY, Game game){
        super(iniPosX, iniPosY);
        _game = game;
    }

    public boolean buttonBehaviour(Input.TouchEvent event){
        return false;
    }


}
