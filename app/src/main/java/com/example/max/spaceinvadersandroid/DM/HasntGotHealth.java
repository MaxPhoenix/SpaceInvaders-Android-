package com.example.max.spaceinvadersandroid.DM;

/**
 * Created by Max on 1/26/2018.
 */

public class HasntGotHealth implements HealthStats {
    @Override
    public String displayHealth() {
        return "Hasn't got health";
    }

    @Override
    public void setHealth(int health) {

    }

    @Override
    public int getHealth() {
       return Integer.valueOf(null);
    }
}
