package com.example.engine.Utils;


import com.example.engine.Interfaces.Graphics;
import com.example.engine.Interfaces.Image;

public class Sprite {

    private Image _image;
    private Rect _srcRect;
    private Graphics _graphics;

    public Sprite(Graphics graphics, Image img, Rect srcRect){

        _graphics = graphics;
        _image = img;
        _srcRect = srcRect;
    }

    public void drawImage(int x, int y){
        _graphics.drawImage(_image, x, y, _srcRect);
    }

    public void drawImageAsBackground(){
        _graphics.drawImageAsBackground(_image, _srcRect);
    }

    public void drawImageXCentered(int y){_graphics.drawImageXCentered(_image, y, _srcRect);}

    public void drawImageAsUpperLeftBand(){_graphics.drawImageAsUpperLeftBand(_image, _srcRect);}

    public void drawImageAsBottomRightBand(){_graphics.drawImageAsBottomRightBand(_image, _srcRect);}

    public void drawImageXCenteredResized(int y, int w, int h){
        _graphics.drawImageXCenteredResized(_image, y, _srcRect, w, h);
    }

    public int getWidth() {
        return _srcRect.getWidth();
    }

    public int getHeight() {
        return _srcRect.getHeight();
    }

}