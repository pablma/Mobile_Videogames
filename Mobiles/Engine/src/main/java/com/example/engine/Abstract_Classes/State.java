package com.example.engine.Abstract_Classes;

import com.example.engine.Interfaces.Game;

public abstract class State {

    protected final Game _game;

    public State(Game game){
        this._game = game;
    }

    public abstract void update(float deltaTime);
    public abstract void present(float deltaTime);

    public abstract void pause();
    public abstract void resume();

    public abstract void dispose();
}
