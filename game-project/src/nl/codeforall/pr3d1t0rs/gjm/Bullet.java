package nl.codeforall.pr3d1t0rs.gjm;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Bullet {

    private boolean spacePushed;
    private Rectangle rectangle;

    public Bullet(int startingX, int startingY, int bulletWidth, int bulletHeight) {
        rectangle = new Rectangle(startingX, startingY, bulletWidth, bulletHeight);
    }

    public void goUp() {
        if(rectangle.getY() <= 0) {
            rectangle.delete();
            return;
        }
        rectangle.translate(0, -7);
        rectangle.setColor(Color.WHITE);
        rectangle.fill();
    }


}


