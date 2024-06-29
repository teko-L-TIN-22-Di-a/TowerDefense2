package controller;

import model.GameModel;
import model.enemies.*;
import model.waves.Wave;

import java.util.*;
import java.util.stream.IntStream;

public class WaveManager {
    private GameModel model;
    private Wave currentWave;
    private final int delayBetweenWaves;
    private long lastWaveSpawnTime;

    public WaveManager(GameModel model) {
        this.model = model;
        this.currentWave = model.getWavesQueue().poll();
        this.delayBetweenWaves = model.getGameConfig().getDelayBetweenWaves();
        this.lastWaveSpawnTime = System.currentTimeMillis();
    }

    public void updateWaves() {
        if (!model.getWavesQueue().isEmpty()) {
            long currentTime = System.currentTimeMillis();
            System.out.println(currentTime - lastWaveSpawnTime);
            System.out.println(delayBetweenWaves);
            System.out.println("---");
            // Delay überschritten
            if (currentTime - lastWaveSpawnTime >= delayBetweenWaves) {
                // Nur spawnen, wenn die Enemy Queue leer ist
                if (model.getSpawningQueue().isEmpty()) {
                    // add enemies to the spawning queue
                    queueWave(currentWave);
                    currentWave = model.getWavesQueue().poll();
                    lastWaveSpawnTime = currentTime;
                }
            }
        }
    }

    public void queueWave(Wave wave) {
        List<AbstractEnemy> enemiesToAdd = new ArrayList<>();

        // Gegner hinzufügen
        IntStream.range(0, wave.getNormalEnemyCount()).forEach(i -> enemiesToAdd.add(new NormalEnemy(model.getWaypoints())));
        IntStream.range(0, wave.getFastEnemyCount()).forEach(i -> enemiesToAdd.add(new FastEnemy(model.getWaypoints())));
        IntStream.range(0, wave.getEliteEnemyCount()).forEach(i -> enemiesToAdd.add(new EliteEnemy(model.getWaypoints())));

        // shuffle
        Collections.shuffle(enemiesToAdd, new Random(System.currentTimeMillis()));

        // in die Spawning Queue aufnehmen
        model.getSpawningQueue().addAll(enemiesToAdd);
    }

}
