package com.example.androidengine.Android_Game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class AndroidSurfaceView extends SurfaceView implements Runnable {

    /**
     * CLASE MY_SURFACE_VIEW
     * Implementa el bucle principal de juego
     */

    Game _game;
    Bitmap _frameBuffer;

    Thread _renderThread = null;
    SurfaceHolder _holder;
    volatile boolean _running = false;
    int frames = 0;

    /**
     * Constructora de la clase
     * @param game referencia a game necesaria para acceder a sus métodos
     * @param frameBuffer frameBuffer que usaremos para el renderizado
     */
    public AndroidSurfaceView(Game game, Bitmap frameBuffer) { // context es una avtivity de android , game es una actividad de android
        super(game);
        this._game = game;
        this._frameBuffer = frameBuffer;
        _holder = getHolder();
    }

    /**
     * Reanuda la ejecución de la aplicación
     */
    public void resume() {
        if (!_running) {
            _running = true;
            _renderThread = new Thread(this);
            _renderThread.start();
        }
    } //  como en la prueba de concepto

    /**
     * LLeva el bucle ppal del juego además de hacer el cálculo para el deltaTime que usamos
     */
    public void run(){
        Rect dstRect = new Rect();
        long startTime = System.nanoTime();
        long informePrevio = startTime;

        while (_running){
            if(!_holder.getSurface().isValid())
                continue;

            float deltaTime = (System.nanoTime() - startTime) / 1000000000.0f;
            startTime = System.nanoTime();

            _game.getCurrentState().update(deltaTime);


            // Informe de FPS
            if (System.nanoTime() - informePrevio > 1000000000l) {
                long fps = frames * 1000000000l / (System.nanoTime() - informePrevio);
                //System.out.println("" + fps + " fps");
                frames = 0;
                informePrevio = System.nanoTime();
            }
            ++frames;

            _game.getCurrentState().present();

            Canvas canvas = _holder.lockCanvas();
            canvas.getClipBounds(dstRect);
            canvas.drawBitmap(_frameBuffer, null, dstRect, null);

            _holder.unlockCanvasAndPost(canvas);
        }
    }

    /**
     * Pausa la ejecución de la aplicación
     */
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
