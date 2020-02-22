package nl.codeforall.pr3d1t0rs.gjm.ships;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy {

    private Picture enemyship;
    private Picture explosion;
    private EnemyType type;
    protected boolean dead;
    private int sufferStage = 15; //decides how long explosions should be drawn
    private int x;
    private int y;


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
        x = getX();
        y = getY();
        enemyship.delete();
        explosion = new Picture(x, y, "explosion2.png");
        explosion.draw();
    }

    public void sufferStage() {
        sufferStage--;
        if (sufferStage <= 0) {
            explosion.delete();
            return;
        }
        if (sufferStage <= 10) {
            explosion.delete();
            explosion = new Picture(x, y, "explosion3.png");
            explosion.draw();
            sufferStage--;
            return;

        }

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


