import javax.swing.*;

public class SnakeGame extends JFrame {

    public SnakeGame() {
        setSize(Props.width, Props.height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(new GamePanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SnakeGame::new);
    }


}
