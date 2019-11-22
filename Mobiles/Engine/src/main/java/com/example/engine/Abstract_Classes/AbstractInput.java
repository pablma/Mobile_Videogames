package com.example.engine.Abstract_Classes;

import com.example.engine.Interfaces.Game;
import com.example.engine.Interfaces.Input;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractInput implements Input {

    /**
     * CLASE ABSTRACTA INPUT
     * Esta clase nos permitirá reescalar las posiciones del input del jugador para
     * saber si ha pulsado alguno de los botones
     */

    Game _game;
    private int _windowWidth, _windowHeight;

    int logicX;
    int logicY;

    /**
     * Constructora de la clase
     */
    public AbstractInput(){}

    /**
     * Método que asigna un game, apra poder acceder más adelante a alguno de sus atributos
     * @param game que será necesario a posteriori
     * para poder acceder a las opciones del graphics y por tanto poder "reescalar" la entrada
     */
    @Override
    public void init(Game game) {
        game = _game;
    }

    /**
     * Método que informa de si se ha pulsado la pantalla
     * @param pointer identificador del dedo que pulsa la pantalla
     * @return true si se ha pulsado la pantalla
     */
    @Override
    public boolean isTouchDown(int pointer) {
        return isTouchDownPrivate(pointer);
    }

    /**
     * Método que devuelve la posición lógica X del input
     * @param pointer identificador del dedo que pulsa la pantalla
     * @return posición lógica X del input
     */
    @Override
    public int getTouchX(int pointer) {
        return logicX;
    }

    /**
     * Método que devuelve la posición lógica Y del input
     * @param pointer identificador del dedo que pulsa la pantalla
     * @return posición lógica Y del input
     */
    @Override
    public int getTouchY(int pointer) {
        return logicY;
    }

    /**
     * Método que devuelve la lista con todos los eventos registrados hasta el momento
     * @return lista de touchEvents con los eventos registrados hasta el momento
     */
    @Override
    public List<TouchEvent> getTouchEvents() {

        float scale;


        int physicWindowWidth;
        int physicWindowHeight;
        int top = 0;
        int left = 0;

        int eventY = 0;
        int eventX = 0;

        float logicAspectRatio = 1920.0f / 1080.0f;

        float physicAspectRatio = (float)_windowHeight/(float)_windowWidth;

        if( physicAspectRatio > logicAspectRatio ){ //vertical

            physicWindowHeight = (int)((float)_windowWidth * logicAspectRatio);
            top = _windowHeight / 2 - physicWindowHeight / 2;

            scale = (float)physicWindowHeight / 1920.0f;
        }
        else {//horizontal
            physicWindowWidth = (int)((float)_windowHeight / logicAspectRatio);
            left = _windowWidth / 2 - physicWindowWidth / 2;

            scale = (float)physicWindowWidth / 1080.0f;
        }


        List<TouchEvent> resizedTouchEvents =  new ArrayList<TouchEvent>();

        List<Input.TouchEvent> touchEvents = getTouchEventsPrivate();
        for (int i = 0; i < touchEvents.size(); i++) {
            Input.TouchEvent event = touchEvents.get(i);



            int repositionatedPhysicX = event._x - left;
            int repositionatedPhysicY = event._y - top;


            logicX = (int)( repositionatedPhysicX / scale);
            logicY = (int)(repositionatedPhysicY / scale);

            event._x = logicX;
            event._y = logicY;
            resizedTouchEvents.add(event);
        }

        return touchEvents;
    }

    /**
     * Guarda los nuevos tamaños de la ventana
     * @param w nuevo ancho
     * @param h nuevo alto
     */
    @Override
    public void saveScreenSizes(int w, int h) {
        _windowWidth = w;
        _windowHeight = h;
    }

    /**
     * Método que actuará con las posiciones ya reescaladas del input
     * @param pointer identificador del dedo que pulsa la pantalla
     * @return true si se ha pulsado la pantalla
     */
    protected abstract boolean isTouchDownPrivate(int pointer);

    /**
     * Método que devuelve la posición física X del input
     * @param pointer identificador del dedo que pulsa la pantalla
     * @return posición lógica X del input
     */
    protected abstract int getTouchXPrivate(int pointer);

    /**
     * Método que devuelve la posición lógica Y del input
     * @param pointer
     * @return posición lógica Y del input
     */
    protected abstract int getTouchYPrivate(int pointer);

    /**
     * Método que devuelve la lista con todos los eventos registrados reeescalados hasta el momento
     * @return lista de touchEvents con los eventos registrados hasta el momento
     */
    protected abstract List<TouchEvent> getTouchEventsPrivate();
}
