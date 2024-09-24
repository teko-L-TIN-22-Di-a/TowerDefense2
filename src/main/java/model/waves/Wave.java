package model.waves;

/**
 * Die Klasse Wave beinhaltet repräsentiert eine Gegnerwelle.
 * Diese Klasse beinhaltet Informationen, welche genutzt werden, um Gegner zu generieren.
 */
public class Wave {
    /**
     * Anzahl Standardgegner
     */
    private int normalEnemyCount;
    /**
     * Anzahl schnelle Gegner
     */
    private int fastEnemyCount;
    /**
     * Anzahl Elitegegner
     */
    private int eliteEnemyCount;

    /**
     * Ein leerer Konstruktor wird für die Jackson Library vorausgesetzt, um die Wellen aus einer JSON Datei einzulesen.
     */
    public Wave() {}

    /**
     * Konstruktor
     * @param normalEnemyCount Anzahl Standardgegner
     * @param fastEnemyCount Anzahl schnelle Gegner
     * @param eliteEnemyCount Anzahl Elitegegner
     */
    public Wave(int normalEnemyCount, int fastEnemyCount, int eliteEnemyCount) {
        this.normalEnemyCount = normalEnemyCount;
        this.fastEnemyCount = fastEnemyCount;
        this.eliteEnemyCount = eliteEnemyCount;
    }

    /**
     * Getter, gibt die Anzahl der Standardgegner zurück
     * @return int normalEnemyCount
     */
    public int getNormalEnemyCount() {
        return normalEnemyCount;
    }

    /**
     * Getter, gibt die Anzahl der schnellen Gegner zurück
     * @return int fastEnemyCount
     */
    public int getFastEnemyCount() {
        return fastEnemyCount;
    }

    /**
     * Getter, gibt die Anzahl der Elitegegner zurück
     * @return int eliteEnemyCount
     */
    public int getEliteEnemyCount() {
        return eliteEnemyCount;
    }

    /**
     * Anzahl Gegner in einer Welle inkrementieren (Endless Modus)
     */
    public void incrementEnemyCount() {
        this.normalEnemyCount++;
        this.fastEnemyCount++;
        this.eliteEnemyCount++;
    }
}