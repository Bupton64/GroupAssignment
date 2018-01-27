import java.awt.*;
import java.awt.event.*;

public class plains_E5 extends Map {



    plains_E5() {
        backgroundImage= loadImage("plains_E5.png");
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
                
                return true;
            case 2:
                //going down
                player.setCurrentMapLocation(18);
                flicker = false;
                return true;
            case 3:
                // going right
               
                return true;
            case 4:
                //going left
               
                return true;
        }
        if(player.getMapPosX() < 410 && player.getMapPosX() > 370 && player.getMapPosY() > 240 && player.getMapPosY() < 250){
            player.setCurrentMapLocation(55);
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
        collisionPoints.addCollisionPoint(12,flicker);

        collisionPoints.addCollisionPoint(2,flicker);
        for(int i = 5;i < 11;i++){
            collisionPoints.addSmallCollisionPoint(i,12,flicker);
        }
        for(int i = 11;i > 7;i--){
            collisionPoints.addSmallCollisionPoint(10,i,flicker);
        }
        collisionPoints.addSmallCollisionPoint(11,7,flicker);
        collisionPoints.addSmallCollisionPoint(11,8,flicker);
        collisionPoints.addSmallCollisionPoint(12,7,flicker);
        collisionPoints.addSmallCollisionPoint(12,6,flicker);
        collisionPoints.addSmallCollisionPoint(13,6,flicker);
        collisionPoints.addSmallCollisionPoint(13,5,flicker);


        collisionPoints.addSmallCollisionPoint(63,7,flicker);
        collisionPoints.addSmallCollisionPoint(63,8,flicker);
        collisionPoints.addSmallCollisionPoint(62,7,flicker);
        collisionPoints.addSmallCollisionPoint(62,6,flicker);
        collisionPoints.addSmallCollisionPoint(61,6,flicker);
        collisionPoints.addSmallCollisionPoint(61,5,flicker);
        for(int i = 64;i < 70;i++){
            collisionPoints.addSmallCollisionPoint(i,12,flicker);
        }
        for(int i = 11;i > 7;i--){
            collisionPoints.addSmallCollisionPoint(63,i,flicker);
        }

        for(int i = 0;i < 12;i++){
            collisionPoints.addCollisionPoint(i * 16,flicker);
        }
        for(int i = 0;i < 12;i++){
            collisionPoints.addCollisionPoint(14 + (i * 16),flicker);
        }

        for(int i = 0; i < 80;i++){
            collisionPoints.addSmallCollisionPoint(i,2,flicker);
        }

        //House
        for(int i = 29; i <= 50; i++){
            collisionPoints.addSmallCollisionPoint(i,23,flicker);
        }
        for(int i = 3; i <= 23; i++){
            collisionPoints.addSmallCollisionPoint(30,i,flicker);
            collisionPoints.addSmallCollisionPoint(50,i,flicker);
        }
        //Rock
        collisionPoints.addSmallCollisionPoint(29,8,flicker);
        collisionPoints.addSmallCollisionPoint(28,8,flicker);
        collisionPoints.addSmallCollisionPoint(27,8,flicker);
        collisionPoints.addSmallCollisionPoint(26,8,flicker);
        collisionPoints.addSmallCollisionPoint(26,8,flicker);
        collisionPoints.addSmallCollisionPoint(26,7,flicker);
        collisionPoints.addSmallCollisionPoint(26,7,flicker);
        collisionPoints.addSmallCollisionPoint(27,6,flicker);
        collisionPoints.addSmallCollisionPoint(28,5,flicker);
        collisionPoints.addSmallCollisionPoint(28,4,flicker);
        collisionPoints.addSmallCollisionPoint(29,4,flicker);

        //Grave
        collisionPoints.addSmallCollisionPoint(58,9,flicker);
        collisionPoints.addSmallCollisionPoint(58,10,flicker);
        for(int i = 57; i <= 59; i++){
            collisionPoints.addSmallCollisionPoint(i,14,flicker);
            collisionPoints.addSmallCollisionPoint(i,11,flicker);       //was 9
        }
        for(int i = 11; i <= 14; i++){
            collisionPoints.addSmallCollisionPoint(59,i,flicker);
            collisionPoints.addSmallCollisionPoint(56,i,flicker);
        }
    }


}

