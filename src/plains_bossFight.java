import java.awt.*;
import java.awt.event.*;

public class plains_bossFight extends Map {


    plains_bossFight() {
        backgroundImage= loadImage("bossFight.png");
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
                break;
            case 2:
                break;
            case 3:
                // going right
                break;
            case 4:
                //going left

                break;
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

