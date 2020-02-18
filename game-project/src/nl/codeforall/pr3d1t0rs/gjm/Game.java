package nl.codeforall.pr3d1t0rs.gjm;

import nl.codeforall.pr3d1t0rs.gjm.ships.Enemy;
import nl.codeforall.pr3d1t0rs.gjm.ships.EnemyFactory;
import nl.codeforall.pr3d1t0rs.gjm.ships.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    static int fieldWidth;
    private Rectangle playingField;
    private boolean gameOver;
    private Enemy[] enemies;
    private Player player;

    public Game() {
        playingField = new Rectangle(10,10, 300, 700);
        playingField.setColor(Color.GRAY);
        playingField.fill();

    }

    public void init() {
        enemies = EnemyFactory.generateEnemies();
        player = new Player();
    }

    public void makeEnemiesMove() {
//        for(int i = 0; i < 50; i++) {
//            for(int j = 0; j < enemies.length; j++) {
//                enemies[j].moveEnemy();
//            }
//        }

        while (true) {
            // move player
            player.move();

            // move enemies
            for (Enemy enemy : enemies) {
                enemy.move();
            }

            // move bullets

            // check collisions

            // sleep
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
