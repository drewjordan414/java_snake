import org.junit.Before;
import org.junit.Test;

import java.awt.Point;
import java.util.List;

import static org.junit.Assert.*;

public class SnakeTest {
    private Snake snake;

    @Before
    public void setUp() {
        snake = new Snake(3, 20, 800, 800);
    }

    @Test
    public void testConstructor() {
        List<Point> snakeParts = snake.getSnakeParts();
        assertEquals(3, snakeParts.size());
        assertEquals(20, snake.getSCALE());
        assertEquals(0, snake.getDirection());
    }

    @Test
    public void testSetDirection() {
        snake.setDirection(1);
        assertEquals(1, snake.getDirection());

        snake.setDirection(3);
        assertEquals(3, snake.getDirection());
    }

    @Test
    public void testMove() {
        // Store the initial head position
        Point initialHead = snake.getHead();

        // Move the snake up
        snake.setDirection(0);
        snake.move();

        // Check if the head position has changed correctly
        Point newHead = snake.getHead();
        assertEquals(initialHead.x, newHead.x);
        assertEquals(initialHead.y - 20, newHead.y);

        // Move the snake right
        snake.setDirection(1);
        snake.move();

        // Check if the head position has changed correctly
        newHead = snake.getHead();
        assertEquals(initialHead.x + 20, newHead.x);
        assertEquals(initialHead.y - 20, newHead.y);

        // Move the snake down
        snake.setDirection(2);
        snake.move();

        // Check if the head position has changed correctly
        newHead = snake.getHead();
        assertEquals(initialHead.x + 20, newHead.x);
        assertEquals(initialHead.y, newHead.y);

        // Move the snake left
        snake.setDirection(3);
        snake.move();

        // Check if the head position has changed correctly
        newHead = snake.getHead();
        assertEquals(initialHead.x, newHead.x);
        assertEquals(initialHead.y, newHead.y);
    }

    @Test
    public void testGrow() {
        List<Point> snakeParts = snake.getSnakeParts();
        assertEquals(3, snakeParts.size());

        // Grow the snake
        snake.grow();
        assertEquals(4, snakeParts.size());

        // Check if the new part is added at the end
        Point lastPart = snakeParts.get(snakeParts.size() - 1);
        Point newPart = snakeParts.get(snakeParts.size() - 2);
        assertEquals(newPart, lastPart);
    }
}
