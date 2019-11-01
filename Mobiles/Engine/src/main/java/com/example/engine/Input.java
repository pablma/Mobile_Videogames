package com.example.engine;


import java.util.List;

public interface Input {

    public static class TouchEvent {
        public static final int TOUCH_DOWN = 0; // Touch
        public static final int TOUCH_UP = 1;   // Release
        public static final int TOUCH_DRAGGED = 2;  // Drag

        public int _type;
        public int _x, _y;
        public int _pointer;
    }

}
