package rgonzalezramos.snake;

import javax.swing.*;

public class Window extends JFrame {
    public Window(int width, int height) {
        super();
        setSize(width, height);

        GamePanel panel = new GamePanel();
        panel.setVisible(true);
        add(panel);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
