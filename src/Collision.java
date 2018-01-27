


public class Collision  {

    Collision(){
        initCollision();
    }

    boolean[][] CollidableObjects;

    int posX;
    int posY;



    public void initCollision(){



        posX = 4;
        posY = 4;
        CollidableObjects  = new boolean[80][60];
        for(int i = 0;i < 60;i++) {
            for (int j = 0; j < 80; j++) {
                CollidableObjects[j][i] = false;

            }
        }


    }

    public void updateCollision(Character playerMan,CharacterMovement playerMovement) {

        posX = (int)playerMan.getMapPosX() / 10;
        posY = (int)playerMan.getMapPosY() / 10;
        if(CollidableObjects[posX+1][posY]){
            playerMovement.setLockRight(true);
        }else{
            playerMovement.setLockRight(false);
        }
        if(CollidableObjects[posX-1][posY]){
            playerMovement.setLockLeft(true);
        }else{
            playerMovement.setLockLeft(false);
        }
        if(CollidableObjects[posX][posY+1]){
            playerMovement.setLockDown(true);
        }else{
            playerMovement.setLockDown(false);
        }
        if(CollidableObjects[posX][posY-1]){
            playerMovement.setLockUp(true);
        }else{
            playerMovement.setLockUp(false);
        }
        if(CollidableObjects[posX][posY]){
            if(playerMovement.getDirection() == CharacterMovement.Direction.right){
                playerMan.setMapPosX(playerMan.getMapPosX() - 2);
                playerMovement.setLockRight(true);
                playerMovement.setLockLeft(true);
                playerMovement.setLockUp(true);
                playerMovement.setLockDown(true);
            }
            if(playerMovement.getDirection() == CharacterMovement.Direction.left){
                playerMan.setMapPosX(playerMan.getMapPosX() + 2);
                playerMovement.setLockRight(true);
                playerMovement.setLockLeft(true);
                playerMovement.setLockUp(true);
                playerMovement.setLockDown(true);
            }
            if(playerMovement.getDirection() == CharacterMovement.Direction.up){
                playerMan.setMapPosY(playerMan.getMapPosY() + 2);
                playerMovement.setLockRight(true);
                playerMovement.setLockLeft(true);
                playerMovement.setLockUp(true);
                playerMovement.setLockDown(true);
            }
            if(playerMovement.getDirection() == CharacterMovement.Direction.down){
                playerMan.setMapPosY(playerMan.getMapPosY() - 2);
                playerMovement.setLockRight(true);
                playerMovement.setLockLeft(true);
                playerMovement.setLockUp(true);
                playerMovement.setLockDown(true);
            }
        }
    }

    public int edgeCheck(Character player){
        switch((int)player.getCurrentMapLocation()){
            case 42:
                if(player.getMapPosY() >= 390){
                    player.setMapPosY(250);
                    player.setMapPosX(590);
                    return 2;
                }
            case 43:
                if(player.getMapPosY() >= 390){
                    player.setMapPosY(460);
                    player.setMapPosX(650);
                    return 2;
                }
            case 44:
                if(player.getMapPosY() >= 390){
                    player.setMapPosY(240);
                    player.setMapPosX(100);
                    return 2;
                }
            case 45:
                if(player.getMapPosY() >= 390){
                    player.setMapPosY(240);
                    player.setMapPosX(250);
                    return 2;
                }
            case 46:
                if(player.getMapPosY() >= 390){
                    player.setMapPosY(210);
                    player.setMapPosX(250);
                    return 2;
                }
            case 47:
                if(player.getMapPosY() >= 390){
                    player.setMapPosY(530);
                    player.setMapPosX(580);
                    return 2;
                }
            case 48:
                if(player.getMapPosY() >= 390){
                    player.setMapPosY(460);
                    player.setMapPosX(70);
                    return 2;
                }
            case 49:
                if(player.getMapPosY() >= 390){
                    player.setMapPosY(460);
                    player.setMapPosX(270);
                    return 2;
                }
            case 50:
                if(player.getMapPosY() >= 390){
                    player.setMapPosY(220);
                    player.setMapPosX(80);
                    return 2;
                }
            case 51:
                if(player.getMapPosY() >= 390){
                    player.setMapPosY(370);
                    player.setMapPosX(380);
                    return 2;
                }
            case 52:
                if(player.getMapPosY() >= 390){
                    player.setMapPosY(255);
                    player.setMapPosX(550);
                    return 2;
                }
            case 53:
                if(player.getMapPosY() >= 390){
                    player.setMapPosY(250);
                    player.setMapPosX(205);
                    return 2;
                }
            case 55:
                if(player.getMapPosY() >= 390){     //Haven't adjust positioning yet
                    player.setMapPosY(350);
                    player.setMapPosX(180);
                    return 2;
                }
        }
     
        if(player.getMapPosY() < 10){
            player.setMapPosY(545);
            return 1;
        }
        if(player.getMapPosY() >= 550){
            player.setMapPosY(10);
            return 2;
        }
        if(player.getMapPosX() >= 770){
            player.setMapPosX(20);
            return 3;

        }
        if(player.getMapPosX() <= 10){
            player.setMapPosX(760);
            return 4;
        }
        return 0;
    }






    int row;
    int col;
    public void addCollisionPoint( int block,boolean flicker){
        row = (block / 16) * 5;//8
        col = ((block % 16) * 5);// 6
        for(int i = row;i < (row+5);i++){
            for(int j = col ;j < (col+5);j++) {
                CollidableObjects[j][i] = flicker;
            }
        }
    }


    public void addSmallCollisionPoint(int posX,int posY, boolean flicker){
        CollidableObjects[posX][posY] = flicker;
    }

    public void addBoxCollision(int posX,int posY,int width, int height, boolean flicker){
        for(int i = posX; i <= posX+width;i++){
            for(int j = posY; j <= posY + height;j++){
                addSmallCollisionPoint(i,j,flicker);
            }
        }
    }




    public int blocknum(Character player){
        row = (int)player.getMapPosY() / 50 ;
        col = (int)player.getMapPosX() / 50;
        return ((row * 16) + col);
    }


}
