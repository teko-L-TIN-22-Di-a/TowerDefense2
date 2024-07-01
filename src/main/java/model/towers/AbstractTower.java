package model.towers;

import model.enemies.AbstractEnemy;

import java.awt.geom.Point2D;

/**
 * Diese Klasse dient als Vorlage für verschiedene Arten von Türme, welche vom Spieler gebaut werden.
 * Die Türme greifen die Gegner an.
 */
public abstract class AbstractTower {
    /**
     * Position des Turmes
     */
    protected Point2D.Double position;
    /**
     * Zeitstempel, wann der der letzte Angriff ausgeführt wurde
     * Wird genutzt, um zu prüfen ob der Turm auf Cooldown ist oder wieder angreifen darf
     */
    protected long lastAttackTimeStamp;
    /**
     * Reichweite des Turmes
     */
    protected int range;
    /**
     * Anzahl Millisekunden, welche der Turm nach einem Angriff abwarten muss, um wieder Angreifen zu können
     */
    protected int cooldown;
    /**
     * Anzahl Schaden, welche der Turm einem Gegner anrichtet
     */
    protected int damage;

    /**
     * Konstruktor
     * @param position Position des Turmes
     * @param cooldown Cooldown des Rurmes
     * @param range Reichweite des Turmes
     * @param damage Anzahl Schadenspunkte, die ein der Turm anrichtet
     */
    public AbstractTower(Point2D.Double position, int cooldown, int range, int damage) {
        this.position = position;
        this.cooldown = cooldown;
        this.range = range;
        this.damage = damage;
        this.lastAttackTimeStamp = System.currentTimeMillis();
    }

    /**
     * Methode isEnemyInRange() prüft, ob der angegebene Gegner in der Reichweite des Turmes ist
     * Man nimm die X und Y Koordinaten des Gegners und prüft, ob sie in der Min und Max Reichweite des Turmes sind.
     * @param enemy Eine Instanz der Klasse AbstractEnemy
     * @return bool
     */
    public boolean isEnemyInRange(AbstractEnemy enemy) {

        // Workaround mit den Offsets aufgrund der Tower Darstellung (SnapToGrid)
        // Magic Numbers :(
        int offsetX = 32;
        int offsetY = 32;

        int minX = this.getX() - range + offsetX;
        int maxX = this.getX() + range + offsetX;
        int minY = this.getY() - range + offsetY;
        int maxY = this.getY() + range + offsetY;

        int enemyX = enemy.getX();
        int enemyY = enemy.getY();

        if (enemyX > minX && enemyX < maxX) {
            if (enemyY > minY && enemyY < maxY) {
                return true;
            }
        }

        return false;
    }

    /**
     * Getter, gibt die Position des Turmes auf der X-Achse als Integer zurück.
     * @return (int)position.x;
     */
    public int getX() {
        return (int)position.x;
    }

    /**
     * Getter, gibt die Position des Turmes auf der Y-Achse als Integer zurück.
     * @return (int)position.y;
     */
    public int getY() {
        return (int)position.y;
    }

    /**
     * Getter, gibt die Schadenspunkte, die der Turm anrichtet zurück.
     * @return int damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Getter, gibt die Reichweite des Turmes zurück.
     * @return double damage
     */
    public double getRange() {
        return range;
    }

    /**
     * Getter, gibt den Cooldown des Turmes zurück.
     * @return int cooldowns
     */
    public int getCooldown() {
        return cooldown;
    }

    /**
     * Getter, gibt den Zeitstempel zurück, wann der letzte Angriff ausgeführt wurde.
     * @return long lastAttackTimeStamp
     */
    public long getLastAttackTimeStamp() {
        return lastAttackTimeStamp;
    }

    /**
     * Setzt den Zeitstempel lastAttackTimeStamp auf den neuen Wert.
     * @param timeStamp Zeitstempel, wenn der Angriff ausgeführt wurde
     */
    public void setLastAttackTimeStamp(long timeStamp) {
        this.lastAttackTimeStamp = timeStamp;
    }

}
