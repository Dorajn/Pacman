public class CollisionChecker {
    
    GamePanel gp;

    CollisionChecker(GamePanel gp){
        this.gp = gp;
    }

    public void check(Area area, String dir){
        
        int col, row;
        boolean tile1, tile2;

        switch(dir){

            case "up":

                col = area.x / gp.tileSize;
                row = area.y / gp.tileSize;


                tile1 = gp.mg.tile[gp.mg.map[col][row]].collision;

                col = (area.x + gp.solid) / gp.tileSize;
                tile2 = gp.mg.tile[gp.mg.map[col][row]].collision;

                if(tile1 || tile2){
                    gp.player.collisionOn = true;
                }

            break;

            case "down":

                col = area.x / gp.tileSize;
                row = (area.y + gp.solid) / gp.tileSize;


                tile1 = gp.mg.tile[gp.mg.map[col][row]].collision;

                col = (area.x + gp.solid) / gp.tileSize;
                row = (area.y + gp.solid) / gp.tileSize;
                tile2 = gp.mg.tile[gp.mg.map[col][row]].collision;

                if(tile1 || tile2){
                    gp.player.collisionOn = true;
                }

            break;

            case "left":

                col = area.x / gp.tileSize;
                row = area.y / gp.tileSize;


                tile1 = gp.mg.tile[gp.mg.map[col][row]].collision;

                row = (area.y + gp.solid) / gp.tileSize;
                tile2 = gp.mg.tile[gp.mg.map[col][row]].collision;

                if(tile1 || tile2){
                    gp.player.collisionOn = true;
                }

            break;

            case "right":

                col = (area.x + gp.solid) / gp.tileSize;
                row = area.y / gp.tileSize;


                tile1 = gp.mg.tile[gp.mg.map[col][row]].collision;

                row = (area.y + gp.solid) / gp.tileSize;
                tile2 = gp.mg.tile[gp.mg.map[col][row]].collision;

                if(tile1 || tile2){
                    gp.player.collisionOn = true;
                }

            break;

        }


    }

    public void checkEating(PointMenager pm, Area area, String dir){
        
        int col, row;

        switch(dir){

            case "up":

                col = area.x / gp.tileSize;
                row = area.y / gp.tileSize;


                if(pm.points[col][row] == 1){
                    pm.points[col][row] = 0;
                    pm.pointsToEat--;
                }

                col = (area.x + gp.solidPoint) / gp.tileSize;
                
                if(pm.points[col][row] == 1){
                    pm.points[col][row] = 0;
                    pm.pointsToEat--;
                }


            break;

            case "down":

                col = area.x / gp.tileSize;
                row = (area.y + gp.solidPoint) / gp.tileSize;


                if(pm.points[col][row] == 1){
                    pm.points[col][row] = 0;
                    pm.pointsToEat--;
                }

                col = (area.x + gp.solidPoint) / gp.tileSize;
                row = (area.y + gp.solidPoint) / gp.tileSize;

                if(pm.points[col][row] == 1){
                    pm.points[col][row] = 0;
                    pm.pointsToEat--;
                }


            break;

            case "left":

                col = area.x / gp.tileSize;
                row = area.y / gp.tileSize;


                if(pm.points[col][row] == 1){
                    pm.points[col][row] = 0;
                    pm.pointsToEat--;
                }

                row = (area.y + gp.solidPoint) / gp.tileSize;
                if(pm.points[col][row] == 1){
                    pm.points[col][row] = 0;
                    pm.pointsToEat--;
                }

            break;

            case "right":

                col = (area.x + gp.solidPoint) / gp.tileSize;
                row = area.y / gp.tileSize;


                if(pm.points[col][row] == 1){
                    pm.points[col][row] = 0;
                    pm.pointsToEat--;
                }

                row = (area.y + gp.solidPoint) / gp.tileSize;
                if(pm.points[col][row] == 1){
                    pm.points[col][row] = 0;
                    pm.pointsToEat--;
                }

            break;

        }

    }

    public void checkMonster(Area area, String dir, int i){
        
        int col, row;
        boolean tile1, tile2;

        switch(dir){

            case "up":

                col = area.x / gp.tileSize;
                row = area.y / gp.tileSize;


                tile1 = gp.mg.tile[gp.mg.map[col][row]].collision;

                col = (area.x + gp.solid) / gp.tileSize;
                tile2 = gp.mg.tile[gp.mg.map[col][row]].collision;

                if(tile1 || tile2){
                    gp.monster[i].collisionON = true;
                }

            break;

            case "down":

                col = area.x / gp.tileSize;
                row = (area.y + gp.solid) / gp.tileSize;


                tile1 = gp.mg.tile[gp.mg.map[col][row]].collision;

                col = (area.x + gp.solid) / gp.tileSize;
                row = (area.y + gp.solid) / gp.tileSize;
                tile2 = gp.mg.tile[gp.mg.map[col][row]].collision;

                if(tile1 || tile2){
                    gp.monster[i].collisionON = true;
                }

            break;

            case "left":

                col = area.x / gp.tileSize;
                row = area.y / gp.tileSize;


                tile1 = gp.mg.tile[gp.mg.map[col][row]].collision;

                row = (area.y + gp.solid) / gp.tileSize;
                tile2 = gp.mg.tile[gp.mg.map[col][row]].collision;

                if(tile1 || tile2){
                    gp.monster[i].collisionON = true;
                }

            break;

            case "right":

                col = (area.x + gp.solid) / gp.tileSize;
                row = area.y / gp.tileSize;


                tile1 = gp.mg.tile[gp.mg.map[col][row]].collision;

                row = (area.y + gp.solid) / gp.tileSize;
                tile2 = gp.mg.tile[gp.mg.map[col][row]].collision;

                if(tile1 || tile2){
                    gp.monster[i].collisionON = true;
                }

            break;

        }


    }
}
