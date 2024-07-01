package controller;

import model.GameModel;
import model.enemies.*;
import model.waves.Wave;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Die Klasse WaveManager ist für das Wellenmodel zuständig, nach welchem die Gegner erscheinen
 */
public class WaveManager {
    /**
     * Instanz der Klasse GameModel, beinhaltet den Spielzustand
     */
    private GameModel model;
    /**
     * Gegnerwelle, welche gerade verarbeitet wird
     */
    private Wave currentWave;
    /**
     * Verzögerung zwischen den Gegnerwellen
     */
    private final int delayBetweenWaves;
    /**
     * Zeitstempel, wann eine Gengerwelle zuletzt gespawnt wurde
     */
    private long lastWaveSpawnTime;

    /**
     * Konstruktor
     * Der Wert delayBetweenWaves ist ein Bestandteil der Konfig 'gameConfig.properties'
     * @param model Instanz der Klasse GameModel
     */
    public WaveManager(GameModel model) {
        this.model = model;
        this.currentWave = model.getWavesQueue().poll();
        this.delayBetweenWaves = model.getGameConfig().getDelayBetweenWaves();
        this.lastWaveSpawnTime = System.currentTimeMillis();
    }

    /**
     * Eine neue Gegnerwelle in die SpawningQueue aufnehmen, wenn keine Gegner in der Queue vorhanden sind
     */
    public void updateWaves() {
        if (!model.getWavesQueue().isEmpty()) {
            long currentTime = System.currentTimeMillis();
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

    /**
     * Eine Gegnerwalle in die Gegnerinstanzen umwandeln und in die Spawning Queue aufnehmen
     * @param wave Gengerwelle
     */
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
