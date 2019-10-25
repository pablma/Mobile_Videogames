package com.example.androidengine;
import android.graphics.Bitmap;

public class Image implements com.example.engine.Image {
    Bitmap _bitmap;

    public Image(Bitmap bitmap){
        this._bitmap = bitmap;
    }

    @Override
    public int getWidth() {
        return _bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return _bitmap.getHeight();
    }

    @Override
    public void dispose() {
        _bitmap.recycle();
    }
}
