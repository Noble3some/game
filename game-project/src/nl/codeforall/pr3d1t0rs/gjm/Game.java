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
    private Player player;
    private BulletList bulletList;
    //TODO Get rid of BulletList class; only have the Bullet class; the game stores each bullet in the container (probably linked list)


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
        bulletList = new BulletList(0,0, 0,0);
        Handler handler = new Handler(player, bulletList);
        handler.init();
        moveEverything();
    }

    public void moveBullets() {
      //TODO iterate through the list and move each bullet
        //for(Bullet b : buletList){
        //    bullet.goUp();
        //}

        bulletList.getHead().getNext().goUp();
        bulletList.getLastUsed().goUp();
        bulletList.getLastUsed().getNext().goUp();
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
            if(bulletList.getLength() > 0) {
                moveBullets();

            }


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
