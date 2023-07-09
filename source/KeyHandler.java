import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    boolean up, down, right, left;


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W){

            down = false;
            left = false;
            right = false;

            up = true;
        }
        if(key == KeyEvent.VK_S){

            up = false;
            left = false;
            right = false;

            down = true;
        }
        if(key == KeyEvent.VK_A){

            down = false;
            up = false;
            right = false;

            left = true;
        }
        if(key == KeyEvent.VK_D){

            down = false;
            left = false;
            up = false;

            right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W){

        }
        if(key == KeyEvent.VK_S){

        }
        if(key == KeyEvent.VK_A){

        }
        if(key == KeyEvent.VK_D){

        }
    }
}