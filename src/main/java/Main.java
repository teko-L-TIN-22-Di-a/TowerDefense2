import controller.GameController;
import model.GameModel;
import util.GameLogger;
import view.GameView;

import javax.swing.*;
import java.io.IOException;

import java.util.logging.Logger;

/**
 * Die Main Klasse beinhaltet Game Loop
 */
public class Main {

    private static final Logger logger = GameLogger.getLogger();

    public static void main(String[] args) throws IOException {

        logger.info("Starting Game...");

        final double FPS_PER_SECOND = 60.0;
        final double TIME_PER_FRAME = 1_000_000_000.00 / FPS_PER_SECOND;

        logger.info("Initialising MVC components...");
        GameModel model = new GameModel();
        GameController controller = new GameController(model);
        GameView view = new GameView(model, controller);

        logger.info("Adding waypoints...");
        controller.addWaypoints();

        logger.info("Initialising UI...");
        JFrame jframe = new JFrame();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setContentPane(view);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.setVisible(true);

        // Game Loop
        long lastFrameTime = System.nanoTime();
        long lastTimeCheck = System.currentTimeMillis();
        long now;

        int frames = 0;

        // todo UPDATE und DRAW trennen (UPS / FPS)
        logger.info("Entering game loop...");
        while (true) {
            now = System.nanoTime();

            // Update and Draw
            if (now - lastFrameTime >= TIME_PER_FRAME) {
                lastFrameTime = now;

                // Update
                controller.updateWaves();
                controller.updateEnemies();
                controller.updateTowers();

                // Draw
                view.repaint();

                // Linux: https://stackoverflow.com/questions/57948299/why-does-my-custom-swing-component-repaint-faster-when-i-move-the-mouse-java
                view.revalidate();
                frames++;
            }

            // FPS ausgeben
            /*
            if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
                System.out.println("FPS: " + frames);
                frames = 0;
                lastTimeCheck = System.currentTimeMillis();
            }
            */

            if (controller.playerWon()) {
                System.out.println("Congratulations! You won!");
                logger.info("Game won, leaving game loop...");
                break;
            }

            if (controller.playerLost()) {
                System.out.println("Congratulations! You lost!");
                logger.info("Game lost, leaving game loop...");
                break;
            }
        }
    }
}
