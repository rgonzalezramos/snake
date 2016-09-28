package rgonzalezramos.snake;

import java.util.LinkedList;

public class GameState {
    public int score;
    public Location food;
    public LinkedList<Location> snake;
    public int width;
    public int height;
    public Direction direction;

    public GameState(int width, int height) {
        this.width = width;
        this.height = height;
        reset();
    }

    public void reset() {
        food = Location.abs(width / 2, height / 2);
        snake = new LinkedList<>();
        direction = Direction.RIGHT;
        score = 0;

        for (int i = 0; i < 4; i++) {
            snake.add(Location.abs(i + 2, 2));
        }
    }

    public GameState copy() {
        GameState copy = new GameState(width, height);
        copy.score = score;
        copy.food = food.copy();
        copy.snake = new LinkedList<>();
        copy.width = width;
        copy.height = height;
        for (Location s : snake) {
            copy.snake.add(s);
        }
        copy.direction = direction;
        return copy;
    }

    public boolean collide() {
        Location head = snake.getLast();
        for (int i = 0; i < snake.size() - 1; i++) {
            if (snake.get(i).equals(head)) {
                return true;
            }
        }
        return false;
    }
}
