import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

public class PointMenager {
    
    GamePanel gp;
    BufferedImage image;
    int[][] points;
    public int pointsToEat = 0;

    PointMenager(GamePanel gp){
        this.gp = gp;
        points = new int[gp.maxCol][gp.maxRow];

        getImage("/Map/point.png");
        loadPoints("/Map/points_map.txt");
    }

    public void getImage(String filePath){

        try{
            image = ImageIO.read(getClass().getResourceAsStream(filePath));
        }catch(Exception e){
            e.printStackTrace();
        }

    }

     public void loadPoints(String filePath){

        try{

            //to read from file
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxCol && row < gp.maxRow){

                String line = br.readLine();
                String[] numbers = line.split(" ");

                while(col < gp.maxCol){
                    int num = Integer.parseInt(numbers[col]);
                    
                    if(num == 1){
                        points[col][row] = 1;
                        pointsToEat++;
                    }
                    col++;
                }

                if(col == gp.maxCol){
                    col = 0;
                    row++;
                }

            }

            br.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D g2){

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < gp.maxCol && row < gp.maxRow){

            if(points[col][row] == 1){
                g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
            }
            
            x += gp.tileSize;
            col++;

            if(col == gp.maxCol){
                col = 0;
                row++;
                y += gp.tileSize;
                x = 0;
            }
        }

    }


}
