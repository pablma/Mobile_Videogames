package com.example.logic.SuperClasses;

import com.example.engine.Utils.Sprite;
import com.example.logic.SuperClasses.GameObject;

public class SwitchDashObject extends GameObject {

    /**
     * CLASE SWITCH_DASH_OBJECT
     * Aporta ciertos atributos comunes que tendrá cada objeto de SwitchDase
     */

    /**
     * Enum que define el color del objeto
     */
    protected enum Color {
        BLACK,
        WHITE
    }

    protected Sprite _blackSp;
    protected Sprite _whiteSp;
    protected Sprite _currentSprite;

    protected Color _color;

    /**
     * Constructora de la clase
     * @param iniPosX posición X inicial del objeto
     * @param iniPosY posición Y inicial del objeto
     * @param blackSp sprite negro del objeto
     * @param whiteSp sprite blanco del objeto
     */
    public SwitchDashObject(float iniPosX, float iniPosY, Sprite blackSp, Sprite whiteSp) {
        super(iniPosX, iniPosY);

        _blackSp = blackSp;
        _whiteSp = whiteSp;
    }

    /**
     * Constructora de la clase más simple
     * @param iniPosX posición X inicial del objeto
     * @param iniPosY posición Y inicial del objeto
     */
    public SwitchDashObject(float iniPosX, float iniPosY) {
        super(iniPosX, iniPosY);
    }

    /**
     * Método que prorporciona la funcionalidad de pausa
     */
    @Override
    public void pause() {
        super.pause();
    }

    /**
     * Método que aporta la funcionalidad de reanudar
     */
    @Override
    public void resume() {
        super.resume();
    }

    /**
     * Método que libera recursos
     */
    @Override
    public void dispose() {
        super.dispose();
    }

    /**
     * Método que devuelve el color actual del objeto
     * @return variable d etipo color con el color del objeto
     */
    public Color getColor() {
        return _color;
    }

    /**
     * Método que devuelve el sprite del objeto
     * @return variable tipo sprite con el sprite del objeto
     */
    public Sprite getSprite() {
        return _currentSprite;
    }
}
