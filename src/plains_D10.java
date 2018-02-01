import java.awt.*;
import java.awt.event.*;

public class plains_D10 extends Map {


    plains_D10() {
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
                player.setCurrentMapLocation(13);
                flicker = false;
                return true;
            case 2:
                //going down
                player.setCurrentMapLocation(15);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(22);
                flicker = false;
                return true;
            case 4:
                //going left
                player.setCurrentMapLocation(7);
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

