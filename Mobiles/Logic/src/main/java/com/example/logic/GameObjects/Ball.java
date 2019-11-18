package com.example.logic.GameObjects;

import com.example.logic.Assets;

import java.util.Random;

public class Ball extends SwitchDashObject {

    private float _velY = 10f;
    private Color _initialColor;

    //private Sprite _blackBall;
    //private Sprite _whiteBall;

    private Random random;

    private Color _masterWhiteArray[] = new Color[]{Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
            Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK};

    private Color _masterBlackArray[] = new Color[]{Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
            Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE};


    public Ball(float iniPosX, float iniPosY) {

        super(iniPosX, iniPosY, Assets._blackBallSprite, Assets._whiteBallSprite);
        _blackSp = Assets._blackBallSprite;
        _whiteSp = Assets._whiteBallSprite;

        random = new Random();

        if(random.nextInt(2) == 0) {
            _initialColor = Color.BLACK;
            _currentSprite = _blackSp;
        }
        else {
            _initialColor = Color.WHITE;
            _currentSprite = _whiteSp;
        }

        _color = _initialColor;
    }

    public void update(float deltaTime){
        movement();
    }

    public void present(float deltaTime){

        if(_color == Color.BLACK)
            _blackSp.drawImageXCentered((int)_posY);
        else
            _whiteSp.drawImageXCentered((int)_posY);
    }

    public void pause(){}
    public void resume(){}

    public void dispose(){}

    private void movement(){
        _posY += _velY;
    }

    public void selectColor(Color master)
    {
        Color colors [];
        Color masterColor = master;

        if(master == Color.BLACK)
            colors = _masterBlackArray;
        else
            colors = _masterWhiteArray;

        int rnd = random.nextInt(10);
        _color = colors[rnd];

        if(_color == Color.BLACK)
            _currentSprite = _blackSp;
        else
            _currentSprite = _whiteSp;
    }

    public Color getColor() {
        return _color;
    }
}
