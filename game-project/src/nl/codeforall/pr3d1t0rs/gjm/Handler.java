package nl.codeforall.pr3d1t0rs.gjm;

import nl.codeforall.pr3d1t0rs.gjm.ships.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Handler implements KeyboardHandler {

    private Player player;


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
