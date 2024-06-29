import controller.GameController;
import model.GameModel;
import model.enemies.EliteEnemy;
import model.enemies.FastEnemy;
import model.enemies.NormalEnemy;
import view.GameView;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        final double FPS_PER_SECOND = 60.0;
        final double TIME_PER_FRAME = 1_000_000_000.00 / FPS_PER_SECOND;

        GameModel model = new GameModel();
        GameView view = new GameView(model);
        GameController controller = new GameController(model);

        controller.addWaypoints();

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

        // todo Game Loop
        while (true) {
            now = System.nanoTime();

            // Update and Draw
            if (now - lastFrameTime >= TIME_PER_FRAME) {
                lastFrameTime = now;

                // Update
                controller.updateWaves();
                controller.updateEnemies();

                // Draw
                view.repaint();
                frames++;
            }

            // FPS ausgeben
            if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
                System.out.println("FPS: " + frames);
                frames = 0;
                lastTimeCheck = System.currentTimeMillis();
            }
        }
    }
}
