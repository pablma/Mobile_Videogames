package com.example.logic;

public class ParticleSystem extends GameObject {

    private Particle particles[];

    public ParticleSystem(float iniPosX, float iniPosY) {
        super(iniPosX, iniPosY);

        particles = new Particle[4];
        for(int i = 0; i < particles.length; i++){
            particles[i] = new Particle(iniPosX, iniPosY);
        }
    }

    @Override
    public void update(float deltaTime) {
        for(int i = 0; i < particles.length; i++){
            particles[i].update(deltaTime);
        }
    }

    @Override
    public void present(float deltaTime) {
        for(int i = 0; i < particles.length; i++){
            particles[i].present(deltaTime);
        }
    }
}