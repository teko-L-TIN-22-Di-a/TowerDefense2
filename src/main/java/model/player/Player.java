package model.player;

public class Player {

    private int health;
    private int coins;

    public Player(int health, int coins) {
        this.health =  health;
        this.coins = coins;
    }

    public int getHealth() {
        return health;
    }

    public int getCoins() {
        return coins;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}