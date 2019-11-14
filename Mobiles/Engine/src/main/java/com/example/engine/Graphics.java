package com.example.engine;

import java.awt.Canvas;

public interface Graphics {
    public Image newImage(String name);

    public void clear(int color);

    public void drawImage(Image image, int x, int y, Rect srcRect);

    public void drawImageAsBackground(Image image, Rect srcRect);

    public void drawImageXCentered(Image image, int y, Rect srcRect);

    public int getWidth();

    public int getHeight();
}
