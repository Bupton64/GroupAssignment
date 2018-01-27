import java.awt.*;
import java.awt.event.*;

public class plains_C8 extends  Map{


    plains_C8() {
        backgroundImage= loadImage("farm.png");
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
				player.setCurrentMapLocation(4);

                flicker = false;
                return true;
            case 2:
                //going down
				player.setCurrentMapLocation(6);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(12);
                flicker = false;
                return true;
            case 4:
                //going left
                player.setCurrentMapLocation(1);
                flicker = false;
                return true;
        }
        if(player.getMapPosX() < 200 && player.getMapPosX() > 160 && player.getMapPosY() > 230 && player.getMapPosY() < 260){
            player.setCurrentMapLocation(53);
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
        //Fence
        collisionPoints.addBoxCollision(24,44,42,2,flicker);
        collisionPoints.addBoxCollision(9,44,10,2,flicker);
        collisionPoints.addBoxCollision(9,31,14,2,flicker);
        collisionPoints.addBoxCollision(27,31,5,2,flicker);
        collisionPoints.addBoxCollision(9,4,57,2,flicker);
        collisionPoints.addBoxCollision(33,22,4,2,flicker);
        collisionPoints.addBoxCollision(42,22,24,2,flicker);
        collisionPoints.addBoxCollision(9,4,1,43,flicker);
        collisionPoints.addBoxCollision(30,28,1,19,flicker);
        collisionPoints.addBoxCollision(33,4,1,21,flicker);
        collisionPoints.addBoxCollision(64,4,1,42,flicker);
        //House
        collisionPoints.addBoxCollision(12,6,19,17,flicker);

    }


}

