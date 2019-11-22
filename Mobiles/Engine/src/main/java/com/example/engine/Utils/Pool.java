package com.example.engine.Utils;

import java.util.ArrayList;
import java.util.List;

public class Pool<T> {

    /**
     * INTERFAZ POOL_OBJECT_FACTORY
     * Nos permite crear cualquier tipo de objeto
     * @param <T> cualquier tipo de objeto
     */
    public interface PoolObjectFactory<T> {

        /**
         * Crea un nuevo objeto
         * @return objeto del tipo T
         */
        public T createObject();
    }

    /**
     * CLASE POOL
     * Nos permite reutilizar objetos, en nuestro caso la usaremos para los eventos que recibimos del input
     */
    private final List<T> _freeObjects;
    private final PoolObjectFactory<T> _factory;
    private final int _maxSize;

    /**
     * Contructora de la clase Pool
     * @param factory una nueva PoolObjectFactory de tipo T
     * @param maxSize el tamaño máximo del Pooler
     */
    public Pool(PoolObjectFactory<T> factory, int maxSize){
        this._factory = factory;
        this._maxSize = maxSize;
        this._freeObjects = new ArrayList<T>(_maxSize);
    }


    /**
     * Crea un nuevo objeto
     * @return nuevo objeto de tipo T
     */
    public T newObject(){
        T object = null;

        if(_freeObjects.isEmpty())
            object = _factory.createObject();
        else
            object = _freeObjects.remove(_freeObjects.size() - 1);

        return object;
    }


    /**
     * Llena el array de objetos
     * @param object objeto de tipo T a introducir en el pooler
     */
    public void free(T object) {
        if(_freeObjects.size() < _maxSize)
            _freeObjects.add(object);
    }

}
