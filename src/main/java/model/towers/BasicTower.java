package model.towers;

import java.awt.geom.Point2D;

public class BasicTower extends AbstractTower {

    public BasicTower(Point2D.Double position, int cooldown, int range, int damage) {
        super(position, cooldown, range, damage);
    }
}
