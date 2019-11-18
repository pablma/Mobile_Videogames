package com.example.androidengine;

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

    AssetManager _assets;
    Bitmap _frameBuffer;
    Canvas _canvas;
    Paint _paint;

    Rect _srcRect = new Rect();
    Rect _dstRect = new Rect();



    public Graphics(AssetManager assets, Bitmap frameBuffer){
        this._assets = assets;
        this._frameBuffer = frameBuffer;
        this._canvas = new Canvas(frameBuffer);
        this._paint = new Paint();

    }

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

        com.example.androidengine.Image img = new com.example.androidengine.Image(bitmap);
        return img;
    }

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

        com.example.androidengine.Image img = (com.example.androidengine.Image)image;
        _canvas.drawBitmap(img.getBitmap(), _srcRect, _dstRect,null);
    }


    @Override
    public void clear(int color) {
        _canvas.drawRGB((color & 0xff0000) >> 16, (color & 0xff00) >> 8, (color & 0xff));
    }

    @Override
    public int getWidth() {
        return _frameBuffer.getWidth();
    }

    @Override
    public int getHeight() {
        return _frameBuffer.getHeight();
    }
}
