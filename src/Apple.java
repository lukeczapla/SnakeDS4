import java.awt.*;

public class Apple {

    private int x, y;

    enum Shape {
        APPLE, COUGAR
    }

    Shape appleShape;

    public Apple(Snake s) {
        appleShape = Shape.APPLE;
        do {
            x = (int)(Props.xsize*Math.random());
            y = (int)(Props.ysize*Math.random());
        } while (Math.abs(s.head.getX() - x) < 4 && Math.abs(s.head.getY() - y) < 4);
    }

    public void draw(Graphics g) {
        g.setColor(Props.appleColor);
        g.fillOval(Props.gridtopX+x*Props.gridwidth, Props.gridtopY+y*Props.gridheight,
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
