package com.example.logic.GameObjects;

import com.example.engine.Utils.Sprite;
import com.example.logic.SuperClasses.Assets;
import com.example.logic.SuperClasses.GameManager;
import com.example.logic.SuperClasses.GameObject;

import java.util.Random;

public class BackgroundColor extends GameObject {

    /**
     * CLASE BACKGROUND_COLOR
     * Es la encargada de gestionar los backgroubds de fondo, así como de cargar cada color posible
     */

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

    /**
     * Constructora de la clase
     * @param iniPosX posición X inicial
     * @param iniPosY posición Y inicial
     */
    public BackgroundColor(float iniPosX, float iniPosY) {
        super(iniPosX, iniPosY);

        _randomColorIndex = 0;
        _colorSpriteSelected = _colorSpritesArray[_randomColorIndex];
        _colorIntSelected = _colorIntArray[_randomColorIndex];
    }

    /**
     * Pinta el sprite en pantalla
     */
    public void present(){
        _colorSpriteSelected.drawImageXCenteredResized(0, Assets._backgroundArrowsImg.getWidth(),1920);
    }

    /**
     * Devuelve el color actual del fondo
     * @return int con el index del color que está de fondo
     */
    public int getBackgroundColor(){
        return _colorIntSelected;
    }

    /**
     * Pone un nuevo color random de fondo
     */
    public void setNewBackgroundColor(){

        _randomColorIndex = random.nextInt(_colorSpritesArray.length);
        _colorSpriteSelected = _colorSpritesArray[_randomColorIndex];
        _colorIntSelected = _colorIntArray[_randomColorIndex];
        GameManager.getInstance().saveBackgroundColorIndex(_randomColorIndex);
    }

    /**
     * Pone nuevamente el color que había sido pueso anteriormente de fondo
     */
    public void setOldBackgroudnColor(){

        _randomColorIndex = GameManager.getInstance().getBackgroundColorIndex();
        _colorSpriteSelected = _colorSpritesArray[_randomColorIndex];
        _colorIntSelected = _colorIntArray[_randomColorIndex];

    }


}
