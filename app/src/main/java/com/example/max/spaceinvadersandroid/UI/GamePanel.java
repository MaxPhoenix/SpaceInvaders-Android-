package com.example.max.spaceinvadersandroid.UI;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import com.example.max.spaceinvadersandroid.UI.States.GameState;
import com.example.max.spaceinvadersandroid.UI.States.StateHandler;

/**
 * Created by Max on 1/25/2018.
 */

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread;

    //TODO agregar States en esta clase
    //State handler
    private StateHandler stateHandler;
    private GameState gameState;


    public GamePanel(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        this.stateHandler = new StateHandler();
        this.gameState = new GameState(this,"");
        StateHandler.setCurrentState(this.gameState);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new MainThread(getHolder(), this);
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while(true){
            try{
                thread.setRunning(false);
                thread.join();
            }
            catch (Exception e)  {e.printStackTrace();}
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
      return  StateHandler.getCurrentState().onTouchEvent(event);
    }

    public void update(){
        StateHandler.getCurrentState().tick();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(Color.WHITE);
        StateHandler.getCurrentState().render(canvas);
    }


    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

}
