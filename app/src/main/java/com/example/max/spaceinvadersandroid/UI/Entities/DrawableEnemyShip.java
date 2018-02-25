package com.example.max.spaceinvadersandroid.UI.Entities;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.max.spaceinvadersandroid.DM.EnemyShip;
import com.example.max.spaceinvadersandroid.DM.SpaceShip;

/**
 * Created by Max on 2/25/2018.
 */

public class DrawableEnemyShip implements DrawableObject {
    private EnemyShip enemyShip;
    private Rect rectangle;
    private int color;

    public DrawableEnemyShip(EnemyShip enemyShip, int color){
        this.enemyShip = enemyShip;
        int left = this.enemyShip.getLeft();
        int top = this.enemyShip.getTop();
        int right = this.enemyShip.getRight();
        int bottom = this.enemyShip.getBottom();
        this.rectangle = new Rect(left,top,right,bottom);
        this.color = color;
    }

    @Override
    public void tick() {
        int x = this.enemyShip.getPoint().x;
        int y = this.enemyShip.getPoint().y;
        this.enemyShip.setLeft(x - rectangle.width()/2);
        this.enemyShip.setTop(y - this.rectangle.height()/2);
        this.enemyShip.setRight(x + this.rectangle.width()/2);
        this.enemyShip.setBottom(y + this.rectangle.height()/2);
        int left = this.enemyShip.getLeft();
        int top = this.enemyShip.getTop();
        int right = this.enemyShip.getRight();
        int bottom = this.enemyShip.getBottom();
        this.rectangle.set( left, top, right, bottom);
    }

    @Override
    public void render(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.color);
        canvas.drawRect(this.rectangle,paint);
    }

    @Override
    public EnemyShip getEntity() {
        return this.enemyShip;
    }
}
