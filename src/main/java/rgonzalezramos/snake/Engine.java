package rgonzalezramos.snake;

public class Engine implements Runnable {
    private final SnakeGame game;
    private final InputManager input;

    public Engine(SnakeGame game, InputManager input) {
        this.game = game;
        this.input = input;
    }

    private void loop() throws InterruptedException {
        while (true) {
            game.update(input.getDirection());
            game.repaint();
            Thread.sleep(30 + Math.max(0, (100 - 10 * game.speed())));
        }
    }

    @Override
    public void run() {
        try {
            loop();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
