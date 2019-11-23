package com.example.androidengine;


import android.view.View;

import com.example.engine.Abstract_Classes.AbstractInput;

import java.util.List;

public class Input extends AbstractInput {

    /**
     * CLASE INPUT
     * Clase que usamos para definir los mñetodos del AbstractInput y así poder hacer el reescalado con las
     * posiciones que pulsa el jugador
     */

    TouchHandler _touchHandler;

    /**
     * Constructora de la clase
     * @param view para poder registrarnos como oyentes y recibir input
     * @param scaleX se usarán para diferentes tamaños de pantalla
     * @param scaleY se usarán para diferentes tamaños de pantalla
     */
    public Input(View view, float scaleX, float scaleY){
        _touchHandler = new MultiTouchHandler(view, scaleX, scaleY);
    }

    /**
     * Informa de si se ha pulsado en la pantalla
     * @param pointer identificador del dedo que pulsa la pantalla
     * @return true si se ha registrafo una pulsación
     */
    @Override
    protected boolean isTouchDownPrivate(int pointer) {
        return false;
    }

    /**
     * Devuelve la pòsición X del input recibido
     * @param pointer identificador del dedo que ha pulsado
     * @return int con la posición X del input
     */
    @Override
    protected int getTouchXPrivate(int pointer) {
        return _touchHandler.getTouchX(pointer);
    }

    /**
     * Devuelve la pòsición Y del input recibido
     * @param pointer identificador del dedo que ha pulsado
     * @return int con la posición Y del input
     */
    @Override
    protected int getTouchYPrivate(int pointer) {
        return _touchHandler.getTouchY(pointer);
    }

    /**
     * Devuelve una lista con todos los TouchEvents registrados hasta el momento
     * @return una lista de TouchEvents con todos los eventos registrados hasta el momento
     */
    @Override
    protected List<com.example.engine.Interfaces.Input.TouchEvent> getTouchEventsPrivate() {
        return _touchHandler.getTouchEvents();
    }
}
