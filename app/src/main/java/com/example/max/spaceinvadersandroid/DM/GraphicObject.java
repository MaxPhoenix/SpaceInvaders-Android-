package com.example.max.spaceinvadersandroid.DM;

import android.graphics.Point;

/**
 * Created by Max on 1/26/2018.
 */

public abstract class GraphicObject {

    protected int left, top, right, bottom, xSpeed, ySpeed, leftBound, rigthBound;
    protected HealthStats healthStats;
    protected Shooter shootingCapability;
    protected Point point;

    public GraphicObject(){
        this.point = new Point();
    }

    public GraphicObject(GraphicObjectBuilder graphicObjectBuilder){
        this.left = graphicObjectBuilder.left;
        this.top = graphicObjectBuilder.top;
        this.right = graphicObjectBuilder.right;
        this.bottom = graphicObjectBuilder.bottom;
        this.xSpeed = graphicObjectBuilder.xSpeed;
        this.ySpeed = graphicObjectBuilder.ySpeed;
        this.rigthBound = graphicObjectBuilder.rightBound;
        this.leftBound = graphicObjectBuilder.leftBound;
        this.point = new Point((this.left + this.right) /2,(this.top + this.bottom) /2);
    }

    public static abstract class GraphicObjectBuilder {

        private int left, top, right, bottom, xSpeed, ySpeed, leftBound, rightBound;

        public GraphicObjectBuilder setLeft(int x){
            this.left = x;
            return this;
        }

        public GraphicObjectBuilder setTop(int y){
            this.top = y;
            return this;
        }

        public GraphicObjectBuilder setRight(int witdh){
            this.right = witdh;
            return this;
        }

        public GraphicObjectBuilder setBottom(int height){
            this.bottom = height;
            return this;
        }

        public GraphicObjectBuilder setXSpeed(int xSpeed){
            if(xSpeed < 0)
                throw new IllegalArgumentException("No pueden existitr velocidades negativas de movimiento");
            this.xSpeed = xSpeed;
            return this;
        }

        public GraphicObjectBuilder setYSpeed(int ySpeed){
            if(ySpeed < 0)
                throw new IllegalArgumentException("No pueden existitr velocidades negativas de movimiento");
            this.ySpeed = ySpeed;
            return this;
        }

        public GraphicObjectBuilder setRightBound(int yLimit){
            this.rightBound = yLimit;
            return this;
        }

        public GraphicObjectBuilder setLeftBound(int xLimit){
            this.leftBound = xLimit;
            return this;
        }

        public abstract GraphicObject build();

    }


    public int getxSpeed() {return xSpeed;}

    public void setxSpeed(int xSpeed) {this.xSpeed = xSpeed;}

    public int getySpeed() {return ySpeed;}

    public void setySpeed(int ySpeed) {this.ySpeed = ySpeed;}

    public int getLeftBound() {
        return leftBound;
    }

    public void setLeftBound(int leftBound) {
        this.leftBound = leftBound;
    }

    public int getRigthBound() {
        return rigthBound;
    }

    public void setRigthBound(int rigthBound) {
        this.rigthBound = rigthBound;
    }

    public void increaseYSpeedBy(int ammounOfSpeed){
        if(ammounOfSpeed <= 0)
            throw  new IllegalArgumentException("No pueden existir velocidades nulas o negativas de movimiento");
        this.ySpeed += ammounOfSpeed;
    }

    public void decreaseYSpeedBy(int ammounOfSpeed){
        if(ammounOfSpeed <= 0)
            throw  new IllegalArgumentException("No pueden existir velocidades nulas o negativas de movimiento");
        this.ySpeed -= ammounOfSpeed;
    }

    public void increaseXSpeedBy(int ammounOfSpeed){
        if(ammounOfSpeed <= 0)
            throw  new IllegalArgumentException("No pueden existir velocidades nulas o negativas de movimiento");
        this.xSpeed += ammounOfSpeed;
    }

    public void decreaseXSpeedBy(int ammounOfSpeed){
        if(ammounOfSpeed <= 0)
            throw  new IllegalArgumentException("No pueden existir velocidades nulas o negativas de movimiento");
        this.xSpeed -= ammounOfSpeed;
    }

    public void setHealthStats (HealthStats healthStats){ this.healthStats = healthStats;}

    public HealthStats getHealthStats(){return this.healthStats;}

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public Point getPoint(){return this.point;}

    public void moveRight(){ this.point.x++;}

    public void moveLeft(){this.point.x--;}

    public void moveDown(){ this.point.y++;}

    public void moveUp(){this.point.y--;}

    public void setShootingCapability(Shooter shootingCapability){this.shootingCapability = shootingCapability;}

    public Shooter getShootingCapability(){return this.shootingCapability;}

    private boolean contains(GraphicObject graphicObject){
        return (graphicObject.left >= this.left && graphicObject.left <= this.right)
                &&(graphicObject.top >= this.top && graphicObject.top <= this.bottom);
    }

    public boolean crashes(GraphicObject graphicObject){
        return this.contains(graphicObject) || graphicObject.contains(this);
    }

}
