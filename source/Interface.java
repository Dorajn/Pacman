import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;

public class Interface {
    
    GamePanel gp;
    BufferedImage heart, lost_heart, sh1, sh2, im;
    Font s80;
    DecimalFormat dFormat = new DecimalFormat("#0.000");
    double playTime = 0;
    int time = 0;

    Interface(GamePanel gp){
        this.gp = gp;

        
        try {
            InputStream is = getClass().getResourceAsStream("/Font/game_over.ttf");
            s80 = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        loadImages();
    }

    public void loadImages(){

        try{

            heart = ImageIO.read(getClass().getResourceAsStream("/ui/heart.png"));
            lost_heart = ImageIO.read(getClass().getResourceAsStream("/ui/lost_heart.png"));
            sh1 = ImageIO.read(getClass().getResourceAsStream("/ui/shield.png"));
            sh2 = ImageIO.read(getClass().getResourceAsStream("/ui/shield_bright.png"));

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D g2){


        if(gp.over){

            g2.setFont(s80);
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 165F));
            g2.setColor(Color.WHITE);

            String text;
            int textLenght;
            int x;
            int y;

            text = "GAME OVER";
            textLenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - (textLenght / 2);
            y = gp.screenHeight / 2 - 20;
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 100F));
            text = "try again";
            textLenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - (textLenght / 2);
            y = gp.screenHeight / 2 + 20;
            g2.drawString(text, x, y);

        }
        else if(gp.win){

            g2.setFont(s80);
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 165F));
            g2.setColor(Color.GREEN);

            String text;
            int textLenght;
            int x;
            int y;

            text = "LEVEL PASSED";
            textLenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - (textLenght / 2);
            y = gp.screenHeight / 2 - gp.tileSize;
            g2.drawString(text, x, y);

            g2.setColor(Color.WHITE);

            text = "Your time: " +  dFormat.format(playTime) + "!";
            textLenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - (textLenght / 2);
            y = gp.screenHeight / 2 + gp.tileSize;
            g2.drawString(text, x, y);
        }


        int x = 10;

        for(int i = 0; i < gp.lifes; i++){
            g2.drawImage(heart, x ,gp.tileSize * 15, gp.tileSize, gp.tileSize, null);
            x += 52;
        }
        for(int i = 0; i < 3 - gp.lifes; i++){
            g2.drawImage(lost_heart, x ,gp.tileSize * 15, gp.tileSize, gp.tileSize, null);
            x += 52;
        }

        if(gp.shield && gp.lifes > 0){
            
            if(time % 10 == 0){
                im = sh1;
            }
            else{
                im = sh2;
            }
            time++;
            
            g2.drawImage(im, 3 * gp.tileSize + 32, 15 * gp.tileSize - 6, gp.tileSize, gp.tileSize, null);

            
            if(time == 80){
                time = 0;
                gp.shield = false;
            }
        }

        playTime += (double) 1 / 60;

        g2.setFont(s80);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 75F));
        g2.setColor(Color.WHITE);
        g2.drawString("Left to collect: " + gp.pm.pointsToEat, 10 * gp.tileSize - 20, 16 * gp.tileSize - 20);
        g2.drawString("Time " + dFormat.format(playTime), 5 * gp.tileSize, 16 * gp.tileSize - 20);


    }


}
