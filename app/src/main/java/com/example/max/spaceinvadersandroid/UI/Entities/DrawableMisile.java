package com.example.max.spaceinvadersandroid.UI.Entities;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.max.spaceinvadersandroid.DM.Misile;
import com.example.max.spaceinvadersandroid.DM.SpaceShip;

/**
 * Created by Max on 2/27/2018.
 */

public class DrawableMisile implements DrawableObject {

    private Misile misile;
    private Rect rectangle;
    private int color;

    public DrawableMisile(Misile spaceShip, int color){
        this.misile = spaceShip;
        int left = this.misile.getLeft();
        int top = this.misile.getTop();
        int right = this.misile.getRight();
        int bottom = this.misile.getBottom();
        this.rectangle = new Rect(left,top,right,bottom);
        this.color = color;
    }

    @Override
    public void tick() {
        int x = this.misile.getPoint().x;
        int y = this.misile.getPoint().y;
        this.misile.setLeft(x - rectangle.width()/2);
        this.misile.setTop(y - this.rectangle.height()/2);
        this.misile.setRight(x + this.rectangle.width()/2);
        this.misile.setBottom(y + this.rectangle.height()/2);
        int left = this.misile.getLeft();
        int top = this.misile.getTop();
        int right = this.misile.getRight();
        int bottom = this.misile.getBottom();
        this.rectangle.set( left, top, right, bottom);
    }

    @Override
    public void render(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.color);
        canvas.drawRect(this.rectangle,paint);
    }

    @Override
    public Misile getEntity() {
        return this.misile;
    }
}
