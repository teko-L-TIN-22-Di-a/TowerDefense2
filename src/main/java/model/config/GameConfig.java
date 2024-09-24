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
     * Gegner endlos generieren, nachdem das JSON abgearbeitet wurde
     */
    private final boolean endlessEnemiesMode;
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
     * Anzahl Münzen, die es braucht, um einen Teleporting Tower zu bauen
     */
    private final int teleportingTowerCost;
    /**
     * Anzahl Millisekunden, die nach einem Angriff vergehen müssen, bis der Teleporting Tower wieder angreifen darf
     */
    private final int teleportingTowerCooldown;
    /**
     * Reichweite des Turmes Teleporting Tower
     */
    private final int teleportingTowerRange;
    /**
     * Anzahl Schadenspunkte, die ein Teleporting Tower anrichtet
     */
    private final int teleportingTowerDamage;
    /**
     * Anzahl Münzen, die es braucht, um einen fFreezing Tower zu bauen
     */
    private final int freezingTowerCost;
    /**
     * Anzahl Millisekunden, die nach einem Angriff vergehen müssen, bis der Freezing Tower wieder angreifen darf
     */
    private final int freezingTowerCooldown;
    /**
     * Reichweite des Turmes Freezing Tower
     */
    private final int freezingTowerRange;
    /**
     * Anzahl Schadenspunkte, die ein Freezing Tower anrichtet
     */
    private final int freezingTowerDamage;

    /**
     * Singleton: privater Konstruktor
     * @param rows Anzahl Zeilen auf dem Spielfeld
     * @param columns Anzahl Spalten auf dem Spielfeld
     * @param tileSize Kachelgrösse auf dem Spielfeld
     * @param delayBetweenEnemies Verzögerung beim Erstellen der Gegnerinstanzen
     * @param delayBetweenWaves Verzögerung zwischen den Gegnerwellen
     * @param endlessEnemiesMode Gegner endlos generieren, nachdem das JSON abgearbeitet wurde
     * @param startingHealth Anzahl Lebenspunkte, die der Spieler am Anfang des Spiels hat
     * @param startingCoins Anzahl Münzen, die der Spieler am Anfang des Spiels hat
     * @param basicTowerCost Anzahl Münzen, die es braucht, um einen Basic Tower zu bauen
     * @param basicTowerCooldown Anzahl Millisekunden, die nach einem Angriff vergehen müssen, bis der Basic Tower wieder angreifen darf
     * @param basicTowerRange Reichweite des Turmes Basic Tower
     * @param basicTowerDamage Anzahl Schadenspunkte, die ein Basic Tower anrichtet
     * @param teleportingTowerCost Anzahl Münzen, die es braucht, um einen Teleporting Tower zu bauen
     * @param teleportingTowerCooldown Anzahl Millisekunden, die nach einem Angriff vergehen müssen, bis der Teleporting Tower wieder angreifen darf
     * @param teleportingTowerRange Reichweite des Turmes Teleporting Tower
     * @param teleportingTowerDamage Anzahl Schadenspunkte, die ein Teleporting Tower anrichtet
     * @param freezingTowerCost Anzahl Münzen, die es braucht, um einen Freezing Tower zu bauen
     * @param freezingTowerCooldown Anzahl Millisekunden, die nach einem Angriff vergehen müssen, bis der Freezing Tower wieder angreifen darf
     * @param freezingTowerRange Reichweite des Turmes Freezing Tower
     * @param freezingTowerDamage Anzahl Schadenspunkte, die ein Freezing Tower anrichtet
     */
    public GameConfig(
            int rows,
            int columns,
            int tileSize,
            int delayBetweenEnemies,
            int delayBetweenWaves,
            boolean endlessEnemiesMode,
            int startingHealth,
            int startingCoins,
            int basicTowerCost,
            int basicTowerCooldown,
            int basicTowerRange,
            int basicTowerDamage,
            int teleportingTowerCost,
            int teleportingTowerCooldown,
            int teleportingTowerRange,
            int teleportingTowerDamage,
            int freezingTowerCost,
            int freezingTowerCooldown,
            int freezingTowerRange,
            int freezingTowerDamage) {
        this.rows = rows;
        this.columns = columns;
        this.tileSize = tileSize;
        this.delayBetweenEnemies = delayBetweenEnemies;
        this.delayBetweenWaves = delayBetweenWaves;
        this.endlessEnemiesMode = endlessEnemiesMode;
        this.startingHealth = startingHealth;
        this.startingCoins = startingCoins;
        this.basicTowerCost = basicTowerCost;
        this.basicTowerCooldown = basicTowerCooldown;
        this.basicTowerRange = basicTowerRange;
        this.basicTowerDamage = basicTowerDamage;
        this.teleportingTowerCost = teleportingTowerCost;
        this.teleportingTowerCooldown = teleportingTowerCooldown;
        this.teleportingTowerRange = teleportingTowerRange;
        this.teleportingTowerDamage = teleportingTowerDamage;
        this.freezingTowerCost = freezingTowerCost;
        this.freezingTowerCooldown = freezingTowerCooldown;
        this.freezingTowerRange = freezingTowerRange;
        this.freezingTowerDamage = freezingTowerDamage;
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
     * Getter, gibt den Wert zurück, ob die Gegnerwellen unendlich gespanwed werden sollen
     * @return boolean endlessEnemies
     */
    public boolean getEndlessEnemiesMode() {
        return endlessEnemiesMode;
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
     * @return int basicTowerCost
     */
    public int getBasicTowerCost() {
        return basicTowerCost;
    }

    /**
     * Getter, gibt die Anzahl Millisekunden zurück, die nach einem Angriff vergehen müssen, bis der Basic Tower wieder angreifen darf
     * @return int basicTowerCooldown
     */
    public int getBasicTowerCooldown() {
        return basicTowerCooldown;
    }

    /**
     * Getter, gibt die Reichweite des Turmes Basic Tower zurück
     * @return int basicTowerRange
     */
    public int getBasicTowerRange() {
        return  basicTowerRange;
    }

    /**
     * Getter, gibt die Anzahl Schadenspunkte zurück, die ein Basic Tower anrichtet
     * @return int basicTowerDamage
     */
    public int getBasicTowerDamage() {
        return basicTowerDamage;
    }

    /**
     * Getter, gibt die Anzahl Münzen zurück, die es braucht, um einen Teleporting Tower zu bauen
     * @return int basicTowerCost
     */
    public int getTeleportingTowerCost() {
        return teleportingTowerCost;
    }

    /**
     * Getter, gibt die Anzahl Millisekunden zurück, die nach einem Angriff vergehen müssen, bis der Teleporting Tower wieder angreifen darf
     * @return int basicTowerCooldown
     */
    public int getTeleportingTowerCooldown() {
        return teleportingTowerCooldown;
    }

    /**
     * Getter, gibt die Reichweite des Turmes Teleporting Tower zurück
     * @return int basicTowerRange
     */
    public int getTeleportingTowerRange() {
        return  teleportingTowerRange;
    }

    /**
     * Getter, gibt die Anzahl Schadenspunkte zurück, die ein Teleporting Tower anrichtet
     * @return int basicTowerDamage
     */
    public int getTeleportingTowerDamage() {
        return teleportingTowerDamage;
    }

    /**
     * Getter, gibt die Anzahl Münzen zurück, die es braucht, um einen Freezing Tower zu bauen
     * @return int basicTowerCost
     */
    public int getFreezingTowerCost() {
        return freezingTowerCost;
    }

    /**
     * Getter, gibt die Anzahl Millisekunden zurück, die nach einem Angriff vergehen müssen, bis der Freezing Tower wieder angreifen darf
     * @return int basicTowerCooldown
     */
    public int getFreezingTowerCooldown() {
        return freezingTowerCooldown;
    }

    /**
     * Getter, gibt die Reichweite des Turmes Freezing Tower zurück
     * @return int basicTowerRange
     */
    public int getFreezingTowerRange() {
        return  freezingTowerRange;
    }

    /**
     * Getter, gibt die Anzahl Schadenspunkte zurück, die ein Freezing Tower anrichtet
     * @return int basicTowerDamage
     */
    public int getFreezingTowerDamage() {
        return freezingTowerDamage;
    }
}
