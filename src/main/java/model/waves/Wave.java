package model.waves;

public class Wave {
    private int normalEnemyCount;
    private int fastEnemyCount;
    private int eliteEnemyCount;

    public Wave(int normalEnemyCount, int fastEnemyCount, int eliteEnemyCount) {
        this.normalEnemyCount = normalEnemyCount;
        this.fastEnemyCount = fastEnemyCount;
        this.eliteEnemyCount = eliteEnemyCount;
    }

    public int getNormalEnemyCount() {
        return normalEnemyCount;
    }

    public int getFastEnemyCount() {
        return fastEnemyCount;
    }

    public int getEliteEnemyCount() {
        return eliteEnemyCount;
    }
}
