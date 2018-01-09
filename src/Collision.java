


public class Collision  {

    Collision(){

    }

    boolean[][] CollidableObjects;

    int posX;
    int posY;

    boolean[] lockRight;
    boolean[] lockLeft;
    boolean[] lockUp;
    boolean[] lockDown;

    public boolean getLockRight() {
        return lockRight[0];
    }

    public boolean getLockLeft() {
        return lockLeft[0];
    }

    public boolean getLockUp() {
        return lockUp[0];
    }

    public boolean getLockDown() {
        return lockDown[0];
    }

    public void initCollision(){

        lockRight = new boolean[1];
        lockLeft = new boolean[1];
        lockDown = new boolean[1];
        lockUp = new boolean[1];

        lockRight[0] = false;
        lockLeft[0] = false;
        lockUp[0] = false;
        lockDown[0] = false;
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
            lockRight[0] = true;
        }else{
            lockRight[0] = false;
        }
        if(CollidableObjects[posX-1][posY]){
            lockLeft[0] = true;
        }else{
            lockLeft[0] = false;
        }
        if(CollidableObjects[posX][posY+1]){
            lockDown[0] = true;
        }else{
            lockDown[0] = false;
        }
        if(CollidableObjects[posX][posY-1]){
            lockUp[0] = true;
        }else{
            lockUp[0] = false;
        }
        if(CollidableObjects[posX][posY]){
//            playerMan.setMapPosX(playerMan.getMapPosX() + 2);
//            playerMan.setMapPosY(playerMan.getMapPosY() + 2);
            if(playerMovement.getDirection() == CharacterMovement.Direction.right){
                playerMan.setMapPosX(playerMan.getMapPosX() - 2);
                lockUp[0] = true;
                lockDown[0] = true;
                lockLeft[0] = true;
                lockRight[0] = true;
            }
            if(playerMovement.getDirection() == CharacterMovement.Direction.left){
                playerMan.setMapPosX(playerMan.getMapPosX() + 2);
                lockUp[0] = true;
                lockDown[0] = true;
                lockLeft[0] = true;
                lockRight[0] = true;
            }
            if(playerMovement.getDirection() == CharacterMovement.Direction.up){
                playerMan.setMapPosX(playerMan.getMapPosY() + 2);
                lockUp[0] = true;
                lockDown[0] = true;
                lockLeft[0] = true;
                lockRight[0] = true;
            }
            if(playerMovement.getDirection() == CharacterMovement.Direction.up){
                playerMan.setMapPosX(playerMan.getMapPosY() - 2);
                lockUp[0] = true;
                lockDown[0] = true;
                lockLeft[0] = true;
                lockRight[0] = true;
            }
        }
    }

    public int edgeCheck(Character player){
        if(player.getMapPosY() < 10){
            player.setMapPosY(545);
            return 1;
        }
        if(player.getMapPosY() >= 550){
            player.setMapPosY(10);
            return 2;
        }
        if(player.getMapPosX() >= 790){
            player.setMapPosX(20);
            return 3;

        }
        if(player.getMapPosX() <= 10){
            player.setMapPosX(780);
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
