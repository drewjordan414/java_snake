// Define package snake.components

// Import the Point class

// Define the Apple class
    // Declare a variable for position (of type Point)

    // Define constructor with parameters x and y (both integers)
        // Initialize position as a new Point with x and y coordinates

    // Define method getPosition
        // Return the position of the apple

    // Define method setPosition with parameters x and y (both integers)
        // Set the position of the apple to the new x and y coordinates

    // Space for additional methods related to apple-specific logic

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
}
