// Psuedocode:
// Define package snake.components

// Import necessary classes (Board, Point, ArrayList, List)

// Define class Snake
    // Declare a list to store snake parts (each part is a Point)
    // Declare an integer for direction
    // Declare a final integer for SCALE (size of each segment)

    // Define constructor of Snake with parameters: initialLength, scale, boardWidth, boardHeight
        // Set SCALE to scale
        // Initialize snakeParts as a new ArrayList
        // Calculate starting X and Y positions (center of the board)
        // For loop from 0 to initialLength
            // Add new Point to snakeParts at calculated starting position
        // Set initial direction (0: up, 1: right, 2: down, 3: left)

    // Define method setDirection with parameter dir
        // Set direction to dir

    // Define method move
        // Get the current head of the snake
        // Switch case based on the direction
            // Case 0 (Up): Decrease head Y by SCALE
            // Case 1 (Right): Increase head X by SCALE
            // Case 2 (Down): Increase head Y by SCALE
            // Case 3 (Left): Decrease head X by SCALE
        // Add the new head position to the start of snakeParts
        // Remove the last part of snakeParts

    // Define method grow
        // Add a new part to snakeParts at the last part's position

    // Define method getSnakeParts
        // Return snakeParts

    // Define method getHead
        // Return the first element of snakeParts

    // Additional methods can be added here (e.g., for collision detection)

    // Define method getDirection
        // Return direction

    // Define method getSCALE
        // Return SCALE

    // Define method setSnakeParts with parameter snakeParts
        // Set this snake's snakeParts to the given snakeParts



package snake.components;

import snake.components.Board;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<Point> snakeParts;
    private int direction;
    private final int SCALE; // Size of each segment

    // public Snake(int initialLength, int scale) {
    //     SCALE = scale;
    //     snakeParts = new ArrayList<>();
    //     // for (int i = 0; i < initialLength; i++) {
    //     //     // Initialize the snake at the center of the board
    //     //     snakeParts.add(new Point(0, -i));
    //     // }
    //     for (int i = 0; i < initialLength; i++) {
    //         snakeParts.add(new Point(WIDTH / 2, HEIGHT / 2 + i * SCALE));
    //     }
        
    //     direction = 0; // 0: up, 1: right, 2: down, 3: left
    // }
    public Snake(int initialLength, int scale, int boardWidth, int boardHeight) {
        SCALE = scale;
        snakeParts = new ArrayList<>();
        int startX = boardWidth / 2;
        int startY = boardHeight / 2;
        
        for (int i = 0; i < initialLength; i++) {
            // Initialize the snake in the center of the board
            snakeParts.add(new Point(startX, startY + i * SCALE));
        }
    
        direction = 0; 
    }
    
    public void setDirection(int dir) {
        direction = dir;
    }

    public void move() {
        Point head = new Point(snakeParts.get(0));
        switch (direction) {
            case 0: // Up
                head.y -= SCALE;
                break;
            case 1: // Right
                head.x += SCALE;
                break;
            case 2: // Down
                head.y += SCALE;
                break;
            case 3: // Left
                head.x -= SCALE;
                break;
        }
        snakeParts.add(0, head);
        snakeParts.remove(snakeParts.size() - 1);
    }

    public void grow() {
        snakeParts.add(new Point(snakeParts.get(snakeParts.size() - 1)));
    }

    public List<Point> getSnakeParts() {
        return snakeParts;
    }

    public Point getHead() {
        return snakeParts.get(0);
    }

    // Add other methods that might be useful

    public int getDirection() {
        return direction;
    }

    public int getSCALE() {
        return SCALE;
    }

    public void setSnakeParts(List<Point> snakeParts) {
        this.snakeParts = snakeParts;
    }
}
