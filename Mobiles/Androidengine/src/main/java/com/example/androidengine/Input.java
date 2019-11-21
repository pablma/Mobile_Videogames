package com.example.androidengine;


import android.view.View;

import com.example.engine.Abstract_Classes.AbstractInput;

import java.util.List;

public class Input  extends AbstractInput {
    TouchHandler _touchHandler;

    public Input(View view, float scaleX, float scaleY){
        _touchHandler = new MultiTouchHandler(view, scaleX, scaleY);
    }


    @Override
    protected boolean isTouchDownPrivate(int pointer) {
        return false;
    }

    @Override
    protected int getTouchXPrivate(int pointer) {
        return _touchHandler.getTouchX(pointer);
    }

    @Override
    protected int getTouchYPrivate(int pointer) {
        return _touchHandler.getTouchY(pointer);
    }

    @Override
    protected List<com.example.engine.Interfaces.Input.TouchEvent> getTouchEventsPrivate() {
        return _touchHandler.getTouchEvents();
    }
}
