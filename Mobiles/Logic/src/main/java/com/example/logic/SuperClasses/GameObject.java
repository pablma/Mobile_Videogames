package com.example.logic.SuperClasses;

public class GameObject {

    /**
     * CLASE GAMEOBJECT
     * Clase que contiene los métodos y atributos básicos para cualquier gamobject
     */
    protected   float _iniPosX, _iniPosY;
    protected float _posX, _posY;

    /**
     * Constructora de la clase
     * @param iniPosX posición inicial x del objeto
     * @param iniPosY posición inicial y del objeto
     */
    public GameObject(float iniPosX, float iniPosY){
        _iniPosX = iniPosX;
        _iniPosY = iniPosY;
        _posX = _iniPosX;
        _posY = _iniPosY;
    }

    /**
     * Método update que actualizará la lógica de todos los objetos del juego
     * @param deltaTime deltaTime del juego
     */
    public void update(float deltaTime){}

    /**
     * Método que pintará cada gameobject en pantalla
     */
    public void present(){}

    /**
     * Método que prorporciona la funcionalidad de pausa
     */
    public void pause(){}

    /**
     * Método que aporta la funcionalidad de reanudar
     */
    public void resume(){}

    /**
     * Método que libera recursos
     */
    public void dispose(){}

    /**
     * Devuelve la posición X del gameObject
     * @return float con la posición X del GameObject
     */
    public float getPosX() { return _posX;}

    /**
     * Devuelve la posición Y del gameObject
     * @return float con la posición Y del GameObject
     */
    public float getPosY() { return _posY;}

    /**
     * Pone el gameObject en una determinada posición X
     * @param value posición X en la que se quiere colocar el objeto
     */
    public void setPosX(float value) { _posX = value;}

    /**
     * Pone el gameObject en una determinada posición Y
     * @param value posición Y en la que se quiere colocar el objeto
     */
    public void setPosY(float value) { _posY = value;}
}
