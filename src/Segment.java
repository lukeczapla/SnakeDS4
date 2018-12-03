import java.awt.*;

public class Segment {

    private int x, y;

    public Segment(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveSegment(Segment other) {
        this.x = other.x;
        this.y = other.y;
    }

    public void draw(Graphics g) {
       // we want to draw in a segment of the snake
        g.setColor(Props.snakeColor);
        g.fillRect(Props.gridtopX+x*Props.gridwidth, Props.gridtopY+y*Props.gridheight,
                Props.gridwidth, Props.gridheight);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
