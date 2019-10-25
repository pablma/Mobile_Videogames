package com.example.androidengine;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.engine.Image;

public class Graphics implements com.example.engine.Graphics {

    AssetManager assets_;
    Bitmap frameBuffer_;
    Canvas canvas_;
    Paint paint_;
    Rect srcRect_ = new Rect();
    Rect dstRect_ = new Rect();

    public Graphics(AssetManager assets, Bitmap frameBuffer){
        this.assets_ = assets;
        this.frameBuffer_ = frameBuffer;
        this.canvas_ = new Canvas(frameBuffer);
        this.paint_ = new Paint();
    }

    @Override
    public Image newImage(String name) {
        return null;
    }

    @Override
    public void clear(int color) {
        canvas_.drawRGB((color & 0xff0000) >> 16, (color & 0xff00) >> 8, (color & 0xff));
    }

    @Override
    public void drawImage(Image image, int x, int y) {

    }

    @Override
    public void drawImage(Image image, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight) {

    }

    @Override
    public int getWidth() {
        return frameBuffer_.getWidth();
    }

    @Override
    public int getHeight() {
        return frameBuffer_.getHeight();
    }
}
