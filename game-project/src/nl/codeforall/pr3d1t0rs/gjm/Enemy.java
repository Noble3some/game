package nl.codeforall.pr3d1t0rs.gjm;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Enemy extends Ellipse{

    private static final int RANDOM_SIZE = (int)(Math.random()*30 - 15) + 15;
    private Ellipse ellipse;
    private int size;


    public Enemy() {
        super(((int)(Math.random()*300)), ((int)(Math.random()*350)), RANDOM_SIZE, RANDOM_SIZE);
        this.setColor(Color.RED);
        this.fill();
    }

    public void moveEnemy() {
        translate(0, 5);
        setColor(Color.RED);
        fill();

    }

}
