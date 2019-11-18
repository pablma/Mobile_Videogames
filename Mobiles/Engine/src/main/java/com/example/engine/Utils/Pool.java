package com.example.engine.Utils;

import java.util.ArrayList;
import java.util.List;

public class Pool<T> {

    public interface PoolObjectFactory<T> {
        public T createObject();
    }

    private final List<T> _freeObjects;
    private final PoolObjectFactory<T> _factory;
    private final int _maxSize;

    public Pool(PoolObjectFactory<T> factory, int maxSize){
        this._factory = factory;
        this._maxSize = maxSize;
        this._freeObjects = new ArrayList<T>(_maxSize);
    }


    public T newObject(){
        T object = null;

        if(_freeObjects.isEmpty())
            object = _factory.createObject();
        else
            object = _freeObjects.remove(_freeObjects.size() - 1);

        return object;
    }


    public void free(T object) {
        if(_freeObjects.size() < _maxSize)
            _freeObjects.add(object);
    }

}
