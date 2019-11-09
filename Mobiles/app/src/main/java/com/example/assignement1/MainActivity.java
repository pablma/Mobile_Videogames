package com.example.assignement1;


import com.example.androidengine.Game;
import com.example.engine.Screen;
import com.example.logic.GameScreen;

public class MainActivity extends Game {


    public Screen getStartScreen() {
        return new GameScreen(this);
    }

}


//hebras de java swing y main

//android gestiona nuestro ciclo de vida (al girar el movil se vuelve a llamar al on create, cierra la actividad
//las hebras creadas por el programador no se cierran las hebras y siguen en funcionamiento
//hebra nueva se debería crear en un nuevo fichero