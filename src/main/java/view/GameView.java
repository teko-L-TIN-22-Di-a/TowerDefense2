package view;

import controller.GameController;
import model.GameModel;
import model.enemies.*;
import model.towers.AbstractTower;
import util.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Die Klasse GameView repräsentiert das View im MVC Pattern.
 * Diese Klasse beinhaltet alle Informationen, die es braucht um das UI sowie den Spielzustand zu rendern.
 * Über den MouseListener wird der Controller angesteurt, um den Spielzustand zu ändern.
 */
public class GameView extends JPanel implements MouseListener {

    /**
     * Anzahl Zeilen, wird mit dem GameConfigLoader eingelesen
     */
    private final int ROWS;
    /**
     * Anzahl Spalten, wird mit dem GameConfigLoader eingelesen
     */
    private final int COLUMNS;
    /**
     * Kachelgrösse, wird mit dem GameConfigLoader eingelesen
     */
    private final int TILE_SIZE;
    /**
     * Breite des JPanels
     */
    private final int PANEL_WIDTH;
    /**
     * Höhe des JPanels
     */
    private final int PANEL_HEIGHT;

    /**
     * Instanz der Klasse GameModel, beinhaltet den Spielzustand, welcher durch die Klasse GameView gerendert wird
     */
    private GameModel model;
    /**
     * Instanz der Klasse GameController, wird genutzt, um den Spielzustand model zu ändern
     */
    private GameController controller;
    /**
     * Dimension, gibt die Grösse des Applikationsfensters an
     */
    private Dimension dimension;
    /**
     * Hintergrund auf dem Spielfeld
     */
    private BufferedImage backgroundImage;
    /**
        Symbol, um die Spielerlebenspunkte darzustellen
     */
    private BufferedImage heartImage;
    /**
     * Symbol, um die Münzen des Spielers darzustellen
     */
    private BufferedImage coinImage;
    /**
     * Bild des Gegners Up
     */
    private BufferedImage enemyImageUp;
    /**
     * Bild des Gegners Down
     */
    private BufferedImage enemyImageDown;
    /**
     * Bild des Gegners Left
     */
    private BufferedImage enemyImageLeft;
    /**
     * Bild des Gegners Right
     */
    private BufferedImage enemyImageRight;
    /**
     * Bild des Turmes
     */
    private BufferedImage towerImage;

    /**
     * Konstruktor
     * Lädt Bilder, initialisiert das Spielfeld und fügt den MouseListener hinzu
     * @param model Instanz der Klasse GameModel
     * @param controller Instanz der Klasse GameController
     */
    public GameView(GameModel model, GameController controller) {

        this.model = model;
        this.controller = controller;

        ROWS = model.getGameConfig().getRows();
        COLUMNS = model.getGameConfig().getColumns();
        TILE_SIZE = model.getGameConfig().getTileSize();
        PANEL_WIDTH = ROWS * TILE_SIZE;
        PANEL_HEIGHT = COLUMNS * TILE_SIZE;

        this.dimension = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);

        // https://www.iconarchive.com/show/beautiful-flat-icons-by-elegantthemes.1.html
        //https://www.kenney.nl/assets/tower-defense-top-down
        // UI
        backgroundImage = ImageLoader.loadImage("/levels/level1.png");
        heartImage = ImageLoader.loadImage("/player/heart.png");
        coinImage = ImageLoader.loadImage("/player/coin.png");
        towerImage = ImageLoader.loadImage("/towers/tower2.png");

        // Enemy
        enemyImageUp = ImageLoader.loadImage("/enemies/enemy1_up.png");
        enemyImageDown = ImageLoader.loadImage("/enemies/enemy1_down.png");
        enemyImageLeft = ImageLoader.loadImage("/enemies/enemy1_left.png");
        enemyImageRight = ImageLoader.loadImage("/enemies/enemy1_right.png");

        this.addMouseListener(this);
        this.setPreferredSize(dimension);
        this.setMinimumSize(dimension);
        this.setMaximumSize(dimension);
    }

    /**
     * Rendert im Model vorhandene Spieldaten
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);
        drawWaypoints(g, model.getWaypoints());
        drawEnemies(g, model.getEnemies());
        drawTowers(g, model.getTowers());
        drawPlayerUI(g);
    }

    /**
     * Zeichnet das Hintergrundsbild
     * @param g Graphics
     */
    private void drawBackground(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, null);
    }

    /**
     * Zeichnet die Spielerbezogene Bilder und Elemente (Lebenspünkte, Münzen, Werte)
     * @param g Graphics
     */
    private void drawPlayerUI(Graphics g) {
        String health = Integer.toString(model.getPlayer().getHealth());
        String coins = Integer.toString(model.getPlayer().getCoins());

        g.drawImage(heartImage, 5,5,null);
        g.drawImage(coinImage, 5, 40, null);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.PLAIN, 19));
        g.drawString(health, 42, 28);
        g.drawString(coins, 42, 63);
    }

    /**
     * Zeichnet die Waypoints auf dem Spielfeld und verbindet sie sequenziell
     * @param g Graphics
     * @param waypoints List Point2D.Double waypoints
     */
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

    /**
     * Zeichnet Gegner auf dem Spielfeld
     * @param g Graphics
     * @param enemies List AbstractEnemy enemies
     */
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
                if (enemy instanceof BasicEnemy) {
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

    /**
     * Zeichent Türme auf dem Spielfeld
     * @param g Graphics
     * @param towers List AbstractTower towers
     */
    public void drawTowers(Graphics g, List<AbstractTower> towers) {
        for (AbstractTower tower : towers) {
            g.drawImage(towerImage, tower.getX(), tower.getY(), null);

            // DEV - Draw Range and Tower Center
            int r = (int)tower.getRange();

            g.setColor(Color.RED);
            g.drawOval(tower.getX()+32, tower.getY()+32, 3, 3);
            g.drawRect(tower.getX()+32 - r, tower.getY()+32 -r, r*2, r*2);
        }
    }

    /**
     * Übergibt den MouseEvent e an den GameController weiter, um einen Turm zu platzieren
     * @param e MouseEvent
     */
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

    @Override
    public void mouseClicked(MouseEvent e) {
        // nichts machen
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // nichts machen
    }
}
