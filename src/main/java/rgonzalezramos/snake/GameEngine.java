package rgonzalezramos.snake;

import java.util.Random;

public class GameEngine implements Runnable {
    private final GamePanel panel;
    private InputManager input;
    private GameState state;
    private Random random = new Random(System.currentTimeMillis());

    public GameEngine(int width, int height, GamePanel panel, InputManager input) {
        this.panel = panel;
        this.input = input;
        this.state = new GameState(width, height);

    }

    public void run() {

        while (true) {

            // Update
            if (state.snake.getLast().equals(state.food)) {
                state.food = Location.abs(random.nextInt(state.width), random.nextInt(state.height));
                state.score += 1;
            } else {
                state.snake.pop();
            }

            Direction newDirection = input.getDirection();

            if (!newDirection.isOppositeOf(state.direction)) {
                state.direction = newDirection;
            }

            state.snake.add(state.snake.getLast().move(state.direction, state.width, state.height));

            // Check collissions
            if (state.collide()) {
                state.reset();
            }
            
            // Draw
            panel.repaint(state.copy());

            // Sleep
            try {
                Thread.sleep(Math.max(0, 200 - state.score * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
