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
            _blackSp.drawImageAlpha((int) _posX, (int)_posY, _alpha);
        else
            _whiteSp.drawImageAlpha((int) _posX, (int)_posY, _alpha);
    }

    public boolean noVisible(){
        boolean b = false;

        if(_alpha <= 0)
            b = true;

        return b;
    }


}
