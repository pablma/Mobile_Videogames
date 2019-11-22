package com.example.engine.Utils;

public class Rect {

    /**
     * CLASE RECT
     * Nos permite crear rectángulos que usaremos como srcRect y dstRect a la hora de
     * presentar nuestros sprites en pantalla
     */
    private int _left, _right, _top, _bottom;
    private int _width, _height;

    /**
     * Constructora de la clase
     * @param x posición X desde la que empieza el rectángulo
     * @param y posición Y  desde la que empieza el rectángulo
     * @param width Ancho del rectángulo
     * @param height Alto del rectángulo
     */
    public Rect(int x, int y, int width, int height){

        _left = x;
        _top = y;
        _right = x + width;
        _bottom = y + height;

        _width = width;
        _height = height;

    }

    /**
     * Devuelve la posición que hace referencia al lado izquierdo del rectángulo
     * @return lado izquierdo del rectángulo
     */
    public int getLeft(){
        return _left;
    }

    /**
     * Devuelve la posición que hace referencia al lado derecho del rectángulo
     * @return lado derecho del rectángulo
     */
    public int getRight(){
        return _right;
    }

    /**
     * Devuelve la posición que hace referencia al lado superior del rectángulo
     * @return lado superior del rectángulo
     */
    public int getTop(){
        return _top;
    }

    /**
     * Devuelve la posición que hace referencia al lado inferior del rectángulo
     * @return lado inferior del rectángulo
     */
    public int getBottom(){
        return _bottom;
    }

    /**
     * Devuelve el ancho del rectángulo
     * @return ancho del rectángulo
     */
    public int getWidth(){
        return _width;
    }

    /**
     * Devuelve el alto del rectángulo
     * @return alto del rectángulo
     */
    public int getHeight(){
        return _height;
    }

    /**
     * Establece el lado izquierdo del rectángulo
     * @param value valor que será el nuevo lado izquierdo del rectángulo
     */
    public void setLeft(int value){
        _left = value;
    }

    /**
     * Establece el lado derecho del rectángulo
     * @param value valor que será el nuevo lado derecho del rectángulo
     */
    public void setRight(int value){
        _right = value;
    }

    /**
     * Establece el lado superior del rectángulo
     * @param value valor que será el nuevo lado superior del rectángulo
     */
    public void setTop(int value){
        _top = value;
    }

    /**
     * Establece el lado inferior del rectángulo
     * @param value valor que será el nuevo lado inferior del rectángulo
     */
    public void setBottom(int value){
        _bottom = value;
    }

    /**
     * Establece el ancho del rectángulo
     * @param left lado izquierdo del rectángulo
     * @param right lado derecho del rectángulo
     */
    private void setWidth(int left, int right){
        int aux = right - left;

        if(aux < 0)
            aux = -aux;

        _height = aux;
    }

    /**
     * Establece el alto del rectángulo
     * @param top lado superior del rectángulo
     * @param bottom lado inferior del rectángulo
     */
    private void setHeight(int top, int bottom){
        int aux = bottom - top;

        if(aux < 0)
            aux = -aux;

        _height = aux;
    }
}
