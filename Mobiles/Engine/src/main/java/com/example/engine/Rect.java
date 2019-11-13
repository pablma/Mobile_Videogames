package com.example.engine;

public class Rect {

    private int _left, _right, _top, _bottom;

    public Rect(int x, int y, int width, int height){

        _left = x;
        _top = y;
        _right = x + width;
        _bottom = y + height;

    }

    public int getLeft(){
        return _left;
    }

    public int getRight(){
        return _right;
    }

    public int getTop(){
        return _top;
    }

    public int getBottom(){
        return _bottom;
    }
}
