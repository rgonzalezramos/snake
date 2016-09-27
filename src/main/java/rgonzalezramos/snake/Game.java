package rgonzalezramos.snake;

import java.util.LinkedList;

public class Game implements Runnable {
    private final GamePanel panel;
    private GameState state;

    public Game(int width, int height, GamePanel panel) {
        this.panel = panel;
        this.state = new GameState();
        this.state.width = width;
        this.state.height = height;
        this.state.food = Location.abs(width / 2, height / 2);
        this.state.snake = new LinkedList<>();
        this.state.direction = Direction.DOWN;

        for (int i = 0; i < 4; i++) {
            this.state.snake.add(Location.abs(i + 2, 2));
        }
    }

    public void run() {
        while (true) {

            // Update
            state.snake.pop();
            state.snake.add(state.snake.getLast().move(state.direction));

            // Draw
            panel.repaint(state.copy());

            // Sleep
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
