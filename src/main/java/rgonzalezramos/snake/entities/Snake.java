package rgonzalezramos.snake.entities;

import rgonzalezramos.snake.common.Direction;
import rgonzalezramos.snake.common.Location;
import rgonzalezramos.snake.common.LocationConverter;
import rgonzalezramos.snake.common.Rect;

import java.awt.*;
import java.util.LinkedList;

public class Snake implements GameEntity {
    public LinkedList<Location> body;
    public Direction direction;
    public final Grid grid;

    public Snake(LinkedList<Location> body, Direction direction, Grid grid) {
        this.body = body;
        this.direction = direction;
        this.grid = grid;
    }

    public static Snake create(Grid grid) {
        LinkedList<Location> body = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            body.add(Location.abs(i, 1));
        }
        return new Snake(body, Direction.RIGHT, grid);
    }

    @Override
    public void paint(Graphics2D g, LocationConverter converter) {
        for (Location section : body) {
            Rect r = converter.rect(section);
            g.setColor(Color.CYAN);
            g.fillRect(r.x, r.y, r.width, r.height);
            g.setColor(Color.BLACK);
            g.drawRect(r.x, r.y, r.width, r.height);
        }
    }

    public boolean bumps() {
        Location head = body.getLast();
        for (int i = 0; i < body.size() - 1; i++) {
            if (body.get(i).equals(head)) {
                return true;
            }
        }
        return false;
    }

    public void move() {
        body.pop();
        body.add(body.getLast().move(direction, grid));
    }

    public boolean eats(Food food) {
        return body.getLast().equals(food.location);
    }

    public void grow() {
        body.add(0, body.getFirst());
    }
}
