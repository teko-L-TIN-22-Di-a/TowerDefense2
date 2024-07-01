package controller;

import model.GameModel;

/**
 * Die Klasse PlayerManager ist für jegliche Interationen mit den Spielerdaten zuständig
 */
public class PlayerManager {
    /**
     * Instanz der Klasse GameModel, beinhaltet den Spielzustand
     */
    private GameModel model;

    /**
     * Konstruktor
     * @param model GameModel
     */
    public PlayerManager(GameModel model) {
        this.model = model;
    }

    /**
     * Fügt dem Spieler die angegebene Anzahl Münzen hinzu
     * @param coins int Anzahl Münzen
     */
    public void addCoins(int coins) {
        model.getPlayer().setCoins(model.getPlayer().getCoins() + coins);
    }

    /**
     * Zieht von Münzenguthaben die angegebene Anzahl Münzen ab
     * @param coins int Anzahl Münzen
     */
    public void removeCoins(int coins) {
        model.getPlayer().setCoins(model.getPlayer().getCoins() - coins);
    }

    /**
     * Zieht dem Spieler die angegebene Anzahl Lebenspunkte ab
     * @param health int Anzahl Lebenspunkte
     */
    public void removeHealth(int health) {
        model.getPlayer().setHealth(model.getPlayer().getHealth() - health);
    }


}
