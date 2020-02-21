package nl.codeforall.pr3d1t0rs.gjm.ships;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy {

    //private Ellipse ellipse;

    private Picture enemyship;
    private EnemyType type;


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
                break;
            case THREE:
                enemyship = new Picture(locationX, locationY, "enemies3.png");
                break;
            default:
                enemyship = new Picture(locationX, 0, "enemies.png");
        }

        enemyship.draw();

    }

    public Picture getEnemyship() {
        return enemyship;
    }

    public void move() {
       if (enemyship.getY() <= 700) {
            enemyship.translate(0, 5);
        }


    }
}


