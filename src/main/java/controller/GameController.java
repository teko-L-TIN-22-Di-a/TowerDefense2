package controller;

import model.GameModel;
import model.enemies.Enemy;
import model.towers.Tower;
import view.GameView;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    private GameModel model;
    private GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void addEnemy(Enemy enemy) {
        model.addEnemy(enemy);
    }

    public void addTower(Tower tower) {
        model.addTower(tower);
    }

    public void addWaypoints(Point2D.Double waypoint) {
        model.addWaypoint(waypoint);
    }

    public void updateEnemies() {
        List<Enemy> enemiesToRemove = new ArrayList<>();

        for (Enemy enemy : model.getEnemies()) {
            enemy.update();
            if (enemy.hasReachedEnd() || enemy.isDead()) {
                enemiesToRemove.add(enemy);
            }
        }

        model.getEnemies().removeAll(enemiesToRemove);
    }
}
