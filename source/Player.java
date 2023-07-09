import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler kh;
    Area area;
    Area area2;
    CollisionChecker checker;

    long counter = 0;
    int num = 1;

    
    Player(GamePanel gp, KeyHandler kh){
        this.gp = gp;
        this.kh = kh;
        
        x = 13 * gp.tileSize;
        y = 13 * gp.tileSize;
        speed = 3;

        dir = "left";
        loadImages();
        area = new Area(gp, x + 8, y + 8);
        area2 = new Area(gp, x + 23, y + 23);
        checker = new CollisionChecker(gp);
    }

    public void update(){

        collisionOn = false;

        if(kh.up){


            area.move("up");
            area2.move("up");
            checker.check(area, "up");
            checker.checkEating(gp.pm, area2, "up");

            if(collisionOn){
                area.move_back("up");
                area2.move_back("up");
            }
            else
                y -= speed;


            dir = "up";
        }
        else if(kh.down){

            
            area.move("down");
            area2.move("down");
            checker.check(area, "down");
            checker.checkEating(gp.pm, area2, "down");

            if(collisionOn){
                area.move_back("down");
                area2.move_back("down");
            }
            else
                y += speed;


            dir = "down";
        }
        else if(kh.left){

            area.move("left");
            area2.move("left");
            checker.check(area, "left");
            checker.checkEating(gp.pm, area2, "left");

            if(collisionOn){
                area.move_back("left");
                area2.move_back("left");
            }
            else
                x -= speed;

            dir = "left";
        }
        else if(kh.right){

            area.move("right");
            area2.move("right");
            checker.check(area, "right");
            checker.checkEating(gp.pm, area2, "right");

            if(collisionOn){
                area.move_back("right");
                area2.move_back("right");
            }
            else
                x += speed;

            dir = "right";
        }


    }

    public void draw(Graphics2D g2){

        if(counter == 12){
            counter = 0;

            if(num == 1){
                num = 2;
            }
            else if(num == 2){
                num = 3;
            }
            else if(num == 3){
                num = 1;
            }
        }

        counter++;

        BufferedImage image = null;

        switch(dir){
            case "up":

                if(num == 1){
                    image = up_open;
                }
                else if(num == 2){
                    image = up_half;
                }
                else if(num == 3){
                    image = up_full;
                }
                
            break;

            case "down":
                if(num == 1){
                    image = down_open;
                }
                else if(num == 2){
                    image = down_half;
                }
                else if(num == 3){
                    image = down_full;
                }
            break;

            case "left":
                if(num == 1){
                    image =left_open;
                }
                else if(num == 2){
                    image = left_half;
                }
                else if(num == 3){
                    image = left_full;
                }
            break;

            case "right":   
                if(num == 1){
                    image = right_open;
                }
                else if(num == 2){
                    image = right_half;
                }
                else if(num == 3){
                    image = right_full;
                }
            break;
        }

        //area.draw(g2);
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

    public void loadImages(){

        try{

            up_full = ImageIO.read(getClass().getResourceAsStream("/Player/up/full.png"));
            up_half = ImageIO.read(getClass().getResourceAsStream("/Player/up/half.png"));
            up_open = ImageIO.read(getClass().getResourceAsStream("/Player/up/open.png"));

            down_full = ImageIO.read(getClass().getResourceAsStream("/Player/down/full.png"));
            down_half = ImageIO.read(getClass().getResourceAsStream("/Player/down/half.png"));
            down_open = ImageIO.read(getClass().getResourceAsStream("/Player/down/open.png"));

            left_full = ImageIO.read(getClass().getResourceAsStream("/Player/left/full.png"));
            left_half = ImageIO.read(getClass().getResourceAsStream("/Player/left/half.png"));
            left_open = ImageIO.read(getClass().getResourceAsStream("/Player/left/open.png"));

            right_full = ImageIO.read(getClass().getResourceAsStream("/Player/right/full.png"));
            right_half = ImageIO.read(getClass().getResourceAsStream("/Player/right/half.png"));
            right_open = ImageIO.read(getClass().getResourceAsStream("/Player/right/open.png"));


            
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
