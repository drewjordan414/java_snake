package snake.components;

import java.awt.Point;

public class Apple {
    private Point position;

    public Apple(int x, int y) {
        position = new Point(x, y);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        position.setLocation(x, y);
    }

    // Additional methods for apple-specific logic can be added here
}
