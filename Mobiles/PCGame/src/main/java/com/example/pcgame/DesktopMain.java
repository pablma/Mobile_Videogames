package com.example.pcgame;

import com.example.engine.Screen;
import com.example.logic.GameScreen;
import com.example.pcengine.Game;

public class DesktopMain extends Game {

    private DesktopMain(String windowName, int w, int h){
        super(windowName, w, h );
    }

    public Screen getStartScreen() {
        return new GameScreen(this);
    }

    public static void main(String[] args){
        DesktopMain game = new DesktopMain("Switch Dash", 780, 420);
    }
}
