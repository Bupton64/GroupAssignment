import java.awt.*;
import java.awt.event.*;

public class plains_E7 extends  Map {


    plains_E7() {
        backgroundImage= loadImage("plains_path_vert2.png");
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
                player.setCurrentMapLocation(18);
                flicker = false;
                return true;
            case 2:
                //going down
					 if(player.getMapPosX() < 400){
                    player.setMapPosX(400);
                }
                player.setCurrentMapLocation(20);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(27);
                flicker = false;
                return true;
            case 4:
                //going left
                player.setCurrentMapLocation(11);
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

