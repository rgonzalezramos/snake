package rgonzalezramos.snake.entities;

import rgonzalezramos.snake.common.LocationConverter;

import java.awt.*;

public interface GameEntity {
    void paint(Graphics2D g, LocationConverter converter);
}
