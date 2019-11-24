package com.example.pcgame;

import com.example.engine.Abstract_Classes.State;
import com.example.logic.States.LoadingState;
import com.example.pcengine.PC_Game.Game;

public class PCMain extends Game {

    /**
     * CLASE PC_MAIN
     * Encargada de lanzar al aplicación para escritorio
     */

    /**
     * Contructora de la clase
     * @param windowName Nombre de la ventana
     * @param w Anchura de la ventana
     * @param h Altura de la ventana
     */
    private PCMain(String windowName, int w, int h){
        super(windowName, w, h );
    }

    /**
     *
     * @return estado de juego que se va a cargar nada más empiece la aplicación
     */
    public State getStartState() {
        return new LoadingState(this);
    }

    /**
     * Crea una instanca de PCMAIN
     * @param args parámetro necesario del main de PC
     */
    public static void main(String[] args){
        PCMain game = new PCMain("Switch Dash", 540, 960);
    }
}
