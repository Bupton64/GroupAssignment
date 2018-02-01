import java.awt.*;
import java.awt.event.*;

public class plains_E9_bottomHouse extends  Map {



    plains_E9_bottomHouse() {
        backgroundImage= loadImage("Image/plains_E9_bottomHouse.png");
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
                player.setCurrentMapLocation(21);
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
        collisionPoints.addBoxCollision(32,19,11,8,flicker);
        collisionPoints.addBoxCollision(35,17,3,2,flicker);
        collisionPoints.addBoxCollision(30,20,3,5,flicker);
        collisionPoints.addBoxCollision(36,26,3,2,flicker);
        collisionPoints.addBoxCollision(42,20,1,5,flicker);
        //Bed
        collisionPoints.addBoxCollision(51,14,6,4,flicker);
    }


}

