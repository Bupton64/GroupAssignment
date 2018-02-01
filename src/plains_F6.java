import java.awt.*;
import java.awt.event.*;

public class plains_F6 extends  Map{


    plains_F6() {
        backgroundImage= loadImage("Image/plains_tree_funnell_TR.png");
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
					 player.setMapPosX(player.getMapPosX()+500);
                flicker = false;
                return true;
            case 2:
                //going down
                player.setCurrentMapLocation(27);
                flicker = false;
                return true;
            case 3:
                // going right
                
					 return true;
            case 4:
                //going left
                player.setCurrentMapLocation(18);
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
		  collisionPoints.addCollisionPoint(174,flicker);
        collisionPoints.addCollisionPoint(175,flicker);
        for(int i = 66,j = 52;i > 15;i--,j--){
            collisionPoints.addSmallCollisionPoint(i,j,flicker);
            collisionPoints.addSmallCollisionPoint(i,j-1,flicker);
        }

        


    }


}

