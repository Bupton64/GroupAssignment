import java.awt.*;
import java.awt.event.*;

public class plains_H9 extends Map {


    plains_H9() {
        backgroundImage= loadImage("Image/plains_H9.png");
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
                player.setCurrentMapLocation(38);
                if(player.getMapPosX() > 660){
                    player.setMapPosX(660);
                }

                flicker = false;
                return true;
            case 2:
                //going down
                player.setCurrentMapLocation(40);
                if(player.getMapPosX() > 670){
                    player.setMapPosX(670);
                }
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(41);
                if(player.getMapPosY() < 40){
                    player.setMapPosY(40);
                }
                if(player.getMapPosY() > 440){
                    player.setMapPosY(440);
                }
                flicker = false;
                return true;
            case 4:
                //going left
                player.setCurrentMapLocation(35);
                flicker = false;
                return true;
        }
        if(player.getMapPosX() < 570 && player.getMapPosX() > 530 && player.getMapPosY() > 220 && player.getMapPosY() < 250){
            player.setCurrentMapLocation(52);
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
        //Furnace
        collisionPoints.addBoxCollision(40,5,8,7,flicker);
        collisionPoints.addBoxCollision(42,1,4,3,flicker);

        //Table
        collisionPoints.addBoxCollision(35,11,5,6,flicker);

        //House
        collisionPoints.addBoxCollision(49,7,11,14,flicker);
        collisionPoints.addBoxCollision(49,5,10,1,flicker);
        collisionPoints.addBoxCollision(50,3,9,1,flicker);
        collisionPoints.addBoxCollision(51,3,7,1,flicker);
        collisionPoints.addBoxCollision(52,2,5,1,flicker);
        collisionPoints.addBoxCollision(53,1,3,1,flicker);
        collisionPoints.addBoxCollision(54,2,1,1,flicker);
        collisionPoints.addSmallCollisionPoint(49,19,flicker);

    }


}

