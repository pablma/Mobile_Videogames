package com.example.engine.Interfaces;

import com.example.engine.Abstract_Classes.State;

public interface Game {
    /**
     *
     *
     * @return
     */

    Graphics getGraphics();
    Input getInput();

    public void setState(State state);

    public State getCurrentState();
    public State getStartState();
}
