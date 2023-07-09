import java.awt.Color;
import java.awt.Graphics2D;

public class Area {

    public int x;
    public int y;

    GamePanel gp;
    
    public Area(GamePanel gp, int x, int y){

        this.x = x;
        this.y = y;
        this.gp = gp;
    }

    public void move(String dir){

        switch(dir){
            case "up": y -= gp.player.speed; break;
            case "down": y += gp.player.speed; break;
            case "left": x -= gp.player.speed; break;
            case "right": x += gp.player.speed; break;
        }

    }

    public void move_back(String dir){

        switch(dir){
            case "up": y += gp.player.speed; break;
            case "down": y -= gp.player.speed; break;
            case "left": x += gp.player.speed; break;
            case "right": x -= gp.player.speed; break;
        }

    }

    public void move2(String dir, int i){

        switch(dir){
            case "up": y -= gp.monster[i].speed; break;
            case "down": y += gp.monster[i].speed; break;
            case "left": x -= gp.monster[i].speed; break;
            case "right": x += gp.monster[i].speed; break;
        }

    }

    public void move_back2(String dir, int i){

        switch(dir){
            case "up": y += gp.monster[i].speed; break;
            case "down": y -= gp.monster[i].speed; break;
            case "left": x += gp.monster[i].speed; break;
            case "right": x -= gp.monster[i].speed; break;
        }

    }


    public void draw(Graphics2D g2){
        
        g2.setColor(Color.WHITE);
        g2.fillRect(x, y, 32, 32);

    }

}
