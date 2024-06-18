package model.towers;

import model.enemies.Enemy;

/**
 * Ein Turm, der Gegner für eine bestimmte Zeit unbeweglich macht
 * FreezeDuration       - int, Dauer der Zustandes 'Frozen'
 * FreezeChange         - double, Wahrscheinlichkeit, dass ein Gegner unbeweglich gemacht wird
 */
public class FreezingTower extends Tower {
    private int FreezeDuration;
    private double FreezeChance;

    // Konstruktor

    public FreezingTower(int posX,
                         int posY,
                         int level,
                         int initialCost,
                         double range,
                         double upgradeCostModifier,
                         int freezeDuration,
                         double freezeChance) {
        super(posX, posY, level, initialCost, range, upgradeCostModifier);
        this.FreezeDuration = freezeDuration;
        this.FreezeChance = freezeChance;
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

    public int getFreezeDuration() {
        return FreezeDuration;
    }

    public void setFreezeDuration(int freezeDuration) {
        FreezeDuration = freezeDuration;
    }

    public double getFreezeChance() {
        return FreezeChance;
    }

    public void setFreezeChance(long freezeChance) {
        FreezeChance = freezeChance;
    }
}
