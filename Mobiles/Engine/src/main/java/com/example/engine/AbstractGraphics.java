package com.example.engine;


import java.awt.Canvas;

public abstract class AbstractGraphics implements Graphics{


    public AbstractGraphics(){

    }

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

        dstRectResized.setLeft(0);
        dstRectResized.setTop(0);
        dstRectResized.setRight(getWidth());
        dstRectResized.setBottom(getHeight());

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

    protected abstract void drawImagePrivate(Image image, int x, int y, Rect srcRect, Rect dstRect);

    protected abstract void drawImageAsBackgroundPrivate(Image image, Rect srcRect, Rect dstRect);

    protected abstract void drawImageXCenteredPrivate(Image image, int y,  Rect srcRect, Rect dstRect);

}
