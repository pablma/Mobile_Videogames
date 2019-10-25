package com.example.pcengine;

public class Image implements com.example.engine.Image {
    java.awt.Image _image;

    public Image(java.awt.Image image){
        this._image = image;
    }

    @Override
    public int getWidth() {
       return _image.getWidth(null);
    }

    @Override
    public int getHeight() {
        return _image.getHeight(null);
    }

    @Override
    public void dispose() {
    }
}
