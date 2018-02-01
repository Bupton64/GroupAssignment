import java.awt.*;
import java.awt.event.*;

public class plains_B9 extends  Map{

    plains_B9() {
        backgroundImage= loadImage("Image/plains_path_horiz.png");
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
                if(player.getMapPosX()< 100){
                    player.setMapPosY(100);
                }
					 player.setCurrentMapLocation(1);
                flicker = false;
                return true;
            case 2:
                //going down
                if(player.getMapPosX() < 100){
                    player.setMapPosX(100);
                }
					 player.setCurrentMapLocation(3);
                flicker = false;
                return true;
            case 3:
                // going right
					 player.setCurrentMapLocation(6);
                flicker = false;
                return true;
            case 4:
                //going left
                player.setCurrentMapLocation(0);
                if(player.getMapPosY() < 40){
                    player.setMapPosY(40);
                }
                if(player.getMapPosY() > 440){
                    player.setMapPosY(440);
                }
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

