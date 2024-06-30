package util;

import model.config.GameConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GameConfigLoader {
    public static GameConfig loadConfig(String resourcePath) {
        Properties properties = new Properties();
        try (InputStream is = ResourceLoader.class.getResourceAsStream(resourcePath)) {
            properties.load(is);
        } catch (IOException e) {
            System.err.println("Failed to load resource: " + resourcePath);
            return null;
        }

        int delayBetweenEnemies = Integer.parseInt(properties.getProperty("delayBetweenEnemies"));
        int delayBetweenWaves = Integer.parseInt(properties.getProperty("delayBetweenWaves"));
        int startingHealth = Integer.parseInt(properties.getProperty("startingHealth"));
        int startingCoins = Integer.parseInt(properties.getProperty("startingCoins"));
        int basicTowerCost = Integer.parseInt(properties.getProperty("basicTowerCost"));
        int basicTowerCooldown = Integer.parseInt(properties.getProperty("basicTowerCooldown"));
        int basicTowerRange = Integer.parseInt(properties.getProperty("basicTowerRange"));

        return new GameConfig(
                delayBetweenEnemies,
                delayBetweenWaves,
                startingHealth,
                startingCoins,
                basicTowerCost,
                basicTowerCooldown,
                basicTowerRange);
    }
}
