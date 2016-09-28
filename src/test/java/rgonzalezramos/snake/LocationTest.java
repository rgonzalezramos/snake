package rgonzalezramos.snake;

import org.junit.Test;
import rgonzalezramos.snake.common.Direction;
import rgonzalezramos.snake.common.Location;

import static org.junit.Assert.assertEquals;

public class LocationTest {
    @Test
    public void test() {
        assertEquals(
                Location.abs(0, 9),
                Location.abs(0, 0).move(Direction.UP, 10, 10)
        );
    }
}