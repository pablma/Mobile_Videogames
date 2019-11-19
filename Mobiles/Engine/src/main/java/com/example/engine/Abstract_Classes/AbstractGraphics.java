package com.example.engine.Abstract_Classes;


import com.example.engine.Interfaces.Graphics;
import com.example.engine.Interfaces.Image;
import com.example.engine.Utils.Rect;

public abstract class AbstractGraphics implements Graphics {

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

        float physicAspectRatio = (float)_windowHeight/(float)_windowWidth;

        if( physicAspectRatio > logicAspectRatio ){ //vertical

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
        float physicAspectRatio = (float)_windowHeight/(float)_windowWidth;

        if( physicAspectRatio > logicAspectRatio ){ //vertical
            physicWindowHeight = (int)((float)_windowWidth * logicAspectRatio);

            top = getHeight() / 2 - physicWindowHeight / 2;
        }
        else {//horizontal
            physicWindowWidth = (int)((float)_windowHeight / logicAspectRatio);

            left = getWidth() / 2 - physicWindowWidth / 2;
        }

        Rect dstRectResized = new Rect(0, 0, 0, 0);
        dstRectResized.setLeft(left);
        dstRectResized.setTop(top);
        dstRectResized.setBottom(top + physicWindowHeight);
        dstRectResized.setRight(left + physicWindowWidth);

        drawImagePrivate(image, srcRect, dstRectResized);
    }

    @Override
    public void drawImageXCentered(Image image, int y, Rect srcRect) {

        float scale = 1;

        int physicWindowWidth = getWidth();
        int physicWindowHeight = getHeight();
        int top = 0;
        int left = 0;

        float logicAspectRatio = 1920.0f / 1080.0f;

        float physicAspectRatio = (float)_windowHeight/(float)_windowWidth;

        if( physicAspectRatio > logicAspectRatio ){ //vertical

            physicWindowHeight = (int)((float)_windowWidth * logicAspectRatio);
            top = getHeight() / 2 - physicWindowHeight / 2;

            scale = (float)physicWindowHeight / 1920.0f;
        }
        else {//horizontal
            physicWindowWidth = (int)((float)_windowHeight / logicAspectRatio);
            left = getWidth() / 2 - physicWindowWidth / 2;

            scale = (float)physicWindowWidth / 1080.0f;
        }


        int resizedY = (int)(y * scale);

        int resizedImageW = (int)(srcRect.getWidth() * scale);
        int resizedImageH = (int)(srcRect.getHeight() * scale);

        int physicX = (int)(((float)getWidth() / 2.0f) - (float)(resizedImageW/2));
        int physicY = resizedY + top;

        Rect dstRectResized = new Rect(0, 0, 0, 0);

        dstRectResized.setLeft(physicX);
        dstRectResized.setTop(physicY);
        dstRectResized.setRight(physicX + resizedImageW);
        dstRectResized.setBottom(physicY + resizedImageH);

        drawImagePrivate(image, srcRect, dstRectResized);

    }

    @Override
    public void drawImageXCenteredResized(Image image, int y, Rect srcRect, int w, int h) {

        float scale = 1;

        int newWidth = w;
        int newHeight = h;

        int physicWindowWidth = getWidth();
        int physicWindowHeight = getHeight();
        int top = 0;
        int left = 0;

        float logicAspectRatio = 1920.0f / 1080.0f;

        float physicAspectRatio = (float)_windowHeight/(float)_windowWidth;

        if( physicAspectRatio > logicAspectRatio ){ //vertical

            physicWindowHeight = (int)((float)_windowWidth * logicAspectRatio);
            top = getHeight() / 2 - physicWindowHeight / 2;

            scale = (float)physicWindowHeight / 1920.0f;
        }
        else {//horizontal
            physicWindowWidth = (int)((float)_windowHeight / logicAspectRatio);
            left = getWidth() / 2 - physicWindowWidth / 2;

            scale = (float)physicWindowWidth / 1080.0f;
        }


        int resizedY = (int)(y * scale);

        int resizedImageW = (int)(newWidth * scale);
        int resizedImageH = (int)(newHeight * scale);

        int physicX = (int)(((float)getWidth() / 2.0f) - (float)(resizedImageW/2));
        int physicY = resizedY + top;

        Rect dstRectResized = new Rect(0, 0, 0, 0);

        dstRectResized.setLeft(physicX);
        dstRectResized.setTop(physicY);
        dstRectResized.setRight(physicX + resizedImageW);
        dstRectResized.setBottom(physicY + resizedImageH);

        drawImagePrivate(image, srcRect, dstRectResized);
    }

