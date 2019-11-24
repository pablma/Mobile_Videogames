package com.example.pcengine.PC_Game;

import javax.swing.JFrame;

public class PCSurfaceView extends JFrame {

    /**
     * CLASE PC_SURFACE_VIEW
     * Implementa el bucle principal de juego
     */

    private Game _game;
    volatile boolean _running = true;
    int frames = 0;

    /**
     * Constructora de la clase
     * @param game referencia a game necesaria para acceder a sus métodos
     * @param windowName nombre de la ventana
     * @param w ancho de la ventana
     * @param h altod de la ventana
     */
    public PCSurfaceView(Game game, String windowName, int w, int h){
        super(windowName);
        _game = game;
        setSize(w, h);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * LLeva el bucle ppal del juego además de hacer el cálculo para el deltaTime que usamos
     */
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
                //System.out.println("" + fps + " fps");
                frames = 0;
                informePrevio = System.nanoTime();
            }
            ++frames;

            do {
                do {
                    _game.getGraphics().setGraphics();

                    _game.saveGraphicsWindowSizeVariables(); // we should update the variables that contains the information of the window size on the AbstractGraphics every frame

                    try {
                        _game.getCurrentState().present();
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
