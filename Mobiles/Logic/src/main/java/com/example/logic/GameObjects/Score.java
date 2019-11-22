package com.example.logic.GameObjects;

import com.example.engine.Utils.Sprite;
import com.example.logic.Assets;
import com.example.logic.GameManager;
import com.example.logic.GameObject;

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
    private boolean _increaseVel = false;
    private int _auxCounter = 0;
    private int _scoreOffsetX = 0;
    private int _scoreOffsetX2 = 0;

    private Sprite _numbersSpriteArray[] = new Sprite[]{_zeroSprite, _oneSprite, _twoSprite, _threeSprite,
            _fourSprite, _fiveSprite, _sixSprite, _sevenSprite, _eigthSprite, _nineSprite};

    public Score(float iniPosX, float iniPosY) {
        super(iniPosX, iniPosY);
    }

    public void present(){

        _scoreOffsetX = 0;
        _scoreOffsetX2 = 0;

        if(_counter>=100) {
            _numbersSpriteArray[_c].drawImage((int) _iniPosX - (int) (0.5 * _zeroSprite.getWidth()), (int) _iniPosY);
            _scoreOffsetX2 = (int) (0.25 * _zeroSprite.getWidth());
        }

        if(_counter >= 10) {
            _numbersSpriteArray[_d].drawImage((int) _iniPosX +_scoreOffsetX2 - (int) (0.25 * _zeroSprite.getWidth()), (int) _iniPosY);
            _scoreOffsetX = (int) (0.25 * _zeroSprite.getWidth());

            if(_counter>=100) _scoreOffsetX = (int) (0.5 * _zeroSprite.getWidth());
        }

        _numbersSpriteArray[_u].drawImage((int)_iniPosX + _scoreOffsetX, (int)_iniPosY);

    }

    public void updateScore(){
        _counter += 1;

        _auxCounter ++;

        _increaseVel = false;

        if(_auxCounter >= GameManager.getInstance().getPointsToIncreaseVel())
        {
            _auxCounter = 0;
            _increaseVel = true;
        }


        _u += 1;

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
        int[] score = new int[]{_u, _d, _c, _counter};
        return score;
    }

    public void setScore(int[] score){
        _u = score[0];
        _d = score[1];
        _c = score[2];
        _counter = score[3];
    }

    public boolean isTimeToIncreaseVel(){
        return _increaseVel;
    }
}
