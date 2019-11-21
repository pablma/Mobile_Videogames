package com.example.pcengine;

import javax.swing.JFrame;

public class PCSurfaceView extends JFrame {

    private Game _game;
    volatile boolean _running = true;
    int frames = 0;

    public PCSurfaceView(Game game, String windowName, int w, int h){
        super(windowName);
        _game = game;
        setSize(w, h);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void run(){
        long startTime = System.nanoTime();
        long informePrevio = startTime;

        // Bucle principal
        while(_running) {
            long currentTime = System.nanoTime();
            long nanoElapsedTime = currentTime - startTime;
            startTime = currentTime;

            float deltaTime = nanoElapsedTime / 1000000000.0f;


            _game.getCurrentState().update(deltaTime);
            // Informe de FPS
            if (System.nanoTime() - informePrevio > 1000000000l) {
                long fps = frames * 1000000000l / (System.nanoTime() - informePrevio);
                System.out.println("" + fps + " fps");
                frames = 0;
                informePrevio = System.nanoTime();
            }
            ++frames;

            do {
                do {
                    _game.getGraphics().setGraphics();

                    _game.saveGraphicsWindowSizeVariables(); // we should update the variables that contains the information of the window size on the AbstractGraphics every frame

                    try {
                        _game.getCurrentState().present(deltaTime);
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
