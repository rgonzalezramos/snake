package rgonzalezramos.snake;

import javax.swing.*;

public class Window extends JFrame {
    public Window(int width, int height) {
        super();
        setSize(width, height);

        Game game = new Game(40, 30);
        GamePanel panel = new GamePanel(game);
        panel.setVisible(true);
        add(panel);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
