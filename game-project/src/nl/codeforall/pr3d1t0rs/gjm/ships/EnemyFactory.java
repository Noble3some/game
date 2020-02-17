package nl.codeforall.pr3d1t0rs.gjm.ships;

public class EnemyFactory {

    static public Enemy[] generateEnemies() {
        Enemy[] enemies = new Enemy[((int)(Math.random()*(10-5))+5)];
        for(int i = 0; i < enemies.length; i++) {
            int randomSize = (int)(Math.random()*(25 - 10)) + 10;
            enemies[i] = new Enemy(randomSize);
        }
        return enemies;
    }
}
