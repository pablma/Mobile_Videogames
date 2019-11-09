package com.example.androidengine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements Runnable {

    Game _game;
    Bitmap _frameBuffer;

    Thread _renderThread = null;
    SurfaceHolder _holder;
    volatile boolean _running = false;

    public MySurfaceView(Game game, Bitmap frameBuffer) { // context es una avtivity de android , game es una actividad de android
        super(game);
        this._game = game;
        this._frameBuffer = frameBuffer;
        _holder = getHolder();
    }

    public void resume() {
        if (!_running) {
            _running = true;
            _renderThread = new Thread(this);
            _renderThread.start();
        }
    } //  como en la prueba de concepto

    public void run(){
        Rect dstRect = new Rect();
        long startTime = System.nanoTime();

        while (_running){
            if(!_holder.getSurface().isValid())
                continue;

            float deltaTime = (System.nanoTime() - startTime) / 1000000000.0f;
            startTime = System.nanoTime();

            _game.getCurrentState().update(deltaTime);
            _game.getCurrentState().present(deltaTime);

            Canvas canvas = _holder.lockCanvas();
            canvas.getClipBounds(dstRect);
            canvas.drawBitmap(_frameBuffer, null, dstRect, null);

            _holder.unlockCanvasAndPost(canvas);
        }
    }

    public void pause() {
        if (_running) {
            _running = false;
            while (true) {
                try {
                    _renderThread.join();
                    _renderThread = null;//PP line, Not on book
                    break;
                } catch (InterruptedException ie) {
                    //retry
                }
            }
        }
    }
}
