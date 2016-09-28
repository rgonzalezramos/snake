package rgonzalezramos.snake.common;

public class Direction {
    public static final Direction UP = new Direction(0, -1);
    public static final Direction DOWN = new Direction(0, 1);
    public static final Direction RIGHT = new Direction(1, 0);
    public static final Direction LEFT = new Direction(-1, 0);

    public final int x;
    public final int y;

    public Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isOppositeOf(Direction o) {
        return x == -o.x && y == -o.y;
    }
}
