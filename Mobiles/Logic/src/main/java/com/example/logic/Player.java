package com.example.logic;

import com.example.engine.Graphics;
import com.example.engine.Sprite;

import java.util.LinkedList;
import java.util.Queue;

public class Player extends GameObject {

    enum PlayerColor {
        BLACK,
        WHITE
    }

    private Sprite _blackPlayer;
    private Sprite _whitePlayer;

    private Queue <PlayerColor> _playerColors;


    public Player(float iniPosX, float iniPosY, Graphics g){
        super(iniPosX, iniPosY, g);

        _blackPlayer = Assets._blackPlayerSprite;
        _whitePlayer = Assets._whitePlayerSprite;

        _playerColors = new LinkedList<PlayerColor>();
        _playerColors.add(PlayerColor.BLACK);
        _playerColors.add(PlayerColor.WHITE);
    }

    public void update(float deltaTime) {
        super.update(deltaTime);
    }

    @Override
    public void present(float deltaTime) {
        if(_playerColors.element() == PlayerColor.BLACK)
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
        PlayerColor c = _playerColors.poll();
        _playerColors.add(c);
        System.out.println(_playerColors.element());
    }
}
