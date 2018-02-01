import java.awt.*;
import java.awt.event.*;

public class plains_B8 extends  Map{


    plains_B8() {
        backgroundImage= loadImage("Image/plains_tree_funnell_TL.png");
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
					 player.setCurrentMapLocation(4);
					 player.setMapPosX(player.getMapPosX()-500);
                flicker = false;
                return true;
            case 2:
                //going down
					 player.setCurrentMapLocation(2);
                flicker = false;
                return true;
            case 3:
                player.setCurrentMapLocation(5);
                
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
        collisionPoints.addCollisionPoint(160,flicker);
        collisionPoints.addCollisionPoint(161,flicker);
        for(int i = 10,j = 49;i  < 60;i++,j--){
            collisionPoints.addSmallCollisionPoint(i,j,flicker);
            collisionPoints.addSmallCollisionPoint(i+1,j,flicker);
        }


    }


}

