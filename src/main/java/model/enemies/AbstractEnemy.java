package model.enemies;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.Random;

/**
 * Diese Klasse dient als Vorlage für verschiedene Arten von Gegner.
 * Aktuell unterscheiden sich die Gegner, welche von dieser Klasse abgeleitet werden
 * durch die Anzahl Lebenspunkte und die Geschwindigkeit.
 */
public abstract class AbstractEnemy {
    /**
     * Liste von Point2D.Double Koordinaten (Waypoint), welche genutzt werden, um die Bewegungsrichtung zu bestimmen.
     */
    protected List<Point2D.Double> waypoints;
    /**
     * Aktuelle Position des Gegners.
     */
    protected Point2D.Double currentPosition;
    /**
     * Bewegungsrichtung des Gegners.
     */
    protected Point2D.Double direction;
    /**
     * Geschwindigkeit des Gegners.
     */
    protected double speed;
    /**
     * Anzahl Lebenspunkte des Gegners.
     * Diese Eigenschaft ist ein Bestandteil der Datei gameConfig.properies
     */
    protected int health;
    /**
     * Anzahl Goldmünzen, die der Spieler erhält, wenn der Gegner getötet wird.
     * Diese Eigenschaft ist ein Bestandteil der Datei gameConfig.properies
     */
    protected int reward;
    /**
     * Anzahl Schadenspunkte, die der Gegner anrichten, wenn der letzte Waypoint erreicht wird.
     * Diese Eigenschaft ist ein Bestandteil der Datei gameConfig.properies
     */
    protected int damage;
    /**
     * Index des Waypoints, der aktuell genutzt wird, um die Bewegungsrichtung zu bestimmen.
     */
    protected int currentWaypointIndex;
    /**
     * Hat der Gegner den letzten Waypoint erreicht?
     */
    protected boolean hasReachedEnd;
    /**
     * Ist der Gegner eingefroren?
     */
    protected boolean isFrozen;

    /**
     * Ist der Gegner tot?
     */
    protected boolean isDead;

    /**
     * Konstruktor
     *
     * @param waypoints Liste von Waypoints, welche als Pfad dienen, um die Bewegung zu ermöglichen
     */
    public AbstractEnemy(List<Point2D.Double> waypoints) {
        this.currentWaypointIndex = 0;
        this.waypoints = waypoints;
        this.currentPosition = new Point2D.Double(
                waypoints.get(currentWaypointIndex).getX(),
                waypoints.get(currentWaypointIndex).getY());
        this.hasReachedEnd = false;
        this.isDead = false;
        this.isFrozen = false;
    }

    /**
     * Aktualisiert den Gegner. Als erstes wird die neue Position des Gegners berechnet.
     * Hat die Anzahl Lebenspunkte 0 erreicht, ist der Gegner tot.
     *
     */
    public void update() {
        // Lebenspunkte berechnen
        move();
        if (health <= 0) {
            isDead = true;
        }
    }

    /**
     * Mit dem Satz vom Pythagoras die Bewegungsrichtung bestimmen und die Position des Gegners.
     * um Richtung * Geschwindigkeit aktualisieren
     */
    private void move() {
        // Darf sich der Gegner bewegen?
        if (!this.isFrozen) {
            if (currentWaypointIndex < waypoints.size() - 1) {
                Point2D.Double startPoint = waypoints.get(currentWaypointIndex);
                Point2D.Double endPoint = waypoints.get(currentWaypointIndex + 1);

                // Pythagoras :D
                double dx = endPoint.x - startPoint.x;
                double dy = endPoint.y - startPoint.y;
                double length = Math.sqrt(dx * dx + dy * dy);
                direction = new Point2D.Double(dx / length, dy / length);

                if (currentPosition.distance(endPoint) > speed) {
                    currentPosition.x += direction.x * speed;
                    currentPosition.y += direction.y * speed;
                } else {
                    currentPosition.setLocation(endPoint);
                    currentWaypointIndex++;
                }
            } else {
                hasReachedEnd = true;
            }
        }
    }

    /**
     * Anzahl Lebenspunkte des Gegners um Anzahl Schaden verringern.
     * Hat der Gegner <= 0 Leben, ist der Gegner tot.
     * @param damage Anzahl Schadenspunkte, die dem Gegner angerichtet werden
     */
    public void damageEnemy(int damage) {
        health -= damage;
        if (health <= 0) {
            isDead = true;
        }
    }

    /**
     * Gegner an einen zufälling Waypoint importieren, auf welchem er schon mal gewesen war
     */
    public void teleportEnemy() {
        Random random = new Random();
        currentWaypointIndex = random.nextInt(waypoints.size() - this.currentWaypointIndex);
        currentPosition.setLocation(waypoints.get(currentWaypointIndex));
    }

    /**
     * Gegner anhalten
     */
    public void freezeEnemy() {
        this.isFrozen = true;
    }

    /**
     * Gegner befreien
     */
    public void unfreezeEnemy() {
        this.isFrozen = false;
    }

    /**
     * Getter, gibt zurück, ob der Gegner den letzten Waypoint erreicht hat.
     * @return bool isDead
     */
    public boolean hasReachedEnd() {
        return hasReachedEnd;
    }

    /**
     * Getter, gibt zurück, ob der Gegner tot ist.
     * @return boolean isDead
     */
    public boolean isDead() {
        return isDead;
    }

    /**
     * Getter, gibt die Position des Gegners auf der X-Achse als Integer zurück.
     * @return (int)currentPosition.getX()
     */
    public int getX() {
        return (int)currentPosition.getX();
    }

    /**
     * Getter, gibt die Position des Gegners auf der Y-Achse als Integer zurück.
     * @return (int)currentPosition.getY()
     */
    public int getY() {
        return (int)currentPosition.getY();
    }

    /**
     * Getter, gibt die Bewegungsrichtung als Point2d.Double zurück.
     * @return Point2D.Double direction
     */
    public Point2D.Double getDirection() {
        return direction;
    }

    /**
     * Getter, gibt die Anzahl Goldmünzen zurück, die der Spieler erhält, wenn der Gegner getötet wird.
     * Diese Eigenschaft ist ein Bestandteil der Datei gameConfig.properies.
     * @return int reward
     */
    public int getReward() {
        return reward;
    }

    /**
     * Getter, gibt die Anzahl Schaden zurück, die dem Spieler angerichtet werden, wenn der Gegner
     * den letzten Waypoint erreicht hat.
     * @return int damage
     */
    public int getDamage() {
        return damage;
    }
}

