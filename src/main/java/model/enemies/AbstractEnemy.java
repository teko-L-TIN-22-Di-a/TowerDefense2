package model.enemies;

import java.awt.geom.Point2D;
import java.util.Date;
import java.util.List;

public abstract class AbstractEnemy {
    protected List<Point2D.Double> waypoints;
    protected Point2D.Double currentPosition;
    protected Point2D.Double direction;
    protected double speed;
    protected int health;
    protected int reward;
    protected int damage;
    protected int currentWaypointIndex;
    protected boolean hasReachedEnd;
    private boolean isDead;

    public AbstractEnemy(List<Point2D.Double> waypoints) {
        this.currentWaypointIndex = 0;
        this.waypoints = waypoints;
        this.currentPosition = new Point2D.Double(
                waypoints.get(currentWaypointIndex).getX(),
                waypoints.get(currentWaypointIndex).getY());
        this.hasReachedEnd = false;
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

        // DEV
        //System.out.println(currentPosition.toString());
    }

    public boolean hasReachedEnd() {
        return hasReachedEnd;
    }

    public boolean isDead() {
        return isDead;
    }

    public int getX() {
        return (int)currentPosition.getX();
    }

    public int getY() {
        return (int)currentPosition.getY();
    }

    public Point2D.Double getDirection() {
        return direction;
    }

    public int getReward() {
        return reward;
    }

    public int getDamage() {
        return damage;
    }
}

