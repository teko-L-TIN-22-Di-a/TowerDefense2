package model;

import model.config.GameConfig;
import model.enemies.AbstractEnemy;
import model.player.Player;
import model.waves.Wave;
import util.GameConfigLoader;
import util.WaveLoader;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameModel {
    private GameConfig gameConfig;
    private List<AbstractEnemy> enemies;
    private List<Point2D.Double> waypoints;
    private Queue<AbstractEnemy> spawningQueue;
    private Queue<Wave> wavesQueue;

    private Player player;

    public GameModel(){
        System.out.println("GameModel : Constructor");
        this.enemies = new ArrayList<>();
        this.spawningQueue = new LinkedList<>();
        this.waypoints = new ArrayList<>();
        this.gameConfig = GameConfigLoader.loadConfig("/gameConfig.properties");
        this.wavesQueue = WaveLoader.loadWaves("waves/waves.json");
    }

    public GameConfig getGameConfig() {
        return gameConfig;
    }

    public List<Point2D.Double> getWaypoints() {
        return waypoints;
    }

    public List<AbstractEnemy> getEnemies() {
        return enemies;
    }

    public Queue<AbstractEnemy> getSpawningQueue() {
        return spawningQueue;
    }

    public Queue<Wave> getWavesQueue() {
        return wavesQueue;
    }
}
