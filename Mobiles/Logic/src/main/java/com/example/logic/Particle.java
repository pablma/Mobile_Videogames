package com.example.logic;

import com.example.logic.GameObjects.SwitchDashObject;

import java.util.Random;

public class Particle extends SwitchDashObject {

    private float _speed;
    private Random random;
    private float _lifetime = 3f;


    public Particle(float iniPosX, float iniPosY) {
        super(iniPosX, iniPosY, Assets._blackBallSprite, Assets._whiteBallSprite);

        _blackSp = Assets._blackBallSprite;
        _whiteSp = Assets._whiteBallSprite;

        random = new Random();
        _iniPosX = iniPosX + random.nextInt(4);
        _iniPosY = iniPosY + random.nextInt(4);

        _speed = 1.0f;
    }

    @Override
    public void update(float deltaTime) {
        _posX += _speed;
        _posY -= _speed;
    }

    @Override
    public void present(float deltaTime) {
        _blackSp.drawImage((int)_posX, (int)_posY);
    }
}
