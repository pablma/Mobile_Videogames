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

    private Sprite[] _colorSpritesArray = new Sprite[]{_greenBackgroundSprite, _greenBlueBackgroundSprite, _softBlueBackgroundSprite,
            _blueBackgroundSprite, _purpleBackgroundSprite, _darkBlueBackgroundSprite,
            _orangeBackgroundSprite, _redBackgroundImgSprite, _brownBackgroundSprite};

    private Sprite _colorSpriteSelected;


    private Random random = new Random();
    private int _randomColorIndex;

    public BackgroundColor(float iniPosX, float iniPosY, Graphics g) {
        super(iniPosX, iniPosY, g);

        _randomColorIndex = random.nextInt(_colorSpritesArray.length);
        _colorSpriteSelected = _colorSpritesArray[_randomColorIndex];
    }

    public void present(float deltaTime){
        _colorSpriteSelected.drawImageAsBackground();
    }
}
