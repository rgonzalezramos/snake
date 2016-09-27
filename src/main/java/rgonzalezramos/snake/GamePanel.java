package rgonzalezramos.snake;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final Game game;

    public GamePanel(Game game) {
        super();
        this.game = game;
    }

    @Override
    public void paint(Graphics g_) {
        super.paint(g_);

        Graphics2D g = (Graphics2D) g_;

        // TODO reuse this
        LocationConverter converter = LocationConverter.create(
                game.getWidth(), game.getHeight(),
                getWidth(), getHeight());

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        GameState state = game.getState();

        // Paint score
        g.setColor(Color.GREEN);
        g.drawString(String.format("Score: %4d", state.score), 20, 20);

        // Paint food
        Rect rect = converter.rect(state.food);
        g.setColor(Color.RED);
        g.fillRect(rect.x, rect.y, rect.width, rect.height);
    }
}
