package model.towers;

import java.awt.geom.Point2D;

public class BasicTower extends AbstractTower {

    public BasicTower(Point2D.Double position, int cost, int cooldown, int range) {
        super(position, cost, cooldown, range);
    }
}
