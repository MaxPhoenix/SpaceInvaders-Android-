package com.example.max.spaceinvadersandroid.UI.States;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.max.spaceinvadersandroid.UI.GamePanel;

/**
 * Created by Max on 2/11/2018.
 */

public abstract class State {

    protected GamePanel gamePanel;

    public State(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public abstract void tick();
    public abstract void render(Canvas canvas);
    public abstract boolean onTouchEvent(MotionEvent event);

}
