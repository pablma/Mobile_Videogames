package com.example.logic;

import com.example.engine.Game;
import com.example.engine.Graphics;
import com.example.engine.Image;
import com.example.engine.Rect;
import com.example.engine.Sprite;
import com.example.engine.State;

public class LoadingState extends State {

    public LoadingState(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics _graphics = _game.getGraphics();

        //Player

        Assets._blackPlayerImg  = _graphics.newImage("players.png");
        Assets._blackPlayerRect  = new Rect(0,  Assets._blackPlayerImg.getHeight() / 2,
                Assets._blackPlayerImg.getWidth(),  Assets._blackPlayerImg.getHeight() / 2);
        Assets._blackPlayerSprite = new Sprite(_graphics, Assets._blackPlayerImg, Assets._blackPlayerRect);


        Assets._whitePlayerImg = Assets._blackPlayerImg;
        Assets._withePlayerRect = new Rect(0,  0,
                Assets._whitePlayerImg.getWidth(),  Assets._whitePlayerImg.getHeight() / 2);
        Assets._whitePlayerSprite = new Sprite(_graphics, Assets._blackPlayerImg, Assets._withePlayerRect);



        //Balls

        Assets._blackBallImg = _graphics.newImage("balls.png");
        Assets._blackBallRect = new Rect(0,  Assets._blackBallImg.getHeight() / 2,
                Assets._blackBallImg.getWidth() / 10,  Assets._blackBallImg.getHeight() / 2);
        Assets._blackBallSprite = new Sprite(_graphics, Assets._blackBallImg, Assets._blackBallRect);


        Assets._whiteBallImg = Assets._blackBallImg;
        Assets._whiteBallRect  = new Rect(0,  0,
                Assets._whiteBallImg.getWidth() / 10,  Assets._whiteBallImg.getHeight() / 2);
        Assets._whiteBallSprite  = new Sprite(_graphics, Assets._whiteBallImg, Assets._whiteBallRect);



        //Background Arrows

        Assets._backgroundArrowsImg  = _graphics.newImage("arrowsBackground.png");
        Assets._backgroundArrowsRect  = new Rect(0,0, Assets._backgroundArrowsImg.getWidth(), Assets._backgroundArrowsImg.getHeight());
        Assets._backgroundArrowsSprite  = new Sprite(_graphics, Assets._backgroundArrowsImg, Assets._backgroundArrowsRect);



        //Background Color Images

        Assets._greenBackgroundImg = _graphics.newImage("backgrounds.png");
        Assets._greenBackgroundRect  = new Rect(0,0,
                Assets._greenBackgroundImg.getWidth() / 9, Assets._greenBackgroundImg.getHeight());
        Assets._greenBackgroundSprite = new Sprite(_graphics, Assets._greenBackgroundImg, Assets._greenBackgroundRect);


        Assets._greenBlueBackgroundImg  = Assets._greenBackgroundImg;
        Assets._greenBlueBackgroundRect  = new Rect((Assets._greenBlueBackgroundImg.getWidth() / 9),0,
                Assets._greenBlueBackgroundImg.getWidth() / 9, Assets._greenBlueBackgroundImg.getHeight());
        Assets._greenBlueBackgroundSprite = new Sprite(_graphics, Assets._greenBlueBackgroundImg, Assets._greenBlueBackgroundRect);


        Assets._softBlueBackgroundImg  = Assets._greenBackgroundImg;
        Assets._softBlueBackgroundRect  = new Rect(2 * (Assets._softBlueBackgroundImg.getWidth() / 9),0,
                 Assets._softBlueBackgroundImg.getWidth() / 9, Assets._softBlueBackgroundImg.getHeight());
        Assets._softBlueBackgroundSprite = new Sprite(_graphics, Assets._softBlueBackgroundImg, Assets._softBlueBackgroundRect);


        Assets._blueBackgroundImg  = Assets._greenBackgroundImg;
        Assets._blueBackgroundRect  = new Rect(3 * (Assets._blueBackgroundImg.getWidth() / 9),0,
                Assets._blueBackgroundImg.getWidth() / 9, Assets._blueBackgroundImg.getHeight());
        Assets._blueBackgroundSprite = new Sprite(_graphics, Assets._blueBackgroundImg, Assets._blueBackgroundRect);


        Assets._purpleBackgroundImg = Assets._greenBackgroundImg;
        Assets._purpleBackgroundRect  = new Rect(4 * (Assets._purpleBackgroundImg.getWidth() / 9),0,
                Assets._purpleBackgroundImg.getWidth() / 9, Assets._purpleBackgroundImg.getHeight());
        Assets._purpleBackgroundSprite = new Sprite(_graphics, Assets._purpleBackgroundImg, Assets._purpleBackgroundRect);

        Assets._darkBlueBackgroundImg  = Assets._greenBackgroundImg;
        Assets._darkBlueBackgroundRect  = new Rect(5 * (Assets._darkBlueBackgroundImg.getWidth() / 9),0,
                Assets._darkBlueBackgroundImg.getWidth() / 9, Assets._darkBlueBackgroundImg.getHeight());
        Assets._darkBlueBackgroundSprite = new Sprite(_graphics, Assets._darkBlueBackgroundImg, Assets._darkBlueBackgroundRect);


        Assets._orangeBackgroundImg  = Assets._greenBackgroundImg;
        Assets._orangeBackgroundRect  = new Rect(6 * (Assets._orangeBackgroundImg.getWidth() / 9),0,
                Assets._orangeBackgroundImg.getWidth() / 9, Assets._orangeBackgroundImg.getHeight());
        Assets._orangeBackgroundSprite = new Sprite(_graphics, Assets._orangeBackgroundImg, Assets._orangeBackgroundRect);


        Assets._redBackgroundImg  =Assets._greenBackgroundImg;
        Assets._redBackgroundRect  = new Rect(7 * (Assets._redBackgroundImg.getWidth() / 9),0,
                Assets._redBackgroundImg.getWidth() / 9, Assets._redBackgroundImg.getHeight());
        Assets._redBackgroundImgSprite = new Sprite(_graphics, Assets._redBackgroundImg, Assets._redBackgroundRect);


        Assets._brownBackgroundImg  = Assets._greenBackgroundImg;
        Assets._brownBackgroundRect  = new Rect(8 * (Assets._brownBackgroundImg.getWidth() / 9),0,
                Assets._brownBackgroundImg.getWidth() / 9, Assets._brownBackgroundImg.getHeight());
        Assets._brownBackgroundSprite = new Sprite(_graphics, Assets._brownBackgroundImg, Assets._brownBackgroundRect);


        Assets._blackBandImg = _graphics.newImage("black.png") ;
        Assets._blackBandRect = new Rect(0,0,
                Assets._blackBandImg.getWidth(), Assets._blackBandImg.getHeight());
        Assets._blackBandSprite = new Sprite(_graphics, Assets._blackBandImg,Assets._blackBandRect);



        //Interface

        Assets._gameOverImg = _graphics.newImage("gameOver.png");
        Assets._gameOverRect  = new Rect(0,0,
                Assets._gameOverImg.getWidth(), Assets._gameOverImg.getHeight());
        Assets._gameOverSprite = new Sprite(_graphics, Assets._gameOverImg, Assets._gameOverRect);


        Assets._howToPlayImg = _graphics.newImage("howToPlay.png");
        Assets._howToPlayRect  = new Rect(0,0,
                Assets._howToPlayImg.getWidth(), Assets._howToPlayImg.getHeight());
        Assets._howToPlaySprite = new Sprite(_graphics, Assets._howToPlayImg, Assets._howToPlayRect);


        Assets._instructionsImg = _graphics.newImage("instructions.png");
        Assets._instructionsRect  = new Rect(0,0,
                Assets._instructionsImg.getWidth(), Assets._instructionsImg.getHeight());
        Assets._instructionsSprite = new Sprite(_graphics, Assets._instructionsImg, Assets._instructionsRect);


        Assets._playAgainImg = _graphics.newImage("playAgain.png");
        Assets._playAgainRect  = new Rect(0,0,
                Assets._playAgainImg.getWidth(), Assets._playAgainImg.getHeight());
        Assets._playAgainISprite = new Sprite(_graphics, Assets._playAgainImg, Assets._playAgainRect);


        Assets._tapToPlayImg = _graphics.newImage("tapToPlay.png");
        Assets._tapToPlayRect  = new Rect(0,0,
                Assets._tapToPlayImg.getWidth(), Assets._tapToPlayImg.getHeight());
        Assets._tapToPlaySprite = new Sprite(_graphics, Assets._tapToPlayImg, Assets._tapToPlayRect);


        Assets._switchDashLogoImg = _graphics.newImage("switchDashLogo.png");
        Assets._switchDashLogoRect  = new Rect(0,0,
                Assets._switchDashLogoImg.getWidth(), Assets._switchDashLogoImg.getHeight());
        Assets._switchDashLogoSprite = new Sprite(_graphics, Assets._switchDashLogoImg, Assets._switchDashLogoRect);



        //Numbers

        Assets._zeroImg  = _graphics.newImage("scoreFont.png");
        Assets._zeroRect  = new Rect(7 * (Assets._zeroImg.getWidth() / 15),3 * (Assets._zeroImg.getHeight() / 7),
                Assets._zeroImg.getWidth() / 15, Assets._zeroImg.getHeight() / 7);
        Assets._zeroSprite = new Sprite(_graphics, Assets._zeroImg, Assets._zeroRect);


        Assets._oneImg = Assets._zeroImg;
        Assets._oneRect  = new Rect(8 * (Assets._oneImg.getWidth() / 15),3 * (Assets._oneImg.getHeight() / 7),
                Assets._oneImg.getWidth() / 15, Assets._oneImg.getHeight() / 7);
        Assets._oneSprite = new Sprite(_graphics, Assets._oneImg, Assets._oneRect);


        Assets._twoImg = Assets._zeroImg;
        Assets._twoRect  = new Rect(9 * (Assets._twoImg.getWidth() / 15),3 * (Assets._twoImg.getHeight() / 7),
                Assets._twoImg.getWidth() / 15, Assets._twoImg.getHeight() / 7);
        Assets._twoSprite = new Sprite(_graphics, Assets._twoImg, Assets._twoRect);


        Assets._threeImg = Assets._zeroImg;
        Assets._threeRect  = new Rect(10 * (Assets._threeImg.getWidth() / 15),3 * (Assets._threeImg.getHeight() / 7),
                Assets._threeImg.getWidth() / 15, Assets._threeImg.getHeight() / 7);
        Assets._threeSprite = new Sprite(_graphics, Assets._threeImg, Assets._threeRect);


        Assets._fourImg = Assets._zeroImg;
        Assets._fourRect  = new Rect(11 * (Assets._fourImg.getWidth() / 15),3 * (Assets._zeroImg.getHeight() / 7),
                Assets._fourImg.getWidth() / 15, Assets._fourImg.getHeight() / 7);
        Assets._fourSprite = new Sprite(_graphics, Assets._fourImg, Assets._fourRect);


        Assets._fiveImg = Assets._zeroImg;
        Assets._fiveRect  = new Rect(12 * (Assets._fiveImg.getWidth() / 15),3 * (Assets._fiveImg.getHeight() / 7),
                Assets._fiveImg.getWidth() / 15, Assets._fiveImg.getHeight() / 7);
        Assets._fiveSprite = new Sprite(_graphics, Assets._fiveImg, Assets._fiveRect);


        Assets._sixImg = Assets._zeroImg;
        Assets._sixRect  = new Rect(13 * (Assets._sixImg.getWidth() / 15),3 * (Assets._sixImg.getHeight() / 7),
                Assets._sixImg.getWidth() / 15, Assets._sixImg.getHeight() / 7);
        Assets._sixSprite = new Sprite(_graphics, Assets._sixImg, Assets._sixRect);


        Assets._sevenImg = Assets._zeroImg;
        Assets._sevenRect  = new Rect(14 * (Assets._sevenImg.getWidth() / 15),3 * (Assets._sevenImg.getHeight() / 7),
                Assets._sevenImg.getWidth() / 15, Assets._sevenImg.getHeight() / 7);
        Assets._sevenSprite = new Sprite(_graphics, Assets._sevenImg, Assets._sevenRect);


        Assets._eightImg = Assets._zeroImg;
        Assets._eightRect  = new Rect(0,4 * (Assets._eightImg.getHeight() / 7),
                Assets._eightImg.getWidth() / 15, Assets._eightImg.getHeight() / 7);
        Assets._eigthSprite  = new Sprite(_graphics, Assets._eightImg, Assets._eightRect);


        Assets._nineImg = Assets._zeroImg;
        Assets._nineRect  = new Rect((Assets._nineImg.getWidth() / 15),4 * (Assets._nineImg.getHeight() / 7),
                Assets._nineImg.getWidth() / 15, Assets._nineImg.getHeight() / 7);
        Assets._nineSprite = new Sprite(_graphics, Assets._nineImg, Assets._nineRect);



        //Letters

        Assets._A_Img = Assets._zeroImg;
        Assets._A_Rect  = new Rect(0,0 ,
                Assets._A_Img.getWidth() / 15, Assets._A_Img.getHeight() / 7);
        Assets._A_Sprite = new Sprite(_graphics, Assets._A_Img, Assets._A_Rect);

        Assets._B_Img = Assets._zeroImg;
        Assets._B_Rect  = new Rect((Assets._B_Img.getWidth() / 15),0,
                Assets._B_Img.getWidth() / 15, Assets._B_Img.getHeight() / 7);
        Assets._B_Sprite = new Sprite(_graphics, Assets._B_Img, Assets._B_Rect);

        Assets._C_Img = Assets._zeroImg;
        Assets._C_Rect  = new Rect(2 * (Assets._C_Img.getWidth() / 15),0,
                Assets._C_Img.getWidth() / 15, Assets._C_Img.getHeight() / 7);
        Assets._C_Sprite = new Sprite(_graphics, Assets._C_Img, Assets._C_Rect);

        Assets._D_Img = Assets._zeroImg;
        Assets._D_Rect  = new Rect(3 * (Assets._D_Img.getWidth() / 15),0,
                Assets._D_Img.getWidth() / 15, Assets._D_Img.getHeight() / 7);
        Assets._D_Sprite = new Sprite(_graphics, Assets._D_Img, Assets._D_Rect);

        Assets._E_Img = Assets._zeroImg;
        Assets._E_Rect  = new Rect(4 * (Assets._E_Img.getWidth() / 15),0,
                Assets._E_Img.getWidth() / 15, Assets._E_Img.getHeight() / 7);
        Assets._E_Sprite = new Sprite(_graphics, Assets._E_Img, Assets._E_Rect);

        Assets._F_Img = Assets._zeroImg;
        Assets._F_Rect  = new Rect(5 * (Assets._F_Img.getWidth() / 15),0,
                Assets._F_Img.getWidth() / 15, Assets._F_Img.getHeight() / 7);
        Assets._F_Sprite = new Sprite(_graphics, Assets._F_Img, Assets._F_Rect);

        Assets._G_Img = Assets._zeroImg;
        Assets._G_Rect  = new Rect(6 * (Assets._G_Img.getWidth() / 15),0,
                Assets._G_Img.getWidth() / 15, Assets._G_Img.getHeight() / 7);
        Assets._G_Sprite = new Sprite(_graphics, Assets._G_Img, Assets._G_Rect);

        Assets._H_Img = Assets._zeroImg;
        Assets._H_Rect  = new Rect(7 * (Assets._H_Img.getWidth() / 15),0,
                Assets._H_Img.getWidth() / 15, Assets._H_Img.getHeight() / 7);
        Assets._H_Sprite = new Sprite(_graphics, Assets._H_Img, Assets._H_Rect);

        Assets._I_Img = Assets._zeroImg;
        Assets._I_Rect  = new Rect(8 * (Assets._I_Img.getWidth() / 15),0,
                Assets._I_Img.getWidth() / 15, Assets._I_Img.getHeight() / 7);
        Assets._I_Sprite = new Sprite(_graphics, Assets._I_Img, Assets._I_Rect);

        Assets._J_Img = Assets._zeroImg;
        Assets._J_Rect  = new Rect(9 * (Assets._J_Img.getWidth() / 15),0,
                Assets._J_Img.getWidth() / 15, Assets._J_Img.getHeight() / 7);
        Assets._J_Sprite = new Sprite(_graphics, Assets._J_Img, Assets._J_Rect);

        Assets._K_Img = Assets._zeroImg;
        Assets._K_Rect  = new Rect(10 * (Assets._K_Img.getWidth() / 15),0,
                Assets._K_Img.getWidth() / 15, Assets._K_Img.getHeight() / 7);
        Assets._K_Sprite = new Sprite(_graphics, Assets._K_Img, Assets._K_Rect);

        Assets._L_Img = Assets._zeroImg;
        Assets._L_Rect  = new Rect(11 * (Assets._L_Img.getWidth() / 15),0,
                Assets._L_Img.getWidth() / 15, Assets._L_Img.getHeight() / 7);
        Assets._L_Sprite = new Sprite(_graphics, Assets._L_Img, Assets._L_Rect);

        Assets._M_Img = Assets._zeroImg;
        Assets._M_Rect  = new Rect(12 * (Assets._M_Img.getWidth() / 15),0,
                Assets._M_Img.getWidth() / 15, Assets._M_Img.getHeight() / 7);
        Assets._M_Sprite = new Sprite(_graphics, Assets._M_Img, Assets._M_Rect);

        Assets._N_Img = Assets._zeroImg;
        Assets._N_Rect  = new Rect(13 * (Assets._N_Img.getWidth() / 15),0,
                Assets._N_Img.getWidth() / 15, Assets._N_Img.getHeight() / 7);
        Assets._N_Sprite = new Sprite(_graphics, Assets._N_Img, Assets._N_Rect);

        Assets._O_Img = Assets._zeroImg;
        Assets._O_Rect  = new Rect(14 * (Assets._O_Img.getWidth() / 15),0,
                Assets._O_Img.getWidth() / 15, Assets._O_Img.getHeight() / 7);
        Assets._O_Sprite = new Sprite(_graphics, Assets._O_Img, Assets._O_Rect);

        Assets._P_Img = Assets._zeroImg;
        Assets._P_Rect  = new Rect(0,(Assets._P_Img.getHeight() / 7),
                Assets._P_Img.getWidth() / 15, Assets._P_Img.getHeight() / 7);
        Assets._P_Sprite = new Sprite(_graphics, Assets._P_Img, Assets._P_Rect);

        Assets._Q_Img = Assets._zeroImg;
        Assets._Q_Rect  = new Rect((Assets._Q_Img.getWidth() / 15),(Assets._Q_Img.getHeight() / 7),
                Assets._twoImg.getWidth() / 15, Assets._Q_Img.getHeight() / 7);
        Assets._Q_Sprite = new Sprite(_graphics, Assets._Q_Img, Assets._Q_Rect);

        Assets._R_Img = Assets._zeroImg;
        Assets._R_Rect  = new Rect(2 * (Assets._R_Img.getWidth() / 15),(Assets._R_Img.getHeight() / 7),
                Assets._R_Img.getWidth() / 15, Assets._R_Img.getHeight() / 7);
        Assets._R_Sprite = new Sprite(_graphics, Assets._R_Img, Assets._R_Rect);

        Assets._S_Img = Assets._zeroImg;
        Assets._S_Rect  = new Rect(3 * (Assets._S_Img.getWidth() / 15),(Assets._S_Img.getHeight() / 7),
                Assets._S_Img.getWidth() / 15, Assets._S_Img.getHeight() / 7);
        Assets._S_Sprite = new Sprite(_graphics, Assets._S_Img, Assets._S_Rect);

        Assets._T_Img = Assets._zeroImg;
        Assets. _T_Rect  = new Rect(4 * (Assets._T_Img.getWidth() / 15), (Assets._T_Img.getHeight() / 7),
                Assets._T_Img.getWidth() / 15, Assets._T_Img.getHeight() / 7);
        Assets._T_Sprite = new Sprite(_graphics, Assets._T_Img, Assets._T_Rect);

        Assets._U_Img = Assets._zeroImg;
        Assets._U_Rect  = new Rect(5 * (Assets._U_Img.getWidth() / 15),(Assets._U_Img.getHeight() / 7),
                Assets._U_Img.getWidth() / 15, Assets._U_Img.getHeight() / 7);
        Assets. _U_Sprite = new Sprite(_graphics, Assets._U_Img, Assets._U_Rect);

        Assets._V_Img = Assets._zeroImg;
        Assets._V_Rect  = new Rect(6 * (Assets._V_Img.getWidth() / 15),(Assets._V_Img.getHeight() / 7),
                Assets._V_Img.getWidth() / 15, Assets._V_Img.getHeight() / 7);
        Assets._V_Sprite = new Sprite(_graphics, Assets._V_Img, Assets._V_Rect);

        Assets._W_Img = Assets._zeroImg;
        Assets. _W_Rect  = new Rect(7 * (Assets._W_Img.getWidth() / 15), (Assets._W_Img.getHeight() / 7),
                Assets._W_Img.getWidth() / 15, Assets._W_Img.getHeight() / 7);
        Assets._W_Sprite = new Sprite(_graphics, Assets._W_Img, Assets._W_Rect);

        Assets._X_Img = Assets._zeroImg;
        Assets._X_Rect  = new Rect(8 * (Assets._X_Img.getWidth() / 15),(Assets._X_Img.getHeight() / 7),
                Assets._X_Img.getWidth() / 15, Assets._X_Img.getHeight() / 7);
        Assets._X_Sprite = new Sprite(_graphics, Assets._X_Img, Assets._X_Rect);

        Assets._Y_Img = Assets._zeroImg;
        Assets._Y_Rect  = new Rect(9 * (Assets._Y_Img.getWidth() / 15),(Assets._Y_Img.getHeight() / 7),
                Assets._Y_Img.getWidth() / 15, Assets._Y_Img.getHeight() / 7);
        Assets._Y_Sprite = new Sprite(_graphics, Assets._Y_Img, Assets._Y_Rect);

        Assets._Z_Img = Assets._zeroImg;
        Assets._Z_Rect  = new Rect(10 * (Assets._Z_Img.getWidth() / 15),(Assets._Z_Img.getHeight() / 7),
                Assets._Z_Img.getWidth() / 15, Assets._Z_Img.getHeight() / 7);
        Assets._Z_Sprite = new Sprite(_graphics, Assets._Z_Img, Assets._Z_Rect);



        //Buttons

        Assets._crosImg = _graphics.newImage("buttons.png");
        Assets._crosRect   = new Rect(Assets._crosImg.getWidth() / 10,0,
                Assets._crosImg.getWidth() / 10, Assets._crosImg.getHeight());
        Assets._crosSprite = new Sprite(_graphics, Assets._crosImg, Assets._crosRect);


        Assets._questionImg = Assets._crosImg;
        Assets._questionRect  = new Rect(0,0,
                Assets._questionImg.getWidth() / 10, Assets._questionImg.getHeight());
        Assets._questionSprite = new Sprite(_graphics, Assets._questionImg, Assets._questionRect);



        _game.setState(new MainMenuState(_game));
    }

    @Override
    public void present(float deltaTime) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
