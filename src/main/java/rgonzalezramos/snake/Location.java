package rgonzalezramos.snake;

public class Location {
    final int x;
    final int y;

    private Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Location abs(int x, int y) {
        return new Location(x, y);
    }

    public Location move(Direction direction) {
        return new Location(x + direction.x, y + direction.y);
    }

    public Location copy() {
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
}
