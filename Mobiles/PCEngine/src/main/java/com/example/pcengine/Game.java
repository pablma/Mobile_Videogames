package com.example.pcengine;


import com.example.engine.Interfaces.Input;
import com.example.engine.Abstract_Classes.State;

public class Game implements com.example.engine.Interfaces.Game {

    PCSurfaceView _renderView;
    com.example.pcengine.Graphics _graphics;
    com.example.pcengine.Input _input;
    State _state;

    public Game(String windowName, int w, int h){

        _renderView = new PCSurfaceView(this, windowName, w, h);

        _renderView.setIgnoreRepaint(true);
        _renderView.setVisible(true);

        _graphics = new com.example.pcengine.Graphics(_renderView);
        _input = new com.example.pcengine.Input(_renderView);
        _state = getStartState();

        _renderView.run();

        _input.init(this);
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
    public void setState(State state) {

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

    public void saveGraphicsWindowSizeVariables(){
        _graphics.getScreenSizes(_graphics.getWidth(), _graphics.getHeight()); // Method that allow us to update the variables that have the information of the window Size on the abstract class Graphics
        _input.saveScreenSizes(_graphics.getWidth(), _graphics.getHeight());
    }
}
