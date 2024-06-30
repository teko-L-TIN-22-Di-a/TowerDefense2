package controller;

import model.GameModel;

public class PlayerManager {
    private GameModel model;

    public PlayerManager(GameModel model) {
        this.model = model;
    }

    public void addCoins(int coins) {
        model.getPlayer().setCoins(model.getPlayer().getCoins() + coins);
    }

    public void removeCoins(int coins) {
        model.getPlayer().setCoins(model.getPlayer().getCoins() - coins);
    }

    public void removeHealth(int health) {
        model.getPlayer().setHealth(model.getPlayer().getHealth() - health);
    }


}
