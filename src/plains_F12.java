import java.awt.*;
import java.awt.event.*;

public class plains_F12 extends  extraFunctions {



    int direction;


    plains_F12() {
        backgroundImage= loadImage("plains_tree_funnell_BR.png");
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
                player.setCurrentMapLocation(31);
                flicker = false;
                return true;
            case 2:
                //going down
                player.setCurrentMapLocation(25);
					 player.setMapPosX(player.getMapPosX()+500);
                flicker = false;
                return true;
            case 3:
                // going right
                
                return true;
            case 4:
                //going left
                player.setCurrentMapLocation(24);
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
		  collisionPoints.addCollisionPoint(14,flicker);
        collisionPoints.addCollisionPoint(15,flicker);
        collisionPoints.addCollisionPoint(28,flicker);
        collisionPoints.addCollisionPoint(29,flicker);
        collisionPoints.addCollisionPoint(30,flicker);
        collisionPoints.addCollisionPoint(31,flicker);
        collisionPoints.addCollisionPoint(164,flicker);

        for(int i = 20,j = 49;i  < 69;i++,j--){
            collisionPoints.addSmallCollisionPoint(i,j,flicker);
            collisionPoints.addSmallCollisionPoint(i+1,j,flicker);
        }

        


    }


}

