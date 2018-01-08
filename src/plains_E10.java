import java.awt.*;
import java.awt.event.*;

public class plains_E10 extends  extraFunctions {



    int direction;
    boolean flicker;


    plains_E10() {
        backgroundImage= loadImage("plains_path_vert.png");
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
                player.setCurrentMapLocation(21);
                flicker = false;
                return true;
            case 2:
                //going down
                player.setCurrentMapLocation(23);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(30);
                flicker = false;
                return true;
            case 4:
                //going left
                player.setCurrentMapLocation(14);
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

