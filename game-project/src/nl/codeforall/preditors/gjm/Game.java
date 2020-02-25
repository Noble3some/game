package nl.codeforall.preditors.gjm;

import nl.codeforall.preditors.gjm.ships.Enemy;
import nl.codeforall.preditors.gjm.ships.EnemyFactory;
import nl.codeforall.preditors.gjm.ships.MusicPlayer;
import nl.codeforall.preditors.gjm.ships.Player;
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
        startScreen = new Picture(10,10, "startscreen.png");
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
        Handler handler = new Handler(player);
        handler.init();
        collisionDetector = new CollisionDetector();
        drawStartScreen();
        Thread thread = new Thread(){
            public void run(){
                MusicPlayer AudioPlayer = new MusicPlayer();
                try {
                    AudioPlayer.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

        while (!player.isShooting()) {
            Thread.sleep(10);
        }

        player.resetShooting();
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

            if (player.isShooting()) {
                bullets.add(new Bullet(player.getSpaceship().getX()+25, player.getSpaceship().getY(), 3, 5));
                player.resetShooting();
            }

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
            //check if all enemies are dead and spawn new ones
            int enemyCounter = enemies.length;
            for (Enemy enemy : enemies) {
                if (enemy.isDead()) {
                    enemyCounter--;
                }
                if (enemyCounter == 0) {
                    for (Enemy enemy1 : enemies) {
                        enemy1.deleteExplosions();
                    }
                    enemies = EnemyFactory.generateEnemies();

                }
            }

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
