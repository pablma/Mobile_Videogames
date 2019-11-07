package com.example.androidengine;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.engine.Image;

import java.io.IOException;
import java.io.InputStream;

public class Graphics implements com.example.engine.Graphics {

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
    public void clear(int color) {
        _canvas.drawRGB((color & 0xff0000) >> 16, (color & 0xff00) >> 8, (color & 0xff));
    }

    @Override
    public void drawImage(Image image, int x, int y) {
        com.example.androidengine.Image img = (com.example.androidengine.Image)image;
        _canvas.drawBitmap(img._bitmap, x, y,null);
    }

    @Override
    public void drawImage(Image image, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight) {
        _srcRect.left = srcX;
        _srcRect.top = srcY;
        _srcRect.right = srcX + srcWidth - 1;
        _srcRect.bottom = srcY + srcHeight - 1;

        _dstRect.left = x;
        _dstRect.top = y;
        _dstRect.right = x + srcWidth - 1;
        //_dstRect.right = x + _canvas.getWidth() - 1;
        //_dstRect.bottom = y + _canvas.getHeight() - 1;
        _dstRect.bottom = y + srcHeight - 1;

        com.example.androidengine.Image img = (com.example.androidengine.Image)image;
        _canvas.drawBitmap(img._bitmap, _srcRect, _dstRect,null);
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
