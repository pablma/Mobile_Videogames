package com.example.pcengine;

import javax.swing.JFrame;

public class DesktopSurfaceView extends JFrame {

    private Game _game;
    volatile boolean _running = false;

    public DesktopSurfaceView(Game game, String windowName, int w, int h){
        super(windowName);
        _game = game;
        setSize(w, h);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void run(){
        long startTime = System.nanoTime();

        // Bucle principal
        while(_running) {
            long currentTime = System.nanoTime();
            long nanoElapsedTime = currentTime - startTime;
            startTime = currentTime;
            float deltaTime = (System.nanoTime() - startTime) / 1000000000.0f;

            _game.getCurrentScreen().update(deltaTime);

            do {
                do {
                    _game.getGraphics().setGraphics();
                    try {
                        _game.getCurrentScreen().present(deltaTime);
                    }
                    finally {
                        _game.getGraphics().dispose();
                    }
                } while(_game.getGraphics().getBufferStrategy().contentsRestored());
                _game.getGraphics().getBufferStrategy().show();
            } while(_game.getGraphics().getBufferStrategy().contentsLost());
        }
    }
}
