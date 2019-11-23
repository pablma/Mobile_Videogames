package com.example.pcengine;


import com.example.engine.Abstract_Classes.AbstractGraphics;
import com.example.engine.Interfaces.Image;
import com.example.engine.Utils.Rect;

import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

import java.awt.*;

public class Graphics extends AbstractGraphics {

    /**
     * CLASE GRAPHICS
     * Proporciona la funcionalidad parra cargar y pintar imágenes en PC
     */

    java.awt.Graphics _graphics;
    private BufferStrategy _strategy; // obtener referencia a grafics - strategy show - dispose
    JFrame _window;

    java.awt.Rectangle _srcRect = new java.awt.Rectangle();
    java.awt.Rectangle _dstRect = new java.awt.Rectangle();
    Graphics2D _graphics2D;


    /**
     * Constructora de la clase
     * @param window ventana de la aplicación
     */
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

    /**
     * Carga una imagen de un archivo
     * @param name Nombre del archivo a cargar
     * @return imagen de tipo PCImage como mapa de bits
     */
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

    /**
     * Pinta una imagen en pantalla
     * @param image imagen que se quiere pintar
     * @param srcRect rectángulo fuente d ela imagen
     * @param dstRect rectángulo destino en el que se va a pintar la imagen
     */
    @Override
    protected void drawImagePrivate(Image image, Rect srcRect, Rect dstRect) {
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

    /**
     * Pinta una imagen en pantalla con un determinado alpha
     * @param image imagen que se quiere pintar
     * @param srcRect rectángulo fuente d ela imagen
     * @param dstRect rectángulo destino en el que se va a pintar la imagen
     * @param alpha alpha con el que se desea pintar la imagen
     */
    @Override
    protected void drawImagePrivateAlpha(Image image, Rect srcRect, Rect dstRect, float alpha) {
        _srcRect.x = srcRect.getLeft();
        _srcRect.y = srcRect.getTop();
        _srcRect.width = srcRect.getRight();
        _srcRect.height = srcRect.getBottom();

        _dstRect.x = dstRect.getLeft();
        _dstRect.y = dstRect.getTop();
        _dstRect.width = dstRect.getRight();
        _dstRect.height = dstRect.getBottom();


        _graphics2D = (Graphics2D)_graphics;
        Composite alphaComp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        Composite opaqueComp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1);

        _graphics2D.setComposite(alphaComp);

        com.example.pcengine.Image img = (com.example.pcengine.Image)image;
        _graphics.drawImage(img.getImage(), _dstRect.x,  _dstRect.y, _dstRect.width, _dstRect.height, _srcRect.x, _srcRect.y, _srcRect.width, _srcRect.height,null);

        _graphics2D.setComposite(opaqueComp);
    }


    /**
     * Método para limpiar el canvas de un color determinado
     * @param color Color con el que se quiere limpiar el canvas
     */
    @Override
    public void clear(int color) {
        int r = (color>>16)&0xFF;
        int g = (color>>8)&0xFF;
        int b = (color>>0)&0xFF;
        _graphics.setColor(new Color(r, g, b));
        _graphics.fillRect(0, 0, getWidth(), getHeight());
    }

    /**
     * Devuelve el ancho físico de graphics
     * @return int con el ancho de graphics
     */
    @Override
    public int getWidth() {
        return  _window.getWidth();
    } //In PC the physic dimensions are the dimensions of the window where we are displaying the game

    /**
     * Devuelve el alto físico de Graphics
     * @return int con el alto de Graphics
     */
    @Override
    public int getHeight() {
        return  _window.getHeight();
    }

    /**
     * Igualamos la varible grphics a strategy
     */
    public void setGraphics(){
        while(true) {
            try {
                _graphics = _strategy.getDrawGraphics();
                break;
            } catch (Exception e) {

            }
        }
    }

    /**
     * Libera recursos del graphics
     */
    public void dispose() {
        _graphics.dispose();
    }

    /**
     * Devuelve el strategybuffer
     * @return BufferStrattegy
     */
    public BufferStrategy getBufferStrategy() { return _strategy; }



}