package nl.codeforall.pr3d1t0rs.gjm.ships;

import nl.codeforall.pr3d1t0rs.gjm.Bullet;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player implements KeyboardHandler {

    private Rectangle rectangle;


    public Player() {
        rectangle = new Rectangle(150,650, 20, 20);
        rectangle.setColor(Color.WHITE);
        rectangle.fill();
        initKeyboard();
    }


    public void moveRight() {
        if(rectangle.getX() > 280) {
            return;
        }
        rectangle.translate(10, 0);
        rectangle.fill();
    }

    public void moveLeft() {
        if(rectangle.getX() < 20) {
            return;
        }
        rectangle.translate(-10, 0);
        rectangle.fill();
    }

    public void shoot() {
        Bullet bullet = new Bullet(rectangle.getX(), rectangle.getY(), 10, 10);
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

    }

    @Override

    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch(keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                moveRight();
                break;
            case KeyboardEvent.KEY_LEFT:
                moveLeft();
                break;
            case KeyboardEvent.KEY_SPACE:
                shoot();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {}

}
