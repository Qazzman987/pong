import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        ImageIcon iconimage = new ImageIcon("res/pongIcon.png");
        Image gameIcon = iconimage.getImage();

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("PONG");
        window.setIconImage(gameIcon);

        gamePanel gamepanel = new gamePanel();
        window.add(gamepanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamepanel.startGameThread();
    }
}