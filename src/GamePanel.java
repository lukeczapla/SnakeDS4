import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

    JLabel l = new JLabel(this.toString());
    JButton pauseButton;
    JButton restartButton;

    Timer timer = new Timer(200, this);
    boolean paused = false;

    boolean caught = false;
    boolean lost = false;

    int points = 0;

    Snake snake = new Snake();
    Apple apple = new Apple(snake);

    public GamePanel() {
        pauseButton = new JButton("Pause");
        pauseButton.setVisible(true);
        pauseButton.addActionListener(this);
        add(pauseButton);
        restartButton = new JButton("Restart");
        restartButton.setVisible(true);
        restartButton.addActionListener(this);
        add(restartButton);
        setBackground(Props.backgroundColor);
        setFocusable(true);
        addKeyListener(this);
        repaint();
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(Props.gridtopX, Props.gridtopY, Props.gridwidth * Props.xsize, Props.gridheight * Props.ysize);
        if (lost) {
            g.setFont(Props.font1);
            g.drawString("YOU LOST", Props.width/2-80, Props.height/2);
            return;
        }
        for (int i = 0; i < Props.xsize; i++) {
            for (int j = 0; j < Props.ysize; j++) {
                g.setColor(Props.squareColor);
                g.fillRect(Props.gridtopX+i*Props.gridwidth, Props.gridtopY+j*Props.gridheight, Props.gridwidth, Props.gridheight);
                g.setColor(Props.squareOutlineColor);
                g.drawRect(Props.gridtopX+i*Props.gridwidth, Props.gridtopY+j*Props.gridheight, Props.gridwidth, Props.gridheight);
            }
        }
        apple.draw(g);
        snake.draw(g);
    }


    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            snake.setDirection(Snake.UP);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            snake.setDirection(Snake.DOWN);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            snake.setDirection(Snake.LEFT);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            snake.setDirection(Snake.RIGHT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(timer)) {
            // update snake, check for collisions, check for caught apples (and grow snake), etc.
            if (!caught) {
                snake.move();
                if (snake.hitWall() || snake.selfCollision()) {
                    lost = true;
                }
                caught = snake.caughtApple(apple);
            } else {
                apple = new Apple(snake);
                snake.grow();
                points++;
                if (snake.hitWall() || snake.selfCollision()) {
                    lost = true;
                }
                timer.setDelay(timer.getDelay()-3);
                caught = false;
            }
            repaint();
        }

        if (e.getSource().equals(pauseButton)) {
            if (paused) {
                System.out.println("Starting timer");
                timer.start();
                grabFocus();
            } else {
                System.out.println("Stopping timer");
                timer.stop();
                grabFocus();
            }
            paused = !paused;
        }

        if (e.getSource().equals(restartButton)) {
            snake = new Snake();
            apple = new Apple(snake);
            caught = false;
            lost = false;
            points = 0;
            grabFocus();
            repaint();
        }
    }
}
