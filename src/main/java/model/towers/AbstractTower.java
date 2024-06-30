package model.towers;

import model.enemies.AbstractEnemy;

import java.awt.geom.Point2D;

public abstract class AbstractTower {
    protected Point2D.Double position;
    protected long lastAttackTimeStamp;
    protected int range;
    protected int cooldown;
    protected int damage;

    public AbstractTower(Point2D.Double position, int cooldown, int range, int damage) {
        this.position = position;
        this.cooldown = cooldown;
        this.range = range;
        this.damage = damage;
        this.lastAttackTimeStamp = System.currentTimeMillis();
    }

    public int getX() {
        return (int)position.x;
    }

    public int getY() {
        return (int)position.y;
    }

    public int getDamage() {
        return damage;
    }

    public double getRange() {
        return range;
    }

    public int getCooldown() {
        return cooldown;
    }

    public long getLastAttackTimeStamp() {
        return lastAttackTimeStamp;
    }

    public void setLastAttackTimeStamp(long timeStamp) {
        this.lastAttackTimeStamp = timeStamp;
    }

    public boolean isEnemyInRange(AbstractEnemy enemy) {

        // Workaround mit den Offsets aufgrund der Tower Darstellung
        // Yay Magic Numbers :(
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
}
