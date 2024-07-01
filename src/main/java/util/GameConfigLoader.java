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

        int rows = Integer.parseInt(properties.getProperty("rows"));
        int columns = Integer.parseInt(properties.getProperty("columns"));
        int tileSize = Integer.parseInt(properties.getProperty("tileSize"));
        int delayBetweenEnemies = Integer.parseInt(properties.getProperty("delayBetweenEnemies"));
        int delayBetweenWaves = Integer.parseInt(properties.getProperty("delayBetweenWaves"));
        int startingHealth = Integer.parseInt(properties.getProperty("startingHealth"));
        int startingCoins = Integer.parseInt(properties.getProperty("startingCoins"));
        int basicTowerCost = Integer.parseInt(properties.getProperty("basicTowerCost"));
        int basicTowerCooldown = Integer.parseInt(properties.getProperty("basicTowerCooldown"));
        int basicTowerRange = Integer.parseInt(properties.getProperty("basicTowerRange"));
        int basicTowerDamage = Integer.parseInt(properties.getProperty("basicTowerDamage"));

        return new GameConfig(
                rows,
                columns,
                tileSize,
                delayBetweenEnemies,
                delayBetweenWaves,
                startingHealth,
                startingCoins,
                basicTowerCost,
                basicTowerCooldown,
                basicTowerRange,
                basicTowerDamage);
    }
}
