package com.example.androidengine.Android_Input;

import android.view.View;

import com.example.engine.Interfaces.Input;

import java.util.List;


public interface TouchHandler extends View.OnTouchListener {

    /**
     * INTERFAZ TOUCH_HANDLER
     * Interfaz que hereda de onTouchListener y nos permite tener las funcinalidades básicas para llevar
     * el input del player en móvil
     */

    /**
     * Informa de si la pantalla ha sido pulsada
     * @param pointer identificador del dedo que ha pulsado
     * @return true si se ha pulsado la pantalla
     */
    public boolean isTouchDown(int pointer);

    /**
     * Devuelve la pòsición X del input recibido
     * @param pointer identificador del dedo que ha pulsado
     * @return int con la posición X del input
     */
    public int getTouchX(int pointer);

    /**
     * Devuelve la pòsición Y del input recibido
     * @param pointer identificador del dedo que ha pulsado
     * @return int con la posición Y del input
     */
    public int getTouchY(int pointer);

    /**
     * Devuelve una lista con todos los TouchEvents registrados hasta el momento
     * @return una lista de TouchEvents con todos los eventos registrados hasta el momento
     */
    public List<Input.TouchEvent> getTouchEvents();
}
