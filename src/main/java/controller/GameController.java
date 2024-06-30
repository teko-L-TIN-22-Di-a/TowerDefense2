package controller;

import model.GameModel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class GameController {
    private GameModel model;
    private WaypointManager waypointManager;
    private EnemyManager enemyManager;
    private TowerManager towerManager;
    private WaveManager waveManager;
    private PlayerManager playerManager;

    public GameController(GameModel model) {
        this.model = model;
        this.waypointManager = new WaypointManager(model);
        this.playerManager = new PlayerManager(model);
        this.enemyManager = new EnemyManager(model, playerManager);
        this.towerManager = new TowerManager(model, playerManager);
        this.waveManager = new WaveManager(model);
    }

    public void handleMouseClick(MouseEvent e) {
        // DEV
        Point2D.Double clickLocation = new Point2D.Double(e.getX(), e.getY());
        towerManager.addTower(clickLocation);
    }

    public void addWaypoints() {
        waypointManager.addWaypoints();
    }

    // DEV
    public void addTower(Point2D.Double location) {
        towerManager.addTower(location);
    }

    public void updateWaves() {
        waveManager.updateWaves();
    }

    public void updateEnemies() {
        enemyManager.spawnEnemies();
        enemyManager.updateEnemies();
    }

    public void updateTowers() {
        towerManager.updateTowers();
    }


}