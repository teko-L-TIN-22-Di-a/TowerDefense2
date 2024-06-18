package model.towers;

import model.enemies.Enemy;

/** Abstrakte Klasse Tower
 * PosX                 - int, Position auf der X-Achse
 * PosY                 - int, Positiion auf dey Y-Achse
 * Level                - int, Stufe des Turmes
 * InitialCost          - int, Anzahl Goldmünzen, um den Turm zu bauen
 * Range                - double, Reichweite des Turmes
 * UpgradeCostModifier  - double, Fliesskommazahl, welche den Wert darstellt, um welchen die Upgrade-Konsten
 *                        bei einem Stufenaufstieg erhöht werden, z.B. 1.2
 * ---
 * attackEnemy()        - void, Einem Gegner Schaden hinzufügen
 * upgradeTower()       - void, Stufe des Turmes erhöhen
 */
public abstract class Tower {
    protected int PosX;
    protected int PosY;
    protected int Level;
    protected int InitialCost;
    protected double Range;
    protected double UpgradeCostModifier;

    // Konstruktor

    public Tower(int posX, int posY, int level, int initialCost, double range, double upgradeCostModifier) {
        this.PosX = posX;
        this.PosY = posY;
        this.Level = level;
        this.InitialCost = initialCost;
        this.Range = range;
        this.UpgradeCostModifier = upgradeCostModifier;
    }

    // Methoden

    public void attackEnemy(Enemy enemy) {
        // todo
    }

    public void upgradeTower() {
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

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public int getInitialCost() {
        return InitialCost;
    }

    public void setInitialCost(int initialCost) {
        InitialCost = initialCost;
    }

    public double getRange() {
        return Range;
    }

    public void setRange(double range) {
        Range = range;
    }

    public double getUpgradeCostModifier() {
        return UpgradeCostModifier;
    }

    public void setUpgradeCostModifier(double upgradeCostModifier) {
        UpgradeCostModifier = upgradeCostModifier;
    }
}
