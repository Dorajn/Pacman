import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;


public class Main{

    public static void main(String[] args) {
        
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Pacman");
        window.setLocationRelativeTo(null); 
        window.setVisible(true);

        GamePanel gp = new GamePanel();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - gp.screenWidth) / 2;
        int y = (screenSize.height - gp.screenHeight) / 2;
        
        window.setLocation(x, y);


        window.add(gp);
        window.pack();

        gp.startGame();
    }

}

