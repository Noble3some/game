package nl.codeforall.pr3d1t0rs.gjm;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

public class Game {

    static int fieldWidth;
    private Rectangle playingField;

    public Game() {
        playingField = new Rectangle(10,10, 300, 700);
        playingField.setColor(Color.GRAY);
        playingField.fill();

    }

}
