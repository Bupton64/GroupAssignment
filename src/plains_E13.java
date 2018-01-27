import java.awt.*;
import java.awt.event.*;

public class plains_E13 extends  Map {



    plains_E13() {
        backgroundImage= loadImage("plains_E13.png");
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
                player.setCurrentMapLocation(24);
                flicker = false;
                return true;
            case 2:
                //going down
                
                
                return true;
            case 3:
                // going right
                
                
                return true;
            case 4:
                //going left
                
                
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
		  collisionPoints.addCollisionPoint(164,flicker);
        collisionPoints.addCollisionPoint(170,flicker);
        collisionPoints.addSmallCollisionPoint(24,49,flicker);
        collisionPoints.addSmallCollisionPoint(23,48,flicker);
        collisionPoints.addSmallCollisionPoint(23,47,flicker);
        collisionPoints.addSmallCollisionPoint(22,46,flicker);
        collisionPoints.addSmallCollisionPoint(11,36,flicker);
        collisionPoints.addSmallCollisionPoint(12,36,flicker);
        collisionPoints.addSmallCollisionPoint(12,37,flicker);
        collisionPoints.addSmallCollisionPoint(11,37,flicker);
        collisionPoints.addSmallCollisionPoint(13,37,flicker);
        collisionPoints.addSmallCollisionPoint(13,38,flicker);
        collisionPoints.addSmallCollisionPoint(14,39,flicker);
        collisionPoints.addSmallCollisionPoint(14,40,flicker);
        for(int i = 15; i < 22; i++){
            collisionPoints.addSmallCollisionPoint(i,45,flicker);
        }
        for(int i = 40; i < 45; i++){
            collisionPoints.addSmallCollisionPoint(15,i,flicker);
        }
        for(int i = 5; i < 11; i++){
            collisionPoints.addSmallCollisionPoint(i,35,flicker);
        }


        collisionPoints.addSmallCollisionPoint(50,49,flicker);
        collisionPoints.addSmallCollisionPoint(50,48,flicker);
        collisionPoints.addSmallCollisionPoint(50,47,flicker);
        collisionPoints.addSmallCollisionPoint(51,46,flicker);
        collisionPoints.addSmallCollisionPoint(52,45,flicker);
        collisionPoints.addSmallCollisionPoint(52,46,flicker);
        collisionPoints.addSmallCollisionPoint(61,38,flicker);
        collisionPoints.addSmallCollisionPoint(61,37,flicker);
        collisionPoints.addSmallCollisionPoint(61,36,flicker);
        collisionPoints.addSmallCollisionPoint(62,36,flicker);
        for(int i = 53; i < 60; i++){
            collisionPoints.addSmallCollisionPoint(i,45,flicker);
        }
        for(int i = 38; i < 45; i++){
            collisionPoints.addSmallCollisionPoint(60,i,flicker);
          //  60,40
        }
        for(int i = 63; i < 70; i++){
            collisionPoints.addSmallCollisionPoint(i,35,flicker);
        }



        for(int i = 0;i < 12;i++){
            collisionPoints.addCollisionPoint(i * 16,flicker);
        }
        for(int i = 0;i < 12;i++){
            collisionPoints.addCollisionPoint(14 + (i * 16),flicker);
        }
        //Bottom trees

        collisionPoints.addBoxCollision(22,45,27,4,flicker);
        //Trees left
        collisionPoints.addBoxCollision(5,16,10,1,flicker);
        collisionPoints.addBoxCollision(15,17,2,2,flicker);
        collisionPoints.addBoxCollision(17,19,2,2,flicker);
        collisionPoints.addBoxCollision(19,21,2,5,flicker);

        collisionPoints.addBoxCollision(20,23,18,5,flicker);
        collisionPoints.addBoxCollision(21,19,14,5,flicker);
        collisionPoints.addBoxCollision(23,18,12,2,flicker);
        collisionPoints.addBoxCollision(25,17,9,2,flicker);
        collisionPoints.addBoxCollision(27,30,8,5,flicker);
        collisionPoints.addBoxCollision(32,27,6,5,flicker);

        collisionPoints.addBoxCollision(22,32,8,12,flicker);
        //Right
        collisionPoints.addBoxCollision(41,23,29,7,flicker);
        collisionPoints.addBoxCollision(42,18,28,6,flicker);
        collisionPoints.addBoxCollision(45,17,25,4,flicker);
        collisionPoints.addBoxCollision(55,14,14,4,flicker);
        collisionPoints.addBoxCollision(42,28,19,7,flicker);
        collisionPoints.addBoxCollision(49,35,11,6,flicker);


    }


}

