package controller;

import model.GameModel;

public class WaveManager {
    private GameModel model;
    private int currentWaveIndex;

    public WaveManager(GameModel model) {
        this.model = model;
        this.currentWaveIndex = 0;
    }
}
