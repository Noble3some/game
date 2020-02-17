package nl.codeforall.pr3d1t0rs.gjm;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Bullet extends Rectangle {

    private Rectangle rectangle;

    public Bullet(int startingX, int startingY, int bulletWidth, int bulletHeight) {
        rectangle = new Rectangle();
        rectangle.setColor(Color.WHITE);
        rectangle.fill();
    }

    public void move() {
        rectangle.translate(0, -2);
        rectangle.setColor(Color.WHITE);
        rectangle.fill();
        System.out.println("Pew pew.");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println("You fucked up.");
        }
    }

}
