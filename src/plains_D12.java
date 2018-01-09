import java.awt.*;
import java.awt.event.*;

public class plains_D12 extends  extraFunctions {



    int direction;


    plains_D12() {
        backgroundImage= loadImage("plains_tree_funnell_BL3.png");
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
                player.setCurrentMapLocation(15);
                flicker = false;
                return true;
            case 2:
                //going down
                player.setCurrentMapLocation(25);
					 player.setMapPosX(player.getMapPosX()-500);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(24);
                flicker = false;
                return true;
            case 4:
                //going left
                
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
		  collisionPoints.addCollisionPoint(172,flicker);
        collisionPoints.addCollisionPoint(1,flicker);
        collisionPoints.addCollisionPoint(2,flicker);
        collisionPoints.addCollisionPoint(19,flicker);
        for(int i = 66,j = 54;i > 15;i--,j--){
            collisionPoints.addSmallCollisionPoint(i,j,flicker);
            collisionPoints.addSmallCollisionPoint(i,j-1,flicker);
        }


    }


}

