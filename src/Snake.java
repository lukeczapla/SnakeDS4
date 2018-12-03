import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Snake {

    // directions are represented as Snake.UP, Snake.DOWN, etc. and are just mapped to numbers
    static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;

    int direction = -1;

    Segment head;
    List<Segment> tails = new LinkedList<>();

    public Snake() {
        // put head in the middle
        head = new Segment(Props.xsize/2, Props.ysize/2);
        tails.clear();
    }

    public void setDirection(int d) {
        direction = d;
    }

    public boolean caughtApple(Apple a) {
        return (head.getX() == a.getX() && head.getY() == a.getY());
    }

    public void grow() {
        int newX, newY;
        if (tails.size() > 0) {
            newX = tails.get(tails.size() - 1).getX();
            newY = tails.get(tails.size() - 1).getY();
        } else {
            newX = head.getX();
            newY = head.getY();
        }
        move();
        tails.add(new Segment(newX, newY));
    }

    public void move() {
        // Code to set non-head segments (tails) to follow one closer to head and move the head based on direction
        if (direction == -1) return;  // do nothing if no direction set yet, at the very beginning of the game.
        int oldx = -1, oldy = -1, tmpx = -1, tmpy = -1;
        for (int i = 0; i < tails.size(); i++) {
            if (i == 0) {
                oldx = tails.get(i).getX();
                oldy = tails.get(i).getY();
                tails.get(i).setX(head.getX());
                tails.get(i).setY(head.getY());
            } else {
                tmpx = tails.get(i).getX();
                tmpy = tails.get(i).getY();
                tails.get(i).setX(oldx);
                tails.get(i).setY(oldy);
                oldx = tmpx;
                oldy = tmpy;
            }
        }
        if (direction == UP) {
            head.setY(head.getY()-1);
        }
        if (direction == DOWN) {
            head.setY(head.getY()+1);
        }
        if (direction == LEFT) {
            head.setX(head.getX()-1);
        }
        if (direction == RIGHT) {
            head.setX(head.getX()+1);
        }
    }

    public void draw(Graphics g) {
        if (head != null) head.draw(g);
        for (int i = 0; i < tails.size(); i++) {
            tails.get(i).draw(g);
        }
    }

    public boolean hitWall() {
        int x = head.getX();
        int y = head.getY();
        return (x < 0 || y < 0 || x >= Props.xsize || y >= Props.ysize);
    }

    // return true if any snake segment overlaps coordinates x, y (where x and y are boxes, not screen pixels), false otherwise
    public boolean overlaps(int x, int y) {
        if (head != null && head.getX() == x && head.getY() == y) return true;
        for (int i = 0; i < tails.size(); i++) {
            if (tails.get(i) != null && tails.get(i).getX() == x && tails.get(i).getY() == y) return true;
        }
        return false;
    }

    public boolean selfCollision() {
        for (int i = 0; i < tails.size(); i++) {
            if (head.getX() == tails.get(i).getX() && head.getY() == tails.get(i).getY()) return true;
        }
        return false;
    }

}
