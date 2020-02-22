package nl.codeforall.pr3d1t0rs.gjm.ships;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy {

    private Picture enemyship;
    private EnemyType type;
    protected boolean dead;

    public Enemy() {
        EnemyType type = EnemyType.selectEnemyType();
        int locationX = (int) (Math.random() * (20 - 680) + 680);
        int locationY = (int) (Math.random() * (10 - 200) + 200);
        switch (type) {
            case ONE:
                enemyship = new Picture(locationX, locationY, "enemies.png");
                this.type = EnemyType.ONE;
                break;
            case TWO:
                enemyship = new Picture(locationX, locationY, "enemies2.png");
                this.type = EnemyType.TWO;
                break;
            case THREE:
                enemyship = new Picture(locationX, locationY, "enemies3.png");
                this.type = EnemyType.THREE;
                break;
            default:
                enemyship = new Picture(locationX, 0, "enemies.png");
        }

        enemyship.draw();

    }

    public boolean isDead() {
        return dead;
    }

    public int getX() {
        return enemyship.getX();
    }

    public int getMaxX() {
        return enemyship.getMaxX();
    }

    public int getY() {
        return enemyship.getY();
    }

    public int getMaxY() {
        return enemyship.getMaxY();
    }

    public void suffer() {
        dead = true;
        enemyship.delete();
    }

    public Picture getEnemyship() {
        return enemyship;
    }

    public void move() {
       if (enemyship.getY() <= 701) {
           switch (type) {
               case TWO: enemyship.translate(0, 3);
               default: enemyship.translate(0, 2);
           }
        } else {
           suffer();
       }


    }
}


