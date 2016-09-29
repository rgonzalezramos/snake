package rgonzalezramos.snake.engine;

import rgonzalezramos.snake.common.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class BufferedInputManager implements KeyListener {

    private LinkedList<Direction> buffer = new LinkedList<>();

    public Direction getDirection() {
        return buffer.isEmpty() ? null : buffer.pop();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                buffer.add(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                buffer.add(Direction.RIGHT);
                break;
            case KeyEvent.VK_UP:
                buffer.add(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                buffer.add(Direction.DOWN);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // NO OP
    }
}
