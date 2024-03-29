package com.example.logic.GameObjects;

import com.example.engine.Utils.Sprite;
import com.example.logic.SuperClasses.Assets;
import com.example.logic.SuperClasses.GameObject;

public class PointsString extends GameObject {

    /**
     * CLASE POINTS_STRING
     * Es la encargada de mostrar un string que escribe la palabra POINTS en pantalla
     */

    private Sprite _P_Sprite = Assets._P_Sprite;
    private Sprite _O_Sprite = Assets._O_Sprite;
    private Sprite _I_Sprite = Assets._I_Sprite;
    private Sprite _N_Sprite = Assets._N_Sprite;
    private Sprite _T_Sprite = Assets._T_Sprite;
    private Sprite _S_Sprite = Assets._S_Sprite;

    /**
     * Constructora de la clase
     * @param iniPosX posición X inicial
     * @param iniPosY posición Y inicial
     */
    public PointsString(float iniPosX, float iniPosY) {
        super(iniPosX, iniPosY);
    }

    /**
     * Muestra la palabra points en pantalla
     */
    public void present(){

        _P_Sprite.drawImage((int)_iniPosX, (int)_iniPosY);
        _O_Sprite.drawImage(((int)_iniPosX + (int)(0.75 * _P_Sprite.getWidth())), (int)_iniPosY);
        _I_Sprite.drawImage(((int)_iniPosX + (int)(1.5 * _P_Sprite.getWidth())), (int)_iniPosY);
        _N_Sprite.drawImage(((int)_iniPosX + (int)(2.25 * _P_Sprite.getWidth())), (int)_iniPosY);
        _T_Sprite.drawImage(((int)_iniPosX + (int)(3 * _P_Sprite.getWidth())), (int)_iniPosY);
        _S_Sprite.drawImage(((int)_iniPosX + (int)(3.75 * _P_Sprite.getWidth())), (int)_iniPosY);
    }

}
