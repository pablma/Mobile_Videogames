package com.example.engine;

import org.w3c.dom.css.Rect;

public class Sprite {
    private Image _image;
    private Rect _srcRect;

    public Sprite(Image img, Rect srcRect){
        _image = img;
        _srcRect = srcRect;
    }

    /*public draw(Graphics g) {
        //g.drawImage();
    }*/
}
