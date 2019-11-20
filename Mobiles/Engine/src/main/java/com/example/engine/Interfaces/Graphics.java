package com.example.engine.Interfaces;

import com.example.engine.Utils.Rect;

public interface Graphics {

    /**
     * Interfaz que aporta las funcionalidades gráficas para pintar
     * imágenes en pantalla
     */


    /**
     * Carga una imagen
     * @param name Nombre del archivo a cargar
     * @return Imagen como mapa de bits
     */
    public Image newImage(String name);

    /**
     * Limpia el canvas con un color específico
     * @param color Color con el que se quiere limpiar el canvas
     */
    public void clear(int color);

    /**
     * Pinta una imagen en pantalla en una posición X e Y determinadas
     * @param image imagen que se quiere pintar
     * @param x posición X
     * @param y posición Y
     * @param srcRect parte / rectángulo de la imagen que se quiere pintar
     */
    public void drawImage(Image image, int x, int y, Rect srcRect);

    /**
     * Pinta una imagen en pantalla como fondo
     * @param image imagen que se quiere pintar
     * @param srcRect parte / rectángulo de la imagen que se quiere pintar
     */
    public void drawImageAsBackground(Image image, Rect srcRect);

    /**
     * Pinta una imagen en pantalla centrada en el eje X
     * @param image imagen que se quiere pintar
     * @param y posición Y
     * @param srcRect parte / rectángulo de la imagen que se quiere pintar
     */
    public void drawImageXCentered(Image image, int y, Rect srcRect);

    /**
     * Pinta una imagen en pantalla centrada en el eje X y reescalada
     * @param image imagen que se quiere pintar
     * @param y posición Y
     * @param srcRect parte / rectángulo de la imagen que se quiere pintar
     * @param w
     * @param h
     */
    public void drawImageXCenteredResized(Image image, int y, Rect srcRect, int w, int h);

    public void drawImageAlpha(Image image, int x, int y, Rect srcRect, float alpha);

    public void drawImageAsBackgroundAlpha(Image image, Rect srcRect, float alpha);

    public void drawImageXCenteredAlpha(Image image, int y, Rect srcRect, float alpha);

    public void drawImageXCenteredResizedAlpha(Image image, int y, Rect srcRect, int w, int h, float alpha);

    public void drawImageAsUpperLeftBand(Image image, Rect srcRect);

    public void drawImageAsBottomRightBand(Image image, Rect srcRect);

    public int getWidth();

    public int getHeight();

    public void getScreenSizes(int w, int h);
}
