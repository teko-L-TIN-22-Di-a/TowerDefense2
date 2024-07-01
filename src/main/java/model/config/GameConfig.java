package model.config;

/**
 * Die Klasse GameConfig beinhaltet Werte und Einstellungen, welchen einen Einfluss auf die Spielmechanik haben.
 * Diese Informationen werden mittels der Util Klasse GameConfigLoader aus gameConfig.properties eingelesen
 */
public class GameConfig {
    /**
     * View: Anzahl Zeilen auf dem Spielfeld
     */
    private final int rows;
    /**
     * View: Anzahl Spalten auf dem Spielfeld
     */
    private final int columns;
    /**
     * View: Kachelgrösse auf dem Spielfeld
     */
    private final int tileSize;
    /**
     * Verzögerung beim Erstellen der Gegnerinstanzen
     */
    private final int delayBetweenEnemies;
    /**
     * Verzögerung zwischen den Gegnerwellen
     */
    private final int delayBetweenWaves;
    /**
     * Anzahl Lebenspunkte, die der Spieler am Anfang des Spiels hat
     */
    private final int startingHealth;
    /**
     * Anzahl Münzen, die der Spieler am Anfang des Spiels hat
     */
    private final int startingCoins;
    /**
     * Anzahl Münzen, die es braucht, um einen Basic Tower zu bauen
     */
    private final int basicTowerCost;
    /**
     * Anzahl Millisekunden, die nach einem Angriff vergehen müssen, bis der Basic Tower wieder angreifen darf
     */
    private final int basicTowerCooldown;
    /**
     * Reichweite des Turmes Basic Tower
     */
    private final int basicTowerRange;
    /**
     * Anzahl Schadenspunkte, die ein Basic Tower anrichtet
     */
    private final int basicTowerDamage;

    /**
     * Singleton: privater Konstruktor
     * @param rows Anzahl Zeilen auf dem Spielfeld
     * @param columns Anzahl Spalten auf dem Spielfeld
     * @param tileSize Kachelgrösse auf dem Spielfeld
     * @param delayBetweenEnemies Verzögerung beim Erstellen der Gegnerinstanzen
     * @param delayBetweenWaves Verzögerung zwischen den Gegnerwellen
     * @param startingHealth Anzahl Lebenspunkte, die der Spieler am Anfang des Spiels hat
     * @param startingCoins Anzahl Münzen, die der Spieler am Anfang des Spiels hat
     * @param basicTowerCost Anzahl Münzen, die es braucht, um einen Basic Tower zu bauen
     * @param basicTowerCooldown Anzahl Millisekunden, die nach einem Angriff vergehen müssen, bis der Basic Tower wieder angreifen darf
     * @param basicTowerRange Reichweite des Turmes Basic Tower
     * @param basicTowerDamage Anzahl Schadenspunkte, die ein Basic Tower anrichtet
     */
    public GameConfig(
            int rows,
            int columns,
            int tileSize,
            int delayBetweenEnemies,
            int delayBetweenWaves,
            int startingHealth,
            int startingCoins,
            int basicTowerCost,
            int basicTowerCooldown,
            int basicTowerRange,
            int basicTowerDamage) {
        this.rows = rows;
        this.columns = columns;
        this.tileSize = tileSize;
        this.delayBetweenEnemies = delayBetweenEnemies;
        this.delayBetweenWaves = delayBetweenWaves;
        this.startingHealth = startingHealth;
        this.startingCoins = startingCoins;
        this.basicTowerCost = basicTowerCost;
        this.basicTowerCooldown = basicTowerCooldown;
        this.basicTowerRange = basicTowerRange;
        this.basicTowerDamage = basicTowerDamage;
    }

    /**
     * Getter, gibt die Anzahl Zeilen auf dem Spielfeld zurück
     * @return int rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * Getter, gibt die Anzahl Spalten auf dem Spielfeld zurück
     * @return int columns
     */
    public int getColumns() {
        return columns;
    }

    /**
     * Getter, gibt die Kachelgrösse auf dem Spielfeld zurück
     */
    public int getTileSize() {
        return tileSize;
    }

    /**
     * Getter, gibt die Verzögerung beim Erstellen der Gegnerinstanzen zurück
     * @return int delayBetweenEnemies
     */
    public int getDelayBetweenEnemies() {
        return delayBetweenEnemies;
    }

    /**
     * Getter, gibt die Verzögerung zwischen den Gegnerwellen zurück
     * @return int delayBetweenWaves
     */
    public int getDelayBetweenWaves() {
        return delayBetweenWaves;
    }

    /**
     * Getter, gibt die Anzahl Lebenspunkte zurück, die der Spieler am Anfang des Spiels hat
     * @return int startingHealth
     */
    public int getStartingHealth() {
        return startingHealth;
    }

    /**
     * Getter, gibt die Anzahl Münzen zurück, die der Spieler am Anfang des Spiels hat
     * @return int startingCoins
     */
    public int getStartingCoins() {
        return startingCoins;
    }

    /**
     * Getter, gibt die Anzahl Münzen zurück, die es braucht, um einen Basic Tower zu bauen
     * @return
     */
    public int getBasicTowerCost() {
        return basicTowerCost;
    }

    /**
     * Getter, gibt die Anzahl Millisekunden zurück, die nach einem Angriff vergehen müssen, bis der Basic Tower wieder angreifen darf
     * @return
     */
    public int getBasicTowerCooldown() {
        return basicTowerCooldown;
    }

    /**
     * Getter, gibt die Reichweite des Turmes Basic Tower zurück
     * @return
     */
    public int getBasicTowerRange() {
        return  basicTowerRange;
    }

    /**
     * Getter, gibt die Anzahl Schadenspunkte zurück, die ein Basic Tower anrichtet
     * @return
     */
    public int getBasicTowerDamage() {
        return basicTowerDamage;
    }
}
