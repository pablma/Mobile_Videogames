package com.example.engine.Utils;


import com.example.engine.Interfaces.Graphics;
import com.example.engine.Interfaces.Image;

public class Sprite {

    /**
     * CLASE SPRITE
     * Nos permite crear sprites de juego, lo que nos simplificará el código a la hora de
     * dibujar elementos en pantalla
     */

    private Image _image;
    private Rect _srcRect;
    private Graphics _graphics;

    /**
     * Constructora de la clase
     * @param graphics objeto graphics
     * @param img imagen del sprite
     * @param srcRect rectángulo en el que está contenida la imagen
     */
    public Sprite(Graphics graphics, Image img, Rect srcRect){

        _graphics = graphics;
        _image = img;
        _srcRect = srcRect;
    }

    /**
     * Pinta un sprite en una posición x e y
     * @param x posición X dónde se quiere pintar el sprite
     * @param y posición Y donde se quiere pintar el sprite
     */
    public void drawImage(int x, int y){
        _graphics.drawImage(_image, x, y, _srcRect);
    }


    public void drawImageResized(int x, int y, int w, int h, float alpha) {
        _graphics.drawImageResized(_image, x, y, _srcRect, w, h);
    }

    /**
     * Pinta un sprite como fondo
     */
    public void drawImageAsBackground(){
        _graphics.drawImageAsBackground(_image, _srcRect);
    }

    /**
     * Pinta un sprite centrada en el eje X con una posición Y proporcionada
     * @param y posición Y donde se quiere pintar el sprite
     */
    public void drawImageXCentered(int y){_graphics.drawImageXCentered(_image, y, _srcRect);}

    /**
     * Pinta un sprite redimensionada centrada en el eje X con una posición Y proporcionada
     * @param y posición Y donde se quiere pintar el sprite
     * @param w nueva anchura de el sprite
     * @param h nueva altura de el sprite
     */
    public void drawImageXCenteredResized(int y, int w, int h){
        _graphics.drawImageXCenteredResized(_image, y, _srcRect, w, h);
    }

    /**
     * Pinta un sprite en una posición x e y con un determinado alpha
     * @param x posición X dónde se quiere pintar el sprite
     * @param y posición Y donde se quiere pintar el sprite
     * @param alpha alpha con el que se quiere pintar el sprite
     */
    public void drawImageAlpha(int x, int y, float alpha){
        _graphics.drawImageAlpha(_image, x, y, _srcRect, alpha);
    }

    /**
     * Pinta un sprite como fondo con un alpha determinado
     * @param alpha alpha con el que se quiere pintar el sprite
     */
    public void drawImageAsBackgroundAlpha(float alpha){
        _graphics.drawImageAsBackgroundAlpha(_image, _srcRect, alpha);
    }

    /**
     * Pinta un sprite con un alpha determinado centrada en el eje X con una posición Y proporcionada
     * @param y posición Y donde se quiere pintar el sprite
     * @param alpha alpha con el que se quiere pintar el sprite
     */
    public void drawImageXCenteredAlpha(int y, float alpha){
        _graphics.drawImageXCenteredAlpha(_image, y, _srcRect, alpha);
    }

    /**
     * Pinta un sprite redimensionada con un alpha determinado en una posición x e y
     * @param x posición X donde se quiere pintar el sprite
     * @param y posición Y donde se quiere pintar el sprite
     * @param w nueva anchura de el sprite
     * @param h nueva altura de el sprite
     * @param alpha alpha con el que se quiere pintar el sprite
     */
    public void drawImageResizedAlpha(int x, int y, int w, int h, float alpha) {
        _graphics.drawImageResizedAlpha(_image, x, y, _srcRect, w, h, alpha);
    }

    /**
     *  Pinta un sprite redimensionada con un alpha determinado centrada en el eje X con una posición Y proporcionada
     * @param y posición Y donde se quiere pintar el sprite
     * @param w nueva anchura de el sprite
     * @param h nueva altura de el sprite
     * @param alpha alpha con el que se quiere pintar el sprite
     */
    public void drawImageXCenteredResizedAlpha(int y, int w, int h, float alpha){
        _graphics.drawImageXCenteredResizedAlpha(_image, y, _srcRect, w, h, alpha);
    }

    /**
     * Pinta un sprite como una banda en la parte superior izquierda de la pantalla
     */
    public void drawImageAsUpperLeftBand(){_graphics.drawImageAsUpperLeftBand(_image, _srcRect);}

    /**
     * Pinta un sprite como una banda en la parte inferior derecha de la pantalla
     */
    public void drawImageAsBottomRightBand(){_graphics.drawImageAsBottomRightBand(_image, _srcRect);}

    /**
     * Devuelve el ancho del sprite
     * @return ancho del sprite
     */
    public int getWidth() {
        return _srcRect.getWidth();
    }

    /**
     * Devuelve el alto del sprite
     * @return alto del sprite
     */
    public int getHeight() {
        return _srcRect.getHeight();
    }

}
