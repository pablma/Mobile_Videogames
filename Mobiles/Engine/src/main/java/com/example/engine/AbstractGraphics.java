package com.example.engine;


import java.awt.Canvas;

public abstract class AbstractGraphics implements Graphics{

    Graphics _graphics;
    public AbstractGraphics(Graphics graphics){
        _graphics = graphics;
    }

    @Override
    public Image newImage(String name) {
        return null;
    }

    @Override
    public void clear(int color) {
    }

    @Override
    public void drawImage(Image image, int x, int y) {
    }

    @Override
    public void drawImage(Image image, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight) {

    }

    @Override
    public void drawBackground(Image image, int srcX, int srcY, int srcWidth, int srcHeight) {
    }

    @Override
    public void drawImageCentered(Image image, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight, float scale) {

    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}
