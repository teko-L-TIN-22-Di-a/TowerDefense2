package model.config;

public class GameConfig {
    final private int delayBetweenEnemies;
    final private int delayBetweenWaves;
    final private int startingHealth;
    final private int startingCoins;
    final private int basicTowerCost;

    public GameConfig(int delayBetweenEnemies,
                      int delayBetweenWaves,
                      int startingHealth,
                      int startingCoins,
                      int basicTowerCost) {
        this.delayBetweenEnemies = delayBetweenEnemies;
        this.delayBetweenWaves = delayBetweenWaves;
        this.startingHealth = startingHealth;
        this.startingCoins = startingCoins;
        this.basicTowerCost = basicTowerCost;
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
}
