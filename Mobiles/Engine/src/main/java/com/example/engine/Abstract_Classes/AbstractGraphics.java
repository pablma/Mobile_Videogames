package com.example.engine.Abstract_Classes;


import com.example.engine.Interfaces.Graphics;
import com.example.engine.Interfaces.Image;
import com.example.engine.Utils.Rect;

public abstract class AbstractGraphics implements Graphics {

    /**
     * CLASE ABSTRACTA ABSTRACT_GRAPHICS
     * Esta clase nos permitirá hacer el reescalado de todos los sprites presentes en el estado de juego
     */

    private int _windowWidth, _windowHeight;

    int logicHeight = 1920;
    int logicWidth = 1080;

    float logicAspectRatio = (float)logicHeight / (float)logicWidth;

    /**
     * Constructora de la clase
     */
    public AbstractGraphics(){}

    /**
     * Método heredado de la interfaz Graphics que pinta una imagen en una posición x e y
     * @param image imagen que se quiere pintar
     * @param x posición X
     * @param y posición Y
     * @param srcRect parte / rectángulo de la imagen que se quiere pintar
     */
    @Override
    public void drawImage(Image image, int x, int y, Rect srcRect) {

        drawImageResized(image, x, y, srcRect, srcRect.getWidth(), srcRect.getHeight());
    }

    /**
     * Método heredado de la interfaz Graphics que pinta una imagen redimensionada en una posición x e y
     * @param image imagen que se quiere pintar
     * @param x posición X
     * @param y posición Y
     * @param srcRect parte / rectángulo de la imagen que se quiere pintar
     * @param w nueva anchura lógca de la imagen
     * @param h nueva altura lógica de la imagen
     */
    @Override
    public void drawImageResized(Image image, int x, int y, Rect srcRect, int w, int h) {
        float scale = 1;

        int newWidth = w;
        int newHeight = h;

        int physicWindowWidth = getWidth();
        int physicWindowHeight = getHeight();
        int top = 0;
        int left = 0;


        float physicAspectRatio = (float)_windowHeight/(float)_windowWidth;

        if( physicAspectRatio > logicAspectRatio ){ //vertical

            physicWindowHeight = (int)((float)_windowWidth * logicAspectRatio);
            top = _windowHeight / 2 - physicWindowHeight / 2;

            scale = (float)physicWindowHeight / (float)logicHeight;
        }
        else {//horizontal
            physicWindowWidth = (int)((float)_windowHeight / logicAspectRatio);
            left = _windowWidth / 2 - physicWindowWidth / 2;

            scale = (float)physicWindowWidth / (float)logicWidth;
        }

        int resizedX = (int)(x * scale);
        int resizedY = (int)(y * scale);

        int resizedImageW = (int)(newWidth * scale);
        int resizedImageH = (int)(newHeight * scale);

        int physicX = resizedX + left;
        int physicY = resizedY + top;

        Rect dstRectResized = new Rect(0, 0, 0, 0);

        dstRectResized.setLeft(physicX);
        dstRectResized.setTop(physicY);
        dstRectResized.setRight(physicX + resizedImageW);
        dstRectResized.setBottom(physicY + resizedImageH);

        drawImagePrivate(image, srcRect, dstRectResized);
    }

    /**
     * Método heredado de la interfaz Graphics que pinta una imagen de fondo
     * @param image imagen que se quiere pintar
     * @param srcRect parte / rectángulo de la imagen que se quiere pintar
     */
    @Override
    public void drawImageAsBackground(Image image, Rect srcRect) {
        drawImageResized(image, 0, 0, srcRect, logicWidth, logicHeight);
    }

    /**
     * Método heredado de la interfaz Graphics que pinta una imagen cnetrada en el eje X con una posición Y determinada
     * @param image imagen que se quiere pintar
     * @param y posición Y
     * @param srcRect parte / rectángulo de la imagen que se quiere pintar
     */
    @Override
    public void drawImageXCentered(Image image, int y, Rect srcRect) {
        drawImageResized(image, logicWidth / 2 - srcRect.getWidth() / 2, y, srcRect, srcRect.getWidth(), srcRect.getHeight());
    }

    /**
     * Método heredado de la interfaz Graphics que pinta una imagen reescalada centrada en el eje X una con una posición y
     * @param image imagen que se quiere pintar
     * @param y posición Y
     * @param srcRect parte / rectángulo de la imagen que se quiere pintar
     * @param w nueva anchura lógca de la imagen
     * @param h nueva altura lógica de la magen
     */
    @Override
    public void drawImageXCenteredResized(Image image, int y, Rect srcRect, int w, int h) {
        drawImageResized(image, logicWidth / 2 - w / 2, y, srcRect, w, h);
    }

