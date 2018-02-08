package com.example.max.spaceinvadersandroid.Controller;

import com.example.max.spaceinvadersandroid.DM.Player;
import com.example.max.spaceinvadersandroid.DM.SpaceShip;
import com.example.max.spaceinvadersandroid.UI.Handler;

/**
 * Created by Max on 1/26/2018.
 */

public class PlayerShipController {


    private SpaceShip playerShip;
    private Player player;

    public PlayerShipController(SpaceShip spaceShip, Player player){
       this.playerShip = spaceShip;
       this.player = player;
    }

    public void moveShipUP(int height){
        if(this.playerShip.getY() > height)
            this.playerShip.moveUP();
    }

    public void moveShipDown(int height){
        if(this.playerShip.getY() < height)
            this.playerShip.moveDown();
    }

    public void moveShipLeft(int width){
        if(this.playerShip.getX() > width)
            this.playerShip.moveLeft();
    }

    public void moveShipRight(int width){
        if(this.playerShip.getX() < width)
            this.playerShip.moveRight();
    }

    public void increaseShipXSpeedBy(int ammount){ this.playerShip.increaseXSpeedBy(ammount);}

    public void increaseShipYSpeedBy(int ammount){ this.playerShip.increaseYSpeedBy(ammount);}

    public void decreaseShipYSpeedBy(int ammount){ this.playerShip.decreaseYSpeedBy(ammount);}

    public void decreaseShipXSpeedBy(int ammount){ this.playerShip.decreaseXSpeedBy(ammount);}

    public void decreasePlayerLife(){this.player.decreaseLifes();}

    public void reduceShipHealthBy(int health){this.playerShip.reduceHealthBy(health);}

    public void increasePlayerScoreBy(int score){this.player.increaseScoreBy(score);}

}
