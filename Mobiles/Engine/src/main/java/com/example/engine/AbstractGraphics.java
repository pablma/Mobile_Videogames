package com.example.engine;


import java.awt.Canvas;

public abstract class AbstractGraphics implements Graphics{

    Graphics _graphics;
    public AbstractGraphics(Graphics graphics){
        _graphics = graphics;
    }


    @Override
    public void drawImage(Image image, int x, int y, Rect srcRect) {
        //reescaldo X Y
        int recaladaX = 0;
        int rescaladaY = 0;
        drawImagePrivate(image, recaladaX, rescaladaY, srcRect);
    }

    @Override
    public void drawImageAsBackground(Image image, Rect srcRect) {

    }

    @Override
    public void drawImageCentered(Image image, int y, Rect srcRect) {

    }


    protected abstract void drawImagePrivate(Image image, int x, int y, Rect srcRect);
}
