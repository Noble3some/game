package nl.codeforall.pr3d1t0rs.gjm;

import nl.codeforall.pr3d1t0rs.gjm.ships.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.LinkedList;

public class Handler implements KeyboardHandler {
    //added game property
    private Player player;

    public Handler(Player player) {
        this.player = player;
    }

    public void init() {

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
                player.setDirection(Direction.RIGHT);
                break;
            case KeyboardEvent.KEY_LEFT:
                player.setDirection(Direction.LEFT);
                break;
            case KeyboardEvent.KEY_SPACE:
                player.shoot();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        player.setDirection(null);
    }

}
