import java.awt.*;
import java.awt.event.*;

public class plains_I9 extends Map {


    plains_I9() {
        backgroundImage= loadImage("Image/plains_I9.png");
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
                
                return true;
            case 3:
                // going right
                
                
                return true;
            case 4:
                //going left
                player.setCurrentMapLocation(39);
                flicker = false;
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


        collisionPoints.addCollisionPoint(28,flicker);
        collisionPoints.addCollisionPoint(29,flicker);
        collisionPoints.addCollisionPoint(45,flicker);
        collisionPoints.addCollisionPoint(125,flicker);
        collisionPoints.addCollisionPoint(140,flicker);
        collisionPoints.addCollisionPoint(141,flicker);

        collisionPoints.addSmallCollisionPoint(61,39,flicker);
        collisionPoints.addSmallCollisionPoint(61,38,flicker);
        collisionPoints.addSmallCollisionPoint(62,37,flicker);
        collisionPoints.addSmallCollisionPoint(62,36,flicker);
        collisionPoints.addSmallCollisionPoint(63,36,flicker);
        collisionPoints.addSmallCollisionPoint(64,36,flicker);


        collisionPoints.addSmallCollisionPoint(60,3,flicker);
        collisionPoints.addSmallCollisionPoint(60,4,flicker);
        for(int i = 0; i < 80;i++){
            collisionPoints.addSmallCollisionPoint(i,2,flicker);
        }
        for(int i = 0; i < 80;i++){
            collisionPoints.addSmallCollisionPoint(i,1,flicker);
        }
        for(int i = 0; i < 80;i++){
            collisionPoints.addSmallCollisionPoint(i,0,flicker);
        }
        for(int i = 144;i < 177;i++){
            collisionPoints.addCollisionPoint(i,flicker);
        }
        for(int i = 0;i < 12;i++){
            collisionPoints.addCollisionPoint(14 + (i * 16),flicker);
        }


    }


}

