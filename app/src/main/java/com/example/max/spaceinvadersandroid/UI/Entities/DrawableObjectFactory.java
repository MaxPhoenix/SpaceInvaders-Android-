package com.example.max.spaceinvadersandroid.UI.Entities;

import android.graphics.Color;
import com.example.max.spaceinvadersandroid.DM.EnemyShip;
import com.example.max.spaceinvadersandroid.DM.GraphicObject;
import com.example.max.spaceinvadersandroid.DM.Misile;
import com.example.max.spaceinvadersandroid.DM.SpaceShip;

public class DrawableObjectFactory {

    public DrawableObjectFactory(){ }

    public DrawableObject drawObjectFromEntity(DrawableObjectType drawableObjectType, GraphicObject entity){
        if(drawableObjectType == drawableObjectType.PLAYERSHIP)
            return new DrawableSpaceShip((SpaceShip) entity,Color.rgb(255,0,0));
        if(drawableObjectType == drawableObjectType.ENEMYSHIP)
            return new DrawableEnemyShip((EnemyShip) entity,Color.rgb(0,0,255));
        if(drawableObjectType == drawableObjectType.MISILE)
            return new DrawableMisile((Misile) entity,Color.rgb(0,255,0));
        return null;
    }
}
