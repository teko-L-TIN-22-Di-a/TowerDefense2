package controller;

import model.GameModel;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

/**
 * Die Klasse GameController repräsentiert das View im MVC Pattern.
 * Diese Klasse steuert via diverse Manager die Spieldaten an, welche im GameModel gespeichert sind
 */
public class GameController {
    /**
     * Instanz der Klasse GameModel, beinhaltet den Spielzustand
     */
    private GameModel model;
    /**
     * Instanz der Klasse WaypointManager, steuert die Waypoints an
     */
    private WaypointManager waypointManager;
    /**
     * Instanz der Klasse EnemyManager, steuert die Gegner an
     */
    private EnemyManager enemyManager;
    /**
     * Instanz der Klasse TowerManager, steuert die Türme an
     */
    private TowerManager towerManager;
    /**
     * Instanz der Klasse WaveManager, steuert die Gegnerwellen an
     */
    private WaveManager waveManager;
    /**
     * Instanz der Klasse PlayerManager, steuert die Spielerdaten an
     */
    private PlayerManager playerManager;

    /**
     * Konstruktor
     * @param model Instanz der Klasse GameModel
     */
    public GameController(GameModel model) {
        this.model = model;
        this.waypointManager = new WaypointManager(model);
        this.playerManager = new PlayerManager(model);
        this.enemyManager = new EnemyManager(model, playerManager);
        this.towerManager = new TowerManager(model, playerManager, enemyManager);
        this.waveManager = new WaveManager(model);
    }

    /**
     * Mausklick verarbeiten und versuchen einen Turm zu platzieren
     * @param e MouseEvent
     */
    public void handleMouseClick(MouseEvent e) {
        // Links und Rechtsklick unterscheiden

        if (e.getButton() == MouseEvent.BUTTON1) {
            Point2D.Double clickLocation = new Point2D.Double(e.getX(), e.getY());
            towerManager.addTower(clickLocation);
        }

        else if (e.getButton() == MouseEvent.BUTTON3) {
            towerManager.cycleTowerType();
            System.out.println("right click");
        }

    }

    /**
     * Waypoints ins Model aufnehnen
     */
    public void addWaypoints() {
        waypointManager.addWaypoints();
    }

    /**
     * Gegnerwellen aktualisieren
     */
    public void updateWaves() {
        waveManager.updateWaves();
    }

    /**
     * Gegner aktualisieren
     */
    public void updateEnemies() {
        enemyManager.spawnEnemies();
        enemyManager.updateEnemies();
    }

    /**
     * Türme aktualisieren
     */
    public void updateTowers() {
        towerManager.updateTowers();
    }

    /**
     * Spiel gewonnen?
     * @return boolean
     */
    public boolean playerWon() {
        // Spiel gewonnen, wenn alle Gegner getötet wurde und die Wave Queue leer ist
        return (model.getEnemies().isEmpty() && model.getWavesQueue().isEmpty());
    }

    /**
     * Spiel verloren?
     * @return boolean
     */
    public boolean playerLost() {
        // Spiel verloren, wenn keine der Spieler keine Lebenspunkte mehr hat
        return model.getPlayer().getHealth() <= 0;
    }
}