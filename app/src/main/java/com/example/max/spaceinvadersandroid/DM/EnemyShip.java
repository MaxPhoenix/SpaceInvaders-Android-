package com.example.max.spaceinvadersandroid.DM;

/**
 * Created by Max on 1/26/2018.
 */

public class EnemyShip extends GraphicObject {



    private int health,row,column;
    private static int currentRow,currentColumn;
    private boolean lastRow;
    private Direction direction;


    public EnemyShip(EnemyShipBuilder enemyShipBuilder) {
        super(enemyShipBuilder);
        this.health = enemyShipBuilder.health;
        this.row = enemyShipBuilder.row;
        this.column = enemyShipBuilder.column;
        this.shootingCapability = new CantShoot();
        this.healthStats = new HasHealth();
        this.direction = Direction.RIGHT;
    }

    public static class EnemyShipBuilder extends GraphicObjectBuilder{

        private int health,row,column;

        public EnemyShipBuilder setHealth(int health){
            this.health = health;
            return this;
        }
        public EnemyShipBuilder setRow(int row){
            this.row = row;
            return this;
        }
        public EnemyShipBuilder setColumn(int column){
            this.column = health;
            return this;
        }

        @Override
        public EnemyShip build() {return new EnemyShip(this);}
    }

    public boolean isLastRow() {return lastRow;}

    public void setAsLastRow() {this.lastRow = true;}

    public void setNotAsLastRow() {this.lastRow = false;}

    public int getRow() {return row;}

    public int getColumn() {return column;}

    public static int getCurrentRow() {return currentRow;}

    public static int getCurrentColumn() {return currentColumn;}

    public static void increaseRowNumber(){
        currentRow++;
        if(currentRow > 4)
            currentRow = 0;
    }

    public static void increaseColumnNumber(){
        currentColumn++;
        if(currentColumn > 4)
            currentColumn =0;
    }

    public int getHealth() {return health;}

    public void setHealth(int health) {this.health = health;}

    public void setPosition(int row, int column){this.row = row; this.column = column;}

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public static void setCurrentRow(int currentRow) {
        EnemyShip.currentRow = currentRow;
    }

    public static void setCurrentColumn(int currentColumn) {
        EnemyShip.currentColumn = currentColumn;
    }

    public void setLastRow(boolean lastRow) {
        this.lastRow = lastRow;
    }

    public void setDirection(Direction direction) {this.direction = direction;}

    public Direction getDirection() {return direction;}
}
