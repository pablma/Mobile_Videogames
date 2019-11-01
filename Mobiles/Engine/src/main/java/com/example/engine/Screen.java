package com.example.engine;

public abstract class Screen {

    protected final Game _game;

    public Screen(Game game){
        this._game = game;
    }

    public abstract void update(float deltaTime);
    public abstract void present(float deltaTime);

    public abstract void pause();
    public abstract void resume();

    public abstract void dispose();
}
