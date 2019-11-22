package com.example.logic;

import com.example.logic.GameObjects.SwitchDashObject;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ParticleSystem extends SwitchDashObject {

    /**
     * CLASE PARTICLE SYSTEM
     * Contiene la funcionalidad ppal para generar partículas
     */

    private List<Particle> _particles;
    int NUM_PARTICLES = 10;
    private Random _random;

    /**
     * Constructora que crea el objeto
     * @param iniPosX posición X inicial del objeto
     * @param iniPosY posición Y inicial del objeto
     */
    public ParticleSystem(float iniPosX, float iniPosY) {
        super(iniPosX, iniPosY);
        _particles = new LinkedList<Particle>();
        _random = new Random();
    }

    /**
     * Método update que recorre la lista de partículas llamando al update de cada una
     * @param deltaTime deltaTime del juego
     */
    @Override
    public void update(float deltaTime) {
        for(int i = 0; i < _particles.size(); i++){
            Particle p = _particles.get(i);
            p.update(deltaTime);

            if(p.noVisible())
                _particles.remove(i);

        }
    }

    /**
     * Método present que recorre la lista de partículas llamando al present de cada una
     * @param deltaTime deltaTime del juego
     */
    @Override
    public void present(float deltaTime) {
        for(int i = 0; i < _particles.size(); i++){
            Particle p = _particles.get(i);
            p.present(deltaTime);
        }
    }

    /**
     * Método que rellena la lista de partículas haciendo random para evitar que aparezcan todas las
     * partícuals en el mismo sitio, generándolas así en una zona
     * @param posX posición X inicial dónde queremos las partículas
     * @param posY posición Y inicial dónde queremos las partículas
     * @param color color del que queremos las partícuals
     */
    public void generateParticles(float posX, float posY, Color color){

        for(int i = 0; i < NUM_PARTICLES; i++){
            float rndX = _random.nextInt(100 + 100) - 100;
            float rndY = _random.nextInt(10);

            int speedXrndRange = 450;
            int speedYrndRange = 600;

            float rndSpeedX = _random.nextInt(speedXrndRange + speedXrndRange) - speedXrndRange;
            float rndSpeedY = _random.nextInt(speedYrndRange) - speedYrndRange * 2;
            _particles.add(new Particle(posX + rndX, posY + rndY, color, rndSpeedX, rndSpeedY));
        }
    }
}