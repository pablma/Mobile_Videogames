package com.example.logic.SuperClasses;

import com.example.engine.Utils.Sprite;
import com.example.logic.SuperClasses.GameObject;

public class SwitchDashObject extends GameObject {

    protected enum Color {
        BLACK,
        WHITE
    }

    protected Sprite _blackSp;
    protected Sprite _whiteSp;
    protected Sprite _currentSprite;

    protected Color _color;

    public SwitchDashObject(float iniPosX, float iniPosY, Sprite blackSp, Sprite whiteSp) {
        super(iniPosX, iniPosY);

        _blackSp = blackSp;
        _whiteSp = whiteSp;
    }

    public SwitchDashObject(float iniPosX, float iniPosY) {
        super(iniPosX, iniPosY);
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

    public Color getColor() {
        return _color;
    }

    public Sprite getSprite() {
        return _currentSprite;
    }
}
