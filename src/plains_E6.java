import java.awt.*;
import java.awt.event.*;

public class plains_E6 extends Map {



    plains_E6() {
        backgroundImage= loadImage("Image/plains_path_vert.png");
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
                player.setCurrentMapLocation(17);
                if(player.getMapPosX() > 680){
                    player.setMapPosX(680);
                }
                if(player.getMapPosX() < 50){
                    player.setMapPosX(50);
                }
                flicker = false;
                return true;
            case 2:
                //going down
                player.setCurrentMapLocation(19);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(26);
                flicker = false;
                return true;
            case 4:
                //going left
                player.setCurrentMapLocation(10);
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

