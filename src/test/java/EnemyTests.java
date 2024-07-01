import static org.junit.Assert.*;

import model.enemies.EliteEnemy;
import model.enemies.FastEnemy;
import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import model.enemies.BasicEnemy;
import model.config.GameConfig;
import util.GameConfigLoader;

public class EnemyTests {

    private static GameConfigLoader gameConfigLoader;
    private GameConfig gameConfig;

    private BasicEnemy basicEnemy;
    private FastEnemy fastEnemy;
    private EliteEnemy eliteEnemy;
    private List<Point2D.Double> waypoints;

    @Before
    public void setUp() {
        this.gameConfig = GameConfigLoader.loadConfig("/gameConfig.properties");

        waypoints = new ArrayList<>();
        waypoints.add(new Point2D.Double(10.0,12.0));
        waypoints.add(new Point2D.Double(12.0,14.0));

        basicEnemy = new BasicEnemy(waypoints);
        fastEnemy = new FastEnemy(waypoints);
        eliteEnemy = new EliteEnemy(waypoints);
    }

    @Test
    public void testEnemyInitialPosX() {
        assertEquals(10, basicEnemy.getX());
        assertEquals(10, fastEnemy.getX());
        assertEquals(10, eliteEnemy.getX());
    }

    @Test
    public void testEnemyInitialPosY() {
        assertEquals(12, basicEnemy.getY());
        assertEquals(12, fastEnemy.getY());
        assertEquals(12, eliteEnemy.getY());
    }
}
