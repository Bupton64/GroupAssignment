import java.awt.*;
import java.awt.event.*;

public class plains_H9 extends  extraFunctions {



    int direction;


    plains_H9() {
        backgroundImage= loadImage("plains_H9.png");
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
                player.setCurrentMapLocation(38);
                if(player.getMapPosX() <500){
                    player.setMapPosX(player.getMapPosX()-80);
                }

                flicker = false;
                return true;
            case 2:
                //going down
                player.setCurrentMapLocation(40);
                if(player.getMapPosX() <500){
                    player.setMapPosX(player.getMapPosX()-80);
                }
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(41);
                flicker = false;
                return true;
            case 4:
                //going left
                player.setCurrentMapLocation(35);
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
//        collisionPoints.addBoxCollision(53,7,11,14,flicker);

    }


}

