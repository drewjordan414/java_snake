package snake.utils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Listener extends KeyAdapter{

    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case 39:	// -> Right
                //if it's not the opposite direction
                if(Controller.directionSnake!=2)
                    Controller.directionSnake=1;
                break;
            case 38:	// -> Top
                if(Controller.directionSnake!=4)
                    Controller.directionSnake=3;
                break;

            case 37: 	// -> Left
                if(Controller.directionSnake!=1)
                    Controller.directionSnake=2;
                break;

            case 40:	// -> Bottom
                if(Controller.directionSnake!=3)
                    Controller.directionSnake=4;
                break;

            default: 	break;
        }
    }

}