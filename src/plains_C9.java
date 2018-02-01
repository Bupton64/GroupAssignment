import java.awt.*;
import java.awt.event.*;

public class plains_C9 extends Map {


    plains_C9() {
        backgroundImage= loadImage("Image/plains_path_horiz2.png");
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
                player.setCurrentMapLocation(5);
                flicker = false;
                return true;
            case 2:
                //going down
                player.setCurrentMapLocation(7);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(13);
                flicker = false;
                return true;
            case 4:
                //going left
                player.setCurrentMapLocation(2);
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

