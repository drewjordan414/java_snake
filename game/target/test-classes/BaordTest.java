package snake.components;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.awt.Point;

public class BoardTest {
    
    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testInitialGameNotOver() {
        // Verify that the game is not over when it starts
        assertFalse("Game should not be over at start", board.isGameOver());
    }

    @Test
    public void testSpawnApple() {
        // Test if an apple is spawned correctly within the board boundaries
        board.spawnApple();
        Point apple = board.getApplePosition();
        assertTrue("Apple should be within width", apple.x >= 0 && apple.x < board.getWIDTH());
        assertTrue("Apple should be within height", apple.y >= 0 && apple.y < board.getHEIGHT());
    }

    @Test
    public void testRestartGame() {
        // Test if the game restarts correctly
        board.restartGame();
        assertFalse("Game should not be over after restart", board.isGameOver());
        assertNotNull("Snake should not be null after restart", board.getSnake());
        assertNotNull("Apple should not be null after restart", board.getApplePosition());
    }

    // Additional test methods can be added here to cover more functionalities
}
