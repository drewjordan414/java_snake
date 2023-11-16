
package snake.components;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.Point;
import static org.junit.jupiter.api.Assertions.*;

class AppleTest {

    private Apple apple;
    private final int initialX = 5;
    private final int initialY = 10;

    @BeforeEach
    void setUp() {
        // Initialize an Apple object before each test
        apple = new Apple(initialX, initialY);
    }

    @Test
    void testGetPosition() {
        // Get the position of the apple
        Point position = apple.getPosition();

        // Assert that the position is not null and has the correct coordinates
        assertNotNull(position, "Position should not be null.");
        assertEquals(initialX, position.x, "X coordinate should match the initial value.");
        assertEquals(initialY, position.y, "Y coordinate should match the initial value.");
    }

    @Test
    void testSetPosition() {
        // Set a new position for the apple
        int newX = 15;
        int newY = 20;
        apple.setPosition(newX, newY);

        // Get the position of the apple after setting a new one
        Point position = apple.getPosition();

        // Assert that the position has the new coordinates
        assertEquals(newX, position.x, "X coordinate should be updated to the new value.");
        assertEquals(newY, position.y, "Y coordinate should be updated to the new value.");
    }
}