    //Métodos con transparencias

    /**
     * Método heredado de la interfaz Graphics que pinta una imagen en una posición x e y con un determinado alpha
     * @param image imagen que se quiere pintar
     * @param x posición X
     * @param y posición Y
     * @param srcRect parte / rectángulo de la imaen que se quiere pintar
     * @param alpha cantidad de alpha para la imagen
     */
    @Override
    public void drawImageAlpha(Image image, int x, int y, Rect srcRect, float alpha) {
        drawImageResizedAlpha(image, x, y, srcRect,  srcRect.getWidth(), srcRect.getHeight(), alpha);
    }

    /**
     * Método heredado de la interfaz Graphics que pinta una imagen redimensionada en una posición x e y
     * @param image imagen que se quiere pintar
     * @param x posición X
     * @param y posición Y
     * @param srcRect parte / rectángulo de la imagen que se quiere pintar
     * @param w nueva anchura lógca de la imagen
     * @param h nueva altura lógica de la magen
     * @param alpha cantidad de alpha para la imagen
     */
    @Override
    public void drawImageResizedAlpha(Image image, int x, int y, Rect srcRect, int w, int h, float alpha) {

        float scale = 1;

        int newWidth = w;
        int newHeight = h;

        int physicWindowWidth = getWidth();
        int physicWindowHeight = getHeight();
        int top = 0;
        int left = 0;


        float physicAspectRatio = (float)_windowHeight/(float)_windowWidth;

        if( physicAspectRatio > logicAspectRatio ){ //vertical

            physicWindowHeight = (int)((float)_windowWidth * logicAspectRatio);
            top = _windowHeight / 2 - physicWindowHeight / 2;

            scale = (float)physicWindowHeight / (float)logicHeight;
        }
        else {//horizontal
            physicWindowWidth = (int)((float)_windowHeight / logicAspectRatio);
            left = _windowWidth / 2 - physicWindowWidth / 2;

            scale = (float)physicWindowWidth / (float)logicWidth;
        }

        int resizedX = (int)(x * scale);
        int resizedY = (int)(y * scale);

        int resizedImageW = (int)(newWidth * scale);
        int resizedImageH = (int)(newHeight * scale);

        int physicX = resizedX + left;
        int physicY = resizedY + top;

        Rect dstRectResized = new Rect(0, 0, 0, 0);

        dstRectResized.setLeft(physicX);
        dstRectResized.setTop(physicY);
        dstRectResized.setRight(physicX + resizedImageW);
        dstRectResized.setBottom(physicY + resizedImageH);

        drawImagePrivateAlpha(image, srcRect, dstRectResized, alpha);
    }

    /**
     * Método heredado de la interfaz Graphics que pinta una imagen como fondo con un determinado alpha
     * @param image imagen que se quiere pintar
     * @param srcRect parte / rectángulo de la imaen que se quiere pintar
     * @param alpha cantidad de alpha para la imagen
     */
    @Override
    public void drawImageAsBackgroundAlpha(Image image, Rect srcRect, float alpha) {
        drawImageResizedAlpha(image, 0, 0, srcRect, logicWidth, logicHeight, alpha);
    }

    /**
     * Método heredado de la interfaz Graphics que pinta una imagen centrada en el eje X con una posición Y determinada y un alpha
     * @param image imagen que se quiere pintar
     * @param y
     * @param srcRect parte / rectángulo de la imaen que se quiere pintar
     * @param alpha cantidad de alpha para la imagen
     */
    @Override
    public void drawImageXCenteredAlpha(Image image, int y, Rect srcRect, float alpha) {
        drawImageResizedAlpha(image, logicWidth / 2 - srcRect.getWidth() / 2, y, srcRect, srcRect.getWidth(), srcRect.getHeight(), alpha);
    }


    /**
     * Método heredado de la interfaz Graphics que pinta una imagen redimensionada centrada en el eje X con una posición Y determinada y un alpha
     * @param image imagen que se quiere pintar
     * @param y posición Y
     * @param srcRect parte / rectángulo de la imagen que se quiere pintar
     * @param w nueva anchura lógca de la imagen
     * @param h nueva altura lógica de la magen
     * @param alpha cantidad de alpha para la imagen
     */
    @Override
    public void drawImageXCenteredResizedAlpha(Image image, int y, Rect srcRect, int w, int h, float alpha) {
        drawImageResizedAlpha(image, logicWidth / 2 - w / 2, y, srcRect, w, h, alpha);
    }

