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

    boolean _isTouched;

    int _touchX;
    int _touchY;

    Pool<Input.TouchEvent> _touchEventPool;
    List<Input.TouchEvent> _touchEvents = new ArrayList<Input.TouchEvent>();
    List<Input.TouchEvent> _touchEventsBuffer = new ArrayList<Input.TouchEvent>();


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

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        //pouse pressed and release
    }

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


    public boolean isTouchDown() {
        return _isTouched;
    }


    public int getTouchX() {
        return _touchX;
    }


    public int getTouchY() {
        return _touchY;
    }

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


    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {}


    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
