package model.enemies;

import java.awt.geom.Point2D;
import java.util.List;

/**
 * Diese Klasse ist die Childklasse der Klasse AbstractEnemy.
 * Die normalen Gegner haben eine durchschnittliche Anzahl der Lebenspunkte und sind weder schnell noch langsam.
 */
public class BasicEnemy extends AbstractEnemy {

    /**
     * Konstruktor
     *
     * @param waypoints Liste von Waypoints, welche als Pfad dienen, um die Bewegung zu ermöglichen.
     */
    public BasicEnemy(List<Point2D.Double> waypoints) {
        super(waypoints);

        // ToDo: Keine Magic Numbers -> via gameConfig.properties einlesen
        this.health = 10;
        this.speed = 2;
        this.reward = 5;
        this.damage = 2;
    }
}
