package com.example.androidengine;
import android.graphics.Bitmap;

public class Image implements com.example.engine.Interfaces.Image {

    /**
     * CLASE IMAGE
     * Implementa la interfaz Image de Engine y sirve para crear nuevas imágenes
     * Trabajamos con el bitmap de android
     */

    private Bitmap _bitmap;

    /**
     * Constructora de la clase
     * @param bitmap imagen que se quiere crear
     */
    public Image(Bitmap bitmap){
        this._bitmap = bitmap;
    }

    /**
     * Devuelve el mapa de bits con la imagen que tiene guardada
     * @return mapa de bits
     */
    public Bitmap getBitmap(){ return _bitmap; }

    /**
     * Devuelve el ancho del mapa de bits
     * @return int con el ancho del mapa de bits
     */
    @Override
    public int getWidth() {
        return _bitmap.getWidth();
    }

    /**
     * Devuelve el alto del mapa de bits
     * @return int con el alto del mapa de bits
     */
    @Override
    public int getHeight() {

        return _bitmap.getHeight();
    }

    /**
     * Libera recursos del mapa de bits
     */
    @Override
    public void dispose() {
        _bitmap.recycle();
    }
}
