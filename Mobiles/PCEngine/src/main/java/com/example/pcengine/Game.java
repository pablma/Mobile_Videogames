package com.example.pcengine;


import com.example.engine.Input;
import com.example.engine.Screen;

public class Game implements com.example.engine.Game {

    DesktopSurfaceView _renderView;
    com.example.pcengine.Graphics _graphics;
    com.example.pcengine.Input _input;
    Screen _screen;

    public Game(String windowName, int w, int h){

        _renderView = new DesktopSurfaceView(this, windowName, w, h);

        _renderView.setIgnoreRepaint(true);
        _renderView.setVisible(true);

        _graphics = new com.example.pcengine.Graphics(_renderView);
        _input = new com.example.pcengine.Input(_renderView);
        _screen = getStartScreen();

        _renderView.run();
    }

    @Override
    public com.example.pcengine.Graphics getGraphics() {
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
