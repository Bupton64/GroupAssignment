import java.awt.*;
import java.awt.event.*;

public class plains_F8_House extends  Map {



    plains_F8_House() {
        backgroundImage= loadImage("plains_F8_House.png");
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
                break;
            case 2:
                //going down
                player.setCurrentMapLocation(28);
                flicker = false;
                return true;

            case 3:
                // going right
                break;
            case 4:
                //going left
                break;
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
        //Walls at the bottom
        collisionPoints.addBoxCollision(2,39,32,15,flicker);
        collisionPoints.addBoxCollision(41,39,35,15,flicker);
        collisionPoints.addBoxCollision(34,40,7,1,flicker);
        //Walls sides
        collisionPoints.addBoxCollision(2,1,11,37,flicker);
        collisionPoints.addBoxCollision(62,14,11,36,flicker);
        collisionPoints.addBoxCollision(2,1,74,12,flicker);

        //DETAIL
        //Table
        collisionPoints.addBoxCollision(50,15,8,7,flicker);
        collisionPoints.addBoxCollision(48,15,4,5,flicker);
        collisionPoints.addBoxCollision(56,15,4,5,flicker);
        collisionPoints.addBoxCollision(52,14,4,1,flicker);
        collisionPoints.addBoxCollision(52,21,4,3,flicker);
        //Bed
        collisionPoints.addBoxCollision(16,14,7,3,flicker);
        //Shelf
        collisionPoints.addBoxCollision(14,24,10,14,flicker);
    }


}

