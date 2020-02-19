package nl.codeforall.pr3d1t0rs.gjm.ships;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy{

    //private Ellipse ellipse;

    private Picture enemyship;
    private int size;



    public Enemy() {
        EnemyType type = EnemyType.selectEnemyType();
        int locationX = (int)(Math.random()*(20-680)+680);
        int locationY = (int) (Math.random()* (10-200) + 200);
        System.out.println(locationX);
        System.out.println(type);
        switch (type) {
            case ONE:
                enemyship = new Picture(locationX, locationY, "enemies.png");
                break;
            case TWO:
                enemyship = new Picture(locationX, locationY, "enemies2.png");
                break;
            case THREE:
                enemyship = new Picture( locationX, locationY, "enemies3.png");
                break;
            default:
                enemyship = new Picture(locationX, 0, "enemies.png");
        }

        enemyship.draw();

    }



    public void move() {
        //if(enemyship.getY() >= 600) {
            enemyship.translate(0,5);
        }
        /*if(size < 15) {
            enemyship.translate(0, 16);
            this.setEnemyColor();
            enemyship.fill();
        }
        if(size >= 15 && size < 20) {
            enemyship.translate(0, 8);
            this.setEnemyColor();
            enemyship.fill();
        }
        if(size >= 20) {
            enemyship.translate(0, 5);
            this.setEnemyColor();
            enemyship.fill();
        }

         */
    }


