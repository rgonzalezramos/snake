package rgonzalezramos.snake;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
