import java.awt.*;
import java.awt.event.*;

public class plains_A9 extends  extraFunctions {



    int direction;
    boolean flicker;


    plains_A9() {
        backgroundImage= loadImage("plains_A9.png");
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
                player.setCurrentMapLocation(2);
                flicker = false;
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
        collisionPoints.addCollisionPoint(113,flicker);
        collisionPoints.addCollisionPoint(130,flicker);
        collisionPoints.addCollisionPoint(1,flicker);
        collisionPoints.addCollisionPoint(2,flicker);
        collisionPoints.addCollisionPoint(17,flicker);
        collisionPoints.addCollisionPoint(129,flicker);

        collisionPoints.addSmallCollisionPoint(14,5,flicker);
        collisionPoints.addSmallCollisionPoint(13,6,flicker);
        collisionPoints.addSmallCollisionPoint(12,6,flicker);
        collisionPoints.addSmallCollisionPoint(12,7,flicker);
        collisionPoints.addSmallCollisionPoint(11,7,flicker);
        collisionPoints.addSmallCollisionPoint(11,8,flicker);
        collisionPoints.addSmallCollisionPoint(10,8,flicker);

        for(int i = 5; i <10; i++){
            collisionPoints.addSmallCollisionPoint(i,12,flicker);
        }

        collisionPoints.addSmallCollisionPoint(9,11,flicker);
        collisionPoints.addSmallCollisionPoint(9,10,flicker);


        collisionPoints.addSmallCollisionPoint(13,39,flicker);
        collisionPoints.addSmallCollisionPoint(12,38,flicker);
        collisionPoints.addSmallCollisionPoint(12,37,flicker);
        collisionPoints.addSmallCollisionPoint(11,37,flicker);
        collisionPoints.addSmallCollisionPoint(11,36,flicker);
        collisionPoints.addSmallCollisionPoint(10,35,flicker);

        for(int i = 0; i < 80;i++){
            collisionPoints.addSmallCollisionPoint(i,2,flicker);
        }
        for(int i = 144;i < 177;i++){
            collisionPoints.addCollisionPoint(i,flicker);
        }
        for(int i = 0;i < 12;i++){
            collisionPoints.addCollisionPoint(i * 16,flicker);
        }


    }


}