    @Override
    public void drawImageAlpha(Image image, int x, int y, Rect srcRect, float alpha) {

        float scale = 1;

        int physicWindowWidth = getWidth();
        int physicWindowHeight = getHeight();
        int top = 0;
        int left = 0;

        float logicAspectRatio = 1920.0f / 1080.0f;

        float physicAspectRatio = (float)_windowHeight/(float)_windowWidth;

        if( physicAspectRatio > logicAspectRatio ){ //vertical

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

        drawImagePrivateAlpha(image, srcRect, dstRectResized, alpha);
    }

    @Override
    public void drawImageAsBackgroundAlpha(Image image, Rect srcRect, float alpha) {
        //reescaldo X Y

        int physicWindowWidth = getWidth();
        int physicWindowHeight = getHeight();
        int top = 0;
        int left = 0;

        float logicAspectRatio = 1920.0f / 1080.0f;
        float physicAspectRatio = (float)_windowHeight/(float)_windowWidth;

        if( physicAspectRatio > logicAspectRatio ){ //vertical
            physicWindowHeight = (int)((float)_windowWidth * logicAspectRatio);

            top = getHeight() / 2 - physicWindowHeight / 2;
        }
        else {//horizontal
            physicWindowWidth = (int)((float)_windowHeight / logicAspectRatio);

            left = getWidth() / 2 - physicWindowWidth / 2;
        }

        Rect dstRectResized = new Rect(0, 0, 0, 0);
        dstRectResized.setLeft(left);
        dstRectResized.setTop(top);
        dstRectResized.setBottom(top + physicWindowHeight);
        dstRectResized.setRight(left + physicWindowWidth);

        drawImagePrivateAlpha(image, srcRect, dstRectResized, alpha);
    }

    @Override
    public void drawImageXCenteredAlpha(Image image, int y, Rect srcRect, float alpha) {

        float scale = 1;

        int physicWindowWidth = getWidth();
        int physicWindowHeight = getHeight();
        int top = 0;
        int left = 0;

        float logicAspectRatio = 1920.0f / 1080.0f;

        float physicAspectRatio = (float)_windowHeight/(float)_windowWidth;

        if( physicAspectRatio > logicAspectRatio ){ //vertical

            physicWindowHeight = (int)((float)_windowWidth * logicAspectRatio);
            top = getHeight() / 2 - physicWindowHeight / 2;

            scale = (float)physicWindowHeight / 1920.0f;
        }
        else {//horizontal
            physicWindowWidth = (int)((float)_windowHeight / logicAspectRatio);
            left = getWidth() / 2 - physicWindowWidth / 2;

            scale = (float)physicWindowWidth / 1080.0f;
        }


        int resizedY = (int)(y * scale);

        int resizedImageW = (int)(srcRect.getWidth() * scale);
        int resizedImageH = (int)(srcRect.getHeight() * scale);

        int physicX = (int)(((float)getWidth() / 2.0f) - (float)(resizedImageW/2));
        int physicY = resizedY + top;

        Rect dstRectResized = new Rect(0, 0, 0, 0);

        dstRectResized.setLeft(physicX);
        dstRectResized.setTop(physicY);
        dstRectResized.setRight(physicX + resizedImageW);
        dstRectResized.setBottom(physicY + resizedImageH);

        drawImagePrivateAlpha(image, srcRect, dstRectResized, alpha);
    }

    @Override
    public void drawImageXCenteredResizedAlpha(Image image, int y, Rect srcRect, int w, int h, float alpha) {
        float scale = 1;

        int newWidth = w;
        int newHeight = h;

        int physicWindowWidth = getWidth();
        int physicWindowHeight = getHeight();
        int top = 0;
        int left = 0;

        float logicAspectRatio = 1920.0f / 1080.0f;

        float physicAspectRatio = (float)_windowHeight/(float)_windowWidth;

        if( physicAspectRatio > logicAspectRatio ){ //vertical

            physicWindowHeight = (int)((float)_windowWidth * logicAspectRatio);
            top = getHeight() / 2 - physicWindowHeight / 2;

            scale = (float)physicWindowHeight / 1920.0f;
        }
        else {//horizontal
            physicWindowWidth = (int)((float)_windowHeight / logicAspectRatio);
            left = getWidth() / 2 - physicWindowWidth / 2;

            scale = (float)physicWindowWidth / 1080.0f;
        }


        int resizedY = (int)(y * scale);

        int resizedImageW = (int)(newWidth * scale);
        int resizedImageH = (int)(newHeight * scale);

        int physicX = (int)(((float)getWidth() / 2.0f) - (float)(resizedImageW/2));
        int physicY = resizedY + top;

        Rect dstRectResized = new Rect(0, 0, 0, 0);

        dstRectResized.setLeft(physicX);
        dstRectResized.setTop(physicY);
        dstRectResized.setRight(physicX + resizedImageW);
        dstRectResized.setBottom(physicY + resizedImageH);

        drawImagePrivateAlpha(image, srcRect, dstRectResized, alpha);
    }



    @Override
    public void drawImageAsUpperLeftBand(Image image, Rect srcRect) {

        //reescaldo X Y

        int physicWindowWidth = getWidth();
        int physicWindowHeight = getHeight();
        int top = 0;
        int left = 0;

        float logicAspectRatio = 1920.0f / 1080.0f;
        float physicAspectRatio = (float)_windowHeight/(float)_windowWidth;

        Rect dstRectResized = new Rect(0, 0, 0, 0);

        if( physicAspectRatio > logicAspectRatio ){ //vertical
            physicWindowHeight = (int)((float)_windowWidth * logicAspectRatio);

            top = getHeight() / 2 - physicWindowHeight / 2;

            dstRectResized.setLeft(left);
            dstRectResized.setTop(0);
            dstRectResized.setBottom(top);
            dstRectResized.setRight(left + physicWindowWidth);
        }
        else {//horizontal
            physicWindowWidth = (int)((float)_windowHeight / logicAspectRatio);

            left = getWidth() / 2 - physicWindowWidth / 2;

            dstRectResized.setLeft(0);
            dstRectResized.setTop(top);
            dstRectResized.setBottom(top + physicWindowHeight);
            dstRectResized.setRight(left);
        }



        drawImagePrivate(image, srcRect, dstRectResized);
    }

    @Override
    public void drawImageAsBottomRightBand(Image image, Rect srcRect) {

        //reescaldo X Y

        int physicWindowWidth = getWidth();
        int physicWindowHeight = getHeight();
        int top = 0;
        int left = 0;

        float logicAspectRatio = 1920.0f / 1080.0f;
        float physicAspectRatio = (float)_windowHeight/(float)_windowWidth;

        Rect dstRectResized = new Rect(0, 0, 0, 0);

        if( physicAspectRatio > logicAspectRatio ){ //vertical
            physicWindowHeight = (int)((float)_windowWidth * logicAspectRatio);

            top = getHeight() / 2 - physicWindowHeight / 2;

            dstRectResized.setLeft(left);
            dstRectResized.setTop(top + physicWindowHeight);
            dstRectResized.setBottom(getHeight());
            dstRectResized.setRight(left + physicWindowWidth);
        }
        else {//horizontal
            physicWindowWidth = (int)((float)_windowHeight / logicAspectRatio);

            left = getWidth() / 2 - physicWindowWidth / 2;

            dstRectResized.setLeft(left + physicWindowWidth);
            dstRectResized.setTop(top);
            dstRectResized.setBottom(top + physicWindowHeight);
            dstRectResized.setRight(getWidth());
        }

        drawImagePrivate(image, srcRect, dstRectResized);
    }


    @Override
    public void getScreenSizes(int w, int h) {
        _windowWidth = w;
        _windowHeight = h;
    }

    protected abstract void drawImagePrivate(Image image, Rect srcRect, Rect dstRect);
    protected abstract void drawImagePrivateAlpha(Image image, Rect srcRect, Rect dstRect, float alpha);
}
