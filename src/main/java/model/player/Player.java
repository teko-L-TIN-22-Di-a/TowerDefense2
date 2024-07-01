package model.player;

/**
 * Die Klasse Player repräsentiert den Spieler.
 */
public class Player {

    /**
     * Gesamtanzahl der Lebenspunkt, die der Spieler hat.
     * Lebenspunkte werden verringert, wenn einer der Gegner den letzten Waypoint erreicht.
     */
    private int health;
    /**
     * Gesamtanzahl der Münzen, die der Spieler hat.
     */
    private int coins;

    /**
     * Konstruktor
     * @param health Gesamtanzahl Lebenspunkte
     * @param coins Gesamtanzahl Münzen
     */
    public Player(int health, int coins) {
        this.health =  health;
        this.coins = coins;
    }

    /**
     * Getter, gibt die Anzahl Lebenspunkte des Spielers zurück.
     * @return int health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Getter, gibt die Anzahl Münzen des Spielers zurück.
     * @return int coins
     */
    public int getCoins() {
        return coins;
    }

    /**
     * Setter, setzt die Lebenspunkte des Spielers auf den Wert health.
     * @param health Anzahl Lebenspunkte
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Setter, setzt die Anzahl Münzen des Spielers auf den Wert coins.
     * @param coins Anzahl Münzen
     */
    public void setCoins(int coins) {
        this.coins = coins;
    }
}