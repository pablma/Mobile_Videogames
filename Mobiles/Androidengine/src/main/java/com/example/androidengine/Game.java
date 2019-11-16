package com.example.androidengine;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import com.example.engine.State;


public class Game extends Activity implements com.example.engine.Game {

    MySurfaceView _renderView;
    com.example.androidengine.Graphics _graphics;
    com.example.androidengine.Input _input;
    State _state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        boolean isLandScape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        int frameBufferWidth = isLandScape ? 1920 : 1080;
        int frameBufferHeight = isLandScape ?  1080 : 1920;

        Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth, frameBufferHeight, Bitmap.Config.RGB_565);

        float scaleX = (float)frameBufferWidth / getWindowManager().getDefaultDisplay().getWidth();
        float scaleY = (float)frameBufferHeight / getWindowManager().getDefaultDisplay().getHeight();

        _renderView = new MySurfaceView(this, frameBuffer);
        _graphics = new com.example.androidengine.Graphics(getAssets(), frameBuffer);
        _input = new com.example.androidengine.Input(_renderView, scaleX, scaleY);
        _state = getStartState();

        setContentView(_renderView);

    }

    @Override
    protected void onResume() {
        super.onResume();

        _graphics.getScreenSizes(_graphics.getHeight(), _graphics.getHeight());

        _state.resume();
        _renderView.resume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        _renderView.pause();
        _state.pause();

        if(isFinishing())
            _state.dispose();
    }


    @Override
    public Graphics getGraphics() {
        return _graphics;
    }

    @Override
    public Input getInput() {
        return _input;
    } // Puede dar porblemas no devolver el deAndorid engine, ahora devolvemos la interfaz

    @Override
    public void setScreen(State state) {
        if(state == null)
            throw new IllegalArgumentException("State must not be null");

        this._state.pause();
        this._state.dispose();
        state.resume();
        state.update(0);
        this._state = state;
    }

    @Override
    public State getCurrentState() {
        return _state;
    }

    @Override
    public State getStartState() {
        return null;
    }
    
}
