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
    private KeyboardHandler keyboardHandler;

    public Game() {
        playingField = new Rectangle(10,10, 300, 700);
        playingField.setColor(Color.GRAY);
        playingField.fill();

    }

    public void init() {
        enemies = EnemyFactory.generateEnemies();
        player = new Player();
        initKeyboard();
    }

    public void initKeyboard() {
        KeyboardHandler keyboardHandler = new Handler();

        Keyboard keyboard = new Keyboard(keyboardHandler);

        KeyboardEvent pressRight = new KeyboardEvent();
        pressRight.setKey(KeyboardEvent.KEY_RIGHT);
        pressRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressRight);

        KeyboardEvent pressLeft = new KeyboardEvent();
        pressLeft.setKey(KeyboardEvent.KEY_LEFT);
        pressLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressLeft);

        KeyboardEvent pressSpace = new KeyboardEvent();
        pressSpace.setKey(KeyboardEvent.KEY_SPACE);
        pressSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressSpace);

        KeyboardEvent releaseLeft = new KeyboardEvent();
        releaseLeft.setKey(KeyboardEvent.KEY_LEFT);
        releaseLeft.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(releaseLeft);

        KeyboardEvent releaseRight = new KeyboardEvent();
        releaseRight.setKey(KeyboardEvent.KEY_RIGHT);
        releaseRight.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(releaseRight);
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
