import java.awt.*;
import java.awt.event.*;

public class plains_G8 extends Map {



    plains_G8() {
        backgroundImage= loadImage("Image/plains_blank_variation1.png");
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
                player.setCurrentMapLocation(33);
                if(player.getMapPosX() > 660){
                    player.setMapPosX(660);
                }
                flicker = false;
                return true;
            case 2:
                //going down
               player.setCurrentMapLocation(35);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(38);
                flicker = false;
                return true;
            case 4:
                //going left
                player.setCurrentMapLocation(28);
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


        


    }


}

