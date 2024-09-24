package model.towers;

import java.awt.geom.Point2D;

/**
 * Die Klasse BasicTower ist eine Childklasse der Klasse AbstractTower.
 * Diese Klasse repräsentiert einen Turm, der Gegner teleportieren kann.
 */
public class TeleportingTower extends AbstractTower {
    /**
     * Konstruktor
     * @param position Position des Turmes
     * @param cooldown Cooldown des Turmes
     * @param range Reichweite des Turmes
     * @param damage Anzahl Schadenpunkte, die der Turm anrichtet
     */
    public TeleportingTower(Point2D.Double position, int cooldown, int range, int damage) {
        super(position, cooldown, range, damage);
    }
}