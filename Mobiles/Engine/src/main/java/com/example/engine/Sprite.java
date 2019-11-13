package com.example.engine;



public class Sprite {

    private Image _image;
    private Rect _srcRect;
    private Graphics _graphics;

    public Sprite(Graphics graphics, Image img, Rect srcRect){

        _graphics = graphics;
        _image = img;
        _srcRect = srcRect;
    }

    public void drawImage(int x, int y) {
        _graphics.drawImage(_image, x, y);
    }

    public void drawImage(int x, int y, Rect srcRect){
    }
}
