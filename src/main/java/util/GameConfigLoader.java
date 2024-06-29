package util;

import model.config.GameConfig;

import java.io.FileInputStream;
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

        return new GameConfig(delayBetweenEnemies, delayBetweenWaves);
    }
}
