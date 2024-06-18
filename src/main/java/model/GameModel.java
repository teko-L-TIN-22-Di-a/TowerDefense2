package model;

import model.enemies.Enemy;
import model.player.Player;
import model.towers.Tower;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private List<Enemy> enemies;
    private List<Tower> towers;

    private Player player;

    // Konstruktor

    public GameModel() {
        System.out.println("GameModel : Constructor");
        this.enemies = new ArrayList<>();
        this.towers = new ArrayList<>();
        //this.player = Player.getInstance()
    }

    // Methoden

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public void addTower(Tower tower) {
        towers.add(tower);
    }

    // Getter und Setter

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Tower> getTowers() {
        return towers;
    }
}
