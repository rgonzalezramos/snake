package rgonzalezramos.snake;

import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow(int width, int height) {
        super();
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
