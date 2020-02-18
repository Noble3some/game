package nl.codeforall.pr3d1t0rs.gjm.ships;

import nl.codeforall.pr3d1t0rs.gjm.Bullet;
import nl.codeforall.pr3d1t0rs.gjm.Direction;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player implements KeyboardHandler {

    private Direction direction;
    private Rectangle rectangle;
    private Bullet bullet;

    public Player() {
        rectangle = new Rectangle(150,650, 20, 20);
        rectangle.setColor(Color.WHITE);
        rectangle.fill();
        bullet = new Bullet(rectangle.getX(),rectangle.getY(),10, 10);
        initKeyboard();
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
        bullet.fill();
        bullet.move();
    }

    public void initKeyboard() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent pressRight = new KeyboardEvent();
        pressRight.setKey(KeyboardEvent.KEY_RIGHT);
        pressRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressRight);

        KeyboardEvent pressLeft = new KeyboardEvent();
        pressLeft.setKey(KeyboardEvent.KEY_LEFT);
        pressLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressLeft);

        KeyboardEvent pressSpace = new KeyboardEvent();
        pressSpace.setKey(KeyboardEvent.KEY_SPACE);
        pressSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressSpace);

        KeyboardEvent releaseLeft = new KeyboardEvent();
        releaseLeft.setKey(KeyboardEvent.KEY_LEFT);
        releaseLeft.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(releaseLeft);

        KeyboardEvent releaseRight = new KeyboardEvent();
        releaseRight.setKey(KeyboardEvent.KEY_RIGHT);
        releaseRight.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(releaseRight);
    }

    @Override

    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch(keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                setDirection(Direction.RIGHT);
                break;
            case KeyboardEvent.KEY_LEFT:
                setDirection(Direction.LEFT);
                break;
            case KeyboardEvent.KEY_SPACE:
                shoot();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        setDirection(null);
    }


    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
