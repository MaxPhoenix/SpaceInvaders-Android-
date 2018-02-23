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
        int x = this.spaceShip.getLeft();
        int y = this.spaceShip.getTop();
        int width = this.spaceShip.getRight();
        int height = this.spaceShip.getBottom();
        this.rectangle = new Rect(x,y,width,height);
        this.color = color;
    }

    @Override
    public void tick() {
        int x = this.spaceShip.getPoint().x;
        int y = this.spaceShip.getPoint().y;
        this.rectangle.set( x - this.rectangle.width()/2, y - this.rectangle.height()/2,
                            x + this.rectangle.width()/2, y + this.rectangle.height()/2);
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
