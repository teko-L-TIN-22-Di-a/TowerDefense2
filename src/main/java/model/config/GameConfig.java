package model.config;

public class GameConfig {
    final private int delayBetweenEnemies;
    final private int delayBetweenWaves;
    final private int startingHealth;
    final private int startingCoins;
    final private int basicTowerCost;
    final private int basicTowerCooldown;
    final private int basicTowerRange;

    public GameConfig(int delayBetweenEnemies,
                      int delayBetweenWaves,
                      int startingHealth,
                      int startingCoins,
                      int basicTowerCost,
                      int basicTowerCooldown,
                      int basicTowerRange) {
        this.delayBetweenEnemies = delayBetweenEnemies;
        this.delayBetweenWaves = delayBetweenWaves;
        this.startingHealth = startingHealth;
        this.startingCoins = startingCoins;
        this.basicTowerCost = basicTowerCost;
        this.basicTowerCooldown = basicTowerCooldown;
        this.basicTowerRange = basicTowerRange;
    }

    public int getDelayBetweenEnemies() {
        return delayBetweenEnemies;
    }

    public int getDelayBetweenWaves() {
        return delayBetweenWaves;
    }

    public int getStartingHealth() {
        return startingHealth;
    }

    public int getStartingCoins() {
        return startingCoins;
    }

    public int getBasicTowerCost() {
        return basicTowerCost;
    }

    public int getBasicTowerCooldown() {
        return basicTowerCooldown;
    }

    public int getBasicTowerRange() {
        return  basicTowerRange;
    }
}
