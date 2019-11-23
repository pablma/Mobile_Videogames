package com.example.androidengine;

import android.view.MotionEvent;
import android.view.View;

import com.example.engine.Interfaces.Input;
import com.example.engine.Utils.Pool;

import java.util.ArrayList;
import java.util.List;

public class SingleTouchHandler implements TouchHandler {

    /**
     * CLASE SINGLE_TOUCH_HANDLER
     * Implementa los métodos de la interfaz TouchHandler para llevar el
     * input que no permite varios eventos a la vez
     */

    boolean _isTouched;

    int _touchX;
    int _touchY;

    Pool<Input.TouchEvent> _touchEventPool;
    List<Input.TouchEvent> _touchEvents = new ArrayList<Input.TouchEvent>();
    List<Input.TouchEvent> _touchEventsBuffer = new ArrayList<Input.TouchEvent>();

    float _scaleX;
    float _scaleY;


    /**
     * Constructora de la clase, inicializa el pooler con objetos de tipo TouchEvent
     * @param view para poder registrarnos como oyentes y recibir input
     * @param scaleX se usarán para diferentes tamaños de pantalla
     * @param scaleY se usarán para diferentes tamaños de pantalla
     */
    public SingleTouchHandler(View view, float scaleX, float scaleY) {

        Pool.PoolObjectFactory<Input.TouchEvent> factory = new Pool.PoolObjectFactory<Input.TouchEvent>() {
            @Override
            public Input.TouchEvent createObject() {
                return new Input.TouchEvent();
            }
        };

        _touchEventPool = new Pool<Input.TouchEvent>(factory, 100);
        view.setOnTouchListener(this);

        this._scaleX = scaleX;
        this._scaleY = scaleY;
    }

    /**
     * Nos informa de si se ha pulsado la pantalla
     * @param id identificador del dedo que realiza el input
     * @return true si se ha pulsado la pantalla
     */
    @Override
    public boolean isTouchDown(int id) {
        synchronized (this){
            if(id == 0)
                return _isTouched;
            else
                return false;
        }
    }

    /**
     * Devuelve la pòsición X del input recibido
     * @param id identificador del dedo que ha pulsado
     * @return int con la posición X del input
     */
    @Override
    public int getTouchX(int id) {
        synchronized (this){
            return _touchX;
        }
    }

    /**
     * Devuelve la pòsición Y del input recibido
     * @param id identificador del dedo que ha pulsado
     * @return int con la posición Y del input
     */
    @Override
    public int getTouchY(int id) {
        synchronized (this){
            return _touchY;
        }
    }

    /**
     * Devuelve una lista con todos los TouchEvents registrados hasta el momento
     * Va copiando los eventos al pool y limpiando el buffer
     * @return una lista de TouchEvents con todos los eventos registrados hasta el momento
     */
    @Override
    public List<Input.TouchEvent> getTouchEvents() {
        synchronized (this){
            int len = _touchEvents.size();

            for(int i = 0; i < len; i++)
                _touchEventPool.free(_touchEvents.get(i));

            _touchEvents.clear();
            _touchEvents.addAll(_touchEventsBuffer);
            _touchEventsBuffer.clear();

            return  _touchEvents;
        }
    }

    /**
     * Registra la pulsación en pantalla y añade un nuevo evento al pooler, con sus respectivos atributos
     * @param v viene de la interfaz que hereda de onTouchListener
     * @param event tipo de evento
     * @return true si se ha pulsado la pantalla
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        synchronized (this){
            Input.TouchEvent touchEvent = _touchEventPool.newObject();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    touchEvent._type = Input.EventType.TOUCH_DOWN;
                    _isTouched = true;
                    break;
                case MotionEvent.ACTION_MOVE:
                    touchEvent._type = Input.EventType.TOUCH_DRAGGED;
                    _isTouched = true;
                    break;
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:
                    touchEvent._type = Input.EventType.TOUCH_UP;
                    _isTouched = false;
                    break;
            }

            touchEvent._id = 0;
            touchEvent._x = _touchX = (int)(event.getX() * _scaleX);
            touchEvent._y = _touchY = (int)(event.getY() * _scaleY);
            _touchEventsBuffer.add(touchEvent);

            return true;
        }
    }
}
