package nl.codeforall.pr3d1t0rs.gjm;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Enemy extends Ellipse{

    private Ellipse ellipse;
    private int size;


    public Enemy(int randomSize) {
        super(((int)(Math.random()*280)), ((int)(Math.random()*350)), randomSize, randomSize);
        setEnemyColor();
        fill();
        size = randomSize;
    }

    public void setEnemyColor() {
        if(size < 15) {
            setColor(Color.ORANGE);
        }
        if(size >=15 && size < 20) {
            setColor(Color.MAGENTA);
        }
        if(size >= 20) {
            setColor(Color.RED);
        }
    }

    public void moveEnemy() {
        if(this.getY() >= 600) {
            return;
        }
        if(size < 15) {
            translate(0, 16);
            setColor(Color.ORANGE);
            fill();
        }
        if(size >= 15 && size < 20) {
            translate(0, 8);
            setColor(Color.MAGENTA);
            fill();
        }
        if(size >= 20) {
            translate(0, 5);
            setColor(Color.RED);
            fill();
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Fucked up.");
        }
    }

}
