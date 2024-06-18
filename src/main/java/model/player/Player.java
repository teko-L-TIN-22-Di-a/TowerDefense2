package model.player;

/** Spielerklasse, welche den Spieler darstellt
 * Implementiert den "Singleton" Pattern
 * PosX     - Position des Spielers auf der X-Achse
 * PosY     - Position des Spielers auf der Y-Achse
 * Health   - Anzahl Lebenspunkte
 * Gold     - Anzahl Goldmünzen
 */
public class Player {
    private int PosX;
    private int PosY;
    private int Health;
    private int Gold;

    // Singleton Pattern
    private static Player instance;

    // Konstruktor (privat, weil Singleton)

    private Player(int posX, int posY, int health, int gold) {
        PosX = posX;
        PosY = posY;
        Health = health;
        Gold = gold;
    }

    // Public Static Method, um den Zugriff auf die Spielerinstanz zu ermöglichen
    public static Player getInstance(int posX, int posY, int health, int gold) {
        if (instance == null) {
            instance = new Player(posX, posY, health, gold);
        }

        return instance;
    }

    // Getter und Setter

    public int getPosX() {
        return PosX;
    }

    public void setPosX(int posX) {
        PosX = posX;
    }

    public int getPosY() {
        return PosY;
    }

    public void setPosY(int posY) {
        PosY = posY;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getGold() {
        return Gold;
    }

    public void setGold(int gold) {
        Gold = gold;
    }
}
