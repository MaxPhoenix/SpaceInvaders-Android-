package com.example.max.spaceinvadersandroid.DM;

/**
 * Created by Max on 1/26/2018.
 */

public class SpaceShip extends GraphicObject {

    private int health;

    public SpaceShip(SpaceShipBuilder spaceShipBuilder) {
        super(spaceShipBuilder);
        this.health = spaceShipBuilder.health;
    }

    public static class SpaceShipBuilder extends GraphicObjectBuilder{

        private int health;

        public SpaceShipBuilder setHealth(int health){
            this.health = health;
            return this;
        }

        @Override
        public SpaceShip build() {return new SpaceShip(this);}
    }



    public int getHealth() {return health;}

    public void reduceHealthBy(int health) {this.health -= health;}


}
