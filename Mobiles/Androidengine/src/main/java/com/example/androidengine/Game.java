package com.example.androidengine;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.engine.Abstract_Classes.State;


public class Game extends Activity implements com.example.engine.Interfaces.Game {

    /**
     * CLASE GAME
     * Inicializa el bucle ppal del juego y tiene acceso a otras clases necesarias como graphics e input
     */

    MySurfaceView _renderView;
    com.example.androidengine.Graphics _graphics;
    com.example.androidengine.Input _input;
    State _state;

    /**
     * Constructora de la clase
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        boolean isLandScape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        int frameBufferWidth = isLandScape ? 1920 : 1080;
        int frameBufferHeight = isLandScape ?  1080 : 1920;

        Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth, frameBufferHeight, Bitmap.Config.RGB_565);

        float scaleX = (float)frameBufferWidth / getWindowManager().getDefaultDisplay().getWidth();
        float scaleY = (float)frameBufferHeight / getWindowManager().getDefaultDisplay().getHeight();

        _renderView = new MySurfaceView(this, frameBuffer);
        _graphics = new com.example.androidengine.Graphics(getAssets(), frameBuffer);
        _input = new com.example.androidengine.Input(_renderView, scaleX, scaleY);
        _state = getStartState();

        setContentView(_renderView);

        _input.init(this);
    }

    /**
     * Se encarga de llamar a los métodos necesarios cuando el juego se reanuda
     * se guardan los screenSizes por si hay que reescalar
     */
    @Override
    protected void onResume() {
        super.onResume();

        _graphics.getScreenSizes(_graphics.getWidth(), _graphics.getHeight());
        _input.saveScreenSizes(_graphics.getWidth(), _graphics.getHeight());

        _state.resume();
        _renderView.resume();

    }

    /**
     * Se encarga de llamar a los métodos necesarios cuando el juego pudiese ser pausado
     */
    @Override
    protected void onPause() {
        super.onPause();
        _renderView.pause();
        _state.pause();

        if(isFinishing())
            _state.dispose();
    }

    /**
     * Devuelve una referencia a graphics
     * @return variable de tipo graphics de AndroidEngine
     */
    @Override
    public Graphics getGraphics() {
        return _graphics;
    }

    /**
     * Devuelve una referencia a input
     * @return variable de tipo input de AndroidEngine
     */
    @Override
    public Input getInput() {
        return _input;
    } // Puede dar porblemas no devolver el deAndorid engine, ahora devolvemos la interfaz

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

}
