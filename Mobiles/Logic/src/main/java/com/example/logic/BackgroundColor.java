package com.example.logic;

import com.example.engine.Graphics;
import com.example.engine.Sprite;

import java.util.Random;

public class BackgroundColor extends GameObject {

    private Sprite _greenBackgroundSprite = Assets._greenBackgroundSprite;
    private Sprite _greenBlueBackgroundSprite = Assets._greenBlueBackgroundSprite;
    private Sprite _softBlueBackgroundSprite = Assets._softBlueBackgroundSprite;
    private Sprite _blueBackgroundSprite = Assets._blueBackgroundSprite;
    private Sprite _purpleBackgroundSprite = Assets._purpleBackgroundSprite;
    private Sprite _darkBlueBackgroundSprite = Assets._darkBlueBackgroundSprite;
    private Sprite _orangeBackgroundSprite = Assets._orangeBackgroundSprite;
    private Sprite _redBackgroundImgSprite = Assets._redBackgroundImgSprite;
    private Sprite _brownBackgroundSprite = Assets._brownBackgroundSprite;

    private int _greenBackgroundInt = 0x41a85f;
    private int _greenBlueBackgroundInt = 0x00a885;
    private int _softBlueBackgroundInt =0x3d8eb9;
    private int _blueBackgroundInt = 0x2969b0;
    private int _purpleBackgroundInt = 0x553982;
    private int _darkBlueBackgroundInt = 0x28324e;
    private int _orangeBackgroundInt = 0xf37934;
    private int _redBackgroundInt = 0xd14b41;
    private int _brownBackgroundInt = 0x75706b;


    private Sprite[] _colorSpritesArray = new Sprite[]{_greenBackgroundSprite, _greenBlueBackgroundSprite, _softBlueBackgroundSprite,
            _blueBackgroundSprite, _purpleBackgroundSprite, _darkBlueBackgroundSprite,
            _orangeBackgroundSprite, _redBackgroundImgSprite, _brownBackgroundSprite};

    private int[] _colorIntArray = new int[]{_greenBackgroundInt, _greenBlueBackgroundInt, _softBlueBackgroundInt,
            _blueBackgroundInt, _purpleBackgroundInt, _darkBlueBackgroundInt,
            _orangeBackgroundInt, _redBackgroundInt, _brownBackgroundInt};

    private Sprite _colorSpriteSelected;
    private int _colorIntSelected;


    private Random random = new Random();
    private int _randomColorIndex;

    public BackgroundColor(float iniPosX, float iniPosY) {
        super(iniPosX, iniPosY);

        _randomColorIndex = 0;
        _colorSpriteSelected = _colorSpritesArray[_randomColorIndex];
        _colorIntSelected = _colorIntArray[_randomColorIndex];
    }

    public void present(float deltaTime){
        _colorSpriteSelected.drawImageXCenteredResized(0, Assets._backgroundArrowsImg.getWidth(),1920);
    }

    public int getBackgroundColor(){
        return _colorIntSelected;
    }

    public void setNewBackgroundColor(){

        _randomColorIndex = random.nextInt(_colorSpritesArray.length);
        _colorSpriteSelected = _colorSpritesArray[_randomColorIndex];
        _colorIntSelected = _colorIntArray[_randomColorIndex];
        GameManager.getInstance().saveBackgroundColorIndex(_randomColorIndex);
    }

    public void setOldBackgroudnColor(){

        _randomColorIndex = GameManager.getInstance().getBackgroundColorIndex();
        _colorSpriteSelected = _colorSpritesArray[_randomColorIndex];
        _colorIntSelected = _colorIntArray[_randomColorIndex];

    }


}
