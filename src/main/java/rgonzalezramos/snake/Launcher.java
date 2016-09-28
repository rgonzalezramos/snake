package rgonzalezramos.snake;

import javax.swing.*;

public class Launcher {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        frame.setSize(640, 480);
        InputManager input = new InputManager();
        frame.addKeyListener(input);
        SnakeGame game = SnakeGame.create(32, 24);
        frame.add(game);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Thread thread = new Thread(new Engine(game, input));
        thread.start();
        thread.join();
    }
}
