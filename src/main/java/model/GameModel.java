package model;

import model.enemies.Enemy;
import model.player.Player;
import model.towers.Tower;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private List<Enemy> enemies;
    private List<Tower> towers;
    private List<Point2D.Double> waypoints;

    private Player player;

    // Konstruktor

    public GameModel() {
        System.out.println("GameModel : Constructor");
        this.enemies = new ArrayList<>();
        this.towers = new ArrayList<>();
        this.waypoints = new ArrayList<>();
    }

    // Methoden

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public void addTower(Tower tower) {
        towers.add(tower);
    }

    public void addWaypoint(Point2D.Double waypoint) {
        waypoints.add(waypoint);
    }

    // Getter und Setter

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Tower> getTowers() {
        return towers;
    }

    public List<Point2D.Double> getWaypoints() {
        return waypoints;
    }
}
