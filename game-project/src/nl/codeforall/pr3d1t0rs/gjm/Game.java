package nl.codeforall.pr3d1t0rs.gjm;

import nl.codeforall.pr3d1t0rs.gjm.ships.Enemy;
import nl.codeforall.pr3d1t0rs.gjm.ships.EnemyFactory;
import nl.codeforall.pr3d1t0rs.gjm.ships.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Game {

    public static final int PADDING = 10;
    public static final int FIELD_WIDTH = 720 - PADDING;
    private Picture startScreen;
    private Picture playingField;
    private Enemy[] enemies;
    private Player player;
    private LinkedList<Bullet> bullets;
    private CollisionDetector collisionDetector;


    public Game() {

    }

    public void drawStartScreen() {
        startScreen = new Picture(10,10, "prepare.png");
        startScreen.draw();
    }

    public void drawPlayingField() {
        playingField = new Picture(10,10, "background.jpg");
        playingField.draw();
    }

    public void init() throws Exception {
        drawPlayingField();
        enemies = EnemyFactory.generateEnemies();
        player = new Player();
        bullets = new LinkedList<Bullet>();
        Handler handler = new Handler(player, bullets);
        handler.init();
        collisionDetector = new CollisionDetector();
        drawStartScreen();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        moveEverything();
    }

    public void moveBullets() {
        for(Bullet bullet : bullets) {
            if(bullet.isKaboomed()) {
                continue;
            }
            bullet.goUp();
        }
    }

    public void moveEverything() {
        //delete startscreen
        startScreen.delete();

        while (true) {

            // move player
            player.move();

            // move enemies
            for (Enemy enemy : enemies) {
                if (!enemy.isDead()) {
                    enemy.move();
                } else if (enemy.isDead()) {
                    enemy.sufferStage();
                }

            }
            //chekc if all enemies are dead and spwan new ones
            int enemyCounter = enemies.length;
            for (Enemy enemy : enemies) {
                if (enemy.isDead()) {
                    enemyCounter--;
                }
                if (enemyCounter ==0) {
                    enemies = EnemyFactory.generateEnemies();

                }
            }

            // delete bullet from linked list if it has gotten boolean state "has gone off screen"
            // move bullets
            if(bullets.size() > 0) {
                moveBullets();
            }

            // check collisions
            collisionDetector.collide(player, enemies, bullets);

            if(player.isDead()) {
                Picture gameover = new Picture( 10, 10, "gameover.png");
                gameover.draw();
                return;
            }
            // sleep
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
