package com.example.max.spaceinvadersandroid.DM;

/**
 * Created by Max on 1/26/2018.
 */

public class HasHealth implements HealthStats {

    private int health;

    @Override
    public String displayHealth() {
        return "It has health";
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getHealth(){ return this.health;}
}
