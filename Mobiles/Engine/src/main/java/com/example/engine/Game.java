package com.example.engine;

public interface Game {

    Graphics getGraphics();
    Input getInput();

    public void setScreen(State state);

    public State getCurrentState();
    public State getStartState();
}
