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
}
