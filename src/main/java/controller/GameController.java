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
        updateEnemies();
    }

    private void updateEnemies() {
        List<AbstractEnemy> enemiesToRemove = new ArrayList<>();

        for (AbstractEnemy enemy : model.getEnemies()) {
            enemy.update();
            if (enemy.hasReachedEnd() || enemy.isDead()) {
                enemiesToRemove.add(enemy);
            }
        }

        model.getEnemies().removeAll(enemiesToRemove);
    }
}