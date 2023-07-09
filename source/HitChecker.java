public class HitChecker {
    
    GamePanel gp;

    public HitChecker(GamePanel gp){
        this.gp = gp;
    }

    public boolean hit(){

        int playerX = gp.player.x;
        int playerY = gp.player.y;
        int p = 8;

        for(int i = 0; i < gp.monster.length; i++){

            int monsterX = gp.monster[i].x;
            int monsterY = gp.monster[i].y;

            if((playerX - p >= monsterX && playerX + p <= monsterX + gp.tileSize && playerY - p >= monsterY - gp.tileSize && playerY + p <= monsterY + gp.tileSize) || (playerY - p >= monsterY - gp.tileSize && playerY + p <= monsterY + gp.tileSize && playerX + p<= monsterX + gp.tileSize && playerX - p >= monsterX - gp.tileSize)){

                return true;
            }
        }

        return false;
    }

}
