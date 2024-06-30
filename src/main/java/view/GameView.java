package view;

import controller.GameController;
import model.GameModel;
import model.enemies.*;
import model.towers.AbstractTower;
import util.ResourceLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.List;

public class GameView extends JPanel implements MouseListener {

    // GameScreen 15 * 48
    private static final int ROWS = 15;
    private static final int COLUMNS = 15;
    private static final int TILE_SIZE = 64;
    private static final int PANEL_WIDTH = ROWS * TILE_SIZE;
    private static final int PANEL_HEIGHT = COLUMNS * TILE_SIZE;

    private GameModel model;
    private GameController controller;
    private Dimension dimension = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);

    private BufferedImage backgroundImage;
    private BufferedImage heartImage;
    private BufferedImage coinImage;
    private BufferedImage enemyImageUp;
    private BufferedImage enemyImageDown;
    private BufferedImage enemyImageLeft;
    private BufferedImage enemyImageRight;
    private BufferedImage towerImage;

    public GameView(GameModel model, GameController controller) {

        // https://www.iconarchive.com/show/beautiful-flat-icons-by-elegantthemes.1.html
        //https://www.kenney.nl/assets/tower-defense-top-down
        backgroundImage = ResourceLoader.loadImage("/levels/level1.png");
        heartImage = ResourceLoader.loadImage("/player/heart.png");
        coinImage = ResourceLoader.loadImage("/player/coin.png");
        towerImage = ResourceLoader.loadImage("/towers/tower2.png");

        // Enemy
        enemyImageUp = ResourceLoader.loadImage("/enemies/enemy1_up.png");
        enemyImageDown = ResourceLoader.loadImage("/enemies/enemy1_down.png");
        enemyImageLeft = ResourceLoader.loadImage("/enemies/enemy1_left.png");
        enemyImageRight = ResourceLoader.loadImage("/enemies/enemy1_right.png");

        this.model = model;
        this.controller = controller;
        this.addMouseListener(this);
        this.setPreferredSize(dimension);
        this.setMinimumSize(dimension);
        this.setMaximumSize(dimension);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);
        drawWaypoints(g, model.getWaypoints());
        drawEnemies(g, model.getEnemies());
        drawTowers(g, model.getTowers());
        drawPlayerUI(g);
    }

    private void drawBackground(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, null);
    }

    private void drawPlayerUI(Graphics g) {
        g.drawImage(heartImage, 5,5,null);
        g.drawImage(coinImage, 5, 40, null);

        String health = Integer.toString(model.getPlayer().getHealth());
        String coins = Integer.toString(model.getPlayer().getCoins());

        System.out.println("health: " + health);
        System.out.println("coins: " + coins);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.PLAIN, 19));
        g.drawString(health, 42, 28);
        g.drawString(coins, 42, 63);
    }

    private void drawWaypoints(Graphics g, List<Point2D.Double> waypoints) {
        double prevX = waypoints.get(0).getX();
        double prevY = waypoints.get(0).getY();

        for (int i = 1; i < waypoints.size(); i++) {

            double currX = waypoints.get(i).getX();
            double currY = waypoints.get(i).getY();

            g.setColor(Color.LIGHT_GRAY);
            g.drawLine((int)prevX, (int)prevY, (int)currX, (int)currY);
            prevX = currX;
            prevY = currY;
        }
    }

    private void drawEnemies(Graphics g, List<AbstractEnemy> enemies) {
        for (AbstractEnemy enemy : enemies) {

            BufferedImage enemyImage = null;

            if (enemy.getDirection() != null) {
                double dirX = enemy.getDirection().getX();
                double dirY = enemy.getDirection().getY();

                if (dirX > 0) {
                    // dirX == 1.0
                    // Bewegung nach rechts
                    enemyImage = enemyImageRight;
                } else if  (dirX < 0) {
                    // dirX == -1.0
                    // Bewegung nach links
                    enemyImage = enemyImageLeft;
                } else {
                    // dirX == 0.0
                    // Bewegung auf der Y-Achse
                    if (dirY > 0) {
                        // Bewegung nach unten
                        enemyImage = enemyImageDown;
                    } else if (dirY < 0) {
                        // Bewegung nach oben
                        enemyImage = enemyImageUp;
                    }
                }

                // x-32, y-32 um das Bild zentriert darzustellen
                g.drawImage(enemyImage, enemy.getX()-32, enemy.getY()-32, null);

                // Gegner unterscheiden
                if (enemy instanceof NormalEnemy) {
                    g.setColor(Color.BLUE);
                } else if (enemy instanceof FastEnemy) {
                    g.setColor(Color.YELLOW);
                } else if (enemy instanceof EliteEnemy) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillOval(enemy.getX(), enemy.getY(), 5,5);
            }
        }
    }

    public void drawTowers(Graphics g, List<AbstractTower> towers) {
        for (AbstractTower tower : towers) {
            g.drawImage(towerImage, tower.getX(), tower.getY(), null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // nichts machen
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // nichts machen
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        controller.handleMouseClick(e);
        System.out.println("Mouse Released at " + e.getX() + ", " + e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // nichts machen
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // nichts machen
    }
}
