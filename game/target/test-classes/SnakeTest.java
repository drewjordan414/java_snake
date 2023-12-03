package snake.components;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.awt.Point;
import java.util.List;

public class SnakeTest {
    private Snake snake;
    private final int initialLength = 3;
    private final int scale = 20;
    private final int boardWidth = 400;
    private final int boardHeight = 400;

    @Before
    public void setUp() {
        // Initialize the snake before each test
        snake = new Snake(initialLength, scale, boardWidth, boardHeight);
    }

    @Test
    public void testInitialLength() {
        // Test if the snake is initialized with the correct length
        assertEquals("Initial length of the snake should be " + initialLength, initialLength, snake.getSnakeParts().size());
    }

    @Test
    public void testMove() {
        // Test if the snake moves correctly
        Point initialHead = new Point(snake.getHead());
        snake.setDirection(1); // Right
        snake.move();
        Point newHead = snake.getHead();
        
        assertEquals("Head should move right by scale", initialHead.x + scale, newHead.x);
        assertEquals("Head y-coordinate should remain same", initialHead.y, newHead.y);
    }

    @Test
    public void testGrow() {
        // Test if the snake grows correctly
        int initialSize = snake.getSnakeParts().size();
        snake.grow();
        assertEquals("Snake should grow by one segment", initialSize + 1, snake.getSnakeParts().size());
    }

    @Test
    public void testSetDirection() {
        // Test setting the direction of the snake
        snake.setDirection(2); // Down
        assertEquals("Direction should be set to down", 2, snake.getDirection());
    }

    // Additional test methods can be added here to cover more functionalities
}
