package com.example.pcengine;


import com.example.engine.AbstractGraphics;
import com.example.engine.Image;
import com.example.engine.Rect;

import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

import java.awt.*;

public class Graphics extends AbstractGraphics {

    java.awt.Graphics _graphics;
    private BufferStrategy _strategy; // obtener referencia a grafics - strategy show - dispose
    JFrame _window;

    java.awt.Rectangle _srcRect = new java.awt.Rectangle();
    java.awt.Rectangle _dstRect = new java.awt.Rectangle();


    public Graphics(JFrame window){
        _window = window;

        int intentos = 100;
        while(intentos-- > 0) {
            try {
                _window.createBufferStrategy(2);
                break;
            }
            catch(Exception e) {
            }
        } // while pidiendo la creación de la buffeStrategy
        if (intentos == 0) {
            System.err.println("No pude crear la BufferStrategy");
            return;
        }
        else {
            // En "modo debug" podríamos querer escribir esto.
            //System.out.println("BufferStrategy tras " + (100 - intentos) + " intentos.");
        }

        // Obtenemos el Buffer Strategy que se supone acaba de crearse.

        _strategy = _window.getBufferStrategy();

    }


    @Override
    public Image newImage(String name) {

        java.awt.Image javaImage = null;
        try {
            javaImage = javax.imageio.ImageIO.read(new java.io.File("assets/" + name));
       }
       catch (Exception e) {
           System.err.println(e);
       }

       com.example.pcengine.Image img = new com.example.pcengine.Image(javaImage);
       return img;
    }

    @Override
    public void clear(int color) {
        int r = (color>>16)&0xFF;
        int g = (color>>8)&0xFF;
        int b = (color>>0)&0xFF;
        _graphics.setColor(new Color(r, g, b));
        _graphics.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    protected void drawImagePrivate(Image image, com.example.engine.Rect srcRect, com.example.engine.Rect dstRect) {
        _srcRect.x = srcRect.getLeft();
        _srcRect.y = srcRect.getTop();
        _srcRect.width = srcRect.getRight();
        _srcRect.height = srcRect.getBottom();

        _dstRect.x = dstRect.getLeft();
        _dstRect.y = dstRect.getTop();
        _dstRect.width = dstRect.getRight();
        _dstRect.height = dstRect.getBottom();

        com.example.pcengine.Image img = (com.example.pcengine.Image)image;
        _graphics.drawImage(img.getImage(), _dstRect.x,  _dstRect.y, _dstRect.width, _dstRect.height, _srcRect.x, _srcRect.y, _srcRect.width, _srcRect.height,null);
    }

    @Override
    protected void drawImageAsBackgroundPrivate(Image image, Rect srcRect, Rect dstRect) {

        _srcRect.x = srcRect.getLeft();
        _srcRect.y = srcRect.getTop();
        _srcRect.width = srcRect.getRight();
        _srcRect.height = srcRect.getBottom();

        _dstRect.x = dstRect.getLeft();
        _dstRect.y = dstRect.getTop();
        _dstRect.width = dstRect.getRight();
        _dstRect.height = dstRect.getBottom();

        com.example.pcengine.Image img = (com.example.pcengine.Image)image;
        _graphics.drawImage(img.getImage(), _dstRect.x, _dstRect.y, _dstRect.width, _dstRect.height, _srcRect.x, _srcRect.y, _srcRect.width, _srcRect.height,null);

    }

    @Override
    protected void drawImageXCenteredPrivate(Image image, int y, Rect srcRect, Rect dstRect) {

    }


    /*
    @Override
    public void drawImage(Image image, int x, int y, Rect srcRect) {

        int srcX2 = srcX + srcWidth - 1;
        int srcY2 = srcY + srcHeight - 1;

        int dstX2 = x + srcWidth - 1;
        int dstY2 = y + srcHeight - 1;

        com.example.pcengine.Image img = (com.example.pcengine.Image)image;
        _graphics.drawImage(img.getImage(), x, y, dstX2, dstY2, srcX, srcY, srcX2, srcY2,null);
    }



    @Override
    public void drawImageAsBackground(Image image, Rect srcRect) {

        int srcX2 = srcX + srcWidth - 1;
        int srcY2 = srcY + srcHeight - 1;

        int dstX2 = srcWidth - 1;
        int dstY2 = srcHeight - 1;

        com.example.pcengine.Image img = (com.example.pcengine.Image)image;
        _graphics.drawImage(img.getImage(), 0, 0, dstX2, dstY2, srcX, srcY, srcX2, srcY2,null);
    }

    @Override
    public void drawImageXCentered(Image image, int y, Rect srcRect) {

        int srcX2 = srcX + srcWidth - 1;
        int srcY2 = srcY + srcHeight - 1;

        int dstX2 = x + srcWidth - 1;
        int dstY2 = y + srcHeight - 1;

        com.example.pcengine.Image img = (com.example.pcengine.Image)image;
        _graphics.drawImage(img.getImage(), x, y, dstX2, dstY2, srcX, srcY, srcX2, srcY2,null);

    }
    */

    @Override
    public int getWidth() {
        return  _window.getWidth();
    }

    @Override
    public int getHeight() {
        return  _window.getHeight();
    }

    @Override
    public void getScreenSizes(int w, int h) {

    }

    public void setGraphics(){
        while(true) {
            try {
                _graphics = _strategy.getDrawGraphics();
                break;
            } catch (Exception e) {

            }
        }
    }

    public void dispose() {
        _graphics.dispose();
    }

    public BufferStrategy getBufferStrategy() { return _strategy; }

}