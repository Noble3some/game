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
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    static int fieldWidth;
    //private Rectangle playingField; becoming a picture

    private Picture playingField;
    private boolean gameOver;
    private Enemy[] enemies;
    private Bullet[] bullets;
    private Player player;
    private KeyboardHandler keyboardHandler;

    public Game() {
    }

    public void drawPlayingField() {
        playingField = new Picture(10,10, "background.jpg");
       //playingField.setColor(Color.GRAY);
        //playingField.fill();
        playingField.draw();
    }

    public void init() {
        drawPlayingField();
        enemies = EnemyFactory.generateEnemies();

        player = new Player();
        Handler handler = new Handler(player);
        handler.init();
        moveEverything();
    }




    public void moveEverything() {
//        for(int i = 0; i < 50; i++) {
//            for(int j = 0; j < enemies.length; j++) {
//                enemies[j].moveEnemy();
//            }
//        }

        while (true) {
            // move player
            player.move();

            // move enemies

            //for (Enemy enemy : enemies) {
            //    enemy.move();
           // }

            // move bullets


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
