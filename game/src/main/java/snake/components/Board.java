package snake.components;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
    private final int WIDTH = 800;
    private final int HEIGHT = 800;
    private final int SCALE = 20;

    private Snake snake;
    private Point apple;
    private Timer timer;
    private boolean gameOver;

    public Board() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);

        initGame();
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                // Handle key events for snake direction change
            }
        });
    }

    private void initGame() {
        snake = new Snake(3, SCALE);
        spawnApple();
        gameOver = false;
        timer = new Timer(100, this);
        timer.start();
    }

    private void spawnApple() {
        int x = (int) (Math.random() * (WIDTH / SCALE)) * SCALE;
        int y = (int) (Math.random() * (HEIGHT / SCALE)) * SCALE;
        apple = new Point(x, y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        if (!gameOver) {
            // Draw apple
            g.setColor(Color.RED);
            g.fillRect(apple.x, apple.y, SCALE, SCALE);

            // Draw snake
            g.setColor(Color.GREEN);
            for (Point p : snake.getSnakeParts()) {
                g.fillRect(p.x, p.y, SCALE, SCALE);
            }
        } else {
            // Display Game Over
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            snake.move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    private void checkApple() {
        if (snake.getHead().equals(apple)) {
            snake.grow();
            spawnApple();
        }
    }

    private void checkCollisions() {
        // Implement collision logic (with walls or snake itself)
        // Set gameOver to true if a collision occurs
    }

    // Additional methods, including those for key event handling, can be added here
}
