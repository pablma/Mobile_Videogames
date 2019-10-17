package com.example.graphics;

import java.awt.Image;

public interface Graphics {
    Image newImage(String name);
    void clear(int color);
    void drawImage(Image image);
    int getWidth();
    int getHeight();
}
