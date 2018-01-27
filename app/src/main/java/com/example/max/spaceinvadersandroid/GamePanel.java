package com.example.max.spaceinvadersandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

/**
 * Created by Max on 1/25/2018.
 */

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread;

    public GamePanel(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
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
        return super.onTouchEvent(event);
    }

    public void update(){

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }


}
