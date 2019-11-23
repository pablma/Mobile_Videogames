package com.example.logic.GameObjects;

import com.example.engine.Utils.Sprite;
import com.example.logic.SuperClasses.Assets;
import com.example.logic.SuperClasses.GameObject;

public class BlackBands extends GameObject {

    /**
     * CLASE BLACK_BANDS
     * Es la encargada de llevar el pintado de las bandas negras que se pintarán a los lados
     * cuando se haga el reescalado
     */

    Sprite _blackBandSprite =  Assets._blackBandSprite;

    private boolean on = true;

    /**
     * Constructora de la clase
     */
    public BlackBands(){
        super(0, 0);
    }

    /**
     * Pinta las bandas negras en pantalla
     */
    public void present(){
        _blackBandSprite.drawImageAsBottomRightBand();
        _blackBandSprite.drawImageAsUpperLeftBand();
    }

}
