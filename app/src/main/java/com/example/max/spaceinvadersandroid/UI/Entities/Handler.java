package com.example.max.spaceinvadersandroid.UI.Entities;

import android.graphics.Canvas;

import java.util.ArrayList;

/**
 * Created by Max on 1/26/2018.
 */

public class Handler {


    private ArrayList<DrawableObject> objects = new ArrayList<DrawableObject>();

    public void tick(){
        for(int i = 0; i < getObjectList().size() ; i++){
            getObjectList().get(i).tick();
        }
    }

    public void render(Canvas canvas){
        for(int i = 0; i < getObjectList().size() ; i++){
            getObjectList().get(i).render(canvas);
        }
    }

    public void addObject(DrawableObject object){this.objects.add(object);}

    public void removeObject(DrawableObject object){this.objects.remove(object);}

    public ArrayList<DrawableObject> getObjectList(){
        return this.objects;
    }
}
