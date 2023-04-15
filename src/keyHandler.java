import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener {

    public Boolean upP1Pressed = false, downP1Pressed = false, upP2Pressed = false, downP2Pressed = false;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W){
            upP1Pressed = true;
        }

        if (code == KeyEvent.VK_S){
            downP1Pressed = true;
        }

        if (code == KeyEvent.VK_UP){
            upP2Pressed = true;
        }

        if (code == KeyEvent.VK_DOWN){
            downP2Pressed = true;
        }



    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W){
            upP1Pressed = false;
        }

        if (code == KeyEvent.VK_S){
            downP1Pressed = false;
        }

        if (code == KeyEvent.VK_UP){
            upP2Pressed = false;
        }

        if (code == KeyEvent.VK_DOWN){
            downP2Pressed = false;
        }

    }
}