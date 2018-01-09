import java.awt.*;
import java.awt.event.*;

public class plains_E12 extends  extraFunctions {



    int direction;

    plains_E12() {
        backgroundImage= loadImage("plains_path_vert3.png");
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
                player.setCurrentMapLocation(23);
                flicker = false;
                return true;
            case 2:
                //going down
                player.setCurrentMapLocation(25);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(32);
                flicker = false;
                return true;
            case 4:
                //going left
                player.setCurrentMapLocation(16);
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
		  for(int i = 0;i < 5;i++){
            collisionPoints.addSmallCollisionPoint(i,54,flicker);
        }
        for(int i = 55;i < 60;i++){
            collisionPoints.addSmallCollisionPoint(i,54,flicker);
        }

        


    }


}

