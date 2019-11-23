package com.example.pcengine;

import com.example.engine.Interfaces.Input;
import com.example.engine.Utils.Pool;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class PCMouseHandler implements MouseListener, MouseMotionListener {

    /**
     * CLASE PC_MOUSE_HANDLER
     * Implementa MouseListener y MouseMotionListener que nos permitirán ercibir y registrar
     * los eventos en pc
     */

    boolean _isTouched;

    int _touchX;
    int _touchY;

    Pool<Input.TouchEvent> _touchEventPool;
    List<Input.TouchEvent> _touchEvents = new ArrayList<Input.TouchEvent>();
    List<Input.TouchEvent> _touchEventsBuffer = new ArrayList<Input.TouchEvent>();

    /**
     * Constructora de la clase, crea el pool con los eventos
     * @param window ventana de la aplicación
     */
    public PCMouseHandler(JFrame window) {

        Pool.PoolObjectFactory<Input.TouchEvent> factory = new Pool.PoolObjectFactory<Input.TouchEvent>() {
            @Override
            public Input.TouchEvent createObject() {
                return new Input.TouchEvent();
            }
        };

        _touchEventPool = new Pool<Input.TouchEvent>(factory, 100);
        window.addMouseListener(this);
    }

    /**
     * Realiza la acción conveniente cuando se clicka el ratón
     * @param mouseEvent evento recibido
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        //mouse pressed and release
    }

    /**
     * Realiza la acción conveniente cuando se mantiene pulsado el ratón
     * @param mouseEvent evento recibido
     */
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        synchronized (this){
            Input.TouchEvent touchEvent = _touchEventPool.newObject();

            touchEvent._type = Input.EventType.TOUCH_DOWN;
            touchEvent._id = mouseEvent.getButton();
            touchEvent._x = _touchX = mouseEvent.getX();
            touchEvent._y = _touchY = mouseEvent.getY();

            _isTouched = true;

            _touchEventsBuffer.add(touchEvent);
        }
    }

    /**
     * Realiza la acción conveniente cuando se deja de pulsar el ratón
     * @param mouseEvent evento recibido
     */
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        synchronized (this){
            Input.TouchEvent touchEvent = _touchEventPool.newObject();

            touchEvent._type = Input.EventType.TOUCH_UP;
            touchEvent._id = mouseEvent.getButton();
            touchEvent._x = _touchX = mouseEvent.getX();
            touchEvent._y = _touchY = mouseEvent.getY();

            _isTouched = false;

            _touchEventsBuffer.add(touchEvent);
        }
    }

    /**
     * Realiza la acción conveniente cuando se arrastra el ratón
     * @param mouseEvent evento recibido
     */
    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        synchronized (this){
            Input.TouchEvent touchEvent = _touchEventPool.newObject();

            touchEvent._type = Input.EventType.TOUCH_DRAGGED;
            touchEvent._id = mouseEvent.getButton();
            touchEvent._x = _touchX = mouseEvent.getX();
            touchEvent._y = _touchY = mouseEvent.getY();

            _touchEventsBuffer.add(touchEvent);
        }
    }

    /**
     * Informa de si la pantalla ha sido pulsada
     * @return true si se ha pulsado la pantalla
     */
    public boolean isTouchDown() {
        return _isTouched;
    }

    /**
     * Devuelve la pòsición Y del input recibido
     * @return int con la posición Y del input
     */
    public int getTouchX() {
        return _touchX;
    }

    /**
     * Devuelve la pòsición Y del input recibido
     * @return int con la posición Y del input
     */
    public int getTouchY() {
        return _touchY;
    }

    /**
     * Devuelve una lista con todos los TouchEvents registrados hasta el momento
     * @return una lista de TouchEvents con todos los eventos registrados hasta el momento
     */
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
     * Gestiona si el ratón entra en la ventana
     * @param mouseEvent evento recibido
     */
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    /**
     * Gestiona si el ratón sale de la ventana
     * @param mouseEvent evento recibido
     */
    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    /**
     * Gestiona si el ratón se mueve en la ventana
     * @param mouseEvent evento recibido
     */
    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
