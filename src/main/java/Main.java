import controller.GameController;
import model.GameModel;
import model.enemies.BasicEnemy;
import model.towers.FreezingTower;
import model.towers.ShootingTower;
import model.towers.TeleportingTower;
import view.GameView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Main : main");

        GameModel model = new GameModel();
        GameView view = new GameView(model);
        GameController controller = new GameController(model, view);

        // DEV:
        controller.addEnemy(new BasicEnemy(10, 10, 250, 0, 30));
        controller.addEnemy(new BasicEnemy(40, 10, 250, 0, 30));

        controller.addTower(new ShootingTower(70, 10, 1, 150, 10.0, 0.5, 100, 0.5));
        controller.addTower(new FreezingTower(100, 10, 1, 150, 10.0, 0.5, 120, 0.9));
        controller.addTower(new TeleportingTower(130, 10, 1,150, 10.0, 0.5, 0.9));

        JFrame jframe = new JFrame();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setContentPane(view);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);

    }
}
