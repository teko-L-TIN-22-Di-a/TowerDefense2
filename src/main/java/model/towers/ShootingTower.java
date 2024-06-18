package model.towers;

import model.enemies.Enemy;

/**
 * Ein Standardturm, welcher den Gegner in der Reichte Schaden anrichten
 * Damage               - int, Anzahl Schadenspunkte, welche der Turm initial anrichten kanno
 * DamageMultiplier     - double, Schadensmodifikator, welcher die Schaden per Stufe erhöht,
 *                        Damage + (int)(Level*DamageMultiplier), z.B. 10 + (int)(3*1.75) => 10+4
 */
public class ShootingTower extends Tower {
    private int Damage;
    private double DamageMultiplier;

    // Konstruktor

    public ShootingTower(int posX,
                         int posY,
                         int level,
                         int initialCost,
                         double range,
                         double upgradeCostModifier,
                         int damage,
                         double damageMultiplier) {
        super(posX, posY, level, initialCost, range, upgradeCostModifier);
        this.Damage = damage;
        this.DamageMultiplier = damageMultiplier;
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

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        Damage = damage;
    }

    public double getDamageMultiplier() {
        return DamageMultiplier;
    }

    public void setDamageMultiplier(long damageMultiplier) {
        DamageMultiplier = damageMultiplier;
    }
}
