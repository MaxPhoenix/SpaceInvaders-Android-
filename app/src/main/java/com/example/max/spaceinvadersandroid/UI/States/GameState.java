package com.example.max.spaceinvadersandroid.UI.States;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.view.MotionEvent;

import com.example.max.spaceinvadersandroid.Controller.EnemyShipController;
import com.example.max.spaceinvadersandroid.Controller.MisileController;
import com.example.max.spaceinvadersandroid.Controller.PlayerShipController;
import com.example.max.spaceinvadersandroid.DM.EnemyShip;
import com.example.max.spaceinvadersandroid.DM.Misile;
import com.example.max.spaceinvadersandroid.UI.Entities.DrawableEnemyShip;
import com.example.max.spaceinvadersandroid.UI.Entities.DrawableMisile;
import com.example.max.spaceinvadersandroid.UI.Entities.DrawableSpaceShip;
import com.example.max.spaceinvadersandroid.UI.Entities.Handler;
import com.example.max.spaceinvadersandroid.UI.GamePanel;

/**
 * Created by Max on 2/11/2018.
 */

public class GameState extends State{

    //resolution
    private int width, height;
    //Game objects handler
    private Handler objectsHandler;
    private DrawableSpaceShip drawableSpaceShip;
    //controllers
    private EnemyShipController enemyShipController;
    private PlayerShipController playerShipController;
    private MisileController misileController;
    private long cont;

    public GameState(GamePanel gamePanel,String playerName) {
        super(gamePanel);
        this.width = GamePanel.getScreenWidth();
        this.height = GamePanel.getScreenHeight();
        this.objectsHandler = new Handler();
        this.enemyShipController = new EnemyShipController(4,4);
        this.misileController = new MisileController();
        this.playerShipController = new PlayerShipController();

        //setting player ship coordinates
        this.playerShipController.setShipCoordinates(
                this.width/2,
                (int)(this.height/1.2),
                this.width/2 +(int)(width / 8.5),
                (int)(this.height/1.2)+(height/20)
        );
        this.playerShipController.setXAxisLimitBounds(this.width);
        this.playerShipController.setPlayerName(playerName);

        this.drawableSpaceShip = new DrawableSpaceShip(playerShipController.getPlayerShip(), Color.rgb(255,0,0));
        this.objectsHandler.addObject(this.drawableSpaceShip);

        this.enemyShipController.setEnemyShips(this.width,this.height);
        for(EnemyShip enemyShip : enemyShipController.getEnemyShipsList()){
            DrawableEnemyShip drawableEnemyShip = new DrawableEnemyShip(enemyShip,Color.rgb(0,0,255));
            objectsHandler.addObject(drawableEnemyShip);
        }
        System.out.println("width" + this.width);
        System.out.println("height" + this.height);

    }

    @Override
    public void tick() {
        this.cont++;
        this.enemyShipController.moveEnemyShipsHorizontally();
        this.misileController.moveEnemyBullets();
        this.misileController.movePlayerBullets();

        if(cont % 100 == 0) {
            for (EnemyShip enemyShip : enemyShipController.getEnemyShipsList()) {
                this.misileController.launchEnemyMisile(enemyShip);
            }
            for (Misile misile : this.misileController.getEnemyMisiles()) {
                DrawableMisile drawableMisile = new DrawableMisile(misile, Color.rgb(0, 255, 0));
                objectsHandler.addObject(drawableMisile);
            }

            this.misileController.launchPlayerMisile(this.playerShipController.getPlayerShip());
            for(Misile misile : this.misileController.getPlayerBullets()){
                DrawableMisile drawableMisile = new DrawableMisile(misile, Color.rgb(0,255,0));
                objectsHandler.addObject(drawableMisile);
            }

        }


        this.objectsHandler.tick();
    }

    @Override
    public void render(Canvas canvas) {
        this.objectsHandler.render(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                this.drawableSpaceShip.getEntity().getPoint().set((int) event.getX(),(int) event.getY());
        }
        return true;
    }

}
