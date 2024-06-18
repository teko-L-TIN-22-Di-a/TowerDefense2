package model.towers;

import model.enemies.Enemy;

/**
 * Ein Turm, welcher den Gegner an einen zufälligen Ort auf dem Spielfeld teleportiert
 * TeleportingChance    - double, Wahrscheinlichkeit, dass der Gegner teleportiert wird
 */
public class TeleportingTower extends Tower {
    private double TeleportingChance;

    // Konstruktor

    public TeleportingTower(int posX,
                            int posY,
                            int level,
                            int initialCost,
                            double range,
                            double upgradeCostModifier,
                            double teleportingChance) {
        super(posX, posY, level, initialCost, range, upgradeCostModifier);
        this.TeleportingChance = teleportingChance;
    }

    // Methoden

    @Override
    public void attackEnemy(Enemy enemy) {
        // todo
    }

    @Override
    public void upgradeTower() {
        // todo
    }

    // Getter und Setter

    public double getTeleportingChange() {
        return TeleportingChance;
    }

    public void setTeleportingChange(long teleportingChance) {
        TeleportingChance = teleportingChance;
    }
}
