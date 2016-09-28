package rgonzalezramos.snake.helpers;

public class Modulus {
    public static int of(int x, int width) {
        if (x >= 0) {
            return x % width;
        }
        return (width + x);
    }
}
