package com.example.pcgame;

import com.example.engine.Abstract_Classes.State;
import com.example.logic.States.LoadingState;
import com.example.pcengine.Game;

public class PCMain extends Game {

    private PCMain(String windowName, int w, int h){
        super(windowName, w, h );
    }

    public State getStartState() {
        return new LoadingState(this);
    }

    public static void main(String[] args){
        PCMain game = new PCMain("Switch Dash", 540, 960);
    }
}
