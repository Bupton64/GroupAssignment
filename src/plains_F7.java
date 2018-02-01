import java.awt.*;
import java.awt.event.*;

public class plains_F7 extends  Map {


    plains_F7() {
        backgroundImage= loadImage("Image/plains_blank_variation4.png");
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
                player.setCurrentMapLocation(26);
                if(player.getMapPosX() > 660){
                    player.setMapPosX(660);
                }
                flicker = false;
                return true;
            case 2:
                //going down
                player.setCurrentMapLocation(28);
                if(player.getMapPosX() >= 390 && player.getMapPosX() < 560){
                    player.setMapPosX(380);
                }
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(33);
                flicker = false;
                return true;
            case 4:
                //going left
                player.setCurrentMapLocation(19);
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

