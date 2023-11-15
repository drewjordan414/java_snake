// Psuedocode
// Define package snake

// Import necessary classes (Board, JFrame, SwingUtilities)

// Define class Main

    // Define main method with String array args as parameters
        // Use SwingUtilities to schedule a job for the event-dispatching thread
            // Create and show the game's GUI

    // Define createAndShowGUI method
        // Create a new JFrame with the title "Snake Game"
        // Set the default close operation to EXIT_ON_CLOSE
        // Make the window non-resizable
        // Add a new instance of Board to the frame
        // Pack the frame to fit the preferred size and layouts of its subcomponents
        // Set the location of the frame relative to null (center the window)
        // Set the frame to be visible


package snake;

import snake.components.Board;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new Board()); // Assuming Board is your game panel class
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }
};




//   You found me!
// |-------------------------|
// |                   __    | 
// |        .,-;-;-,. /'_\   |
// |      _/_/_/_|_\_\) /    |
// |    '-<_><_><_><_>=/\    |
// |      `/_/====/_/-'\_\   |
// |       ""     ""    ""   | 
// | github.com/drewjordan414|
// |-------------------------|    
