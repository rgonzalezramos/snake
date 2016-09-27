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
    public void paint(Graphics g) {
        LocationConverter converter = LocationConverter.create(
                game.getWidth(), game.getHeight(),
                getWidth(), getHeight());

        super.paint(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Paint food
        GameState state = game.getState();
        Rect rect = converter.rect(state.food);
        g.setColor(Color.RED);
        g.fillRect(rect.x, rect.y, rect.width, rect.height);
    }
}
