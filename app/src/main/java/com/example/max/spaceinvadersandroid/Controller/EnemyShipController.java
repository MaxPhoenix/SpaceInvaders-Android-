package com.example.max.spaceinvadersandroid.Controller;

import com.example.max.spaceinvadersandroid.DM.Direction;
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

    public EnemyShipController(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.enemyShipsList = new ArrayList<EnemyShip>();
        this.enemyShipsMatrix = new EnemyShip[rows][columns];
        this.shooterShips = new Boolean [rows][columns];
    }

    public EnemyShip searchShipBy(int row, int column){
        return this.enemyShipsMatrix[row][column];
    }

    public void makeShipShooter(int row, int column){
        if(enemyShipsMatrix[row][column].isLastRow())
            this.enemyShipsMatrix[row][column].setShootingCapability(new ItShoots());
    }

    public void moveEnemyShipsHorizontally(){
        for(int i = 0; i < this.enemyShipsList.size(); i++){
            EnemyShip enemy = enemyShipsList.get(i);
            if(enemy.getPoint().x  < enemy.getRigthBound() && enemy.getDirection() == Direction.RIGHT) {
                enemy.moveRight();
            }
            else if(enemy.getPoint().x  == enemy.getRigthBound() && enemy.getDirection() == Direction.RIGHT){
                enemy.moveLeft();
                enemy.setDirection(Direction.LEFT);
            }
            if(enemy.getPoint().x  > enemy.getLeftBound() && enemy.getDirection() == Direction.LEFT) {
                enemy.moveLeft();

            }
            else if(enemy.getPoint().x  == enemy.getLeftBound() && enemy.getDirection() == Direction.LEFT){
                enemy.moveRight();
                enemy.setDirection(Direction.RIGHT);
            }
        }
    }

    private void moveShipsRight(){}

    public void setEnemyShips(int width, int height){
        EnemyShip enemy = null;
        int startY = height / 9; //dibujado de primer fila
        int bottom = startY + 100;

        for(int currentRow = 0; currentRow < rows ; currentRow++) {
            int startX = width / 11; //dibujado de primer columna

            int leftBound = startX ; //limite izq. para mov. de naves
            int rightBound = startX + 150;   //limite der. para movimiento de naves

            for (int currentColumn = 0; currentColumn < columns; currentColumn++){

                enemy = (EnemyShip) new EnemyShip.EnemyShipBuilder()
                        .setColumn(currentColumn)
                        .setRow(currentRow)
                        .setHealth(100)
                        .setRight(rightBound)
                        .setBottom(bottom)
                        .setLeft(startX)
                        .setTop(startY)
                        .setLeftBound(leftBound)
                        .setRightBound(rightBound)
                        .setXSpeed(1)
                        .setYSpeed(1)
                        .build();


                if(currentRow == rows-1){  // si esta en la ultima fila, puede disparar
                    enemy.setShootingCapability(new ItShoots());
                }
                enemyShipsList.add(enemy);
                enemyShipsMatrix[currentRow][currentColumn] = enemy;

                startX = rightBound + 100 ;
                leftBound = startX;
                rightBound = startX + 150;
            }

            startY  =  bottom + 100;
            bottom = startY + 100;
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
            enemy.moveUp();
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

    public ArrayList<EnemyShip> getEnemyShipsList() {
        return enemyShipsList;
    }
}
