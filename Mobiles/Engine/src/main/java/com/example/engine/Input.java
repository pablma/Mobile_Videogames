package com.example.engine;

import java.util.List;

public interface Input {

    public class TouchEvent {
        public static final int TOUCH_DOWN = 0; // Touch
        public static final int TOUCH_UP = 1;   // Release
        public static final int TOUCH_DRAGGED = 2;  // Drag

        public int type;
        public int x, y;
        public int pointer;
    }

    public boolean isTouchDown(int pointer);

    public int getTouchX(int pointer);

    public int getTouchY(int pointer);

    public List<TouchEvent> getTouchEvents();
}
