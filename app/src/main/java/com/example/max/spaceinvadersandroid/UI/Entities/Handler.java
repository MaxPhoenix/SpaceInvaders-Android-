package com.example.max.spaceinvadersandroid.UI.Entities;

import android.graphics.Canvas;
import com.example.max.spaceinvadersandroid.DM.ActiveState;
import com.example.max.spaceinvadersandroid.DM.GraphicObject;

import java.util.ArrayList;

/**
 * Created by Max on 1/26/2018.
 */

public class Handler {


    private ArrayList<DrawableObject> objects = new ArrayList<DrawableObject>();
    private DrawableObjectFactory drawableObjectFactory;


    public Handler(){
        this.drawableObjectFactory = new DrawableObjectFactory();
    }

    public void tick(){
        for(int i = 0; i < getObjectList().size() ; i++){
            if(getObjectList().get(i).getEntity() != null)
                if(getObjectList().get(i).getEntity().getActiveState() == ActiveState.ACTIVE)
                    getObjectList().get(i).tick();
        }
    }

    public void render(Canvas canvas){
        for(int i = 0; i < getObjectList().size() ; i++){
                getObjectList().get(i).render(canvas);
        }
    }

    public void addObject(DrawableObjectType drawableObjectType, GraphicObject graphicObject){
        DrawableObject drawableObject = drawableObjectFactory.drawObjectFromEntity(drawableObjectType,graphicObject);
        this.objects.add(drawableObject);
    }

    public void removeObject(DrawableObject object){this.objects.remove(object);}

    public ArrayList<DrawableObject> getObjectList(){
        return this.objects;
    }

    public void clearInactiveObjects(){
        ArrayList <DrawableObject> newDrawableObjects = new ArrayList<>();
        for(DrawableObject drawableObject : this.objects){
            if(drawableObject.getEntity() != null){
                if(drawableObject.getEntity().getActiveState() == ActiveState.ACTIVE)
                    newDrawableObjects.add(drawableObject);
            }
        }
        this.objects = newDrawableObjects;
    }
}
