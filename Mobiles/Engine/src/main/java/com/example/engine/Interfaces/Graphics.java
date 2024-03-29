package com.example.engine.Interfaces;

import com.example.engine.Utils.Rect;

public interface Graphics {

    /**
     * INTERFAZ GRAPHICS
     * Aporta las funcionalidades gráficas para pintar
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

    public void drawImageResized(Image image, int x, int y, Rect srcRect, int w, int h);

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
     * @param w nueva anchura lógca de la imagen
     * @param h nueva altura lógica de la magen
     */
    public void drawImageXCenteredResized(Image image, int y, Rect srcRect, int w, int h);

    /**
     * Pinta una imagen en pantala con un determinado alfa
     * @param image imagen que se quiere pintar
     * @param x posición X
     * @param y posición Y
     * @param srcRect parte / rectángulo de la imaen que se quiere pintar
     * @param alpha cantidad de alpha para la imagen
     */
    public void drawImageAlpha(Image image, int x, int y, Rect srcRect, float alpha);

    /**
     * Pinta una imagen en pantala como fondo con un determinado alfa
     * @param image imagen que se quiere pintar
     * @param srcRect parte / rectángulo de la imaen que se quiere pintar
     * @param alpha cantidad de alpha para la imagen
     */
    public void drawImageAsBackgroundAlpha(Image image, Rect srcRect, float alpha);

    /**
     * Pinta una imagen centrada en pantala con un determinado alfa y una posición Y
     * @param image imagen que se quiere pintar
     * @param srcRect parte / rectángulo de la imaen que se quiere pintar
     * @param alpha cantidad de alpha para la imagen
     */
    public void drawImageXCenteredAlpha(Image image, int y, Rect srcRect, float alpha);

    /**
     * Pinta una imagen en pantalla en una posición x e y reescalada con un determinado alfa
     * @param image imagen que se quiere pintar
     * @param x posición X
     * @param y posición Y
     * @param srcRect parte / rectángulo de la imagen que se quiere pintar
     * @param w nueva anchura lógca de la imagen
     * @param h nueva altura lógica de la magen
     * @param alpha cantidad de alpha para la imagen
     */
    public void drawImageResizedAlpha(Image image, int x, int y, Rect srcRect, int w, int h, float alpha);

    /**
     * Pinta una imagen en pantalla centrada en el eje X y reescalada con un determinado alfa
     * @param image imagen que se quiere pintar
     * @param y posición Y
     * @param srcRect parte / rectángulo de la imagen que se quiere pintar
     * @param w nueva anchura lógca de la imagen
     * @param h nueva altura lógica de la magen
     * @param alpha cantidad de alpha para la imagen
     */
    public void drawImageXCenteredResizedAlpha(Image image, int y, Rect srcRect, int w, int h, float alpha);

    /**
     * Pinta una imagen como una banda negra en la aprte superior de la pantalla
     * @param image imagen que se quiere pintar
     * @param srcRect parte / rectángulo de la imagen que se quiere pintar
     */
    public void drawImageAsUpperLeftBand(Image image, Rect srcRect);

    /**
     * Pinta una imagen como una banda negra en la aprte superior de la pantalla
     * @param image imagen que se quiere pintar
     * @param srcRect parte / rectángulo de la imagen que se quiere pintar
     */
    public void drawImageAsBottomRightBand(Image image, Rect srcRect);

    /**
     * Devuelve el ancho del mapa de bts
     * @return ancho del mapa de bits
     */
    public int getWidth();

    /**
     * Devuelve el alto del mapa de bits
     * @return alto del mapa de bits
     */
    public int getHeight();

    /**
     * Devuelve el ancho lógico de la pantalla
     * @return int con el ancho lógico de la pantalla
     */
    public int getLogicWidth();

    /**
     * Devuelve el alto lógico de la pantalla
     * @return int con el alto lógico de la pantalla
     */
    public int getLogicHeight();

    /**
     * Guarda w y h en dos variables que se utlizarán para el reescalado
     * @param w ancho
     * @param h alto
     */
    public void getScreenSizes(int w, int h);
}
