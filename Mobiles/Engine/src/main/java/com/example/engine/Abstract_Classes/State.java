package com.example.engine.Abstract_Classes;

import com.example.engine.Interfaces.Game;

public abstract class State {

    /**
     * CLASE ABSTRACTA STATE
     * Clase que define los diferentes estados de juego
     */

    protected final Game _game;

    /**
     * Constructora de la clase
     * @param game juego con toda la información del juego
     */
    public State(Game game){
        this._game = game;
    }

    /**
     * Servirá para hacer la actualización de la lógica del juego
     * @param deltaTime deltaTiem
     */
    public abstract void update(float deltaTime);

    /**
     * Servirá para pintar todos los elementos presentes en el estado de juego
     */
    public abstract void present();

    /**
     * Nos puede proporcionar un funcionalidad de pausa
     */
    public abstract void pause();

    /**
     * Nos puede proporcionar una finalidad de reanudar
     */
    public abstract void resume();

    /**
     * Libera recursos
     */
    public abstract void dispose();
}
