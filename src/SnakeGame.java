
import javax.swing.*;

public class SnakeGame extends JFrame {

    public SnakeGame() {
        super("Snake Game by Frisch");
        setSize(Props.width, Props.height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(new GamePanel());
        setVisible(true);
    }

    public void resize() {
        setSize(Props.width, Props.height);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SnakeGame::new);
    }


}
