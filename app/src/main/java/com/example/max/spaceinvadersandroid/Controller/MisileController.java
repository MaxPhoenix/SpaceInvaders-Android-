package com.example.max.spaceinvadersandroid.Controller;

import com.example.max.spaceinvadersandroid.DM.*;

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

    public Misile launchEnemyMisile(EnemyShip enemyShip){
        int enemyShipXPos = enemyShip.getPoint().x;
        int enemyShipYPos = enemyShip.getPoint().y;

        Misile enemyMisile = (Misile) new Misile.MisileBuilder()
                .setAttackPower(1)
                .setLeft(enemyShipXPos)
                .setTop(enemyShipYPos)
                .setRight(enemyShipXPos + 20)
                .setBottom(enemyShipYPos + 20)
                .setXSpeed(0)
                .setYSpeed(1)
                .build();
        enemyMisile.setBulletType(BulletType.ENEMY);
        enemyMisiles.add(enemyMisile);
        return enemyMisile;
    }

    public Misile launchPlayerMisile(SpaceShip spaceShip){
        int spaceShipXPos = spaceShip.getPoint().x;
        int spaceShipYPos = spaceShip.getPoint().y;

        Misile spaceShipMisile = (Misile) new Misile.MisileBuilder()
                .setAttackPower(1)
                .setLeft(spaceShipXPos)
                .setTop(spaceShipYPos)
                .setRight(spaceShipXPos + 20)
                .setBottom(spaceShipYPos + 20)
                .setXSpeed(0)
                .setYSpeed(1)
                .build();
        spaceShipMisile.setBulletType(BulletType.PLAYER);
        playerMisiles.add(spaceShipMisile);
        return spaceShipMisile;
    }

    public void enemyMisileCrash(SpaceShip spaceShip){
        for(int i = 0; i < enemyMisiles.size(); i++) {
            if (enemyMisiles.get(i).crashes(spaceShip)) {System.out.println(spaceShip);
                spaceShip.reduceHealthBy(enemyMisiles.get(i).getAttackPower());
                enemyMisiles.get(i).setActiveState(ActiveState.INACTIVE);
            }
        }
    }

    public void playerMisileCrash(EnemyShip enemyShip){
        for(int i = 0; i < playerMisiles.size(); i++) {
            if (playerMisiles.get(i).crashes(enemyShip)) {
                enemyShip.reduceHealthBy(playerMisiles.get(i).getAttackPower());
                playerMisiles.get(i).setActiveState(ActiveState.INACTIVE);
            }
        }
    }

    public void removeMisilesOutOfSight(int height){
        for(int i = 0; i < enemyMisiles.size(); i++) {
            if (enemyMisiles.get(i).getBottom() > height) {
                enemyMisiles.get(i).setActiveState(ActiveState.INACTIVE);
            }
        }
        for(int i = 0; i < playerMisiles.size(); i++) {
            if (playerMisiles.get(i).getTop() < height) {
                playerMisiles.get(i).setActiveState(ActiveState.INACTIVE);
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
            playerMisiles.get(i).moveUp();
    }

    public ArrayList<Misile> getPlayerBullets(){return this.playerMisiles;}

    public ArrayList<Misile> getEnemyMisiles(){ return this.enemyMisiles;}

    public void removeInactiveMisilies(){
        ArrayList<Misile> newPlayerMisiles = new ArrayList<>();
        ArrayList<Misile> newEnemyMisiles = new ArrayList<>();

        for(Misile misile : this.playerMisiles){
            if(misile.getActiveState() == ActiveState.ACTIVE){
                newPlayerMisiles.add(misile);
            }
        }

        for(Misile misile : this.enemyMisiles){
            if(misile.getActiveState() == ActiveState.ACTIVE){
                newEnemyMisiles.add(misile);
            }
        }
        this.playerMisiles = newPlayerMisiles;
        this.enemyMisiles = newEnemyMisiles;
    }
}
