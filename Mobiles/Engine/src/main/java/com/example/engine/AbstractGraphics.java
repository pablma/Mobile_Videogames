package com.example.engine;


import java.awt.Canvas;

public abstract class AbstractGraphics implements Graphics{

    private int _windowWidth, _windowHeight;

    public AbstractGraphics(){}

    @Override
    public void drawImage(Image image, int x, int y, Rect srcRect) {
        //reescaldo X Y
        Rect dstRectResized = new Rect(0, 0, 0, 0);

        int scale = 2;

        int resizedX = x * scale;
        int resizedY = y * scale;

        dstRectResized.setLeft(resizedX);
        dstRectResized.setTop(resizedY);
        dstRectResized.setRight((x + srcRect.getWidth()) * scale);
        dstRectResized.setBottom((y + srcRect.getHeight()) * scale);

        drawImagePrivate(image, resizedX, resizedY, srcRect, dstRectResized);
    }

    @Override
    public void drawImageAsBackground(Image image, Rect srcRect) {
        //reescaldo X Y
        Rect dstRectResized = new Rect(0, 0, 0, 0);

        int scaleW = 1;
        int scaleH = 1;

        int physicWidth = getWidth();
        int physicHeight = getHeight();

        int left = 0;
        int top = 0;

        float logicAspectRatio = (float)getHeight()/(float)getWidth(); //logic gH, and logic gW change depending on the rotation of the screen

        if(physicHeight > physicWidth){
            physicHeight = (int)((float)_windowWidth * logicAspectRatio);
            top = getHeight() / 2 - physicHeight / 2;
        }
        else {
            physicWidth = (int)((float)_windowHeight * logicAspectRatio);
            left = getWidth() / 2 - physicWidth / 2;
        }

        dstRectResized.setLeft(left);
        dstRectResized.setTop(top);
        dstRectResized.setBottom(top + physicHeight);
        dstRectResized.setRight(left + physicWidth);

        drawImageAsBackgroundPrivate(image, srcRect, dstRectResized);
    }

    @Override
    public void drawImageXCentered(Image image, int y, Rect srcRect) {
        Rect dstRectResized = new Rect(0, 0, 0, 0);

        int scale = 1;

        int xCenteredPosition = getWidth() / 2 - ((srcRect.getWidth() / 2) * scale);

        dstRectResized.setLeft(xCenteredPosition);
        dstRectResized.setTop(y);
        dstRectResized.setRight((xCenteredPosition + srcRect.getWidth()) * scale);
        dstRectResized.setBottom((y + srcRect.getHeight()) * scale);

        drawImageXCenteredPrivate(image, y,  srcRect, dstRectResized);
    }

    @Override
    public void getScreenSizes(int w, int h) {
        _windowWidth = w;
        _windowHeight = h;
    }

    protected abstract void drawImagePrivate(Image image, int x, int y, Rect srcRect, Rect dstRect);

    protected abstract void drawImageAsBackgroundPrivate(Image image, Rect srcRect, Rect dstRect);

    protected abstract void drawImageXCenteredPrivate(Image image, int y,  Rect srcRect, Rect dstRect);

}
