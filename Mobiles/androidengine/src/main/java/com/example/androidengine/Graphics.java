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
        InputStream in = null;
        Bitmap bitmap = null;

        try {
            in = assets_.open(name);
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
        canvas_.drawRGB((color & 0xff0000) >> 16, (color & 0xff00) >> 8, (color & 0xff));
    }

    @Override
    public void drawImage(Image image, int x, int y) {
        com.example.androidengine.Image img = (com.example.androidengine.Image)image;
        canvas_.drawBitmap(img.bitmap_, x, y,null);
    }

    @Override
    public void drawImage(Image image, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight) {
        srcRect_.left = srcX;
        srcRect_.top = srcY;
        srcRect_.right = srcX + srcWidth - 1;
        srcRect_.bottom = srcY + srcHeight - 1;

        dstRect_.left = x;
        dstRect_.top = y;
        dstRect_.right = x + srcWidth - 1;
        dstRect_.bottom = y + srcHeight - 1;

        com.example.androidengine.Image img = (com.example.androidengine.Image)image;
        canvas_.drawBitmap(img.bitmap_, srcRect_, dstRect_,null);
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
