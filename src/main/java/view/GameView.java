package view;

import model.GameModel;
import model.enemies.Enemy;
import model.towers.*;

import javax.swing.*;
import java.awt.*;

import java.util.List;

public class GameView extends JPanel {
    private static final int PANEL_WIDTH = 800;
    private static final int PANEL_HEIGHT = 600;

    private GameModel model;
    private Dimension dimension = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);

    public GameView(GameModel model) {
        this.model = model;
        this.setPreferredSize(dimension);
        this.setMinimumSize(dimension);
        this.setMaximumSize(dimension);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawEnemies(g, model.getEnemies());
        drawTowers(g, model.getTowers());
    }

    private void drawEnemies(Graphics g, List<Enemy> enemies) {
        // DEV, aktuell ohne tileset
        g.setColor(Color.RED);
        for (Enemy enemy : enemies) {
            g.fillRect(enemy.getPosX(), enemy.getPosY(), 20, 20);
        }
    }

    private void drawTowers(Graphics g, List<Tower> towers) {
        // DEV, aktuell ohne tileset

        for (Tower tower : towers) {

            if (tower instanceof ShootingTower) {
                g.setColor(Color.ORANGE);
            } else if (tower instanceof FreezingTower) {
                g.setColor(Color.BLUE);
            } else if (tower instanceof TeleportingTower) {
                g.setColor(Color.MAGENTA);
            }

            g.fillRect(tower.getPosX(), tower.getPosY(), 20, 20);
        }
    }
}
