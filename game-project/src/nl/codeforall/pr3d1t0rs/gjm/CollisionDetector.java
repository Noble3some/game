package nl.codeforall.pr3d1t0rs.gjm;

import nl.codeforall.pr3d1t0rs.gjm.ships.Enemy;
import nl.codeforall.pr3d1t0rs.gjm.ships.Player;

import java.util.LinkedList;

public class CollisionDetector {

    public void collide(Player player, Enemy[] enemies, LinkedList<Bullet> bullets) {
        int playerTop = player.getY() + 13;
        int playerBottom = player.getMaxY();
        int playerLeft = player.getX() + 13 ;
        int playerRight = player.getMaxX() - 13 ;
        bullets.iterator();
        //iterate through linked list of bullets and check for collisions
        for(Enemy enemy : enemies) {
            int enemyTop = enemy.getY();
            int enemyBottom = enemy.getMaxY() - 10;
            int enemyRight = enemy.getMaxX() - 10;
            int enemyLeft = enemy.getX() + 10;

            for(Bullet bullet : bullets) {
                int bulletY = bullet.getY();
                int bulletX = bullet.getX();
                if(bullet.isKaboomed()) {
                    bullets.remove(this);
                }
                if(bulletY <= enemyBottom && bulletX <= enemyRight && bulletX >= enemyLeft && bulletY >= enemyTop && !enemy.isDead() && !bullet.isKaboomed()) {
                    bullet.kaboom();
                    enemy.suffer();
                }
            }
            if (playerTop <= enemyBottom && playerLeft <= enemyRight && playerRight >= enemyLeft && playerBottom >= enemyTop && !enemy.isDead()) {
                player.suffer();
                enemy.suffer();
            }

        }



    }

}
