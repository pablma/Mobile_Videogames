package com.example.assignement1;


import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.engine.Game;
import com.example.engine.Input;
import com.example.engine.Screen;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivity extends Screen {

    public MainActivity(Game game) {
        super(game);
    }


    @Override
    public void update(float deltaTime) {
        //List<Input.TouchEvent> touchEvents = _game.getInput().get
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


    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InputStream inputStream = null;
        try{
            AssetManager assetManager = this.getAssets();
            inputStream = assetManager.open("th.png");
            _sprite = BitmapFactory.decodeStream(inputStream);
        }
        catch (IOException io){
            android.util.Log.e("MainActivity", "Error lectura");
        }
        finally{
            try{
                inputStream.close();
            }
            catch (Exception io){

            }
        }
        //setContentView(new MyView( this));

        _view = new MyView(this);
        setContentView(_view);
    }

    MyView _view;

    @Override
    protected void onResume(){
        super.onResume();
        _view.resume();
    }

    @Override
    protected void onPause(){
        super.onPause();
        _view.pause();
    }
    Bitmap _sprite;

    class MyView extends SurfaceView implements Runnable {
        public MyView(Context context){
            super(context);
        }

        public void resume(){

            if(!_running) {
                _running = true;
                _renderThread = new Thread(this);
                _renderThread.start();
            }
        }
        public void pause(){
            _running = false;
            try{
                _renderThread.join();
            }
            catch(InterruptedException ie){

            }
        }
        public void update(float deltaTime){

        }

        public void render(Canvas canvas){
            canvas.drawColor(0xFF0000FF);
            if(_sprite != null){
                canvas.drawBitmap(_sprite, ++_x, 100, null);
            }
        }
        public void run(){

            SurfaceHolder holder = getHolder();
            float deltaTime = 0.0f;


            while(_running){
                update(deltaTime);
                while(!holder.getSurface().isValid())
                    ;
                Canvas canvas = holder.lockCanvas();
                render(canvas);
                holder.unlockCanvasAndPost(canvas);
            }
        }

        volatile boolean _running = false;
        Thread _renderThread;

        //public void onDraw(Canvas c){
        //  c.drawColor(0xFF0000FF);
        //if(_sprite != null){
        //  c.drawBitmap(_sprite, ++_x, 100, null);
        //}
        //invalidate(); // forzamos que se repinte en cada vuelta
        //}
    }
    int _x = 100;
    */
}


//hebras de java swing y main

//android gestiona nuestro ciclo de vida (al girar el movil se vuelve a llamar al on create, cierra la actividad
//las hebras creadas por el programador no se cierran las hebras y siguen en funcionamiento
//hebra nueva se debería crear en un nuevo fichero