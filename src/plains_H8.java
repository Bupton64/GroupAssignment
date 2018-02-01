import java.awt.*;
import java.awt.event.*;

public class plains_H8 extends Map {


    plains_H8() {
        backgroundImage= loadImage("Image/plains_tree_funnell_TR3.png");
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
                player.setCurrentMapLocation(33);
                player.setMapPosX(player.getMapPosX()+500);
                flicker = false;
                return true;
            case 2:
                //going down
                player.setCurrentMapLocation(39);
                if(player.getMapPosX() > 400 && player.getMapPosX() < 480){
                    player.setMapPosX(400);
                }
                if(player.getMapPosX() > 530 && player.getMapPosX() < 590){
                    player.setMapPosX(590);
                }
                flicker = false;
                return true;
            case 3:
                // going right

                return true;
            case 4:
                //going left
                player.setCurrentMapLocation(34);
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

