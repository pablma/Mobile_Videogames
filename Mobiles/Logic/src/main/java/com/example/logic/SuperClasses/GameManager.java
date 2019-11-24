package com.example.logic.SuperClasses;

public class GameManager {

    /**
     * CLASE GAMEMANAGER
     * Encargada de llevar todo lo relativo con las puntuaciones asi como cada cuantos puntos
     * aumenta la velocidad del juego y en qué proporción lo hace
     */

    private static GameManager _instance;

    private int[] _score;
    private int _pointsToIncreaseVel = 10;

    private int _backgroundColorIndex;
    private float _incVelY = 200f;

    private float _arrowsGameOverVel = 0;

    /**
     * Constructora de la clase
     */
    private GameManager() {
        _score = new int[] {0, 0, 0, 0};
        _backgroundColorIndex = 0;
    }

    /**
     * Devuelve la instancia de la clase, ya que e sun singletone
     * @return instancia de GameManager
     */
    public static GameManager getInstance() {
        if(_instance == null)
            _instance = new GameManager();
        return _instance;
    }

    /**
     * Guarda una puntación determinada
     * @param score putuación que se quiere salvar
     */
    public void saveScore(int[] score) {
        _score = score;
    }

    /**
     * Devuelve la puntuación
     * @return array con la puntuación
     */
    public int[] getScore(){ return _score; }

    /**
     * Guarda un color de fondo determinado
     * @param backgroundColorIndex color de fondo a guardar
     */
    public void saveBackgroundColorIndex(int backgroundColorIndex) {
        _backgroundColorIndex = backgroundColorIndex;
    }

    /**
     * Devuelve el identificador del color de fondo guardado
     * @return int con el identificador del color de fondo guardado
     */
    public int getBackgroundColorIndex(){
        return _backgroundColorIndex;
    }

    /**
     * Devuelve el incremento de velocidad que el juego tiene que aplicar
     * @return incrementod e velocidad en el eje Y
     */
    public float getIncVelY() {
        return _incVelY;
    }

    /**
     * Devuelve el número de puntos tras los que se tiene que aplicar el incremento de velocidad
     * @return cantidad de puntos que requieren un incremento de velocidad
     */
    public int getPointsToIncreaseVel() {
        return _pointsToIncreaseVel;
    }

    /**
     * guarda la velocidad de las flechas de fondo
     * @param vel velocidad de las flechas de fondo
     */
    public void saveArrowsGameOverVel(float vel){
        _arrowsGameOverVel = vel;
    }

    /**
     * Devuelve la velocidad de las flechas de fondoo
     * @return float con la velocidad de las flechas de fondo
     */
    public float getArrowsGameOverVel(){
        return  _arrowsGameOverVel;
    }

}
