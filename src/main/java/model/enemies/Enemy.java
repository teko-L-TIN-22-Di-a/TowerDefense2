package model.enemies;

import java.awt.geom.Point2D;
import java.util.List;

public class Enemy {
    private List<Point2D.Double> waypoints;
    private Point2D.Double currentPos;
    private Point2D.Double direction;
    private double speed;
    private int currentWaypointIndex;
    private boolean hasReachedEnd;
    private boolean isDead;

    public Enemy(List<Point2D.Double> waypoints, double speed) {
        this.currentWaypointIndex = 0;
        this.waypoints = waypoints;
        //this.currentPos = waypoints.get(currentWaypointIndex);
        this.currentPos = new Point2D.Double(waypoints.get(currentWaypointIndex).getX(), waypoints.get(currentWaypointIndex).getY());
        this.speed = speed;
        this.hasReachedEnd  = false;
        this.isDead = false;
    }

    public void update() {
        move();
    }

    private void move() {
        if (currentWaypointIndex < waypoints.size() - 1) {
            Point2D.Double startPoint = waypoints.get(currentWaypointIndex);
            Point2D.Double endPoint = waypoints.get(currentWaypointIndex + 1);

            // Pythagoras :D
            double dx = endPoint.x - startPoint.x;
            double dy = endPoint.y - startPoint.y;
            double length = Math.sqrt(dx * dx + dy * dy);
            direction = new Point2D.Double(dx / length, dy / length);

            if (currentPos.distance(endPoint) > speed) {
                currentPos.x += direction.x * speed;
                currentPos.y += direction.y * speed;
            } else {
                currentPos.setLocation(endPoint);
                currentWaypointIndex++;
            }
        } else {
            hasReachedEnd = true;
        }
    }

    public int getX() {
        return (int)currentPos.getX();
    }

    public int getY() {
        return (int)currentPos.getY();
    }

    public Point2D.Double getDirection() {
        return direction;
    }

    public boolean hasReachedEnd() {
        return hasReachedEnd;
    }

    public boolean isDead() {
        return isDead;
    }
}
