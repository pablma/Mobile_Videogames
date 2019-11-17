package com.example.logic;

import com.example.engine.Graphics;
import com.example.engine.Sprite;

import java.util.Random;

public class Ball extends GameObject {

    enum BallColor {
        BLACK,
        WHITE
    }

    private float _velY = 10f;
    private BallColor _ballColor;
    private BallColor _initialColor;

    private Sprite _blackBall;
    private Sprite _whiteBall;

    private Random random;

    private BallColor _masterWhiteArray[] = new BallColor[]{BallColor.WHITE, BallColor.WHITE, BallColor.WHITE, BallColor.WHITE, BallColor.WHITE,
            BallColor.WHITE, BallColor.WHITE, BallColor.BLACK, BallColor.BLACK, BallColor.BLACK};

    private BallColor _masterBlackArray[] = new BallColor[]{BallColor.BLACK, BallColor.BLACK, BallColor.BLACK, BallColor.BLACK, BallColor.BLACK,
            BallColor.BLACK, BallColor.BLACK, BallColor.WHITE, BallColor.WHITE, BallColor.WHITE};


    public Ball(float iniPosX, float iniPosY, Graphics g) {
        super(iniPosX, iniPosY, g);
        _blackBall = Assets._blackBallSprite;
        _whiteBall = Assets._whiteBallSprite;

        random = new Random();
        if(random.nextInt(2) == 0)
            _initialColor = BallColor.BLACK;
        else
            _initialColor = BallColor.WHITE;

        _ballColor = _initialColor;

        selectBallColor(_initialColor);
    }

    public void update(float deltaTime){
        movement();
    }

    public void present(float deltaTime){
        if(_ballColor == BallColor.BLACK)
            _blackBall.drawImageXCentered((int)_posY);
        else
            _whiteBall.drawImageXCentered((int)_posY);
    }

    public void pause(){}
    public void resume(){}

    public void dispose(){}

    private void movement(){
        _posY += _velY;
    }

    public void selectBallColor(BallColor master)
    {
        BallColor colors [];
        BallColor masterColor = master;

        if(master == BallColor.BLACK)
            colors = _masterBlackArray;
        else
            colors = _masterWhiteArray;

        int rnd = random.nextInt(10);
        _ballColor = colors[rnd];
    }

    public BallColor getBallColor() {
        return _ballColor;
    }
}
