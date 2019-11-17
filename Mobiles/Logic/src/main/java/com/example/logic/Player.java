package com.example.logic;

import com.example.engine.Graphics;
import com.example.engine.Sprite;

import java.util.LinkedList;
import java.util.Queue;

public class Player extends SwitchDashObject {

    private Sprite _blackPlayer;
    private Sprite _whitePlayer;

    private Queue <Color> _playerColors;


    public Player(float iniPosX, float iniPosY, Graphics g){
        super(iniPosX, iniPosY, g, Assets._blackPlayerSprite, Assets._whitePlayerSprite);

        _blackPlayer = Assets._blackPlayerSprite;
        _whitePlayer = Assets._whitePlayerSprite;

        _playerColors = new LinkedList<Color>();
        _playerColors.add(Color.BLACK);
        _playerColors.add(Color.WHITE);

        this._color = Color.BLACK;
    }

    public void update(float deltaTime) {
        super.update(deltaTime);
    }

    @Override
    public void present(float deltaTime) {
        if(_playerColors.element() == Color.BLACK)
            _blackPlayer.drawImageXCentered((int)_posY);
        else
            _whitePlayer.drawImageXCentered((int)_posY);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    public void changePlayerColor(){
        Color c = _playerColors.poll();
        _playerColors.add(c);
        _color = _playerColors.element();
    }

    public Color getPlayerColor(){
        return _playerColors.element();
    }
}
