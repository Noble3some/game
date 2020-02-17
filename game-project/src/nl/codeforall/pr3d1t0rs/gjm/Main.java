package nl.codeforall.pr3d1t0rs.gjm;

import nl.codeforall.pr3d1t0rs.gjm.ships.Player;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();

        Player player = new Player();

        game.makeEnemies();
        game.makeEnemiesMove();

    }
}
