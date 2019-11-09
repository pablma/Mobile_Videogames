package com.example.engine;

import java.awt.Canvas;

public interface Graphics {
    public Image newImage(String name);

    public void clear(int color);

    public void drawImage(Image image, int x, int y);

    public void drawImage(Image image, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight);

    public void drawBackground(Image image, int srcX, int srcY, int srcWidth, int srcHeight);

    public void drawImageCentered(Image image, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight, float scale);

    public int getWidth();

    public int getHeight();
}
