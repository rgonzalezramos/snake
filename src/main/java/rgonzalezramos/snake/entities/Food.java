package rgonzalezramos.snake.entities;

import rgonzalezramos.snake.common.Location;
import rgonzalezramos.snake.common.LocationConverter;
import rgonzalezramos.snake.common.Rect;

import java.awt.*;

public class Food implements GameEntity {
    Location location;
    private final Grid grid;

    public Food(Grid grid) {
        this.grid = grid;
        reset();
    }

    public void reset() {
        this.location = Location.random(grid.width, grid.height);
    }

    @Override
    public void paint(Graphics2D g, LocationConverter converter) {
        Rect rect = converter.rect(location);
        g.setColor(Color.RED);
        g.fillRect(rect.x, rect.y, rect.width, rect.height);
        g.setColor(Color.BLACK);
        g.drawRect(rect.x, rect.y, rect.width, rect.height);
    }
}
