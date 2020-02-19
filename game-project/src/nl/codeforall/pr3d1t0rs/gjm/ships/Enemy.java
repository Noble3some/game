package nl.codeforall.pr3d1t0rs.gjm.ships;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy{

    //private Ellipse ellipse;

    private Picture enemyship;
    private int size;


    public Enemy() {
        enemyship = new Picture(360, 0, "enemies.png");
        enemyship.draw();

    }



    public void move() {
        //if(enemyship.getY() >= 600) {
            enemyship.translate(0,5);
        }
        /*if(size < 15) {
            enemyship.translate(0, 16);
            this.setEnemyColor();
            enemyship.fill();
        }
        if(size >= 15 && size < 20) {
            enemyship.translate(0, 8);
            this.setEnemyColor();
            enemyship.fill();
        }
        if(size >= 20) {
            enemyship.translate(0, 5);
            this.setEnemyColor();
            enemyship.fill();
        }

         */
    }


