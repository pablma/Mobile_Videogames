package com.example.androidengine;


import android.view.View;

import java.util.List;

public class Input implements com.example.engine.Interfaces.Input {
    TouchHandler _touchHandler;

    public Input(View view, float scaleX, float scaleY){
        _touchHandler = new SingleTouchHandler(view, scaleX, scaleY);
    }


    @Override
    public boolean isTouchDown(int pointer) {
        return _touchHandler.isTouchDown(pointer);
    }

    @Override
    public int getTouchX(int pointer) {
        return _touchHandler.getTouchX(pointer);
    }

    @Override
    public int getTouchY(int pointer) {
        return _touchHandler.getTouchY(pointer);
    }

    @Override
    public List<TouchEvent> getTouchEvents() {
        return _touchHandler.getTouchEvents();
    }
}
