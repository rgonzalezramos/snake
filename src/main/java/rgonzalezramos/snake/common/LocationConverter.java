package rgonzalezramos.snake.common;

public class LocationConverter {

    private final int cellWidth;
    private final int cellHeight;

    public LocationConverter(int cellWidth, int cellHeight) {
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
    }

    public static LocationConverter create(int uWidth, int uHeight, int pWidth, int pHeight) {
        return new LocationConverter(
                pWidth / uWidth,
                pHeight / uHeight
        );
    }

    public Rect rect(Location location) {
        return new Rect(
                location.x * cellWidth,
                location.y * cellHeight,
                cellWidth,
                cellHeight
        );
    }
}
