package com.example.max.spaceinvadersandroid.UI.Entities;

import android.graphics.Canvas;

import com.example.max.spaceinvadersandroid.DM.GraphicObject;

/**
 * Created by Max on 2/10/2018.
 */

public interface DrawableObject {

    public void tick();
    public void render(Canvas canvas);
    public GraphicObject getEntity();

}
