package controller;

import model.GameModel;
import model.enemies.AbstractEnemy;

import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse EnemyManager ist für jegliche Interaktionen mit den Instanzen der Gegnerklassen.
 */
public class EnemyManager {
    /**
     * Instanz der Klasse GameModel, beinhaltet den Spielzustand
     */
    private GameModel model;
    /**
     * Instanz der Klasse PlayerManager, über welche die Spielerdaten angesteuert werden
     */
    private PlayerManager playerManager;
    /**
     * Verzögerung beim Erstellen der Gegnerinstanzen
     */
    private final int delayBetweenEnemies;
    /**
     * Zeitstempel, wann das letzte Erstellen einer Gegnerinstanz stattgefunden hat
     */
    private long lastEnemySpawnTime;

    /**
     * Konstruktor
     * @param model Instanz der Klasse GameModel
     * @param playerManager Instanz der Klasse PlayerManager
     */
    public EnemyManager(GameModel model, PlayerManager playerManager) {
        this.model = model;
        this.delayBetweenEnemies = model.getGameConfig().getDelayBetweenEnemies();
        this.lastEnemySpawnTime = System.currentTimeMillis();
        this.playerManager = playerManager;
    }

    /**
     * Prüft ob der Instanzierungsdelay überschritten wurde, liest einen Gegner
     * aus der SpawningQueue aus und erstellen diesen.
     */
    public void spawnEnemies() {
        long currentTime = System.currentTimeMillis();
        if (!model.getSpawningQueue().isEmpty()) {
            if (currentTime - lastEnemySpawnTime >= delayBetweenEnemies) {
                // Enemy aus der Queue entfernen und rendern lassen
                addEnemy(model.getSpawningQueue().poll());
                lastEnemySpawnTime = currentTime;
            }
        }
    }

    // Einen Gegner direkt in die List aufnehmen, welche gerendert wird

    /**
     * Fügt einen Gegner in die Liste der aktiven Gegner auf dem Spielfeld hinzu
     * @param enemy Instanz der Klasse AbstractEnemy
     */
    public void addEnemy(AbstractEnemy enemy) {
       model.getEnemies().add(enemy);
    }

    /**
     * Richtet einem Gegner Schaden an
     * @param enemy Instanz der Klasse AbstractEnemy
     * @param damage Anzahl Schaden, die einem Gegner angerichtet werden
     */
    public void damageEnemy(AbstractEnemy enemy, int damage) {
        enemy.damageEnemy(damage);
    }

    /**
     * Aktualisiert den Zustand aller Gegner, welche auf dem Spielfeld ersichtlich sind.
     * Hat ein Gegner den letzten Waypoint erreicht, wird er entfernt und dem Spieler werden Lebenspunkte abgezogen.
     * Wurde ein Gegner getötet, wird er entfernt und der Spieler erhält die entsprechende Belohnung.
     */
    public void updateEnemies() {
        List<AbstractEnemy> enemiesToRemove = new ArrayList<>();

        for (AbstractEnemy enemy : model.getEnemies()) {
            enemy.update();

            if (enemy.hasReachedEnd()) {
                playerManager.removeHealth(enemy.getDamage());
                enemiesToRemove.add(enemy);
            }

            if (enemy.isDead()) {
                playerManager.addCoins(enemy.getReward());
                enemiesToRemove.add(enemy);
            }
        }

        model.getEnemies().removeAll(enemiesToRemove);
    }
}
