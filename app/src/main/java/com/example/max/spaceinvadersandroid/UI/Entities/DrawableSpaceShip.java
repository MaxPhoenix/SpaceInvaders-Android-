package com.example.max.spaceinvadersandroid.UI.Entities;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.constraint.solver.widgets.Rectangle;

import com.example.max.spaceinvadersandroid.DM.ActiveState;
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
        int left = this.spaceShip.getLeft();
        int top = this.spaceShip.getTop();
        int right = this.spaceShip.getRight();
        int bottom = this.spaceShip.getBottom();
        this.rectangle = new Rect(left,top,right,bottom);
        this.color = color;
    }

    @Override
    public void tick() {
        if(this.spaceShip == null)
            return;
        if(this.spaceShip.getActiveState() == ActiveState.INACTIVE){
            this.spaceShip = null;
            return;
        }
        int x = this.spaceShip.getPoint().x;
        int y = this.spaceShip.getPoint().y;
        this.spaceShip.setLeft(x - rectangle.width()/2);
        this.spaceShip.setTop(y - this.rectangle.height()/2);
        this.spaceShip.setRight(x + this.rectangle.width()/2);
        this.spaceShip.setBottom(y + this.rectangle.height()/2);
        int left = this.spaceShip.getLeft();
        int top = this.spaceShip.getTop();
        int right = this.spaceShip.getRight();
        int bottom = this.spaceShip.getBottom();
        this.rectangle.set( left, top, right, bottom);
    }

    @Override
    public void render(Canvas canvas) {
        if(this.spaceShip == null)
            return;
        Paint paint = new Paint();
        paint.setColor(this.color);
        canvas.drawRect(this.rectangle,paint);
    }

    @Override
    public SpaceShip getEntity() {
        return this.spaceShip;
    }
}
