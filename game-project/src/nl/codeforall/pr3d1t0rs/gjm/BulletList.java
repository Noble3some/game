package nl.codeforall.pr3d1t0rs.gjm;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class BulletList {

    private Bullet head;
    private Bullet lastUsed;
    private int length = 0;

    public BulletList(int x, int y, int width, int height) {
        this.head = new Bullet(x, y, width, height);
    }

    public Bullet getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public Bullet getLastUsed() {
        return lastUsed;
    }

    //adds a bullet to the linked list when the space bar is pushed
    public void add(int startingX, int startingY, int bulletWidth, int bulletHeight) {
        Bullet bullet = new Bullet(startingX, startingY, bulletWidth, bulletHeight);
        Bullet iterator = head;
        while(iterator.getNext() != null) {
            System.out.println(iterator .getNext());
            iterator = iterator.getNext();
        }
        lastUsed = iterator;
        iterator.setNext(bullet);
        length++;
    }

    public class Bullet {
        private boolean spacePushed;
        private Rectangle rectangle;
        private Bullet next;

        public Bullet(int startingX, int startingY, int bulletWidth, int bulletHeight) {
            rectangle = new Rectangle(startingX, startingY, bulletWidth, bulletHeight);
        }

        public Bullet getNext() {
            return next;
        }

        public void setNext(Bullet next) {
            this.next = next;
        }

        public void goUp() {
            rectangle.translate(0, -7);
            rectangle.setColor(Color.WHITE);
            rectangle.fill();
        }

        public void spacePushed() {
            spacePushed = true;
        }

        public boolean isSpacePushed() {
            return spacePushed;
        }

        public Rectangle getRectangle() {
            return rectangle;
        }

    }

}
