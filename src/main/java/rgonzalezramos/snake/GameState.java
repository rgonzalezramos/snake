package rgonzalezramos.snake;

import java.util.LinkedList;

public class GameState {
    public int score = 0;
    public Location food;
    public LinkedList<Location> snake;
    public int width;
    public int height;
    public Direction direction;

    public GameState copy() {
        GameState copy = new GameState();
        copy.score = score;
        copy.food = food.copy();
        copy.snake = new LinkedList<>();
        copy.width = width;
        copy.height = height;
        for (Location s: snake) {
            copy.snake.add(s);
        }
        copy.direction = direction;
        return copy;
    }
}
