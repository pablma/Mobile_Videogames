package com.example.engine;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.View;

public class SingleTouchHandler implements Input {

    boolean isTouched;

    int touchX;
    int touchY;

    List<TouchEvent> touchEvents = new ArrayList<TouchEvent>();
    List<TouchEvent> touchEventsBuffer = new ArrayList<TouchEvent>();

    float scaleX;
    float scaleY;


    @Override
    public boolean isTouchDown(int pointer) {
        synchronized(this){
            if(pointer == 0)
                return true;
            else
                return false;
        }
    }

    @Override
    public int getTouchX(int pointer) {
        synchronized(this){
            return touchX;
        }
    }

    @Override
    public int getTouchY(int pointer) {
        synchronized(this){
            return touchY;
        }
    }

    @Override
    public List<TouchEvent> getTouchEvents() {
        synchronized(this){
            touchEvents.clear();
            touchEvents.addAll(touchEventsBuffer);
            touchEventsBuffer.clear();

            return touchEvents;
        }
    }
}
