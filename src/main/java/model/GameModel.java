package model;

import model.config.GameConfig;
import model.enemies.AbstractEnemy;
import model.player.Player;
import model.waves.Wave;
import util.GameConfigLoader;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private GameConfig gameConfig;
    private List<AbstractEnemy> enemies;
    private List<Point2D.Double> waypoints;
    private List<Wave> waves;

    private Player player;

    public GameModel(){
        System.out.println("GameModel : Constructor");
        this.enemies = new ArrayList<>();
        this.waypoints = new ArrayList<>();
        this.gameConfig = GameConfigLoader.loadConfig("/gameConfig.properties");

    }

    public GameConfig getGameConfig() {
        return gameConfig;
    }

    public List<Point2D.Double> getWaypoints() {
        return waypoints;
    }

    public List<AbstractEnemy> getEnemies() {
        return enemies;
    }
}
