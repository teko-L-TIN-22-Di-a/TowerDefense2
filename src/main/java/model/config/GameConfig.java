package model.config;

public class GameConfig {
    private int delayBetweenEnemies;
    private int delayBetweenWaves;

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
