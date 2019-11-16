package com.example.engine;

import java.awt.Point;

public interface Game {

    Graphics getGraphics();
    Input getInput();

    public void setScreen(State state);

    public int getScreenWidth();
    public int getScreenHeight();


    public State getCurrentState();
    public State getStartState();
}
