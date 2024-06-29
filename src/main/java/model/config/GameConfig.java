package model.config;

public class GameConfig {
    final private int delayBetweenEnemies;
    final private int delayBetweenWaves;

    public GameConfig(int delayBetweenEnemies, int delayBetweenWaves) {
        this.delayBetweenEnemies = delayBetweenEnemies;
        this.delayBetweenWaves = delayBetweenWaves;
    }

    public int getDelayBetweenEnemies() {
        return delayBetweenEnemies;
    }

    public int getDelayBetweenWaves() {
        return delayBetweenWaves;
    }
}
