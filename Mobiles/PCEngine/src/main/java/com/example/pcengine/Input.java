package com.example.pcengine;


import com.example.engine.Abstract_Classes.AbstractInput;

import java.util.List;

import javax.swing.JFrame;

public class Input extends AbstractInput {

    private PCMouseHandler _PCMouseHandler;

    public Input(JFrame window){
        _PCMouseHandler = new PCMouseHandler(window);
    }

    @Override
    protected boolean isTouchDownPrivate(int pointer) {
        return false;
    }

    @Override
    protected int getTouchXPrivate(int pointer) {
        return _PCMouseHandler.getTouchX();
    }

    @Override
    protected int getTouchYPrivate(int pointer) {
        return _PCMouseHandler.getTouchY();
    }

    @Override
    protected List<TouchEvent> getTouchEventsPrivate() {
        return _PCMouseHandler.getTouchEvents();
    }

}
