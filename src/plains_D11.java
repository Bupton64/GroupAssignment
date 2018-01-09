import java.awt.*;
import java.awt.event.*;

public class plains_D11 extends  extraFunctions {



    int direction;


    plains_D11() {
        backgroundImage= loadImage("plains_blank_variation2.png");
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
                player.setCurrentMapLocation(14);
                flicker = false;
                return true;
            case 2:
                //going down
                player.setCurrentMapLocation(16);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(23);
                flicker = false;
                return true;
            case 4:
                //going left
                player.setCurrentMapLocation(8);
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

