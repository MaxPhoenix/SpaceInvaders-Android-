package com.example.max.spaceinvadersandroid.DM;

/**
 * Created by Max on 1/26/2018.
 */

public class Player {

    private int score, lifes;
    private String name;

    public Player(String name){
        this.name = name;
    }

    public void increaseScoreBy(int score){
        this.score += score;
    }

    public void decreaseLifes() {this.lifes--;}

}
