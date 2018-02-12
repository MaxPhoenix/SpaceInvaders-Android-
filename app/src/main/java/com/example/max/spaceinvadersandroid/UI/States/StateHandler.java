package com.example.max.spaceinvadersandroid.UI.States;

/**
 * Created by Max on 2/11/2018.
 */

public class StateHandler {

    //Static stuff
    private static State currentState;

    public static State getCurrentState(){
        return currentState;
    }

    public static void setCurrentState(State state){
        currentState = state;
    }
}
