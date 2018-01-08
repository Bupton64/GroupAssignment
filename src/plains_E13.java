import java.awt.*;
import java.awt.event.*;

public class plains_E13 extends  extraFunctions {



    int direction;
    boolean flicker;


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


    }


}

