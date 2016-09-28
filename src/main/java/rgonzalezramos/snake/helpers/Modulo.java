package rgonzalezramos.snake.helpers;

public class Modulo {
    public static int of(int dividend, int divisor) {
        if (dividend >= 0) {
            return dividend % divisor;
        }
        return divisor - of(-dividend, divisor);
    }
}
