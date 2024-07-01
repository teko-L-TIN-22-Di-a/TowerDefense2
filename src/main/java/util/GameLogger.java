package util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class GameLogger {
    private static final Logger logger = Logger.getLogger(GameLogger.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("game.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to initialize logger handler.", e);
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}