package rgonzalezramos.snake;

import rgonzalezramos.snake.engine.Engine;
import rgonzalezramos.snake.engine.BufferedInputManager;
import rgonzalezramos.snake.engine.SnakeGame;

import javax.swing.*;

public class Launcher {
    public static void main(String[] args) throws InterruptedException {
        SnakeGame game = SnakeGame.create(32, 24);

        BufferedInputManager input = new BufferedInputManager();

        JFrame frame = new JFrame();
        frame.setSize(640, 480);
        frame.addKeyListener(input);
        frame.add(game);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Thread.sleep(1000);

        Thread thread = new Thread(new Engine(game, input));
        thread.start();
        thread.join();
    }
}
