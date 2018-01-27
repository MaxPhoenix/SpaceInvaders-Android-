package com.example.max.spaceinvadersandroid.Controller;

import com.example.max.spaceinvadersandroid.DM.BulletType;
import com.example.max.spaceinvadersandroid.DM.Misile;

import java.util.ArrayList;

/**
 * Created by Max on 1/26/2018.
 */

public class MisileController {

    ArrayList<Misile> enemyMisiles;
    ArrayList<Misile> playerMisiles;

    public MisileController(){
        enemyMisiles = new ArrayList<Misile>();
        playerMisiles = new ArrayList<Misile>();
    }

    public void launchMisile(Misile misile){
        if(misile.getBulletType().equals(BulletType.ENEMY))
            enemyMisiles.add(misile);
        else
            playerMisiles.add(misile);
    }

    public void increasePlayerMisilesSpeedBy(int speedAmmount){
        for(int i = 0; i < playerMisiles.size(); i++)
            playerMisiles.get(i).increaseYSpeedBy(speedAmmount);
    }

    public void increaseEnemyMisilesSpeedBy(int speedAmmount){
        for(int i = 0; i < enemyMisiles.size(); i++)
            enemyMisiles.get(i).increaseYSpeedBy(speedAmmount);
    }

    public void decreasePlayerMisilesSpeedBy(int speedAmmount){
        for(int i = 0; i < playerMisiles.size(); i++)
            playerMisiles.get(i).decreaseYSpeedBy(speedAmmount);
    }

    public void decreaseEnemyMisilesSpeedBy(int speedAmmount){
        for(int i = 0; i < enemyMisiles.size(); i++)
            enemyMisiles.get(i).decreaseYSpeedBy(speedAmmount);
    }

    public ArrayList<Misile> getPlayerBullets(){return this.playerMisiles;}

    public ArrayList<Misile> getEnemyMisiles(){ return this.enemyMisiles;}
}
