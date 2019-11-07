package com.example.androidengine;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import com.example.engine.Graphics;
import com.example.engine.Input;
import com.example.engine.Screen;


public class Game extends Activity implements com.example.engine.Game {

    MySurfaceView _renderView;
    com.example.androidengine.Graphics _graphics;
    com.example.androidengine.Input _input;
    Screen _screen;


    public Game(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        boolean isLandScape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        int frameBufferWidth = isLandScape ? 480 : 320;
        int frameBufferHeight = isLandScape ?  320 : 480;

        Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth, frameBufferHeight, Bitmap.Config.RGB_565);

        float scaleX = (float)frameBufferWidth / getWindowManager().getDefaultDisplay().getWidth();
        float scaleY = (float)frameBufferHeight / getWindowManager().getDefaultDisplay().getHeight();

        _renderView = new MySurfaceView(this, frameBuffer);
        _graphics = new com.example.androidengine.Graphics(getAssets(), frameBuffer);
        _input = new com.example.androidengine.Input(_renderView, scaleX, scaleY);
        _screen = getStartScreen();
        setContentView(_renderView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        _screen.resume();
        _renderView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        _renderView.pause();
        _screen.pause();

        if(isFinishing())
            _screen.dispose();
    }


    @Override
    public Graphics getGraphics() {
        return _graphics;
    }

    @Override
    public Input getInput() {
        return _input;
    }

    @Override
    public void setScreen(Screen screen) {
        if(screen == null)
            throw new IllegalArgumentException("Screen must not be null");

        this._screen.pause();
        this._screen.dispose();
        screen.resume();
        screen.update(0);
        this._screen = screen;
    }

    @Override
    public Screen getCurrentScreen() {
        return _screen;
    }

    @Override
    public Screen getStartScreen() {
        return null;
    }
}
