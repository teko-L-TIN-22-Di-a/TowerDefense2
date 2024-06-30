package model.towers;

import java.awt.geom.Point2D;

public abstract class AbstractTower {
    protected Point2D.Double position;
    protected int cost;

    public AbstractTower(Point2D.Double position, int cost) {
        this.position = position;
        this.cost = cost;
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
}
