import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

public class MapGenerator {

    GamePanel gp;
    int[][] map;
    Tile[] tile;

    public MapGenerator(GamePanel gp){
        this.gp = gp;

        //create arrays
        map = new int[gp.maxCol][gp.maxRow];
        tile = new Tile[30];

        //load images and map from disc
        loadTiles();
        loadMap("/Map/map01.txt");

    }

    public void loadTiles(){

        try{

            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Map/space.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Map/empty_space.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Map/border_down.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Map/border_angle_left_up.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/Map/border_left.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/Map/border_angle_right_up.png"));
            tile[5].collision = true;

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/Map/border_right.png"));
            tile[6].collision = true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/Map/border_angle_left_down.png"));
            tile[7].collision = true;

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/Map/border_up.png"));
            tile[8].collision = true;

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/Map/border_angle_right_down.png"));
            tile[9].collision = true;

            //walls
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/Map/wall_from_down.png"));
            tile[10].collision = true;

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/Map/wall_from_up.png"));
            tile[11].collision = true;

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/Map/wall_from_right.png"));
            tile[12].collision = true;

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/Map/wall_from_left.png"));
            tile[13].collision = true;

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/Map/wall_horizontal.png"));
            tile[14].collision = true;

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/Map/wall_vertical.png"));
            tile[15].collision = true;

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/Map/angle__right_down.png"));
            tile[16].collision = true;

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/Map/angle__right_up.png"));
            tile[17].collision = true;

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/Map/angle__up_left.png"));
            tile[18].collision = true;

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/Map/angle__left_down.png"));
            tile[19].collision = true;

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/Map/ending_right.png"));
            tile[20].collision = true;

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/Map/ending_up.png"));
            tile[21].collision = true;

            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/Map/ending_down.png"));
            tile[22].collision = true;

            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/Map/ending_left.png"));
            tile[23].collision = true;

            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/Map/wall_one.png"));
            tile[24].collision = true;

            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/Map/wall_two.png"));
            tile[25].collision = true;

            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/Map/wall_three.png"));
            tile[26].collision = true;

            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/Map/wall_four.png"));
            tile[27].collision = true;



        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void loadMap(String filePath){

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
                    map[col++][row] = num;
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

            g2.drawImage(tile[map[col][row]].image, x, y, gp.tileSize, gp.tileSize, null);
            
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
