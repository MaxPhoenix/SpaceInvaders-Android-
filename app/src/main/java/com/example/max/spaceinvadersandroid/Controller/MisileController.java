package com.example.max.spaceinvadersandroid.Controller;

import com.example.max.spaceinvadersandroid.DM.BulletType;
import com.example.max.spaceinvadersandroid.DM.EnemyShip;
import com.example.max.spaceinvadersandroid.DM.Misile;
import com.example.max.spaceinvadersandroid.DM.SpaceShip;

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

    public void launchEnemyMisile(EnemyShip enemyShip){
        int enemyShipXPos = enemyShip.getX();
        int enemyShipYPos = enemyShip.getY();
        int enemyShipWidth = enemyShip.getWitdh();
        int enemyShipHeiht = enemyShip.getHeight();
        Misile enemyMisile = (Misile) new Misile.MisileBuilder()
                .setAttackPower(1)
                .setX(enemyShipXPos)
                .setY(enemyShipYPos)
                .setWidth(enemyShipWidth)
                .setHeight(enemyShipHeiht)
                .setXSpeed(0)
                .setYSpeed(1)
                .build();
        enemyMisile.setBulletType(BulletType.ENEMY);
        enemyMisiles.add(enemyMisile);
    }

    public void launchPlayerMisile(SpaceShip spaceShip){
        int spaceShipXPos = spaceShip.getX();
        int spaceShipYPos = spaceShip.getY();
        int spaceShipWidth = spaceShip.getWitdh();
        int spaceShipHeiht = spaceShip.getHeight();
        Misile spaceShipMisile = (Misile) new Misile.MisileBuilder()
                .setAttackPower(1)
                .setX(spaceShipXPos)
                .setY(spaceShipYPos)
                .setWidth(spaceShipWidth)
                .setHeight(spaceShipHeiht)
                .setXSpeed(0)
                .setYSpeed(1)
                .build();
        spaceShipMisile.setBulletType(BulletType.ENEMY);
        enemyMisiles.add(spaceShipMisile);
    }

    public void enemyMisileCrash(SpaceShip spaceShip){
        for(int i = 0; i < enemyMisiles.size(); i++) {
            if (enemyMisiles.get(i).crashes(spaceShip)) {
                enemyMisiles.remove(enemyMisiles.get(i));
            }
        }
    }

    public void playerMisileCrash(EnemyShip enemyShip){
        for(int i = 0; i < playerMisiles.size(); i++) {
            if (playerMisiles.get(i).crashes(enemyShip)) {
                playerMisiles.remove(playerMisiles.get(i));
            }
        }
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

    public void moveEnemyBullets(){
        for(int i = 0; i < enemyMisiles.size(); i++)
            enemyMisiles.get(i).moveDown();
    }

    public void movePlayerBullets(){
        for(int i = 0; i < playerMisiles.size(); i++)
            playerMisiles.get(i).moveUP();
    }

    public ArrayList<Misile> getPlayerBullets(){return this.playerMisiles;}

    public ArrayList<Misile> getEnemyMisiles(){ return this.enemyMisiles;}
}
