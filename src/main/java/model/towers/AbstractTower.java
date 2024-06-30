package model.towers;

import model.enemies.AbstractEnemy;

import java.awt.geom.Point2D;

public abstract class AbstractTower {
    protected Point2D.Double position;
    protected int range;
    protected int cost;
    protected int cooldown;
    protected boolean isOnCooldown;

    public AbstractTower(Point2D.Double position, int cost, int cooldown, int range) {
        this.position = position;
        this.cost = cost;
        this.cooldown = cooldown;
        this.range = range;
    }

    public int getX() {
        return (int)position.x;
    }

    public int getY() {
        return (int)position.y;
    }

    public int getCost() {
        return cost;
    }

    public double getRange() {
        return range;
    }

    public boolean isOnCooldown() {
        return isOnCooldown;
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
