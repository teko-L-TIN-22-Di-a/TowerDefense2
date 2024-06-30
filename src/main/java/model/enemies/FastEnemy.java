package model.enemies;

import java.awt.geom.Point2D;
import java.util.List;

public class FastEnemy extends AbstractEnemy{
    public FastEnemy(List<Point2D.Double> waypoints) {
        super(waypoints);
        this.health = 7;
        this.speed = 4;
        this.reward = 4;
        this.damage = 1;
    }
}
