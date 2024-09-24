package util;

import model.config.GameConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Bei der Klasse GameConfigLoader handelt es sich um eine Helper Klasse.
 * Diese Klasse liest die Werte aus der Datei 'gameConfig.properties' aus
 * und erstellt eine Instanz der Klasse GameConfig
 */
public class GameConfigLoader {

    /**
     * Liest die Spielkonfiguration ein und erstellt eine Instanz der Klasse GameConfig
     * @param resourcePath Pfad zur Datei mit der Spielkonfiguration
     * @return GameConfig
     */
    public static GameConfig loadConfig(String resourcePath) {
        Properties properties = new Properties();
        try (InputStream is = ImageLoader.class.getResourceAsStream(resourcePath)) {
            properties.load(is);
        } catch (IOException e) {
            System.err.println("Failed to load resource: " + resourcePath);
            return null;
        }

        // UI
        int rows = Integer.parseInt(properties.getProperty("rows"));
        int columns = Integer.parseInt(properties.getProperty("columns"));
        int tileSize = Integer.parseInt(properties.getProperty("tileSize"));

        // Enemy Spawning
        int delayBetweenEnemies = Integer.parseInt(properties.getProperty("delayBetweenEnemies"));
        int delayBetweenWaves = Integer.parseInt(properties.getProperty("delayBetweenWaves"));
        boolean endlessEnemiesMode = Boolean.parseBoolean(properties.getProperty("endlessEnemiesMode"));

        // Spieler
        int startingHealth = Integer.parseInt(properties.getProperty("startingHealth"));
        int startingCoins = Integer.parseInt(properties.getProperty("startingCoins"));

        // Basic Tower
        int basicTowerCost = Integer.parseInt(properties.getProperty("basicTowerCost"));
        int basicTowerCooldown = Integer.parseInt(properties.getProperty("basicTowerCooldown"));
        int basicTowerRange = Integer.parseInt(properties.getProperty("basicTowerRange"));
        int basicTowerDamage = Integer.parseInt(properties.getProperty("basicTowerDamage"));

        // Teleporting Tower
        int teleportingTowerCost = Integer.parseInt(properties.getProperty("teleportingTowerCost"));
        int teleportingTowerCooldown = Integer.parseInt(properties.getProperty("teleportingTowerCooldown"));
        int teleportingTowerRange = Integer.parseInt(properties.getProperty("teleportingTowerRange"));
        int teleportingTowerDamage = Integer.parseInt(properties.getProperty("teleportingTowerDamage"));

        // Freezing Tower
        int freezingTowerCost = Integer.parseInt(properties.getProperty("freezingTowerCost"));
        int freezingTowerCooldown = Integer.parseInt(properties.getProperty("freezingTowerCooldown"));
        int freezingTowerRange = Integer.parseInt(properties.getProperty("freezingTowerRange"));
        int freezingTowerDamage = Integer.parseInt(properties.getProperty("freezingTowerDamage"));

        return new GameConfig(
                rows,
                columns,
                tileSize,
                delayBetweenEnemies,
                delayBetweenWaves,
                endlessEnemiesMode,
                startingHealth,
                startingCoins,
                basicTowerCost,
                basicTowerCooldown,
                basicTowerRange,
                basicTowerDamage,
                teleportingTowerCost,
                teleportingTowerCooldown,
                teleportingTowerRange,
                teleportingTowerDamage,
                freezingTowerCost,
                freezingTowerCooldown,
                freezingTowerRange,
                freezingTowerDamage);
    }
}
