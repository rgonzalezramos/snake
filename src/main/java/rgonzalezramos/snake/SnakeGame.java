package rgonzalezramos.snake;

import rgonzalezramos.snake.common.Direction;
import rgonzalezramos.snake.common.LocationConverter;
import rgonzalezramos.snake.entities.Food;
import rgonzalezramos.snake.entities.Grid;
import rgonzalezramos.snake.entities.Score;
import rgonzalezramos.snake.entities.Snake;

import javax.swing.*;
import java.awt.*;

public class SnakeGame extends JPanel {
    private Score score;
    private Snake snake;
    private Grid grid;
    private Food food;

    private SnakeGame(Score score, Snake snake, Grid grid, Food food) {
        this.score = score;
        this.snake = snake;
        this.grid = grid;
        this.food = food;
    }

    public static SnakeGame create(int width, int height) {
        Grid grid = new Grid(width, height);
        Snake snake = Snake.create(grid);
        Score score = new Score();
        Food food = new Food(grid);
        return new SnakeGame(score, snake, grid, food);
    }

    public void update(Direction input) {
        if (snake.bumps()) {
            reset();
            return;
        }

        if (snake.eats(food)) {
            food.reset();
            snake.grow();
            score.increment();
        }

        if (!input.isOppositeOf(snake.direction)) {
            snake.direction = input;
        }

        snake.move();
    }

    private void reset() {
        this.snake = Snake.create(grid);
        this.score.reset();
    }

    @Override
    public void paint(Graphics g_) {
        super.paint(g_);
        Graphics2D g = (Graphics2D) g_;

        // Background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        LocationConverter converter = LocationConverter.create(grid.width, grid.height, getWidth(), getHeight());
        food.paint(g, converter);
        snake.paint(g, converter);
        score.paint(g, converter);
    }

    public int speed() {
        return score.getScore() + 1;
    }
}
