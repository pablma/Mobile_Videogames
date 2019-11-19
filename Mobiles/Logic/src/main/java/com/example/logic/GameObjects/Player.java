package com.example.logic.GameObjects;

import com.example.logic.Assets;

import java.util.LinkedList;
import java.util.Queue;

public class Player extends SwitchDashObject {

    private Queue <Color> _playerColors;

    public Player(float iniPosX, float iniPosY){
        super(iniPosX, iniPosY, Assets._blackPlayerSprite, Assets._whitePlayerSprite);

        _blackSp = Assets._blackPlayerSprite;
        _whiteSp = Assets._whitePlayerSprite;

        _playerColors = new LinkedList<Color>();
        _playerColors.add(Color.BLACK);
        _playerColors.add(Color.WHITE);

        _color = Color.BLACK;
        _currentSprite = _blackSp;
    }

    public void update(float deltaTime) {
        super.update(deltaTime);
    }

    @Override
    public void present(float deltaTime) {
        if(_color == Color.BLACK)
            _blackSp.drawImageXCentered((int)_posY);
        else
            _whiteSp.drawImageXCentered((int)_posY);
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

        if(_color == Color.BLACK)
            _currentSprite = _blackSp;
        else
            _currentSprite = _whiteSp;
    }

    public Color getPlayerColor(){
        return _playerColors.element();
    }
}
