package com.example.androidengine.Android_Graphics;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.engine.Abstract_Classes.AbstractGraphics;
import com.example.engine.Interfaces.Image;

import java.io.IOException;
import java.io.InputStream;

public class Graphics extends AbstractGraphics {

    /**
     * CLASE GRAPHICS
     * Proporciona la funcionalidad parra cargar y pintar imágenes en android
     */

    AssetManager _assets;
    Bitmap _frameBuffer;
    Canvas _canvas;
    Paint _paint;

    Rect _srcRect = new Rect();
    Rect _dstRect = new Rect();

    /**
     * Constructora de la clase, inicializa todos los parámetros necesarios
     * @param assets
     * @param frameBuffer buffer que utilizaremos para pintar
     */
    public Graphics(AssetManager assets, Bitmap frameBuffer){
        this._assets = assets;
        this._frameBuffer = frameBuffer;
        this._canvas = new Canvas(frameBuffer);
        this._paint = new Paint();
    }

    /**
     * Carga una imagen de un archivo
     * @param name Nombre del archivo a cargar
     * @return imagen de tipo androidImage como mapa de bits
     */
    @Override
    public Image newImage(String name) {
        InputStream in = null;
        Bitmap bitmap = null;

        try {
            in = _assets.open(name);
            bitmap = BitmapFactory.decodeStream(in);
            if(bitmap == null)
                throw new RuntimeException("Couldn't load bitmap from asset '" + name + "'" );
        }
        catch (IOException e){
            throw new RuntimeException("Couldn't load bitmap from asset '" + name + "'" );
        }
        finally {
            if(in != null){
                try{
                    in.close();
                } catch (IOException e){}
            }
        }

        com.example.androidengine.Android_Graphics.Image img = new com.example.androidengine.Android_Graphics.Image(bitmap);
        return img;
    }

    /**
     * Pinta una imagen en pantalla
     * @param image imagen que se quiere pintar
     * @param srcRect rectángulo fuente d ela imagen
     * @param dstRect rectángulo destino en el que se va a pintar la imagen
     */
    @Override
    protected void drawImagePrivate(Image image, com.example.engine.Utils.Rect srcRect, com.example.engine.Utils.Rect dstRect) {
        _srcRect.left = srcRect.getLeft();
        _srcRect.top = srcRect.getTop();
        _srcRect.right = srcRect.getRight();
        _srcRect.bottom = srcRect.getBottom();

        _dstRect.left = dstRect.getLeft();
        _dstRect.top = dstRect.getTop();
        _dstRect.right = dstRect.getRight();
        _dstRect.bottom = dstRect.getBottom();

        com.example.androidengine.Android_Graphics.Image img = (com.example.androidengine.Android_Graphics.Image)image;
        _canvas.drawBitmap(img.getBitmap(), _srcRect, _dstRect,null);
    }

    /**
     * Pinta una imagen en pantalla con un determinado alpha
     * @param image imagen que se quiere pintar
     * @param srcRect rectángulo fuente d ela imagen
     * @param dstRect rectángulo destino en el que se va a pintar la imagen
     * @param alpha alpha con el que se desea pintar la imagen
     */
    @Override
    protected void drawImagePrivateAlpha(Image image, com.example.engine.Utils.Rect srcRect, com.example.engine.Utils.Rect dstRect, float alpha) {
        _srcRect.left = srcRect.getLeft();
        _srcRect.top = srcRect.getTop();
        _srcRect.right = srcRect.getRight();
        _srcRect.bottom = srcRect.getBottom();

        _dstRect.left = dstRect.getLeft();
        _dstRect.top = dstRect.getTop();
        _dstRect.right = dstRect.getRight();
        _dstRect.bottom = dstRect.getBottom();

        int a = (int)(alpha * 255);
        _paint.setAlpha(a);

        com.example.androidengine.Android_Graphics.Image img = (com.example.androidengine.Android_Graphics.Image)image;
        _canvas.drawBitmap(img.getBitmap(), _srcRect, _dstRect,_paint);
    }

    /**
     * Método para limpiar el canvas de un color determinado
     * @param color Color con el que se quiere limpiar el canvas
     */
    @Override
    public void clear(int color) {
        _canvas.drawRGB((color & 0xff0000) >> 16, (color & 0xff00) >> 8, (color & 0xff));
    }

    /**
     * Devuelve el ancho físico de graphics
     * @return int con el ancho de graphics
     */
    @Override
    public int getWidth() {
        return _frameBuffer.getWidth();
    }

    /**
     * Devuelve el alto físico de Graphics
     * @return int con el alto de Graphics
     */
    @Override
    public int getHeight() {
        return _frameBuffer.getHeight();
    }


}
