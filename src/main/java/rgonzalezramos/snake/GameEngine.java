package rgonzalezramos.snake;

import java.util.LinkedList;
import java.util.Random;

public class GameEngine implements Runnable {
    private final GamePanel panel;
    private InputManager input;
    private GameState state;
    private Random random = new Random(System.currentTimeMillis());

    public GameEngine(int width, int height, GamePanel panel, InputManager input) {
        this.panel = panel;
        this.input = input;
        this.state = new GameState();
        this.state.width = width;
        this.state.height = height;
        this.state.food = Location.abs(width / 2, height / 2);
        this.state.snake = new LinkedList<>();

        for (int i = 0; i < 4; i++) {
            this.state.snake.add(Location.abs(i + 2, 2));
        }
    }

    public void run() {
        int sleepTime = 200;
        while (true) {

            // Update
            if (state.snake.getLast().equals(state.food)) {
                state.food = Location.abs(random.nextInt(state.width), random.nextInt(state.height));
                state.score += 1;
                sleepTime = (int) (sleepTime * 0.9);
            } else {
                state.snake.pop();
            }

            state.snake.add(state.snake.getLast().move(input.getDirection(), state.width, state.height));

            // Draw
            panel.repaint(state.copy());

            // Sleep
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
