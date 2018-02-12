package com.example.max.spaceinvadersandroid.UI;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.example.max.spaceinvadersandroid.UI.GamePanel;

/**
 * Created by Max on 1/25/2018.
 */

public class MainThread extends Thread {

    public static final int  MAX_FPS = 30;
    private double averageFPS;
    private SurfaceHolder surfaceHolder;
    private GamePanel gamePanel;
    private boolean running;
    private static Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder, GamePanel gamePanel){
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;
    }

    @Override
    public void run(){
        long startime;
        long timeMills = 1000/MAX_FPS;
        long waitTime;
        int frameCount = 0;
        long totaltime = 0;
        long targetTime = 1000/MAX_FPS;

        while (running){
            startime = System.nanoTime();
            canvas = null;

            try{
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder){
                    this.gamePanel.update();
                    this.gamePanel.draw(canvas);
                }
            }catch (Exception e){ e.printStackTrace();}
            finally{
                if (canvas != null){
                    try{
                        this.surfaceHolder.unlockCanvasAndPost(canvas);
                    }catch(Exception e){ e.printStackTrace();}
                }
            }
            timeMills = ((System.nanoTime()) - startime ) / 1000000;
            waitTime = targetTime - timeMills;
            try{
                if(waitTime > 0){
                    this.sleep(waitTime);
                }
            }catch(Exception e){ e.printStackTrace();}

            totaltime += System.nanoTime() - startime;
            frameCount++;
            if(frameCount == MAX_FPS){
                averageFPS = 1000/(totaltime/frameCount/1000000);
                frameCount = 0;
                totaltime = 0;
                System.out.println(averageFPS);
            }
        }
    }

    public void setRunning(boolean running) {this.running = running;}
}
