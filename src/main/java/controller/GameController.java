package controller;

import model.GameModel;
import model.enemies.Enemy;
import model.towers.Tower;
import view.GameView;

public class GameController {
    private GameModel model;
    private GameView view;

    private final double FPS_PER_SECOND = 120.0;
    private final double UPS_PER_SECOND = 60.0;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;

        // todo Game Loop
        //while(true) {
        //
        //}
    }

    public void addEnemy(Enemy enemy) {
        model.addEnemy(enemy);
    }

    public void addTower(Tower tower) {
        model.addTower(tower);
    }
}
