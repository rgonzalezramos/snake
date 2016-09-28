package rgonzalezramos.snake;

import rgonzalezramos.snake.helpers.Modulus;

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

    public Location move(Direction direction, int width, int height) {
        return new Location(
                Modulus.of(x + direction.x, width),
                Modulus.of(y + direction.y, height));
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
}
