import java.awt.*;

public class Props {

    public static int initialDelay = 100;

    public static int xsize = 30;
    public static int ysize = 30;

    public static int width = 1000;
    public static int height = 1000;

    public static int gridtopX = 200;
    public static int gridtopY = 200;
    public static int gridwidth = 20;
    public static int gridheight = 20;

    public static Color squareColor = Color.GREEN;
    public static Color squareOutlineColor = Color.GREEN;

    public static Color backgroundColor = Color.BLACK;

    public static Color snakeColor = Color.RED;
    public static Color appleColor = Color.WHITE;
    public static Color customColor = new Color(0.3f, 0.1f, 0.6f);   // <-- a custom color using RGB values

    public static Font font1 = new Font("Andale Mono", Font.PLAIN, 24);

    public static void changePropsSet1() {
        xsize = 20;
        ysize = 20;

        gridtopX = 200;
        gridtopY = 200;
        gridwidth = 30;
        gridheight = 30;

        squareColor = Color.RED;
        squareOutlineColor = Color.BLACK;

        backgroundColor = Color.WHITE;

        snakeColor = Color.GREEN;
        appleColor = Color.BLUE;

        font1 = new Font("Arial", Font.BOLD, 24);
    }

}
