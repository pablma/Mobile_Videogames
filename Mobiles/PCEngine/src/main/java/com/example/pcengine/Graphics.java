package com.example.pcengine;


import com.example.engine.Image;

public class Graphics implements com.example.engine.Graphics {

    java.awt.Graphics _graphics;
    java.awt.Image _frameBuffer;
    java.awt.Rectangle _srcRect = new java.awt.Rectangle();
    java.awt.Rectangle _dstRect = new java.awt.Rectangle();


    public Graphics(java.awt.Graphics graphics, java.awt.Image frameBuffer){
        _graphics = graphics;
        _frameBuffer = frameBuffer;
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

        int srcX2 = srcX + srcWidth - 1;
        int srcY2 = srcY + srcHeight - 1;

        int dstX2 = x + srcWidth - 1;
        int dstY2 = y + srcHeight - 1;

        com.example.pcengine.Image img = (com.example.pcengine.Image)image;
        _graphics.drawImage(img._image, x, y, dstX2, dstY2, srcX, srcY, srcX2, srcY2,null);
    }

    @Override
    public void drawBackground(Image image, int srcX, int srcY, int srcWidth, int srcHeight) {
    }

    @Override
    public void drawImageCentered(Image image, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight, float scale) {

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
