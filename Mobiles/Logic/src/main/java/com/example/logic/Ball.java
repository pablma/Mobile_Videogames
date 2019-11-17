package com.example.logic;

import com.example.engine.Graphics;
import com.example.engine.Sprite;

import java.util.Random;

public class Ball extends SwitchDashObject {

    private float _velY = 10f;
    private Color _initialColor;

    private Sprite _blackBall;
    private Sprite _whiteBall;

    private Random random;

    private Color _masterWhiteArray[] = new Color[]{Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
            Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK};

    private Color _masterBlackArray[] = new Color[]{Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
            Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE};


    public Ball(float iniPosX, float iniPosY, Graphics g) {

        super(iniPosX, iniPosY, g, Assets._blackBallSprite, Assets._whiteBallSprite);
        _blackBall = Assets._blackBallSprite;
        _whiteBall = Assets._whiteBallSprite;

        random = new Random();

        if(random.nextInt(2) == 0)
            _initialColor = Color.BLACK;
        else
            _initialColor = Color.WHITE;

        _color = _initialColor;



    }

    public void update(float deltaTime){
        movement();
    }

    public void present(float deltaTime){

        if(_color == Color.BLACK)
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
    }

    public Color getColor() {
        return _color;
    }
}
