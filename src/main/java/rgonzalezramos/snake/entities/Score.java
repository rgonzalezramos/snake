package rgonzalezramos.snake.entities;

import rgonzalezramos.snake.common.Location;
import rgonzalezramos.snake.common.LocationConverter;
import rgonzalezramos.snake.common.Rect;

import java.awt.*;

public class Score implements GameEntity {
    private int score = 0;
    private Location location = Location.abs(1, 1);

    public int getScore() {
        return score;
    }

    public void reset() {
        score = 0;
    }

    public void increment() {
        score += 1;
    }

    @Override
    public void paint(Graphics2D g, LocationConverter converter) {
        Rect rect = converter.rect(location);
        g.setColor(Color.GREEN);
        g.drawString(String.format("Score: %4d", score), rect.x, rect.y);
    }
}
