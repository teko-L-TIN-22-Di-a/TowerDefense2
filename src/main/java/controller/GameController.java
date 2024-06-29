package controller;

import model.GameModel;
import model.waves.Wave;

public class GameController {
    private GameModel model;
    private WaypointManager waypointManager;
    private EnemyManager enemyManager;
    private WaveManager waveManager;

    public GameController(GameModel model) {
        this.model = model;
        this.waypointManager = new WaypointManager(model);
        this.enemyManager = new EnemyManager(model);
        this.waveManager = new WaveManager(model);
    }

    public void addWaypoints() {
        waypointManager.addWaypoints();
    }

    // dev
    public void updateWaves() {
        waveManager.updateWaves();
    }

    public void updateEnemies() {
        enemyManager.spawnEnemies();
        enemyManager.updateEnemies();
    }


}