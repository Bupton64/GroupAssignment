import java.awt.*;
import java.awt.event.*;

public class plains_D8 extends  Map {


    plains_D8() {
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
                player.setCurrentMapLocation(11);
                flicker = false;
                return true;
            case 2:
                //going down
                player.setCurrentMapLocation(13);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(20);
                flicker = false;
                return true;
            case 4:
                //going left
                player.setCurrentMapLocation(5);
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

