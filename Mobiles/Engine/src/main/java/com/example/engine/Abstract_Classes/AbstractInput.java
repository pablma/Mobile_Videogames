package com.example.engine.Abstract_Classes;

import com.example.engine.Interfaces.Game;
import com.example.engine.Interfaces.Input;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractInput implements Input {

    public AbstractInput(){}

    Game _game;
    private int _windowWidth, _windowHeight;

    @Override
    public void init(Game game) {
        game = _game;
    }

    @Override
    public boolean isTouchDown(int pointer) {
        return isTouchDownPrivate(pointer);
    }

    @Override
    public int getTouchX(int pointer) {
        int x = getTouchXPrivate(pointer);
        int resizedX = 5;
        return resizedX;
    }

    @Override
    public int getTouchY(int pointer) {
        int y = getTouchYPrivate(pointer);
        int resizedY = 0;
        return resizedY;
    }

    @Override
    public List<TouchEvent> getTouchEvents() {


        float scale;


        int physicWindowWidth;
        int physicWindowHeight;
        int top = 0;
        int left = 0;

        int eventY = 0;
        int eventX = 0;

        float logicAspectRatio = 1920.0f / 1080.0f;

        float physicAspectRatio = (float)_windowHeight/(float)_windowWidth;

        if( physicAspectRatio > logicAspectRatio ){ //vertical

            physicWindowHeight = (int)((float)_windowWidth * logicAspectRatio);
            top = _windowHeight / 2 - physicWindowHeight / 2;

            scale = (float)physicWindowHeight / 1920.0f;
        }
        else {//horizontal
            physicWindowWidth = (int)((float)_windowHeight / logicAspectRatio);
            left = _windowWidth / 2 - physicWindowWidth / 2;

            scale = (float)physicWindowWidth / 1080.0f;
        }


        List<TouchEvent> resizedTouchEvents =  new ArrayList<TouchEvent>();

        List<Input.TouchEvent> touchEvents = getTouchEventsPrivate();
        for (int i = 0; i < touchEvents.size(); i++) {
            Input.TouchEvent event = touchEvents.get(i);



            int repositionatedPhysicX = event._x - left;
            int repositionatedPhysicY = event._y - top;


            int logicX = (int)( repositionatedPhysicX / scale);
            int logicY = (int)(repositionatedPhysicY / scale);

            event._x = logicX;
            event._y = logicY;
            resizedTouchEvents.add(event);
        }

        return touchEvents;
    }

    @Override
    public void saveScreenSizes(int w, int h) {
        _windowWidth = w;
        _windowHeight = h;
    }

    protected abstract boolean isTouchDownPrivate(int pointer);
    protected abstract int getTouchXPrivate(int pointer);
    protected abstract int getTouchYPrivate(int pointer);
    protected abstract List<TouchEvent> getTouchEventsPrivate();
}
