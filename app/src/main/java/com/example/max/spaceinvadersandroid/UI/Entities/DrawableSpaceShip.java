package com.example.max.spaceinvadersandroid.UI.Entities;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.constraint.solver.widgets.Rectangle;

import com.example.max.spaceinvadersandroid.DM.GraphicObject;
import com.example.max.spaceinvadersandroid.DM.SpaceShip;

/**
 * Created by Max on 2/11/2018.
 */

public class DrawableSpaceShip implements DrawableObject {

    private SpaceShip spaceShip;
    private Rect rectangle;
    private int color;

    public DrawableSpaceShip(SpaceShip spaceShip, int color){
        this.spaceShip = spaceShip;
        int x = this.spaceShip.getX();
        int y = this.spaceShip.getY();
        int width = this.spaceShip.getWidth();
        int height = this.spaceShip.getHeight();
        this.rectangle = new Rect(x,y,width,height);
        this.color = color;
    }

    @Override
    public void tick() {
        int x = this.rectangle.centerX();
        int y = this.rectangle.centerY();
        this.rectangle.set(x - rectangle.width()/2,
                y - rectangle.height()/2,
                x - rectangle.width()/2,
                y- rectangle.height()/2);
    }

    @Override
    public void render(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.color);
        canvas.drawRect(this.rectangle,paint);
    }

    @Override
    public SpaceShip getEntity() {
        return this.spaceShip;
    }
}
