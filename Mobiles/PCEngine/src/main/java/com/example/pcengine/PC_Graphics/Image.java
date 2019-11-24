package com.example.pcengine.PC_Graphics;

public class Image implements com.example.engine.Interfaces.Image {

    /**
     * CLASE IMAGE
     * Implementa la interfaz Image de Engine y sirve para crear nuevas imágenes
     * Trabajamos con java.awt.Image
     */

    private java.awt.Image _image;

    /**
     * Constructora de la clase
     * @param image imagen que se quiere crear
     */
    public Image(java.awt.Image image){
        this._image = image;
    }

    /**
     * Devuelve la imagen awt de java con la imagen que tiene guardada
     * @return imagen awt de java
     */
    public java.awt.Image getImage(){ return _image; }

    /**
     * Devuelve el ancho del mapa de bits
     * @return int con el ancho del mapa de bits
     */
    @Override
    public int getWidth() {
       return _image.getWidth(null);
    }

    /**
     * Devuelve el alto del mapa de bits
     * @return int con el alto del mapa de bits
     */
    @Override
    public int getHeight() {
        return _image.getHeight(null);
    }

    /**
     * Libera recursos del mapa de bits
     */
    @Override
    public void dispose() {
        _image.flush();
    }
}
