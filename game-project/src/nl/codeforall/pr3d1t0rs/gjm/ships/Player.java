package nl.codeforall.pr3d1t0rs.gjm.ships;


import nl.codeforall.pr3d1t0rs.gjm.Direction;
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
    // get too load the spaceship

    public Player() {
        //load the ship but do not show it yet
        spaceship = new Picture(0, 620, "spaceship.png");
        //decide where the ship should first be shown
        int spawnpoint = (playingFieldSize / 2) - (spaceship.getWidth() /2) + padding;
       // System.out.println("spawnpoint is: " +spawnpoint);
        //go there
        int currentLocation = spaceship.getX();
            for (int i =currentLocation; i< spawnpoint; i++) {
                spaceship.translate(1,0);
            }

        //make the ship appear for the first time
        spaceship.draw();
        //bullet = new Bullet(spaceship.getX(),spaceship.getY(),10, 10);

    }

    public Picture getSpaceship() {
        return spaceship;
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
        if(spaceship.getX() > 670) {
            return;
        }
        spaceship.translate(5, 0);
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
}
