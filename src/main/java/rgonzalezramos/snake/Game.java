package rgonzalezramos.snake;

import java.util.LinkedList;

public class Game {

    private final int width;
    private final int height;
    private GameState state;

    public Game(int width, int height) {
        this.width = width;
        this.height = height;
        this.state = new GameState();
        this.state.food = Location.abs(width / 2, height / 2);
        this.state.snake = new LinkedList<Location>();

        for (int i = 0; i < 4; i++) {
            this.state.snake.add(Location.abs(i + 2, 2));
        }
    }

    public GameState getState() {
        return this.state;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
