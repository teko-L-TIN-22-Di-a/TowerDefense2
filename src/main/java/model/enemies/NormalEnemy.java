package model.enemies;

import java.awt.geom.Point2D;
import java.util.List;

public class NormalEnemy extends AbstractEnemy {
    public NormalEnemy(List<Point2D.Double> waypoints) {
        super(waypoints);
        this.health = 10;
        this.speed = 2;
        this.reward = 5;
    }
}
