package snake.components;

import static org.junit.Assert.assertEquals;
import java.awt.Point;
import org.junit.Before;
import org.junit.Test;

public class AppleTest {

    private Apple apple;

    @Before
    public void setUp() {
        // Initialize an Apple object before each test
        apple = new Apple(5, 10);
    }

    @Test
    public void testInitialPosition() {
        // Test whether the initial position of the apple is set correctly
        Point expectedPosition = new Point(5, 10);
        assertEquals("Initial position should be (5, 10)", expectedPosition, apple.getPosition());
    }

    @Test
    public void testSetPosition() {
        // Test whether the position of the apple is set correctly
        apple.setPosition(15, 20);
        Point expectedPosition = new Point(15, 20);
        assertEquals("Position should be updated to (15, 20)", expectedPosition, apple.getPosition());
    }
}
