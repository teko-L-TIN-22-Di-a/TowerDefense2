package controller;

import model.GameModel;
import model.enemies.AbstractEnemy;
import model.towers.AbstractTower;
import model.towers.BasicTower;
import model.towers.FreezingTower;
import model.towers.TeleportingTower;

import java.awt.geom.Point2D;

/**
 * Die Klasse TowerManager ist für jegliche Interaktionen mit den Instanzen der Tower Klassen zuständig
 */
public class TowerManager {
    /**
     * Instanz der Klasse GameModel, beinhaltet den Spielzustand
     */
    private GameModel model;
    /**
     * Instanz der Klasse PlayerManager, über welche die Spielerdaten angesteuert werden
     */
    private PlayerManager playerManager;
    /**
     * Instanz der Klasse EnemyManger, steuert alle Instanzen der Enemy Klassen an
     */
    private EnemyManager enemyManager;

    /**
     * Konstruktor
     * @param model Instanz der Klasse GameModel
     * @param playerManager Instanz der Klasse PlayerManager
     * @param enemyManager Instanz der Klasse EnemyManager
     */
    public TowerManager(GameModel model, PlayerManager playerManager, EnemyManager enemyManager) {
        this.model = model;
        this.playerManager = playerManager;
        this.enemyManager = enemyManager;
    }

    /**
     * Aktualisiert alle Türme, welche sich auf dem Spielfeld befinden.
     * Prüft ob ein Turm auf Cooldown ist und ob es Gegner in der Reichweite gibt.
     * Lässt den Turm die Gegner angreifen
     */
    public void updateTowers() {
        long currentTimeStamp = System.currentTimeMillis();

        for (AbstractTower tower : model.getTowers()) {
            boolean towerOnCooldown = false;

            // Tower on cooldown?
            if (currentTimeStamp - tower.getLastAttackTimeStamp() > tower.getCooldown()) {
                //System.out.println("not on cooldown");
            } else {
                towerOnCooldown = true;
                //System.out.println("on cooldown");
            }

            // Nur dann angreifen, wenn nicht auf cooldown
            if (!towerOnCooldown) {
                for (AbstractEnemy enemy : model.getEnemies()) {

                    // Gegner in Reichweite?
                    if (tower.isEnemyInRange(enemy)) {

                        if (tower instanceof BasicTower) {
                            enemyManager.damageEnemy(enemy, tower.getDamage());
                        } else if (tower instanceof TeleportingTower) {
                            enemyManager.teleportEnemy(enemy);
                        } else if (tower instanceof FreezingTower) {
                            enemyManager.freezeEnemy(enemy);
                        }

                        towerOnCooldown = true;
                        tower.setLastAttackTimeStamp(currentTimeStamp);

                    }
                    // Schleife verlassen, wenn der Angriff stattgefunden hat
                    if (towerOnCooldown) {
                        break;
                    }
                }
            }
        }
    }

    /**
     * Fügt einen Turm auf das Spielfeld hinzu
     * Prüft ob die Koordinaten, in der Nähe der Waypoints sind.
     * Prüft ob der Spieler genug Guthaben hat, um den Turm zu bauen.
     * Prüft ob ein Turm an diesem Ort bereits vorhanden ist.
     * @param location Point2D.Double location
     */
    public void addTower(Point2D.Double location) {

        double targetX = location.getX();
        double targetY = location.getY();

        boolean sufficientCoins = false;
        boolean isInRange = false;
        boolean towerExists = false;

        // Genug Münzen?
        if (model.getPlayer().getCoins() >= model.getGameConfig().getBasicTowerCost()) {
            sufficientCoins = true;
        } else {
            System.out.println("Not enough coins!");
        }

        // Koordinaten berechnen
        if (sufficientCoins) {
            // Waypoints-Paare durchiterieren und prüfen ob die Ziel location sich in der Nähe
            // einer Gerade zwischen zwischen zwei Punkte befindet

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
        }

        // Turm hinzufügen
        if (sufficientCoins && !isInRange) {
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
                System.out.println("creating a tower at;" + newLocation);
                // Turm hinzufügen

                if (model.getTowerTypes()[model.getSelectedTowerIndex()] == BasicTower.class) {
                    model.getTowers().add(new BasicTower(
                            newLocation,
                            model.getGameConfig().getBasicTowerCooldown(),
                            model.getGameConfig().getBasicTowerRange(),
                            model.getGameConfig().getBasicTowerDamage()));
                } else if (model.getTowerTypes()[model.getSelectedTowerIndex()] == TeleportingTower.class) {
                    model.getTowers().add(new TeleportingTower(
                            newLocation,
                            model.getGameConfig().getTeleportingTowerCooldown(),
                            model.getGameConfig().getTeleportingTowerRange(),
                            model.getGameConfig().getTeleportingTowerDamage()));
                } else if (model.getTowerTypes()[model.getSelectedTowerIndex()] == FreezingTower.class) {
                    model.getTowers().add(new FreezingTower(
                            newLocation,
                            model.getGameConfig().getFreezingTowerCooldown(),
                            model.getGameConfig().getFreezingTowerRange(),
                            model.getGameConfig().getFreezingTowerDamage()));
                }

                // Anzahl Münzen aktualisieren
                playerManager.removeCoins(model.getGameConfig().getBasicTowerCost());
            }
        }
    }

    /**
     * Wechselt zwischen den Turm Typen, die gebaut werden können
     */
    public void cycleTowerType() {
        model.setSelectedTowerIndex((model.getSelectedTowerIndex() + 1) % model.getTowerTypes().length);
    }
}
