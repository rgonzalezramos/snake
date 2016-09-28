package rgonzalezramos.snake.common;

import rgonzalezramos.snake.entities.Grid;
import rgonzalezramos.snake.helpers.Modulo;

import java.util.Random;

public class Location {
    final int x;
    final int y;

    private Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Location copy() {
        return new Location(x, y);
    }

    public Location move(Direction direction, Grid grid) {
        return new Location(
                Modulo.of(x + direction.x, grid.width),
                Modulo.of(y + direction.y, grid.height));
    }

    public static Location abs(int x, int y) {
        return new Location(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (x != location.x) return false;
        return y == location.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    private final static Random random = new Random(System.currentTimeMillis());

    public static Location random(int width, int height) {
        return Location.abs(random.nextInt(width), random.nextInt(height));
    }
}
