package com.example.logic;

import com.example.engine.Graphics;
import com.example.engine.Image;
import com.example.engine.Rect;
import com.example.engine.Sprite;

public class Score extends GameObject {

    private Sprite _zeroSprite = Assets._zeroSprite;
    private Sprite _oneSprite = Assets._oneSprite;
    private Sprite _twoSprite = Assets._twoSprite;
    private Sprite _threeSprite = Assets._threeSprite;
    private Sprite _fourSprite = Assets._fourSprite;
    private Sprite _fiveSprite = Assets._fiveSprite;
    private Sprite _sixSprite = Assets._sixSprite;
    private Sprite _sevenSprite = Assets._sevenSprite;
    private Sprite _eigthSprite = Assets._eigthSprite;
    private Sprite _nineSprite = Assets._nineSprite;

    private int _u = 0;
    private int _d = 0;
    private int _c = 0;
    private int _counter = 0;


    private Sprite _numbersSpriteArray[] = new Sprite[]{_zeroSprite, _oneSprite, _twoSprite, _threeSprite,
            _fourSprite, _fiveSprite, _sixSprite, _sevenSprite, _eigthSprite, _nineSprite};

    public Score(float iniPosX, float iniPosY, Graphics g) {
        super(iniPosX, iniPosY, g);
    }

    public void present(){

        _numbersSpriteArray[_u].drawImage((int)_iniPosX, (int)_iniPosY);

        if(_counter >= 10)
            _numbersSpriteArray[_d].drawImage((int)_iniPosX - (int)(0.5 * Assets._zeroSprite.getWidth()), (int)_iniPosY);

        if(_counter>=100)
            _numbersSpriteArray[_c].drawImage((int)_iniPosX - (int)(1.5 * Assets._zeroSprite.getWidth()), (int)_iniPosY);
    }

    public void updateScore(){
        _counter ++;
        _u++;

        if(_u > 9){
            _u = 0;

            _d++;

            if(_d > 9){
                _d = 0;
                _c++;

                if(_c > 9){_u = 0; _d = 0; _c = 0;}
            }
        }
    }

    public int[] getScore(){
        int[] score = new int[]{_u, _d, _c};
        return score;
    }
}
