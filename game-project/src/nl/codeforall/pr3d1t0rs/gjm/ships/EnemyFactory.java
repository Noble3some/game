package nl.codeforall.pr3d1t0rs.gjm.ships;

public class EnemyFactory {

    static public Enemy[] generateEnemies() {
          //added number of enemies for testing purposes
          Enemy[] enemies = new Enemy[((int)(Math.random()*(15-10))+10)];

            for(int i = 0; i < enemies.length; i++) {
              enemies[i] = new Enemy();
        }
        return enemies;
    }
}
