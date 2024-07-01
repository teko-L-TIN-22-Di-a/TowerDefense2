package model.enemies;

import java.awt.geom.Point2D;
import java.util.List;

/**
 * Diese Klasse ist die Childklasse der Klasse AbstractEnemy.
 * Die Elite Gegner sind zwar langsamer, haben jedoch mehr Lebenspunkte als die anderen Gegnerklassen.
 */
public class EliteEnemy extends AbstractEnemy {

    /**
     * Konstruktor
     *
     * @param waypoints Liste von Waypoints, welche als Pfad dienen, um die Bewegung zu ermöglichen.
     */
    public EliteEnemy(List<Point2D.Double> waypoints) {
        super(waypoints);

        // ToDo: Keine Magic Numbers -> via gameConfig.properties einlesen
        this.health = 30;
        this.speed = 1;
        this.reward = 10;
        this.damage = 3;
    }
}
