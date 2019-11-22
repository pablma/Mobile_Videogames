package com.example.logic.GameObjects;

import com.example.engine.Utils.Sprite;
import com.example.logic.SuperClasses.Assets;
import com.example.logic.SuperClasses.GameObject;

public class BlackBands extends GameObject {

    Sprite _blackBandSprite =  Assets._blackBandSprite;

    private boolean on = true;

    public BlackBands(){
        super(0, 0);
    }


    public void present(){
        _blackBandSprite.drawImageAsBottomRightBand();
        _blackBandSprite.drawImageAsUpperLeftBand();
    }

}
