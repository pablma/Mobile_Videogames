package com.example.engine;

public interface Game {

    Graphics getGraphics();
    Input getInput();

    public void setScreen(Screen screen);

    public Screen getCurrentScreen();
    public Screen getSrartScreen();
}
