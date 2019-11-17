package com.example.logic;

import com.example.engine.Graphics;
import com.example.engine.Sprite;

public class SwitchDashObject extends GameObject {

    protected enum Color {
        BLACK,
        WHITE
    }

    protected Sprite _blackSp;
    protected Sprite _whiteSp;

    protected Color _color;

    public SwitchDashObject(float iniPosX, float iniPosY, Graphics g, Sprite blackSp, Sprite whiteSp) {
        super(iniPosX, iniPosY, g);

        _blackSp = blackSp;
        _whiteSp = whiteSp;
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
}
