import java.awt.*;
import java.awt.event.*;

public class plains_E8_topRightHouse extends  Map {



    plains_E8_topRightHouse() {
        backgroundImage= loadImage("Image/plains_E8_topRightHouse.png");
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
                player.setCurrentMapLocation(20);
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
        collisionPoints.addBoxCollision(32,21,10,5,flicker);
        collisionPoints.addBoxCollision(21,14,3,3,flicker);
        collisionPoints.addBoxCollision(14,14,3,3,flicker);
        collisionPoints.addBoxCollision(50,14,3,3,flicker);
        collisionPoints.addBoxCollision(57 ,14,3,3,flicker);
        collisionPoints.addBoxCollision(34 ,19,2,2,flicker);
        collisionPoints.addBoxCollision(39 ,19,2,2,flicker);
        collisionPoints.addBoxCollision(30 ,22,2,4,flicker);
        collisionPoints.addBoxCollision(43 ,22,2,3,flicker);
        collisionPoints.addBoxCollision(34 ,19,2,2,flicker);

        collisionPoints.addBoxCollision(34 ,27,2,1,flicker);
        collisionPoints.addBoxCollision(39 ,27,2,1         ,flicker);
    }


}

