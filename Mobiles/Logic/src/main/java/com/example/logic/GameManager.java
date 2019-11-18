package com.example.logic;

public class GameManager {
    private static GameManager _instance;

    private int[] _score;
    private int _backgroundColorIndex;


    private GameManager() {
        _score = new int[] {0, 0, 0};
        _backgroundColorIndex = 0;
    }

    public static GameManager getInstance() {
        if(_instance == null)
            _instance = new GameManager();
        return _instance;
    }

    public int[] getScore() {
        return _score;
    }

    public int getBackgroundColorIndex() {
        return _backgroundColorIndex;
    }
}
