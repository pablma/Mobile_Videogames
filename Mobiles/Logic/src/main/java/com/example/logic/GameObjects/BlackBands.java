package com.example.logic.GameObjects;

import com.example.engine.Utils.Sprite;
import com.example.logic.Assets;
import com.example.logic.GameObject;

public class BlackBands extends GameObject {

    Sprite _blackBandSprite =  Assets._blackBandSprite;

    private boolean on = true;

    public BlackBands(){
        super(0, 0);
    }


    public void present(float deltaTime){
        _blackBandSprite.drawImageAsBottomRightBand();
        _blackBandSprite.drawImageAsUpperLeftBand();
    }

}
