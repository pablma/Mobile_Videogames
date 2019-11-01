package com.example.androidengine;


import android.content.Context;
import android.view.View;

import java.util.List;

public class Input implements com.example.engine.Input {
    TouchHandler _touchHandler;

    public Input(View view, float scaleX, float scaleY){
        _touchHandler = new SingleTouchHandler(view, scaleX, scaleY);
    }

    public boolean isTouchDown(int pointer){
        return _touchHandler.isTouchDown(pointer);
    }

    public int getTouchX(int pointer){
        return _touchHandler.getTouchX(pointer);
    }

    public int getTouchY(int pointer){
        return _touchHandler.getTouchY(pointer);
    }

    public List<TouchEvent> getTouchEvents(){
        return _touchHandler.getTouchEvents();
    }
}
