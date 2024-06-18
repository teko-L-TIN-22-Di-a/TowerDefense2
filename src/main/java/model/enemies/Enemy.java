package model.enemies;

/**
 * Abstrakte Klass Enemy
 * PosX             - int, Position auf der X-Achse
 * PosY             - int, Position auf dey Y-Achse
 * Health           - int, Anzahl Lebenspunkte
 * Value            - int, Anzahl Goldmünzen, die der Spieler erhält, wenn der Gegner getötet wird
 * Speed            - long, Geschwindigkeit, mit welcher sich der Gegner bewegt
 * isAlive          - boolean, Ist der Gegner am Leben
 * isFrozen         - boolean, Ist der Gegner eingefroren
 */
public abstract class Enemy {
    protected int PosX;
    protected int PosY;
    protected int Health;
    protected int Value;
    protected double Speed;
    protected boolean isAlive = true;
    protected boolean isFrozen = false;

    // Konstruktor

    public Enemy(int posX,
                 int posY,
                 int health,
                 int speed,
                 int value) {
        this.PosX = posX;
        this.PosY = posY;
        this.Health = health;
        this.Speed = speed;
        this.Value = value;
        this.isAlive = isAlive;
        this.isFrozen = isFrozen;
    }

    // Methoden

    public void freeze(int freezeDuration) {
        // todo
    }

    public void damage(int damage) {
        // todo
    }

    public void kill() {
        // todo
    }

    public void teleport() {
        // todo
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

    public int getValue() {
        return Value;
    }

    public void setValue(int value) {
        Value = value;
    }

    public double getSpeed() {
        return Speed;
    }

    public void setSpeed(long speed) {
        Speed = speed;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public void setFrozen(boolean frozen) {
        isFrozen = frozen;
    }
}
