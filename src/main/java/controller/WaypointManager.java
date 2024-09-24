package controller;

import model.GameModel;

import java.awt.geom.Point2D;

/**
 * Die Klasse WaypointManager ist für jegliche Interaktionen mit den Waypoints zuständig
 */
public class WaypointManager {
    /**
     * Instanz der Klasse GameModel
     */
    GameModel model;

    /**
     * Konstruktor
     * @param model Instanz der Klasse GameModel
     */
    public WaypointManager(GameModel model) {
        this.model = model;
    }

    public void addWaypoints() {
        // Waypoints
        // ToDo: -> waypoints.json
        addWaypoint(new Point2D.Double(832,-64));
        addWaypoint(new Point2D.Double(832, 256));
        addWaypoint(new Point2D.Double(640, 256));
        addWaypoint(new Point2D.Double(640, 128));
        addWaypoint(new Point2D.Double(128, 128));
        addWaypoint(new Point2D.Double(128, 640));
        addWaypoint(new Point2D.Double(320, 640));
        addWaypoint(new Point2D.Double(320, 384));
        addWaypoint(new Point2D.Double(512, 384));
        addWaypoint(new Point2D.Double(512, 448));
        addWaypoint(new Point2D.Double(896, 448));
        addWaypoint(new Point2D.Double(896, 832));
        addWaypoint(new Point2D.Double(704, 832));
        addWaypoint(new Point2D.Double(704, 640));
        addWaypoint(new Point2D.Double(512, 640));
        addWaypoint(new Point2D.Double(512, 832));
        addWaypoint(new Point2D.Double(-64, 832));
    }

    private void addWaypoint(Point2D.Double waypoint) {
        model.getWaypoints().add(waypoint);
    }
}
