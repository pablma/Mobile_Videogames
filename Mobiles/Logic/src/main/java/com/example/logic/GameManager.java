package com.example.logic;

public class GameManager {
    private static GameManager _instance;

    private int[] _score;
    private int _pointsToIncreaseVel = 10;

    private int _backgroundColorIndex;
    private float _incVelY = 200f;

    private float _arrowsGameOverVel = 0;

    private GameManager() {
        _score = new int[] {0, 0, 0, 0};
        _backgroundColorIndex = 0;
    }

    public static GameManager getInstance() {
        if(_instance == null)
            _instance = new GameManager();
        return _instance;
    }

    public void saveScore(int[] score) {
        _score = score;
    }

    public int[] getScore(){ return _score; }

    public void saveBackgroundColorIndex(int backgroundColorIndex) {
        _backgroundColorIndex = backgroundColorIndex;
    }

    public int getBackgroundColorIndex(){
        return _backgroundColorIndex;
    }

    public float getIncVelY() {
        return _incVelY;
    }

    public int getPointsToIncreaseVel() {
        return _pointsToIncreaseVel;
    }

    public void saveArrowsGameOverVel(float vel){
        _arrowsGameOverVel = vel;
    }
    public float getArrowsGameOverVel(){
        return  _arrowsGameOverVel;
    }

}
