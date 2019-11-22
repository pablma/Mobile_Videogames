package com.example.logic;

import com.example.logic.GameObjects.SwitchDashObject;

import java.util.Random;

public class Particle extends SwitchDashObject {

    private float _speed;
    private float _lifetime = 3f;
    private float _alpha = 1f;
    private Random _random;


    public Particle(float iniPosX, float iniPosY, Color color) {
        super(iniPosX, iniPosY, Assets._blackBallSprite, Assets._whiteBallSprite);
        _color = color;
        _random = new Random();
        _speed = _random.nextInt(200 + 200) - 200;
    }

    @Override
    public void update(float deltaTime) {
        _posX += _speed * deltaTime;
        _posY += _speed * deltaTime;
        _alpha -= 1.5f * deltaTime;
    }

    @Override
    public void present(float deltaTime) {
        if(_color == Color.BLACK)
            _blackSp.drawImageResizedAlpha((int)_posX, (int)_posY, _blackSp.getWidth() / 2, _blackSp.getHeight() / 2, _alpha);
        else
            _whiteSp.drawImageResizedAlpha((int)_posX, (int)_posY, _whiteSp.getWidth() / 2, _whiteSp.getHeight() / 2, _alpha);
    }

    public boolean noVisible(){
        boolean b = false;

        if(_alpha <= 0)
            b = true;

        return b;
    }


}
