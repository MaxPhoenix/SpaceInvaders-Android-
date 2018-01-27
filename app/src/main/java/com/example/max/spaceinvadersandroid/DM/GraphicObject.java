package com.example.max.spaceinvadersandroid.DM;

/**
 * Created by Max on 1/26/2018.
 */

public abstract class GraphicObject {

    private int x, y, width, height, xSpeed, ySpeed;
    private HealthStats healthStats;

    public GraphicObject(GraphicObjectBuilder graphicObjectBuilder){
        this.x = graphicObjectBuilder.x;
        this.y = graphicObjectBuilder.y;
        this.width = graphicObjectBuilder.width;
        this.height = graphicObjectBuilder.height;
        this.xSpeed = graphicObjectBuilder.xSpeed;
        this.ySpeed = graphicObjectBuilder.ySpeed;
    }

    public static abstract class GraphicObjectBuilder {

        private int x, y, width, height, xSpeed, ySpeed;

        public GraphicObjectBuilder setX(int x){
            this.x = x;
            return this;
        }

        public GraphicObjectBuilder setY(int y){
            this.y = y;
            return this;
        }

        public GraphicObjectBuilder setWidth(int witdh){
            this.width = witdh;
            return this;
        }

        public GraphicObjectBuilder setHeight(int height){
            this.height = height;
            return this;
        }

        public GraphicObjectBuilder setXSpeed(int xSpeed){
            if(xSpeed <= 0)
                throw new IllegalArgumentException("No pueden existitr velocidades negativas de movimiento");
            this.xSpeed = xSpeed;
            return this;
        }

        public GraphicObjectBuilder setYSpeed(int ySpeed){
            if(ySpeed <= 0)
                throw new IllegalArgumentException("No pueden existitr velocidades negativas de movimiento");
            this.ySpeed = ySpeed;
            return this;
        }

        public abstract GraphicObject build();

    }

    public int getX() {return x;}

    public void setX(int x) {this.x = x;}

    public int getY() {return y;}

    public void setY(int y) {this.y = y;}

    public int getWitdh() {return width;}

    public void setWitdh(int witdh) {this.width = witdh;}

    public int getHeight() {return height;}

    public void setHeight(int height) {this.height = height;}

    public int getxSpeed() {return xSpeed;}

    public void setxSpeed(int xSpeed) {this.xSpeed = xSpeed;}

    public int getySpeed() {return ySpeed;}

    public void setySpeed(int ySpeed) {this.ySpeed = ySpeed;}

    public void moveUP(){this.y -= this.ySpeed;}

    public void moveDown(){this.y += ySpeed;}

    public void moveLeft(){this.x -= this.xSpeed;}

    public void moveRight(){this.x += xSpeed;}

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

}
