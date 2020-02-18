package nl.codeforall.pr3d1t0rs.gjm.ships;

import nl.codeforall.pr3d1t0rs.gjm.Bullet;
import nl.codeforall.pr3d1t0rs.gjm.Direction;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player {

    private Direction direction;
    private Rectangle rectangle;
    private Bullet bullet;

    public Player() {
        rectangle = new Rectangle(150,650, 20, 20);
        rectangle.setColor(Color.WHITE);
        rectangle.fill();
        bullet = new Bullet(rectangle.getX(),rectangle.getY(),10, 10);

    }

    public void move() {
        if (direction == null) {
            return;
        }

        if (direction == Direction.RIGHT) {
            moveRight();
        } else {
            moveLeft();
        }
    }

    private void moveRight() {
        if(rectangle.getX() > 280) {
            return;
        }
        rectangle.translate(5, 0);
        rectangle.fill();
    }

    private void moveLeft() {
        if(rectangle.getX() < 20) {
            return;
        }
        rectangle.translate(-5, 0);
        rectangle.fill();
    }

    public void shoot() {
        bullet.move();
    }




    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
