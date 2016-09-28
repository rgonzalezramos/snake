package rgonzalezramos.snake.engine;

import rgonzalezramos.snake.common.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener {

    private Direction direction = Direction.RIGHT;

    public Direction getDirection() {
        return direction;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                direction = direction.LEFT;
                break;
            case KeyEvent.VK_RIGHT:
                direction = direction.RIGHT;
                break;
            case KeyEvent.VK_UP:
                direction = direction.UP;
                break;
            case KeyEvent.VK_DOWN:
                direction = direction.DOWN;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // NO OP
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // NO OP
    }
}
