package rgonzalezramos.snake;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private GameState state;








    @Override
    public void paint(Graphics g_) {
        super.paint(g_);
        if (this.state == null) return;

        LocationConverter converter = LocationConverter.create(
                state.width, state.height,
                getWidth(), getHeight());

        Graphics2D g = (Graphics2D) g_;

        // TODO reuse this

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());


        // Paint score
        g.setColor(Color.GREEN);
        g.drawString(String.format("Score: %4d", state.score), 20, 20);

        // Paint food
        Rect rect = converter.rect(state.food);
        g.setColor(Color.RED);
        g.fillRect(rect.x, rect.y, rect.width, rect.height);
        g.setColor(Color.GREEN);
        g.drawRect(rect.x, rect.y, rect.width, rect.height);

        // Paint snake

        for (Location section : state.snake) {
            Rect r = converter.rect(section);
            g.setColor(Color.CYAN);
            g.fillRect(r.x, r.y, r.width, r.height);
            g.setColor(Color.BLACK);
            g.drawRect(r.x, r.y, r.width, r.height);
        }

        // Paint head in other color
        g.setColor(Color.MAGENTA);
        Rect r = converter.rect(state.snake.getLast());
        g.fillRect(r.x, r.y, r.width, r.height);
        g.setColor(Color.BLACK);
        g.drawRect(r.x, r.y, r.width, r.height);
    }

    public void repaint(GameState state) {
        this.state = state;
        this.repaint();
    }
}
