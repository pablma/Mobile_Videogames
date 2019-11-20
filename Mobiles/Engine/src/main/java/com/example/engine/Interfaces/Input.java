package com.example.engine.Interfaces;


import java.util.List;

public interface Input {

    /**
     * INTERFAZ INPUT
     * Aporta las funcionalidades básicas para recoger el input del player
     */

    /**
     * Enum para definir un nuevo tipo y ordenar los eventos que vamos a recibir
     */
    public enum EventType{
        TOUCH_DOWN,
        TOUCH_UP,
        TOUCH_DRAGGED
    }

    /**
     * Clase que almacena la información de un evento
     */
    public static class TouchEvent {

        public EventType _type;
        public int _x, _y;
        public int _id;
    }


    /**
     * Nos informa de si se ha pulsado la pantalla
     * @param pointer identificador del dedo que pulsa la pantalla
     * @return true s se ha pulsado, false en caso contrario
     */
    public boolean isTouchDown(int pointer);

    /**
     * Saca la posición X dónde se ha detectado el input
     * @param pointer identificador del dedo que pulsa la pantalla
     * @return entero con la posición X del input
     */
    public int getTouchX(int pointer);

    /**
     * Saca la posición Y dónde se ha detectado el input
     * @param pointer identificador del dedo que pulsa la pantalla
     * @return entero con la posición Y del input
     */
    public int getTouchY(int pointer);

    /**
     * Devuelve una lista con todos los touchEvent registrados
     * @return la lista de touchEvents
     */
    public List<TouchEvent> getTouchEvents();
}
