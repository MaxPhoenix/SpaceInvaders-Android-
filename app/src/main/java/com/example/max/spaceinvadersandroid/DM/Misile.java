package com.example.max.spaceinvadersandroid.DM;

/**
 * Created by Max on 1/26/2018.
 */

public class Misile extends GraphicObject {
    private int attackPower;
    private BulletType bulletType;

    public Misile( MisileBuilder misileBuilder) {
        super(misileBuilder);
        this.attackPower = misileBuilder.attackPower;
        this.shootingCapability = new CantShoot();
        this.healthStats = new HasntGotHealth();
    }

    public static class MisileBuilder extends GraphicObjectBuilder{

        private int attackPower;

        public MisileBuilder setAttackPower(int attackPower){
            this.attackPower = attackPower;
            return this;
        }

        @Override
        public Misile build() {return new Misile(this);}
    }

    public int getAttackPower() {return attackPower;}

    public void setAttackPower(int attackPower) {this.attackPower = attackPower;}

    public void setBulletType(BulletType bulletType){ this.bulletType = bulletType;}

    public BulletType getBulletType(){return this.bulletType;}
}
