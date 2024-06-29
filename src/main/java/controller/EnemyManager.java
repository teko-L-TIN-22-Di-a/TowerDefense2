package controller;

import model.GameModel;
import model.enemies.AbstractEnemy;

public class EnemyManager {
    private GameModel model;

    public EnemyManager(GameModel model) {
        this.model = model;
    }

    public void addEnemy(AbstractEnemy enemy) {
       model.getEnemies().add(enemy);
    }

}
