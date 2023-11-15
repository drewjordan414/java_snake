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
import java.awt.FontMetrics;


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
            @Override
            public void keyPressed(KeyEvent e) {
                if (gameOver) {
                    if (e.getKeyCode() == KeyEvent.VK_R) {
                        restartGame();
                    }
                } else {
                    int currentDirection = snake.getDirection();
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_UP:
                        case KeyEvent.VK_W:
                            if (currentDirection != 2) snake.setDirection(0); // Up
                            break;
                        case KeyEvent.VK_RIGHT:
                        case KeyEvent.VK_D:
                            if (currentDirection != 3) snake.setDirection(1); // Right
                            break;
                        case KeyEvent.VK_DOWN:
                        case KeyEvent.VK_S:
                            if (currentDirection != 0) snake.setDirection(2); // Down
                            break;
                        case KeyEvent.VK_LEFT:
                        case KeyEvent.VK_A:
                            if (currentDirection != 1) snake.setDirection(3); // Left
                            break;
                    }
                }
            }
        });
    }

    private void initGame() {
        snake = new Snake(3, SCALE, WIDTH, HEIGHT);
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
            // Draw the apple
            g.setColor(Color.RED);
            g.fillRect(apple.x, apple.y, SCALE, SCALE);
    
            // Draw the snake
            g.setColor(Color.GREEN);
            for (Point p : snake.getSnakeParts()) {
                g.fillRect(p.x, p.y, SCALE, SCALE);
            }
        } else {
            // Game Over - Display the message
            drawGameOver(g);
        }
    }
    
    private void drawGameOver(Graphics g) {
        String message = "Game Over. Press R to Restart";
        g.setColor(Color.RED);
        FontMetrics fm = g.getFontMetrics();
        int x = (WIDTH - fm.stringWidth(message)) / 2;
        int y = (HEIGHT / 2) + fm.getAscent();
        g.drawString(message, x, y);
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
        Point head = snake.getHead();
        // Check collision with the snake itself
        for (int i = 1; i < snake.getSnakeParts().size(); i++) {
            if (head.equals(snake.getSnakeParts().get(i))) {
                gameOver = true;
                return;
            }
        }

        // Check collision with the walls
        if (head.x < 0 || head.x >= WIDTH || head.y < 0 || head.y >= HEIGHT) {
            gameOver = true;
        }

    }

    // button to restart game when game over is ture
    public void restartGame() {
    if (gameOver) {
        if (timer != null) {
            timer.stop(); // Stop the existing timer
        }

        snake = new Snake(3, SCALE, WIDTH, HEIGHT); // Reset the snake
        spawnApple(); // Respawn the apple
        gameOver = false; // Reset the game over flag

        timer = new Timer(100, this); // Create a new timer with a constant delay
        timer.start(); // Start the timer
    }
}



}
