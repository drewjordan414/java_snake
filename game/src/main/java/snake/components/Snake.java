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
    
        direction = 0; // 0: up, 1: right, 2: down, 3: left
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

    // Additional methods for collision detection, etc., can be added here

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
