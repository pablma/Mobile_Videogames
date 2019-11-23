package com.example.pcengine;


import com.example.engine.Interfaces.Input;
import com.example.engine.Abstract_Classes.State;

public class Game implements com.example.engine.Interfaces.Game {

    /**
     * CLASE GAME
     * Inicializa el bucle ppal del juego y tiene acceso a otras clases necesarias como graphics e input
     */

    PCSurfaceView _renderView;
    com.example.pcengine.Graphics _graphics;
    com.example.pcengine.Input _input;
    State _state;

    /**
     * Constructora de la clase
     * @param windowName nombre de la ventana
     * @param w ancho de la ventana
     * @param h alto de la ventana
     */
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

    /**
     * Devuelve una referencia a graphics
     * @return variable de tipo graphics de PCEngine
     */
    @Override
    public com.example.pcengine.Graphics getGraphics() {
        return _graphics;
    }

    /**
     * Devuelve una referencia a input
     * @return variable de tipo input de PCEngine
     */
    @Override
    public Input getInput() {
        return _input;
    }

    /**
     * Cambia el estado actual del juego por uno nuevo
     * @param state nuevo estado de juego al que se quiere cambiar
     */
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

    /**
     * Devuelve el estado actual del juego
     * @return estado actual del juego
     */
    @Override
    public State getCurrentState() {
        return _state;
    }

    /**
     * Devuelve el primer estado del juego
     * @return null porque será redefinido en el main
     */
    @Override
    public State getStartState() {
        return null;
    }

    /**
     * Guarda los tamaños de la ventana del graphics
     */
    public void saveGraphicsWindowSizeVariables(){
        _graphics.getScreenSizes(_graphics.getWidth(), _graphics.getHeight()); // Method that allow us to update the variables that have the information of the window Size on the abstract class Graphics
        _input.saveScreenSizes(_graphics.getWidth(), _graphics.getHeight());
    }
}
