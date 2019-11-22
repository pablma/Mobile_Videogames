package com.example.logic;

import com.example.logic.GameObjects.SwitchDashObject;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ParticleSystem extends SwitchDashObject {

    private List<Particle> _particles;
    int NUM_PARTICLES = 7;
    private Random _random;

    public ParticleSystem(float iniPosX, float iniPosY) {
        super(iniPosX, iniPosY);
        _particles = new LinkedList<Particle>();
        _random = new Random();
    }

    @Override
    public void update(float deltaTime) {
        for(int i = 0; i < _particles.size(); i++){
            Particle p = _particles.get(i);
            p.update(deltaTime);

            if(p.noVisible())
                _particles.remove(i);

        }
    }

    @Override
    public void present(float deltaTime) {
        for(int i = 0; i < _particles.size(); i++){
            Particle p = _particles.get(i);
            p.present(deltaTime);
        }
    }

    public void generateParticles(float posX, float posY, Color color){

        for(int i = 0; i < NUM_PARTICLES; i++){
            float rndX = _random.nextInt(150 + 150) - 150;
            float rndY = _random.nextInt(10);
            _particles.add(new Particle(posX + rndX, posY + rndY, color));
        }
    }
}