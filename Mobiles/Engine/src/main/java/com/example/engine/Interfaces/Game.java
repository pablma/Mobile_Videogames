package com.example.engine.Interfaces;

import com.example.engine.Abstract_Classes.State;

public interface Game {
    /**
     * INTERFAZ GAME
     * Interfaz encargada de implementar los métodos necesarios para
     * obtener todo lo necesario para el juego, como el input y los graphics
     */

    /**
     * Método encargado de obtener el objeto graphics
     * @return variable tipo graphics con una referencia al objeto graphics que se encarga del renderizado de imágenes
     */
    Graphics getGraphics();

    /**
     * Método encargado de obtener el objeto input
     * @return variable tipo input con una referencia al objeto input que se encarga del procesado del input del player
     */
    Input getInput();

    /**
     * Cambia el estado de juego por uno nuevo proporcionado
     * @param state nuevo estadod e juego al que se quiere cambiar
     */
    public void setState(State state);

    /**
     * Devuelve el estado actual
     * @return estado actuald el juego
     */
    public State getCurrentState();

    /**
     * Devuelve el primer estado del juego
     * @return primer estado con el que se inicia el juego
     */
    public State getStartState();
}
