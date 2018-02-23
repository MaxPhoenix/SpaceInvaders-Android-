package com.example.max.spaceinvadersandroid.Controller;

import com.example.max.spaceinvadersandroid.DM.HasHealth;
import com.example.max.spaceinvadersandroid.DM.Player;
import com.example.max.spaceinvadersandroid.DM.SpaceShip;

/**
 * Created by Max on 1/26/2018.
 */

public class PlayerShipController {


    private SpaceShip playerShip;
    private Player player;

    public PlayerShipController(){
        this.player = new Player();
        this.playerShip = new SpaceShip();
    }

    public void moveShipUP(int height){
        if(this.playerShip.getTop() > height)
            this.playerShip.moveUp();
    }

    public void moveShipDown(int height){
        if(this.playerShip.getBottom() < height)
            this.playerShip.moveDown();
    }

    public void moveShipLeft(int width){
        if(this.playerShip.getLeft() > width)
            this.playerShip.moveLeft();
    }

    public void moveShipRight(int width){
        if(this.playerShip.getRight() < width)
            this.playerShip.moveRight();
    }

    public void increaseShipXSpeedBy(int ammount){ this.playerShip.increaseXSpeedBy(ammount);}

    public void increaseShipYSpeedBy(int ammount){ this.playerShip.increaseYSpeedBy(ammount);}

    public void decreaseShipYSpeedBy(int ammount){ this.playerShip.decreaseYSpeedBy(ammount);}

    public void decreaseShipXSpeedBy(int ammount){ this.playerShip.decreaseXSpeedBy(ammount);}

    public void decreasePlayerLife(){this.player.decreaseLifes();}

    public void reduceShipHealthBy(int health){this.playerShip.reduceHealthBy(health);}

    public void increasePlayerScoreBy(int score){this.player.increaseScoreBy(score);}

    public void setShipCoordinates(int x, int y, int width, int height){
        this.playerShip.setLeft(x);
        this.playerShip.setTop(y);
        this.playerShip.setRight(width);
        this.playerShip.setBottom(height);
        this.playerShip.setxSpeed(1);
        this.playerShip.getPoint().set((this.playerShip.getLeft() + this.playerShip.getRight()) /2,(this.playerShip.getTop() + this.playerShip.getBottom()) /2);
    }

    public void setXAxisLimitBounds(int width){
        this.playerShip.setRigthBound(width);
        this.playerShip.setLeftBound(0);
    }

    public SpaceShip getPlayerShip() {
        return playerShip;
    }

    public void setPlayerShip(SpaceShip playerShip) {
        this.playerShip = playerShip;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setPlayerName(String name){this.player = new Player(name);}
}
