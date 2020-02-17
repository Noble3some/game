package nl.codeforall.pr3d1t0rs.gjm;

import nl.codeforall.pr3d1t0rs.gjm.ships.Enemy;
import nl.codeforall.pr3d1t0rs.gjm.ships.EnemyFactory;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    static int fieldWidth;
    private Rectangle playingField;
    private boolean gameOver;
    private Enemy[] enemies;

    public Game() {
        playingField = new Rectangle(10,10, 300, 700);
        playingField.setColor(Color.GRAY);
        playingField.fill();

    }

    public void makeEnemies() {
        enemies = EnemyFactory.generateEnemies();
    }

    public void makeEnemiesMove() {
        for(int i = 0; i < 50; i++) {
            for(int j = 0; j < enemies.length; j++) {
                enemies[j].moveEnemy();
            }
        }

    }

}
