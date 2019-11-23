package com.example.assignement1;


import com.example.androidengine.Game;
import com.example.engine.Abstract_Classes.State;
import com.example.logic.States.LoadingState;

public class MainActivity extends Game {

    /**
     *
     * @return estado de juego que se va a cargar nada más empiece la aplicación
     */
    public State getStartState() {
        return new LoadingState(this);
    }

}


//hebras de java swing y main

//android gestiona nuestro ciclo de vida (al girar el movil se vuelve a llamar al on create, cierra la actividad
//las hebras creadas por el programador no se cierran y siguen en funcionamiento
//hebra nueva se debería crear en un nuevo fichero