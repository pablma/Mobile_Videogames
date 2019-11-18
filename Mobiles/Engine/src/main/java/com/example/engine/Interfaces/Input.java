package com.example.engine.Interfaces;


import java.util.List;

public interface Input {

    public enum EventType{
        TOUCH_DOWN,
        TOUCH_UP,
        TOUCH_DRAGGED
    }

    public static class TouchEvent {

        public EventType _type;
        public int _x, _y;
        public int _id;
    }


    public boolean isTouchDown(int pointer);

    public int getTouchX(int pointer);

    public int getTouchY(int pointer);

    public List<TouchEvent> getTouchEvents();
}
