package rgonzalezramos.snake;

import javax.swing.*;

public class Window extends JFrame {
    public Window(int width, int height) {
        super();
        setSize(width, height);

        GamePanel panel = new GamePanel();
        panel.setVisible(true);
        add(panel);

        Game game = new Game(40, 30, panel);
        new Thread(game).start();

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
