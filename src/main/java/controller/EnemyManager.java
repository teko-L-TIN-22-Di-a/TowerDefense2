package controller;

import model.GameModel;
import model.enemies.AbstractEnemy;

import java.util.ArrayList;
import java.util.List;

public class EnemyManager {
    private GameModel model;
    private PlayerManager playerManager;
    private final int delayBetweenEnemies;
    private long lastEnemySpawnTime;

    public EnemyManager(GameModel model, PlayerManager playerManager) {
        this.model = model;
        this.delayBetweenEnemies = model.getGameConfig().getDelayBetweenEnemies();
        this.lastEnemySpawnTime = System.currentTimeMillis();
        this.playerManager = playerManager;
    }

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
    public void addEnemy(AbstractEnemy enemy) {
       model.getEnemies().add(enemy);
    }

    public void damageEnemy(AbstractEnemy enemy, int damage) {
        enemy.damageEnemy(damage);
    }

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
