package com.example.max.spaceinvadersandroid.DM;

/**
 * Created by Max on 1/26/2018.
 */

public class SpaceShip extends GraphicObject {


    public SpaceShip(){}

    public SpaceShip(SpaceShipBuilder spaceShipBuilder) {
        super(spaceShipBuilder);
        this.setHealthStats(new HasHealth());
        this.healthStats.setHealth(100);
        this.shootingCapability = new ItShoots();
        this.healthStats = new HasHealth();
    }

    public static class SpaceShipBuilder extends GraphicObjectBuilder{

        @Override
        public SpaceShip build() {return new SpaceShip(this);}
    }



    public int getHealth() {return this.healthStats.getHealth();}

    @Override
    public String toString() {
        return "SpaceShip{" +
                "left=" + left +
                ", top=" + top +
                ", right=" + right +
                ", bottom=" + bottom +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                ", leftBound=" + leftBound +
                ", rigthBound=" + rigthBound +
                ", healthStats=" + healthStats +
                ", shootingCapability=" + shootingCapability +
                ", point=" + point +
                ", activeState=" + activeState +
                '}';
    }

    public void reduceHealthBy(int health) {
        this.healthStats.setHealth (- health);}


}
