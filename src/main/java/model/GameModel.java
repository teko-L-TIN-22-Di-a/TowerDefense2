package model;

import model.config.GameConfig;
import model.enemies.AbstractEnemy;
import model.player.Player;
import model.towers.AbstractTower;
import model.waves.Wave;
import util.GameConfigLoader;
import util.WaveLoader;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Die Klasse GameModel repräsentiert das Model im MVC Pattern.
 * Diese Klasse beinhaltet den Spielzustand, welcher durch den GameController angesteuert
 * und durch GameView gerendert wird.
 */
public class GameModel {
    /**
     * Instanz der Klasse GameConfig, beinhaltet alle relevanten Spieleinstellungen.
     * Wird aus der Datei gameConfig.properties eingelesen.
     */
    private GameConfig gameConfig;
    /**
     * Liste an Gegner, welche aktuell auf dem Spielfeld sind.
     */
    private List<AbstractEnemy> enemies;
    /**
     * Liste an Gegner, welche aktuell auf dem Spielfeld sind.
     */
    private List<AbstractTower> towers;
    /**
     * Liste an Waypoints, die gebraucht werden, um Gegnerbewegung und Turmpositionierung zu ermöglichen.
     */
    private List<Point2D.Double> waypoints;
    /**
     * Eine Queue an Gegner, welche "gespawned" (in die Liste enemies) nach einer bestimmten Verzögerung aufgenommen werden.
     */
    private Queue<AbstractEnemy> spawningQueue;
    /**
     * Eine Queue an Gegnerwellen, welche noch "gespawned" werden.
     */
    private Queue<Wave> wavesQueue;
    /**
     * Eine Instanz der Klasse Spieler.
     */
    private Player player;

    /**
     * Konstruktor
     */
    public GameModel(){
        System.out.println("GameModel : Constructor");
        this.enemies = new ArrayList<>();
        this.towers = new ArrayList<>();
        this.spawningQueue = new LinkedList<>();
        this.waypoints = new ArrayList<>();
        this.gameConfig = GameConfigLoader.loadConfig("/gameConfig.properties");
        this.wavesQueue = WaveLoader.loadWaves("waves/waves.json");
        this.player = new Player(this.gameConfig.getStartingHealth(), this.gameConfig.getStartingCoins());
    }

    /**
     * Getter, gibt die Instanz der Klasse GameConfig zurück.
     * @return GameConfig gameConfig
     */
    public GameConfig getGameConfig() {
        return gameConfig;
    }

    /**
     * Getter, gibt die Liste der Waypoints zurück.
     * @return List Point2D.Double waypoints
     */
    public List<Point2D.Double> getWaypoints() {
        return waypoints;
    }

    /**
     * Getter, gibt die Liste der Gegner zurück, die aktuell auf dem Spielfeld vorhanden sind.
     * @return List AbstractEnemy enemies
     */
    public List<AbstractEnemy> getEnemies() {
        return enemies;
    }

    /**
     * Getter, gibt die Liste der Türme zurück, die aktuell auf dem Spielfeld vorhanden sind.
     * @return List AbstractTower towers
     */
    public List<AbstractTower> getTowers() {
        return towers;
    }

    /**
     * Getter, gibt die Queue der Gegner zurück, die auf dem Spielfeld erscheinen werden
     * @return Queue AbstractEnemy spawningQueue
     */
    public Queue<AbstractEnemy> getSpawningQueue() {
        return spawningQueue;
    }

    /**
     * Getter, gibt die Queue der Gegnerwellen zurück, die noch ausstehend sind
     * @return Queue Wave wavesQueue;
     */
    public Queue<Wave> getWavesQueue() {
        return wavesQueue;
    }

    /**
     * Getter, gibt die Instanz der Klasse Player zurück
     * @return Player player
     */
    public Player getPlayer() {
        return player;
    }
}
