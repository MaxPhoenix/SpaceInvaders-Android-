package com.example.max.spaceinvadersandroid.DM;

/**
 * Created by Max on 1/26/2018.
 */

public class EnemyShip extends GraphicObject {

    private int health,row,column;
    private static int currentRow,currentColumn;
    private boolean lastRow;
    private Shooter shootCapability;

    public EnemyShip(EnemyShipBuilder enemyShipBuilder) {
        super(enemyShipBuilder);
        this.health = enemyShipBuilder.health;
        this.row = enemyShipBuilder.row;
        this.column = enemyShipBuilder.column;
        this.shootCapability = new CantShoot();
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

    public int getHealth() {return health;}

    public void setHealth(int health) {this.health = health;}

    public void setShootCapability(Shooter shootCapability){ this.shootCapability = shootCapability;}

    public Shooter getShootCapability(){return this.shootCapability;}
}
