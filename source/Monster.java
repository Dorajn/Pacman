import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Monster extends Entity{

    GamePanel gp;
    int timeInterval = 0;
    Random random = new Random();
    Area area;
    CollisionChecker cc;
    boolean collisionON = false;
    
    public Monster(GamePanel gp, int x, int y){
        this.gp = gp;  
        dir = "right"; 
        speed = 2;
        cc = new CollisionChecker(gp);

        this.x = x;
        this.y = y;

        area = new Area(gp, x, y);
    }

    public void loadImages(String p1, String p2, String p3, String p4){

        try{

            up = ImageIO.read(getClass().getResourceAsStream(p1));
            down = ImageIO.read(getClass().getResourceAsStream(p2));
            left = ImageIO.read(getClass().getResourceAsStream(p3));
            right = ImageIO.read(getClass().getResourceAsStream(p4));
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void update(int i){

        String temp = dir;

        collisionON = false;
        cc.checkMonster(area, dir, i);

        if(collisionON){

            area.move_back2(dir, i);

            do{

                int choice = random.nextInt(4);

                if(choice == 0){
                    dir = "up";
                }
                else if(choice == 1){
                    dir = "down";
                }
                else if(choice == 2){
                    dir = "left";
                }
                else{
                    dir = "right";
                }

            }while(dir == temp);

        }

        switch(dir){
            case "up": y -= speed; 
                area.move2(dir, i);
            
            break;
            case "down": y += speed; 
                area.move2(dir, i);
            
            break;
            case "left": x -= speed;
                area.move2(dir, i);
            
            break;
            case "right": x += speed;
                area.move2(dir, i);
            
            break;
        }
        
    }
    

    public void draw(Graphics2D g2){


        switch(dir){
            case "up":image = up; break;
            case "down": image = down; break;
            case "left": image = left; break;
            case "right": image = right; break;
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

    }

}
