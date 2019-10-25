package com.example.pcengine;


import com.example.engine.Image;

public class Graphics implements com.example.engine.Graphics {

    java.awt.Graphics _graphics;
    java.awt.Image _frameBuffer;


    public Graphics(){
    }

    @Override
    public Image newImage(String name) {
       try {
           _frameBuffer = javax.imageio.ImageIO.read(new java.io.File(name));
       }
       catch (Exception e) {
           System.err.println(e);
       }

       com.example.pcengine.Image img = new com.example.pcengine.Image(_frameBuffer);
       return img;
    }

    @Override
    public void clear(int color) {

    }

    @Override
    public void drawImage(Image image, int x, int y) {
        com.example.pcengine.Image img = (com.example.pcengine.Image)image;
        _graphics.drawImage(img._image, x, y, null);
    }

    @Override
    public void drawImage(Image image, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight) {

    }

    @Override
    public int getWidth() {
        return  _frameBuffer.getWidth(null);
    }

    @Override
    public int getHeight() {
        return  _frameBuffer.getHeight(null);
    }
}
