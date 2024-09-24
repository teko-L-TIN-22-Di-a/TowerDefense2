package model.enemies;

import java.awt.geom.Point2D;
import java.util.List;

/**
 * Diese Klasse ist die Childklasse der Klasse AbstractEnemy.
 * Die schnellen Gegner sind schneller, haben jedoch weniger Lebenspunkte als die anderen Gegnerklassen.
 */
public class FastEnemy extends AbstractEnemy{

    /**
     * Konstruktor
     *
     * @param waypoints Liste von Waypoints, welche als Pfad dienen, um die Bewegung zu ermöglichen.
     */
    public FastEnemy(List<Point2D.Double> waypoints) {
        super(waypoints);

        this.health = 7;
        this.speed = 4;
        this.reward = 4;
        this.damage = 1;
    }
}
