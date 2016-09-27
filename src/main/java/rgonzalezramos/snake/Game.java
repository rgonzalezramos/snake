package rgonzalezramos.snake;

public class Game {

    private final int width;
    private final int height;
    private GameState state;

    public Game(int width, int height) {
        this.width = width;
        this.height = height;
        this.state = new GameState();
        this.state.food = Location.abs(width / 2, height / 2);
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
