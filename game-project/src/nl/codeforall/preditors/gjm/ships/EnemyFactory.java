package nl.codeforall.preditors.gjm.ships;

public class EnemyFactory {

    static public Enemy[] generateEnemies() {
          Enemy[] enemies = new Enemy[((int)(Math.random()*(15-10))+10)];

            for(int i = 0; i < enemies.length; i++) {
              enemies[i] = new Enemy();
        }
        return enemies;
    }
}
