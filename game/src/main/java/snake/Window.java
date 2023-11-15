import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;


class Window extends JFrame{
    private static final long serialVersionUID = -2542001418764869760L;
    public static ArrayList<ArrayList<Square>> Grid;
    public static int width = 20;
    public static int height = 20;
    public Window(){


        // Creates the arraylist that'll contain the threads
        Grid = new ArrayList<ArrayList<Square>>();
        ArrayList<Square> data;

        // Creates Threads and its data and adds it to the arrayList
        for(int i=0;i<width;i++){
            data= new ArrayList<Square>();
            for(int j=0;j<height;j++){
                Square c = new Square(2);
                data.add(c);
            }
            Grid.add(data);
        }

        // Setting up the layout of the panel
        getContentPane().setLayout(new GridLayout(20,20,0,0));

        // Start & pauses all threads, then adds every square of each thread to the panel
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                getContentPane().add(Grid.get(i).get(j).square);
            }
        }

        // initial position of the snake
        Tuple position = new Tuple(10,10);
        // passing this value to the controller
        Controller c = new Controller(position);
        //Let's start the game now..
        c.start();

        // Links the window to the keyboardlistenner.
        this.addKeyListener((KeyListener) new Listener());



    }
}