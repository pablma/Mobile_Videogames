package com.example.androidengine;
import android.graphics.Bitmap;

public class Image implements com.example.engine.Image {
    Bitmap bitmap_;

    public Image(Bitmap bitmap){
        this.bitmap_ = bitmap;
    }

    @Override
    public int getWidth() {
        return bitmap_.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap_.getHeight();
    }

    @Override
    public void dispose() {
        bitmap_.recycle();
    }
}
