package com.example.androidengine;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.Window;

import com.example.engine.AbstractGraphics;
import com.example.engine.Image;

import java.io.IOException;
import java.io.InputStream;

public class Graphics extends AbstractGraphics {

    AssetManager _assets;
    Bitmap _frameBuffer;
    Canvas _canvas;
    Paint _paint;

    Rect _srcRect = new Rect();
    Rect _dstRect = new Rect();

    float _defaultAspectRatio;
    float _defaultCanvasWidht;
    float _defaultCanvasHeigh;


    public Graphics(AssetManager assets, Bitmap frameBuffer){
        this._assets = assets;
        this._frameBuffer = frameBuffer;
        this._canvas = new Canvas(frameBuffer);
        this._paint = new Paint();

        _defaultCanvasHeigh = 1920;
        _defaultCanvasWidht = 1080;
        _defaultAspectRatio = _defaultCanvasHeigh/_defaultCanvasWidht;
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

    protected void drawImagePrivate(Image image, int x, int y, com.example.engine.Rect srcRect, com.example.engine.Rect dstRect) {
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

    protected void drawImageAsBackgroundPrivate(Image image, com.example.engine.Rect srcRect, com.example.engine.Rect dstRect) {

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
    protected void drawImageXCenteredPrivate(Image image, int y, com.example.engine.Rect srcRect, com.example.engine.Rect dstRect) {

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


    /*
    @Override
    public void drawImage(Image image, int x, int y, com.example.engine.Rect srcRect) {
        _srcRect.left = srcRect.getLeft();
        _srcRect.top = srcRect.getTop();
        _srcRect.right = srcRect.getRight();
        _srcRect.bottom = srcRect.getBottom();

        _dstRect.left = x;
        _dstRect.top = y;
        _dstRect.right = x + srcRect.getWidth() - 1;
        _dstRect.bottom = y + srcRect.getHeight() - 1;

        com.example.androidengine.Image img = (com.example.androidengine.Image)image;
        _canvas.drawBitmap(img.getBitmap(), _srcRect, _dstRect,null);
    }

    @Override
    public void drawImageAsBackground(Image image, com.example.engine.Rect srcRect) {

        _srcRect.left = srcRect.getLeft();
        _srcRect.top = srcRect.getTop();
        _srcRect.right = srcRect.getRight();
        _srcRect.bottom = srcRect.getBottom();

        _dstRect.left = 0;
        _dstRect.top = 0;
        _dstRect.right = _canvas.getWidth();
        _dstRect.bottom = _canvas.getHeight();

        com.example.androidengine.Image img = (com.example.androidengine.Image)image;
        _canvas.drawBitmap(img.getBitmap(), _srcRect, _dstRect,null);
    }


    @Override
    public void drawImageXCentered(Image image, int y, com.example.engine.Rect srcRect) {

        int windowX_center = _canvas.getWidth() / 2;

        int imageX_center = (int)((srcRect.getWidth() / 2));

        _srcRect.left = srcRect.getLeft();
        _srcRect.top = srcRect.getTop();
        _srcRect.right = srcRect.getRight();
        _srcRect.bottom = srcRect.getBottom();

        _dstRect.left = windowX_center - imageX_center;
        _dstRect.top = y;
        _dstRect.right = windowX_center + imageX_center - 1;
        _dstRect.bottom = y + srcRect.getHeight() - 1;

        com.example.androidengine.Image img = (com.example.androidengine.Image)image;
        _canvas.drawBitmap(img.getBitmap(), _srcRect, _dstRect,null);
    }

    public void scaleCanvas(int screenWidth, int screenHeight){

        float screenAspectRatio = screenHeight / screenWidth;

        float _scale;


        if(screenAspectRatio < 1){ //horizontalScreen
            //_scale = screenHeight / _defaultCanvasHeigh;
            System.out.println("Horizontal canvas W " + _canvas.getWidth() + "Horizontal canvas H " + _canvas.getHeight());
            System.out.println("Horizontal screen W " + screenWidth + "Horizontal screen H " + screenHeight);
            //_canvas.scale(1/_defaultAspectRatio, 1, screenWidth/2, screenHeight/2 );
            //System.out.println("HORIZONTAL");
        }
        else { //vertical screen
            System.out.println("Vertical canvas W " + _canvas.getWidth() + "Vertical canvas H " + _canvas.getHeight());
            System.out.println("Vertical screen W " + screenWidth + "Vertical screen H " + screenHeight);;
            //_scale = screenWidth / _defaultCanvasWidht;
            //_canvas.scale(1, 1/_defaultAspectRatio,screenWidth/2, screenHeight/2 );
        }

    }
  */
    public void scaleCanvas(int screenWidth, int screenHeight){

        float screenAspectRatio = screenHeight / screenWidth;

        float _scale;

        if(screenAspectRatio < 1){ //horizontalScreen
            _scale = screenHeight / _defaultCanvasHeigh;
            _canvas.scale(1 / screenAspectRatio, 1, screenWidth/2, screenHeight/2 );

        }
        else { //vertical screen
            _scale = screenWidth / _defaultCanvasWidht;
            _canvas.scale(1, screenAspectRatio,screenWidth/2, screenHeight/2 );
        }
    }

    public void scaleTest(int screenWidth, int screenHeight){
        System.out.println("antes" + _canvas.getWidth());
        _canvas.scale(0.5f,0.5f, screenWidth/2, screenHeight/2 );
        System.out.println("despues" + _canvas.getWidth());
    }
}
