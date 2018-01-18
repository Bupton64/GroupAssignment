import java.awt.*;
import java.awt.event.*;

public class plains_E8 extends  Map {




    plains_E8() {
        direction = 0; //< DONT CHANGE
        flicker = true; //< DONT CHANGE

        backgroundImage = loadImage("plains_E8.png");

    }



    @Override
    public boolean updateMapMovement(Collision collisionPoints, Character player) {
        direction = collisionPoints.edgeCheck(player);
        switch (direction) {
            case 0:
                //do nothing
                break;
            case 1:
                //going up
                // mapnum = 1 higher
                player.setCurrentMapLocation(19);
                flicker = false;
                return true;
            case 2:
                //going down
                player.setCurrentMapLocation(21);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(28);
                flicker = false;
                return true;
            case 4:
                //going left

                player.setCurrentMapLocation(12);
                flicker = false;
                return true;
        }
        if(player.getMapPosX() < 610 && player.getMapPosX() > 570 && player.getMapPosY() > 200 && player.getMapPosY() < 230){
            player.setCurrentMapLocation(46);
            flicker = false;
            player.setMapPosX(380);
            player.setMapPosY(360);
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

        collisionPoints.addBoxCollision(2,2,34,15,flicker);
        collisionPoints.addSmallCollisionPoint(5,1,flicker);
        collisionPoints.addSmallCollisionPoint(33,1,flicker);


        //lake
        collisionPoints.addCollisionPoint(172,flicker);
        collisionPoints.addCollisionPoint(175,flicker);
        collisionPoints.addCollisionPoint(174,flicker);
        for(int i = 53; i < 79; i++){
            collisionPoints.addSmallCollisionPoint(i,55,flicker);
        }
        collisionPoints.addSmallCollisionPoint(69,50,flicker);
        collisionPoints.addSmallCollisionPoint(68,50,flicker);
        collisionPoints.addSmallCollisionPoint(67,50,flicker);
        for(int i = 62,j = 54;i  < 66;i++,j--){
            collisionPoints.addSmallCollisionPoint(i,j,flicker);
            collisionPoints.addSmallCollisionPoint(i+1,j,flicker);
        }


        //tree
        collisionPoints.addSmallCollisionPoint(44,10,flicker);
        collisionPoints.addSmallCollisionPoint(50,10,flicker);
        collisionPoints.addCollisionPoint(74,flicker);
        collisionPoints.addCollisionPoint(57,flicker);
        collisionPoints.addCollisionPoint(58,flicker);
        collisionPoints.addCollisionPoint(59,flicker);
        collisionPoints.addCollisionPoint(42,flicker);
        for(int i = 48; i <= 56; i++){
            collisionPoints.addSmallCollisionPoint(i,27,flicker);
        }
        for(int i = 24; i <= 27; i++){
            collisionPoints.addSmallCollisionPoint(55,i,flicker);
            collisionPoints.addSmallCollisionPoint(50,i,flicker);
        }
        collisionPoints.addSmallCollisionPoint(45,21,flicker);
        collisionPoints.addSmallCollisionPoint(46,22,flicker);
        collisionPoints.addSmallCollisionPoint(47,23,flicker);
        collisionPoints.addSmallCollisionPoint(55,24,flicker);
        collisionPoints.addSmallCollisionPoint(56,23,flicker);
        collisionPoints.addSmallCollisionPoint(57,22,flicker);
        collisionPoints.addSmallCollisionPoint(58,21,flicker);
        collisionPoints.addSmallCollisionPoint(58,21,flicker);
        collisionPoints.addSmallCollisionPoint(59,20,flicker);
        collisionPoints.addSmallCollisionPoint(59,14,flicker);
        collisionPoints.addSmallCollisionPoint(59,14,flicker);
        collisionPoints.addSmallCollisionPoint(58,13,flicker);
        collisionPoints.addSmallCollisionPoint(57,12,flicker);
        collisionPoints.addSmallCollisionPoint(56,11,flicker);
        collisionPoints.addSmallCollisionPoint(55,10,flicker);
        collisionPoints.addSmallCollisionPoint(49,10,flicker);
        collisionPoints.addSmallCollisionPoint(48,11,flicker);
        collisionPoints.addSmallCollisionPoint(47,12,flicker);
        collisionPoints.addSmallCollisionPoint(46,13,flicker);
        collisionPoints.addSmallCollisionPoint(45,14,flicker);
        collisionPoints.addSmallCollisionPoint(48,23,flicker);
        collisionPoints.addSmallCollisionPoint(49,24,flicker);
        collisionPoints.addSmallCollisionPoint(49,23,flicker);
        for(int i = 14; i <= 20; i++){
            collisionPoints.addSmallCollisionPoint(44,i,flicker);
        }

        //Graveyard
        for(int i = 6; i <= 29; i++) {
            collisionPoints.addSmallCollisionPoint(i, 47, flicker);
            collisionPoints.addSmallCollisionPoint(i, 25, flicker);
        }
        for(int i = 25; i <= 47; i++){
            collisionPoints.addSmallCollisionPoint(6,i,flicker);
            collisionPoints.addSmallCollisionPoint(29,i,flicker);
        }
        //Barrell
        collisionPoints.addSmallCollisionPoint(33,17,flicker);
        collisionPoints.addSmallCollisionPoint(33,18,flicker);
        collisionPoints.addSmallCollisionPoint(33,19,flicker);
        collisionPoints.addSmallCollisionPoint(34,19,flicker);
        collisionPoints.addSmallCollisionPoint(35,19,flicker);
        collisionPoints.addSmallCollisionPoint(36,19,flicker);
        collisionPoints.addSmallCollisionPoint(36,18,flicker);
        collisionPoints.addSmallCollisionPoint(36,17,flicker);

        //Sign
        collisionPoints.addSmallCollisionPoint(42,1,flicker);
        collisionPoints.addSmallCollisionPoint(43,1,flicker);
        collisionPoints.addSmallCollisionPoint(44,1,flicker);

        //Tree stump
        for(int i = 63; i <= 68; i++){
            collisionPoints.addSmallCollisionPoint(i,14,flicker);
        }
        collisionPoints.addSmallCollisionPoint(64,11,flicker);
        collisionPoints.addSmallCollisionPoint(65,11,flicker);
        collisionPoints.addSmallCollisionPoint(66,11,flicker);
        collisionPoints.addSmallCollisionPoint(64,13,flicker);
        collisionPoints.addSmallCollisionPoint(64,12,flicker);
        collisionPoints.addSmallCollisionPoint(67,13,flicker);
        collisionPoints.addSmallCollisionPoint(67,12,flicker);
    }
}

