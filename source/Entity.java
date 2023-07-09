import java.awt.image.BufferedImage;

public class Entity {
    
    int x;
    int y;
    int speed;

    BufferedImage image;
    BufferedImage up_full, up_half, up_open, down_full, down_half, down_open, right_full, right_half, right_open, left_full, left_half, left_open;
    BufferedImage up, down, left, right;

    String dir;

    boolean collisionOn = false;
}
