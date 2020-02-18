package nl.codeforall.pr3d1t0rs.gjm.ships;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Enemy{

    private Ellipse ellipse;
    private int size;


    public Enemy() {
        int randomSize = (int)((Math.random()*30 - 15) + 15);
        System.out.println(size = randomSize);
        ellipse = new Ellipse(((int)(Math.random()*280)),((int)(Math.random()*350)), randomSize, randomSize);
        this.setEnemyColor();
        ellipse.draw();
        ellipse.fill();
    }

    public void setEnemyColor() {
        if(size < 15) {
            ellipse.setColor(Color.ORANGE);
        }
        if(size >=15 && size < 20) {
            ellipse.setColor(Color.MAGENTA);
        }
        if(size >= 20) {
            ellipse.setColor(Color.RED);
        }
    }

    public void move() {
        if(ellipse.getY() >= 600) {
            return;
        }
        if(size < 15) {
            ellipse.translate(0, 16);
            this.setEnemyColor();
            ellipse.fill();
        }
        if(size >= 15 && size < 20) {
            ellipse.translate(0, 8);
            this.setEnemyColor();
            ellipse.fill();
        }
        if(size >= 20) {
            ellipse.translate(0, 5);
            this.setEnemyColor();
            ellipse.fill();
        }
    }

}
