package nl.codeforall.pr3d1t0rs.gjm.ships;


import nl.codeforall.pr3d1t0rs.gjm.Direction;
import nl.codeforall.pr3d1t0rs.gjm.Game;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private Direction direction;
    private Picture spaceship;
    private int playingFieldSize = 720;
    private int padding = 10;
    private boolean shooting = false;

    private boolean dead;


    public Player() {
        //load the ship but do not show it yet
        spaceship = new Picture(0, 620, "spaceship.png");
        //decide where the ship should first be shown
        int spawnpoint = (playingFieldSize / 2) - (spaceship.getWidth() /2) + padding;
        //go there
        int currentLocation = spaceship.getX();
            for (int i =currentLocation; i< spawnpoint; i++) {
                spaceship.translate(1,0);
            }

        //make the ship appear for the first time
        spaceship.draw();

    }

    public Picture getSpaceship() {
        return spaceship;
    }

    public int getY() {
        return spaceship.getY();
    }

    public int getMaxY() {
        return spaceship.getMaxY();
    }

    public int getX() {
        return spaceship.getX();
    }

    public int getMaxX() {
        return spaceship.getMaxX();
    }

    public boolean isDead() {
        return dead;
    }

    public void suffer() {
        dead = true;
        spaceship.delete();
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
        if(spaceship.getMaxX() > Game.FIELD_WIDTH) {
            return;
        }
        spaceship.translate(10, 0);
    }

    private void moveLeft() {
        if(spaceship.getX() < 20) {
            return;
        }
        spaceship.translate(-5, 0);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void shoot() {
        shooting = true;
    }

    public boolean isShooting() {
        return shooting;
    }

    public void resetShooting() {
        shooting = false;
    }
}
