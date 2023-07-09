import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable {
    
    //screen settings
    final int tileSize = 48;
    final int maxRow = 16;
    final int maxCol = 15;
    final int screenHeight = tileSize * maxRow;
    final int screenWidth = tileSize * maxCol;
    final int solid = 32;
    final int solidPoint = 2;
    public int lifes = 3;
    int counter = 0;
    public boolean shield = false;
    public boolean over = false;
    public boolean win = false;
    

    //Game running system
    Thread thread;
    KeyHandler kh = new KeyHandler();
    MapGenerator mg = new MapGenerator(this);
    PointMenager pm = new PointMenager(this);
    HitChecker hc = new HitChecker(this);
    Interface in = new Interface(this);
    Sound music = new Sound();
    Sound se = new Sound();
    Monster[] monster = new Monster[3];

    //Player settings
    Player player = new Player(this, kh);

    public GamePanel(){
        
        //screen settings
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

        //keyListener
        this.addKeyListener(kh);

        setupMonsters();

    }

    public void startGame(){
        playMusic(0);
        thread = new Thread(this);
        thread.start();
    }


    @Override
    public void run() {
        
        double interval = 1000000000 / 60;
        double currTime;
        double lastTime = System.nanoTime();
        double delta = 0;


        while(thread != null){

            currTime = System.nanoTime();
            delta += (currTime - lastTime) / interval;
            lastTime = currTime;

            if(delta > 1){  
                update();
                repaint();
                delta--;
            }

        }
        
    }

    public void update(){
        if(pm.pointsToEat <= 0){
            stopMusic();
            playSE(3);
            win = true;
            thread = null;
        }
        else{

            if(hc.hit() && counter == 0){

                if(lifes > 1)
                    playSE(2);

                lifes--;
                shield = true;
                counter = 80;
            }

            if(counter > 0){
                counter--;
            }
            
            if(lifes > 0){
                player.update();
    
                for(int i = 0; i < monster.length; i++){
                    monster[i].update(i);
                }
            }
            else{
                stopMusic();
                playSE(1);
                over = true;
                thread = null;
            }       

        }
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        mg.draw(g2);
        pm.draw(g2);

        for(int i = 0; i < monster.length; i++){
            monster[i].draw(g2);
        }

        player.draw(g2);
        in.draw(g2);

        g2.dispose();

    }

    void setupMonsters(){

        try{

            monster[0] = new Monster(this, 48, 13 * 48);
            monster[0].loadImages("/Monster/red/up.png", "/Monster/red/down.png", "/Monster/red/left.png", "/Monster/red/right.png");

            monster[1] = new Monster(this, 48, 48);
            monster[1].loadImages("/Monster/orange/up.png", "/Monster/orange/down.png", "/Monster/orange/left.png", "/Monster/orange/right.png");

            monster[2] = new Monster(this, 11 * 48, 9 * 48);
            monster[2].dir = "left";
            monster[2].loadImages("/Monster/blue/up.png", "/Monster/blue/down.png", "/Monster/blue/left.png", "/Monster/blue/right.png");


        }catch(Exception e){
            e.printStackTrace();
        }

        
    }

    public void playMusic(int i){
        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic(){
        music.stop();
    }

    public void playSE(int i){
        se.setFile(i);
        se.play();
    }

}
