package nl.codeforall.pr3d1t0rs.gjm;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Bullet{

    private boolean spacePushed;
    private Rectangle rectangle;

    public Bullet(int startingX, int startingY, int bulletWidth, int bulletHeight) {
        rectangle = new Rectangle(startingX, startingY, bulletWidth, bulletHeight);
        rectangle.setColor(Color.WHITE);
        rectangle.fill();
    }

    public void move() {
        if (!spacePushed) {
            rectangle.delete();
        }
        goUp();
    }

    public void goUp() {
        rectangle.translate(0, -10);
        rectangle.setColor(Color.WHITE);
        rectangle.fill();
    }

    public void spacePushed() {
        spacePushed = true;
    }

    public boolean isSpacePushed() {
        return spacePushed;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
