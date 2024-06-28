import controller.GameController;
import model.GameModel;
import model.enemies.Enemy;
import model.movement.Waypoint;
import view.GameView;

import javax.swing.*;
import java.awt.geom.Point2D;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        final double FPS_PER_SECOND = 60.0;
        final double TIME_PER_FRAME = 1_000_000_000.00 / FPS_PER_SECOND;

        GameModel model = new GameModel();
        GameView view = new GameView(model);
        GameController controller = new GameController(model, view);

        // Waypoints
        model.addWaypoint(new Point2D.Double(832,-64));
        model.addWaypoint(new Point2D.Double(832, 256));
        model.addWaypoint(new Point2D.Double(640, 256));
        model.addWaypoint(new Point2D.Double(640, 128));
        model.addWaypoint(new Point2D.Double(128, 128));
        model.addWaypoint(new Point2D.Double(128, 640));
        model.addWaypoint(new Point2D.Double(320, 640));
        model.addWaypoint(new Point2D.Double(320, 384));
        model.addWaypoint(new Point2D.Double(512, 384));
        model.addWaypoint(new Point2D.Double(512, 448));
        model.addWaypoint(new Point2D.Double(896, 448));
        model.addWaypoint(new Point2D.Double(896, 832));
        model.addWaypoint(new Point2D.Double(704, 832));
        model.addWaypoint(new Point2D.Double(704, 640));
        model.addWaypoint(new Point2D.Double(512, 640));
        model.addWaypoint(new Point2D.Double(512, 832));
        model.addWaypoint(new Point2D.Double(-64, 832));

        // Enemies
        controller.addEnemy(new Enemy(model.getWaypoints(), 2));

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