    /**
     * Método heredado de la interfaz Graphics que pinta una imagen como una banda superior izquierda
     * @param image imagen que se quiere pintar
     * @param srcRect parte / rectángulo de la imagen que se quiere pintar
     */
    @Override
    public void drawImageAsUpperLeftBand(Image image, Rect srcRect) {

        //reescaldo X Y

        int physicWindowWidth = getWidth();
        int physicWindowHeight = getHeight();
        int top = 0;
        int left = 0;


        float physicAspectRatio = (float)_windowHeight/(float)_windowWidth;

        Rect dstRectResized = new Rect(0, 0, 0, 0);

        if( physicAspectRatio > logicAspectRatio ){ //vertical
            physicWindowHeight = (int)((float)_windowWidth * logicAspectRatio);

            top = _windowHeight / 2 - physicWindowHeight / 2;

            dstRectResized.setLeft(left);
            dstRectResized.setTop(0);
            dstRectResized.setBottom(top);
            dstRectResized.setRight(left + physicWindowWidth);
        }
        else {//horizontal
            physicWindowWidth = (int)((float)_windowHeight / logicAspectRatio);

            left = _windowWidth / 2 - physicWindowWidth / 2;

            dstRectResized.setLeft(0);
            dstRectResized.setTop(top);
            dstRectResized.setBottom(top + physicWindowHeight);
            dstRectResized.setRight(left);
        }

        drawImagePrivate(image, srcRect, dstRectResized);
    }

    /**
     * Método heredado de la interfaz Graphics que pinta una imagen como una banda inferior derecha
     * @param image imagen que se quiere pintar
     * @param srcRect parte / rectángulo de la imagen que se quiere pintar
     */
    @Override
    public void drawImageAsBottomRightBand(Image image, Rect srcRect) {

        //reescaldo X Y

        int physicWindowWidth = getWidth();
        int physicWindowHeight = getHeight();
        int top = 0;
        int left = 0;

        float physicAspectRatio = (float)_windowHeight/(float)_windowWidth;

        Rect dstRectResized = new Rect(0, 0, 0, 0);

        if( physicAspectRatio > logicAspectRatio ){ //vertical
            physicWindowHeight = (int)((float)_windowWidth * logicAspectRatio);

            top = _windowHeight / 2 - physicWindowHeight / 2;

            dstRectResized.setLeft(left);
            dstRectResized.setTop(top + physicWindowHeight);
            dstRectResized.setBottom(getHeight());
            dstRectResized.setRight(left + physicWindowWidth);
        }
        else {//horizontal
            physicWindowWidth = (int)((float)_windowHeight / logicAspectRatio);

            left = _windowWidth / 2 - physicWindowWidth / 2;

            dstRectResized.setLeft(left + physicWindowWidth);
            dstRectResized.setTop(top);
            dstRectResized.setBottom(top + physicWindowHeight);
            dstRectResized.setRight(getWidth());
        }

        drawImagePrivate(image, srcRect, dstRectResized);
    }

    /**
     * Método heredado de la interfaz Graphics que actualiza los valores el ancho y altod e la pantalla
     * @param w ancho
     * @param h alto
     */
    @Override
    public void getScreenSizes(int w, int h) {
        _windowWidth = w;
        _windowHeight = h;
    }



    @Override
    public int getLogicWidth() {
        return logicWidth;
    }

    @Override
    public int getLogicHeight() {
        return logicHeight;
    }



    /**
     * Método que pinta una imagen con un rectángulo destino determinado
     * @param image imagen que se quiere pintar
     * @param srcRect rectángulo fuente d ela imagen
     * @param dstRect rectángulo destino en el que se va a pintar la imagen
     */
    protected abstract void drawImagePrivate(Image image, Rect srcRect, Rect dstRect);

    /**
     * Método que pinta una imagen con un rectángulo destino y una alpha determinado
     * @param image imagen que se quiere pintar
     * @param srcRect rectángulo fuente d ela imagen
     * @param dstRect rectángulo destino en el que se va a pintar la imagen
     * @param alpha alpha con el que se desea pintar la imagen
     */
    protected abstract void drawImagePrivateAlpha(Image image, Rect srcRect, Rect dstRect, float alpha);
}
