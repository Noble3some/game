package nl.codeforall.pr3d1t0rs.gjm;

public class EnemyFactory {

    static public Enemy[] generateEnemies() {
        Enemy[] enemies = new Enemy[((int)(Math.random()*10-5)+5)];
        for(int i = 0; i < enemies.length; i++) {
            enemies[i] = new Enemy();
        }
        return enemies;
    }
}
