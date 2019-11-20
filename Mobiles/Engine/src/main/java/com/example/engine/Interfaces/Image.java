package com.example.engine.Interfaces;

public interface Image {

    /**
     * Interfaz que envuelve una imagen como mapa de bits
     */

    /**
     * @return El ancho de la imagen
     */
    public int getWidth();

    /**
     * @return El alto de la imagen
     */
    public int getHeight();

    /**
     * Método para liberar recursos
     */
    public void dispose();
}
