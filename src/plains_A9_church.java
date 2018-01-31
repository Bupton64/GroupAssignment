import java.awt.*;
import java.awt.event.*;

public class plains_A9_church extends  Map {



    plains_A9_church() {
        backgroundImage= loadImage("plains_A9_church.png");
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
                player.setCurrentMapLocation(0);
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
        //Front
        collisionPoints.addBoxCollision(33,14,8,4,flicker);
        //Seats left
        collisionPoints.addBoxCollision(14,21,17,3,flicker);
        collisionPoints.addBoxCollision(14,26,17,3,flicker);
        collisionPoints.addBoxCollision(14,31,17,3,flicker);
        collisionPoints.addBoxCollision(14,36,17,3,flicker);
        //Seats right
        collisionPoints.addBoxCollision(43,21,19,3,flicker);
        collisionPoints.addBoxCollision(43,26,19,3,flicker);
        collisionPoints.addBoxCollision(43,31,19,3,flicker);
        collisionPoints.addBoxCollision(43,36,19,3,flicker);
    }


}

