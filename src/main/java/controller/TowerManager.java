package controller;

import model.GameModel;
import model.towers.AbstractTower;
import model.towers.BasicTower;

import java.awt.geom.Point2D;

public class TowerManager {
    private GameModel model;

    public TowerManager(GameModel model) {
        this.model = model;
    }

    public void updateTowers() {
        // todo
    }

    public void addTower(Point2D.Double location) {

        // Waypoints-Paare durchiterieren und prüfen ob die Ziel location sich in der Nähe
        // einer Gerade zwischen zwischen zwei Punkte befindet
        double targetX = location.getX();
        double targetY = location.getY();
        boolean isInRange = false;
        boolean towerExists = false;

        for (int i = 1; i < model.getWaypoints().size(); i++) {
            double aX = model.getWaypoints().get(i-1).getX();
            double aY = model.getWaypoints().get(i-1).getY();
            double bX = model.getWaypoints().get(i).getX();
            double bY = model.getWaypoints().get(i).getY();
            // Min Max bestimmen (+- TILE_SIZE*2)
            double minX = Math.min(aX, bX) - 64;
            double maxX = Math.max(aX, bX) + 64;
            double minY = Math.min(aY, bY) - 64;
            double maxY = Math.max(aY, bY) + 64;

            // X- und Y-Achse prüfen
            if (targetX > minX && targetX < maxX && targetY > minY && targetY < maxY) {
                isInRange = true;
                break;
            }
        }

        // Turm hinzufügen
        if (!isInRange) {
            // Position auf dem imaginären Grid berechnen
            // Division ohne Rest
            // todo: View Konstanten -> GameConfig
            // ROWS * TILE_SIZE
            int gridX = (int)(targetX / 64);
            int gridY = (int)(targetY / 64);

            // +16 -> Zentrum von der imaginären Kacheln
            int newLocationX = (gridX * 64);
            int newLocationY = (gridY * 64);

            // Turm mit gleichen Koordinaten bereits vorhanden?
            for (AbstractTower tower : model.getTowers()) {
                if (tower.getX() == newLocationX && tower.getY() == newLocationY) {
                    towerExists = true;
                }
            }

            // Turm hinzufügen
            if (!towerExists) {
                Point2D.Double newLocation = new Point2D.Double(newLocationX, newLocationY);
                model.getTowers().add(new BasicTower(newLocation));
            }
        }
    }
}
