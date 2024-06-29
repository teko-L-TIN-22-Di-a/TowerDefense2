package model.towers;

import java.awt.geom.Point2D;

public abstract class AbstractTower {
    protected Point2D.Double position;

    public AbstractTower(Point2D.Double position) {
        this.position = position;
    }

    public int getX() {
        return (int)position.x;
    }

    public int getY() {
        return (int)position.y;
    }
}
