package com.example.engine;


import java.awt.Canvas;

public abstract class AbstractGraphics implements Graphics{

    private int _windowWidth, _windowHeight;

    public AbstractGraphics(){}

    @Override
    public void drawImage(Image image, int x, int y, Rect srcRect) {


        float scale = 1;

        int physicWindowWidth = getWidth();
        int physicWindowHeight = getHeight();
        int top = 0;
        int left = 0;

        float logicAspectRatio = 1920.0f / 1080.0f;

        if(physicWindowHeight > physicWindowWidth){ //vertical


            physicWindowHeight = (int)((float)_windowWidth * logicAspectRatio);
            top = getHeight() / 2 - physicWindowHeight / 2;

            scale = (float)physicWindowHeight / 1920.0f;
        }
        else {//horizontal

            physicWindowWidth = (int)((float)_windowHeight / logicAspectRatio);
            left = getWidth() / 2 - physicWindowWidth / 2;

            scale = (float)physicWindowWidth / 1080.0f;
        }

        int resizedX = (int)(x * scale);
        int resizedY = (int)(y * scale);

        int resizedImageW = (int)(srcRect.getWidth() * scale);
        int resizedImageH = (int)(srcRect.getHeight() * scale);

        int physicX = resizedX + left;
        int physicY = resizedY + top;

        Rect dstRectResized = new Rect(0, 0, 0, 0);

        dstRectResized.setLeft(physicX);
        dstRectResized.setTop(physicY);
        dstRectResized.setRight(physicX + resizedImageW);
        dstRectResized.setBottom(physicY + resizedImageH);

        drawImagePrivate(image, srcRect, dstRectResized);
    }

    @Override
    public void drawImageAsBackground(Image image, Rect srcRect) {
        //reescaldo X Y

        int physicWindowWidth = getWidth();
        int physicWindowHeight = getHeight();
        int top = 0;
        int left = 0;

        float logicAspectRatio = 1920.0f / 1080.0f;

        if(physicWindowHeight > physicWindowWidth){ //vertical
            physicWindowHeight = (int)((float)_windowWidth * logicAspectRatio);
            physicWindowWidth = getWidth();
            top = getHeight() / 2 - physicWindowHeight / 2;
        }
        else {//horizontal
            physicWindowWidth = (int)((float)_windowHeight / logicAspectRatio);
            physicWindowHeight = getHeight();
            left = getWidth() / 2 - physicWindowWidth / 2;
        }

        Rect dstRectResized = new Rect(0, 0, 0, 0);
        dstRectResized.setLeft(left);
        dstRectResized.setTop(top);
        dstRectResized.setBottom(top + physicWindowHeight);
        dstRectResized.setRight(left + physicWindowWidth);

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

    protected abstract void drawImagePrivate(Image image, Rect srcRect, Rect dstRect);

    protected abstract void drawImageAsBackgroundPrivate(Image image, Rect srcRect, Rect dstRect);

    protected abstract void drawImageXCenteredPrivate(Image image, int y,  Rect srcRect, Rect dstRect);

}
