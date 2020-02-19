package nl.codeforall.pr3d1t0rs.gjm;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Bullet{

    private Rectangle rectangle;
    private boolean fired;

    public Bullet(int startingX, int startingY, int bulletWidth, int bulletHeight, boolean fired) {
        rectangle = new Rectangle(startingX, startingY, bulletWidth, bulletHeight);
        this.fired = fired;
        rectangle.setColor(Color.WHITE);
        rectangle.fill();
    }

    public void move() {
        if (!fired) {
            return;
        }
        rectangle.translate(0,-50);
        rectangle.setColor(Color.WHITE);
        rectangle.fill();
        System.out.println("Pew pew.");
        }


}
