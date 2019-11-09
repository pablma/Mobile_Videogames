package com.example.pcengine;


import java.util.List;

import javax.swing.JFrame;

public class Input implements com.example.engine.Input {

    private PCMouseHandler _PCMouseHandler;

    public Input(JFrame window){
        _PCMouseHandler = new PCMouseHandler(window);
    }

    @Override
    public boolean isTouchDown(int id) {
        return false;
    }

    @Override
    public int getTouchX(int id) {
        return _PCMouseHandler.getTouchX();
    }

    @Override
    public int getTouchY(int id) {
        return _PCMouseHandler.getTouchY();
    }

    @Override
    public List<TouchEvent> getTouchEvents() {
        return _PCMouseHandler.getTouchEvents();
    }
}
