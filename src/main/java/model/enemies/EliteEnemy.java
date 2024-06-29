package model.enemies;

import java.awt.geom.Point2D;
import java.util.List;

public class EliteEnemy extends AbstractEnemy {
    public EliteEnemy(List<Point2D.Double> waypoints) {
        super(waypoints);
        this.health = 30;
        this.speed = 1;
        this.reward = 10;
    }
}
