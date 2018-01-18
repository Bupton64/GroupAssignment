import java.awt.*;
import java.awt.event.*;

public class plains_E9 extends  Map {


    plains_E9() {
        backgroundImage= loadImage("plains_E9.png");
        direction = 0; //< DONT CHANGE
        flicker = true; //< DONT CHANGE
    }



    @Override
    public boolean updateMapMovement(Collision collisionPoints, Character player){
        direction = collisionPoints.edgeCheck(player);
        switch (direction) {
            case 0:
                //do nothing
                break;
            case 1:
                //going up
                player.setCurrentMapLocation(20);
                flicker = false;
                return true;
            case 2:
                //going down
                player.setCurrentMapLocation(22);
                flicker = false;
                return true;
            case 3:
                // going right
                if(player.getMapPosY() > 400){
                    player.setMapPosY(500);
                    player.setMapPosX(20);
                }
                player.setCurrentMapLocation(29);
                flicker = false;
                return true;
            case 4:
                //going left
                player.setCurrentMapLocation(13);
                flicker = false;
                return true;
        }       //NEED TO EDIT BELOW
        if(player.getMapPosX() < 120 && player.getMapPosX() > 80 && player.getMapPosY() > 210 && player.getMapPosY() < 240){
            player.setCurrentMapLocation(44);
            flicker = false;
            player.setMapPosX(380);
            player.setMapPosY(360);
            return true;
        }
        else if(player.getMapPosX() < 270 && player.getMapPosX() > 230 && player.getMapPosY() > 210 && player.getMapPosY() < 240){
            player.setCurrentMapLocation(45);
            flicker = false;
            player.setMapPosX(380);
            player.setMapPosY(360);
            return true;
        }
        else if(player.getMapPosX() < 660 && player.getMapPosX() > 620 && player.getMapPosY() > 420 && player.getMapPosY() < 450){
            player.setCurrentMapLocation(43);
            flicker = false;
            player.setMapPosX(380);
            player.setMapPosY(360);
            return true;
        }
        return false;
    }


    ////////////////////////////////////////////////////////////
    ///
    /// Collision
    ///
    ///////////////////////////////////////////////////////////
    @Override
    public void setUpCollision(Collision collisionPoints){
        collisionPoints.addSmallCollisionPoint(5,5,flicker);
        collisionPoints.addSmallCollisionPoint(20,5,flicker);
        collisionPoints.addSmallCollisionPoint(10,1,flicker);


        //Right small house
        collisionPoints.addBoxCollision(19,5,12,15,flicker);

        collisionPoints.addBoxCollision(24,1,3,4,flicker);

        collisionPoints.addSmallCollisionPoint(15,19,flicker);
        collisionPoints.addSmallCollisionPoint(21,4,flicker);
        collisionPoints.addSmallCollisionPoint(22,3,flicker);
        collisionPoints.addSmallCollisionPoint(23,2,flicker);
        collisionPoints.addSmallCollisionPoint(27,2,flicker);
        collisionPoints.addSmallCollisionPoint(28,3,flicker);
        collisionPoints.addSmallCollisionPoint(29,4,flicker);
        collisionPoints.addSmallCollisionPoint(30,5,flicker);

        collisionPoints.addSmallCollisionPoint(58,28,flicker);
        collisionPoints.addSmallCollisionPoint(58,29,flicker);
        collisionPoints.addSmallCollisionPoint(58,30,flicker);
        //left small house

        collisionPoints.addBoxCollision(4,5,12,15,flicker);
        collisionPoints.addBoxCollision(9,1,3,4,flicker);
        collisionPoints.addSmallCollisionPoint(6,4,flicker);
        collisionPoints.addSmallCollisionPoint(7,3,flicker);
        collisionPoints.addSmallCollisionPoint(8,2,flicker);
        collisionPoints.addSmallCollisionPoint(12,2,flicker);
        collisionPoints.addSmallCollisionPoint(13,3,flicker);
        collisionPoints.addSmallCollisionPoint(14,4,flicker);
        collisionPoints.addSmallCollisionPoint(15,5,flicker);

        //big house
        collisionPoints.addBoxCollision(59,29,20,14,flicker);



        //pier
        for(int i = 48;i <= 78;i++){
            collisionPoints.addSmallCollisionPoint(i,15,flicker);
        }
        for(int i = 48;i <= 78;i++){
            collisionPoints.addSmallCollisionPoint(i,9,flicker);
        }
//        for(int i = 9;i < 15;i++){
//            collisionPoints.addSmallCollisionPoint(76,i,flicker);
//        }

        //lake
        collisionPoints.addCollisionPoint(111,flicker);

        for(int i = 57,j = 28;i > 48;i--,j--){
            collisionPoints.addSmallCollisionPoint(i,j,flicker);
            collisionPoints.addSmallCollisionPoint(i,j-1,flicker);
        }
        collisionPoints.addSmallCollisionPoint(48,20,flicker);
        for(int i = 16; i < 20;i++){
            collisionPoints.addSmallCollisionPoint(48,i,flicker);

        }
        for(int i = 48,j = 8;i  < 57;i++,j--){
            collisionPoints.addSmallCollisionPoint(i,j,flicker);
            collisionPoints.addSmallCollisionPoint(i+1,j,flicker);
        }
        //Extra DETAILS
            //sign
        collisionPoints.addSmallCollisionPoint(37,50,flicker);
        collisionPoints.addSmallCollisionPoint(36,50,flicker);
        collisionPoints.addSmallCollisionPoint(38,50,flicker);
        collisionPoints.addSmallCollisionPoint(37,49,flicker);
        collisionPoints.addSmallCollisionPoint(36,49,flicker);
        collisionPoints.addSmallCollisionPoint(38,49,flicker);
        collisionPoints.addSmallCollisionPoint(37,48,flicker);
        collisionPoints.addSmallCollisionPoint(36,48,flicker);
        collisionPoints.addSmallCollisionPoint(38,48,flicker);
        //Wood

        collisionPoints.addSmallCollisionPoint(30,21,flicker);
        collisionPoints.addSmallCollisionPoint(30,20,flicker);
        collisionPoints.addSmallCollisionPoint(29,21,flicker);
        collisionPoints.addSmallCollisionPoint(29,20,flicker);
        collisionPoints.addSmallCollisionPoint(28,21,flicker);
        collisionPoints.addSmallCollisionPoint(28,20,flicker);

        //Fence
        for(int i = 51; i <= 58; i++) {
            collisionPoints.addSmallCollisionPoint(i, 32, flicker);
        }
        for(int i = 51; i <= 58; i++) {
            collisionPoints.addSmallCollisionPoint(i, 41, flicker);
        }
        for(int i = 32; i <= 41; i++) {
            collisionPoints.addSmallCollisionPoint(51, i, flicker);
        }

        //Bushes
            //Left
        collisionPoints.addSmallCollisionPoint(55, 42, flicker);
        collisionPoints.addSmallCollisionPoint(55, 43, flicker);
        collisionPoints.addSmallCollisionPoint(57, 44, flicker);
        collisionPoints.addSmallCollisionPoint(58, 44, flicker);
        collisionPoints.addSmallCollisionPoint(59, 44, flicker);
        collisionPoints.addSmallCollisionPoint(60, 44, flicker);
        collisionPoints.addSmallCollisionPoint(61, 44, flicker);

            //Right
        for(int i = 67; i <= 73; i++) {
            collisionPoints.addSmallCollisionPoint(i, 44, flicker);
        }
    }


}

