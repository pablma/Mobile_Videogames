package com.example.logic.GameObjects;

import com.example.logic.SuperClasses.Assets;
import com.example.logic.SuperClasses.SwitchDashObject;

import java.util.Random;

public class Ball extends SwitchDashObject {

    /**
     * CLASE BALL
     * Es la encargada de llevar la lógica y el pintado de cada bola que se pueda crear en el juego
     */

    private float _velY = 430f;
    private Color _initialColor;

    private Random random;

    private Color _masterWhiteArray[] = new Color[]{Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
            Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK};

    private Color _masterBlackArray[] = new Color[]{Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
            Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE};

    /**
     * Constructora de la clase
     * @param iniPosX posición X inicial
     * @param iniPosY posición Y inicial
     */
    public Ball(float iniPosX, float iniPosY) {

        super(iniPosX, iniPosY, Assets._blackBallSprite, Assets._whiteBallSprite);
        _blackSp = Assets._blackBallSprite;
        _whiteSp = Assets._whiteBallSprite;

        random = new Random();

        if(random.nextInt(2) == 0) {
            _initialColor = Color.BLACK;
            _currentSprite = _blackSp;
        }
        else {
            _initialColor = Color.WHITE;
            _currentSprite = _whiteSp;
        }

        _color = _initialColor;
    }

    /**
     * Actualiiza la lógica de la pelota
     * @param deltaTime deltaTime del juego
     */
    public void update(float deltaTime){
        movement(deltaTime);
    }

    /**
     * Pinta el sprite en pantalla depediendo de si es negro o blanco
     */
    public void present(){

        if(_color == Color.BLACK)
            _blackSp.drawImageXCentered((int)_posY);
        else
            _whiteSp.drawImageXCentered((int)_posY);
    }

    /**
     * Podría proporcionar una funcionalidad de pausa si fuera necesario
     */
    public void pause(){}

    /**
     * Podría proporcionar una funcionalidad de reanudar si fuera necesario
     */
    public void resume(){}

    /**
     * Podría proporcionar una funcionalidad de liberar recursos si fuera necesario
     */
    public void dispose(){}

    /**
     * Lógica de la pelota, incrementa su velocidad para que vayan bajando
     * @param deltaTime deltaTime del juego
     */
    private void movement(float deltaTime){
        _posY += _velY * deltaTime;
    }

    /**
     * Selecciona un color para la pelota de forma alaeatoria pero sesgada, teniendo
     * el master un 70% de posibilidades de salir
     * @param master color con 70% de posibilidades de salir elegido
     */
    public void selectColor(Color master)
    {
        Color colors [];
        Color masterColor = master;

        if(master == Color.BLACK)
            colors = _masterBlackArray;
        else
            colors = _masterWhiteArray;

        int rnd = random.nextInt(10);
        _color = colors[rnd];

        if(_color == Color.BLACK)
            _currentSprite = _blackSp;
        else
            _currentSprite = _whiteSp;
    }

    /**
     * Devuelve el color actual de la pelota
     * @return color actual de la pelota
     */
    public Color getColor() {
        return _color;
    }

    /**
     * Incrementa la velocidad de la pelota
     * @param increasement cantidad que se quiere incrementar la velocidad
     */
    public void increaseVel(float increasement) {
        _velY += increasement;
    }
}
