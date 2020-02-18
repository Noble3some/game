package nl.codeforall.pr3d1t0rs.gjm;

import nl.codeforall.pr3d1t0rs.gjm.ships.Enemy;
import nl.codeforall.pr3d1t0rs.gjm.ships.EnemyFactory;
import nl.codeforall.pr3d1t0rs.gjm.ships.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game {

    static int fieldWidth;
    private Rectangle playingField;
    private boolean gameOver;
    private Enemy[] enemies;
    private Player player;
    private Handler handler;

    public Game() {
    }


    public void drawPlayingField() {
        playingField = new Rectangle(10,10, 300, 700);
        playingField.setColor(Color.GRAY);
        playingField.fill();
    }

    public void init() {
        drawPlayingField();
        enemies = EnemyFactory.generateEnemies();
        player = new Player();
        handler = new Handler(player);
        handler.init();
        moveEverything();
    }

    public void moveBullets() {

    }


    public void moveEverything() {

        while (true) {
            // move player
            player.move();

            // move enemies
            for (Enemy enemy : enemies) {
                enemy.move();
            }

            // move bullets

            handler.getBullet().move();

            // check collisions

            // sleep
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
