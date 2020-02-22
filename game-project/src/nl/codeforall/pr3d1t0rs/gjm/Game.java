package nl.codeforall.pr3d1t0rs.gjm;

import nl.codeforall.pr3d1t0rs.gjm.ships.Enemy;
import nl.codeforall.pr3d1t0rs.gjm.ships.EnemyFactory;
import nl.codeforall.pr3d1t0rs.gjm.ships.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Game {

    static int fieldWidth;

    private Picture playingField;
    private Enemy[] enemies;
    private Player player;
    private LinkedList<Bullet> bullets;
    private CollisionDetector collisionDetector;


    public Game() {

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
                //draw a picture that says "YOU DIED. YOU SUCK."
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
