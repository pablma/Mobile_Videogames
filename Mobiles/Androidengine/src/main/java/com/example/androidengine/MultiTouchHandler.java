package com.example.androidengine;

import android.view.MotionEvent;
import android.view.View;

import com.example.engine.Interfaces.Input;
import com.example.engine.Utils.Pool;

import java.util.ArrayList;
import java.util.List;

public class MultiTouchHandler implements TouchHandler {

    /**
     * CLASE MULTI_TOUCH_HANDLER
     * Permite registrar varios eventos de input a la vez
     */

    private static final int MAX_TOUCHPOINTS = 10;

    boolean [] _isTouched = new boolean[MAX_TOUCHPOINTS];

    int [] _touchX = new int[MAX_TOUCHPOINTS];
    int [] _touchY = new int[MAX_TOUCHPOINTS];
    int [] _id = new int[MAX_TOUCHPOINTS];

    Pool<com.example.engine.Interfaces.Input.TouchEvent> _touchEventPool;
    List<com.example.engine.Interfaces.Input.TouchEvent> _touchEvents = new ArrayList<com.example.engine.Interfaces.Input.TouchEvent>();
    List<com.example.engine.Interfaces.Input.TouchEvent> _touchEventsBuffer = new ArrayList<Input.TouchEvent>();

    float _scaleX;
    float _scaleY;

    /**
     * Constructora de la clase, inicializa el pooler con objetos de tipo TouchEvent
     * @param view para poder registrarnos como oyentes y recibir input
     * @param scaleX se usarán para diferentes tamaños de pantalla
     * @param scaleY se usarán para diferentes tamaños de pantalla
     */
    public MultiTouchHandler(View view, float scaleX, float scaleY){
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
     * Registra la pulsación en pantalla y añade un nuevo evento al pooler, con sus respectivos atributos
     * teniendo en cuenta que puede haber varios eventos a la vez
     * @param v viene de la interfaz que hereda de onTouchListener
     * @param event tipo de evento
     * @return true si se ha pulsado la pantalla
     */
    public boolean onTouch(View v, MotionEvent event){
        synchronized (this){
            int action = event.getAction() & MotionEvent.ACTION_MASK;
            int pointerIndex = (event.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >>
                    MotionEvent.ACTION_POINTER_INDEX_SHIFT;
            int pointerCount = event.getPointerCount();

            Input.TouchEvent touchEvent;

            for(int i = 0; i < MAX_TOUCHPOINTS; i++){
                if(i >= pointerCount) {
                    _isTouched[i] = false;
                    _id[i] = -1;
                    continue;
                }

                int pointerId = event.getPointerId(i);

                if(event.getAction() != MotionEvent.ACTION_MOVE && i != pointerIndex){
                    continue;
                }

                switch (action){
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_POINTER_DOWN:
                        touchEvent = _touchEventPool.newObject();
                        touchEvent._type = Input.EventType.TOUCH_DOWN;

                        touchEvent._id = pointerId;

                        touchEvent._x = _touchX[i] = (int) (event.getX(i) * _scaleX);
                        touchEvent._y = _touchY[i] = (int) (event.getY(i) * _scaleY);

                        _isTouched[i] = true;
                        _id[i] = pointerId;
                        _touchEventsBuffer.add(touchEvent);
                        break;

                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_POINTER_UP:
                    case MotionEvent.ACTION_CANCEL:
                        touchEvent = _touchEventPool.newObject();
                        touchEvent._type = Input.EventType.TOUCH_UP;

                        touchEvent._id = pointerId;

                        touchEvent._x = _touchX[i] = (int) (event.getX(i) * _scaleX);
                        touchEvent._y = _touchY[i] = (int) (event.getY(i) * _scaleY);

                        _isTouched[i] = false;
                        _id[i] = -1;
                        _touchEventsBuffer.add(touchEvent);
                        break;

                    case MotionEvent.ACTION_MOVE:
                        touchEvent = _touchEventPool.newObject();
                        touchEvent._type = Input.EventType.TOUCH_DRAGGED;

                        touchEvent._id = pointerId;

                        touchEvent._x = _touchX[i] = (int) (event.getX(i) * _scaleX);
                        touchEvent._y = _touchY[i] = (int) (event.getY(i) * _scaleY);

                        _isTouched[i] = true;
                        _id[i] = pointerId;
                        _touchEventsBuffer.add(touchEvent);
                        break;
                }
            }
            return true;
        }
    }

    /**
     * Nos informa de si se ha pulsado la pantalla
     * @param pointer identificador del dedo que realiza el input
     * @return true si se ha pulsado la pantalla
     */
    @Override
    public boolean isTouchDown(int pointer) {
        synchronized (this) {
            int index = getIndex(pointer);
            if(index < 0 || index >= MAX_TOUCHPOINTS)
                return false;
            else
                return _isTouched[index];
        }
    }

    /**
     * Devuelve la pòsición x del input recibido
     * @param pointer identificador del dedo que ha pulsado
     * @return int con la posición x del input
     */
    @Override
    public int getTouchX(int pointer) {
        synchronized (this) {
            int index = getIndex(pointer);
            if(index < 0 || index >= MAX_TOUCHPOINTS)
                return 0;
            else
                return _touchX[index];
        }
    }

    /**
     * Devuelve la pòsición Y del input recibido
     * @param pointer identificador del dedo que ha pulsado
     * @return int con la posición Y del input
     */
    @Override
    public int getTouchY(int pointer) {
        synchronized (this) {
            int index = getIndex(pointer);
            if(index < 0 || index >= MAX_TOUCHPOINTS)
                return 0;
            else
                return _touchY[index];
        }
    }

    /**
     * Devuelve una lista con todos los TouchEvents registrados hasta el momento
     * Va copiando los eventos al pool y limpiando el buffer
     * @return una lista de TouchEvents con todos los eventos registrados hasta el momento
     */
    @Override
    public List<Input.TouchEvent> getTouchEvents() {
        synchronized (this) {
            int len = _touchEvents.size();

            for(int i = 0; i < len; i++)
                _touchEventPool.free(_touchEvents.get(i));

            _touchEvents.clear();
            _touchEvents.addAll(_touchEventsBuffer);
            _touchEventsBuffer.clear();

            return _touchEvents;
        }
    }

    /**
     * Busca el index de un evento
     * @param pointerId id
     * @return entero con el index
     */
    private int getIndex(int pointerId) {
        for(int i = 0; i < MAX_TOUCHPOINTS; i++){
            if(_id[i] == pointerId){
                return i;
            }
        }

        return -1;
    }

}

