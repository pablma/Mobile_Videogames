package com.example.assignement1;


import com.example.androidengine.Game;
import com.example.engine.State;
import com.example.logic.GameState;
import com.example.logic.LoadingState;

public class MainActivity extends Game {


    public State getStartState() {
        return new LoadingState(this);
    }

}


//hebras de java swing y main

//android gestiona nuestro ciclo de vida (al girar el movil se vuelve a llamar al on create, cierra la actividad
//las hebras creadas por el programador no se cierran las hebras y siguen en funcionamiento
//hebra nueva se debería crear en un nuevo fichero