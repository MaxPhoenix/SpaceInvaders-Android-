package com.example.max.spaceinvadersandroid.Controller;

import com.example.max.spaceinvadersandroid.DM.EnemyShip;
import com.example.max.spaceinvadersandroid.DM.ItShoots;

import java.util.ArrayList;

/**
 * Created by Max on 2/7/2018.
 */

public class EnemyShipController {

    private ArrayList<EnemyShip> enemyShipsList;
    private EnemyShip [][] enemyShipsMatrix;
    private Boolean [][] shooterShips;
    private int rows, columns;

    public EnemyShipController(){
        this.enemyShipsList = new ArrayList<EnemyShip>();
        this.enemyShipsMatrix = new EnemyShip[rows][columns];
        this.shooterShips = new Boolean [rows][columns];
    }

    public EnemyShip searchShipBy(int row, int column){
        return this.enemyShipsMatrix[row][column];
    }

    public void makeShipShooter(int row, int column){
        if(enemyShipsMatrix[row][column].isLastRow())
            this.enemyShipsMatrix[row][column].setShootCapability(new ItShoots());
    }

    public void moveEnemyShipsHorizontally(){
        for(int i = 0; i < this.enemyShipsList.size(); i++){
            EnemyShip enemy = enemyShipsList.get(i);
            if(enemy.getX() <= enemy.getRigthBound())
                enemy.moveRight();
            else if(enemy.getX() > enemy.getLeftBound())
                enemy.moveLeft();
        }
    }

    public void setEnemyShips(int width, int height){
        EnemyShip enemy = null;
        int startY = height / 9; //dibujado de primer fila

        for(int currentRow = 0; currentRow < rows ; currentRow++) {
            int startX = width / 11; //dibujado de primer columna

            int leftBound = startX - 100; //limite izq. para mov. de naves
            int rightBound = width / 7;   //limite der. para movimiento de naves

            for (int currentColumn = 0; currentColumn < columns; currentColumn++){
                enemy = (EnemyShip) new EnemyShip.EnemyShipBuilder()
                        .setColumn(currentColumn)
                        .setRow(currentRow)
                        .setHealth(100)
                        .setWidth(100)
                        .setHeight(100)
                        .setX(startX)
                        .setY(startY)
                        .setLeftBound(leftBound)
                        .setRightBound(rightBound)
                        .setXSpeed(1)
                        .setYSpeed(1)
                        .build();

                rightBound += 100;
                enemyShipsList.add(enemy);
                enemyShipsMatrix[currentRow][currentColumn] = enemy;
                startX += 100;
            }

            startY += 100;
        }
    }

    public void moveShipsDown(){
        for(int i = 0; i < this.enemyShipsList.size(); i++) {
            EnemyShip enemy = enemyShipsList.get(i);
            enemy.moveDown();
        }
    }

    public void moveShipsUp() {
        for (int i = 0; i < this.enemyShipsList.size(); i++) {
            EnemyShip enemy = enemyShipsList.get(i);
            enemy.moveUP();
        }
    }

    public void increaseEnemyShipsXSpeedBy(int speed){
        for (int i = 0; i < this.enemyShipsList.size(); i++) {
            EnemyShip enemy = enemyShipsList.get(i);
            enemy.increaseYSpeedBy(speed);
        }
    }

    public void increaseEnemyShipsYSpeedBy(int speed){
        for (int i = 0; i < this.enemyShipsList.size(); i++) {
            EnemyShip enemy = enemyShipsList.get(i);
            enemy.increaseYSpeedBy(speed);
        }
    }
}
