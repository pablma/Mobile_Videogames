package com.example.pcengine;


import com.example.engine.Abstract_Classes.AbstractInput;

import java.util.List;

import javax.swing.JFrame;

public class Input extends AbstractInput {

    /**
     * CLASE INPUT
     * Clase que usamos para definir los metodos del AbstractInput y así poder hacer el reescalado con las
     * posiciones que pulsa el jugador
     */

    private PCMouseHandler _PCMouseHandler;

    public Input(JFrame window){
        _PCMouseHandler = new PCMouseHandler(window);
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
        return _PCMouseHandler.getTouchX();
    }

    /**
     * Devuelve la pòsición Y del input recibido
     * @param pointer identificador del dedo que ha pulsado
     * @return int con la posición Y del input
     */
    @Override
    protected int getTouchYPrivate(int pointer) {
        return _PCMouseHandler.getTouchY();
    }

    /**
     * Devuelve una lista con todos los TouchEvents registrados hasta el momento
     * @return una lista de TouchEvents con todos los eventos registrados hasta el momento
     */
    @Override
    protected List<TouchEvent> getTouchEventsPrivate() {
        return _PCMouseHandler.getTouchEvents();
    }

}
