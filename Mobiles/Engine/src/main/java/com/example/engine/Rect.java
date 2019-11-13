package com.example.engine;

public class Rect {

    private int _left, _right, _top, _bottom;
    private int _width, _height;

    public Rect(int x, int y, int width, int height){

        _left = x;
        _top = y;
        _right = x + width;
        _bottom = y + height;

        _width = width;
        _height = height;

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

    public int getWidth(){
        return _width;
    }

    public int getHeight(){
        return _height;
    }
}
