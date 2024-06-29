package controller;

import model.GameModel;
import model.enemies.AbstractEnemy;

import view.GameView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private GameModel model;
    private WaypointManager waypointManager;
    private EnemyManager enemyManager;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.waypointManager = new WaypointManager(model);
        this.enemyManager = new EnemyManager(model);
    }

    public void addWaypoints() {
        waypointManager.addWaypoints();
    }

    public void addEnemy(AbstractEnemy enemy) {
        enemyManager.addEnemy(enemy);
    }

    public void update() {
        enemyManager.spawnEnemies();
        enemyManager.updateEnemies();
    }


}