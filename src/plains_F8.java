import java.awt.*;
import java.awt.event.*;

public class plains_F8 extends  extraFunctions {



    int direction;



    plains_F8() {
        backgroundImage= loadImage("plains_F8.png");
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
                player.setCurrentMapLocation(27);
                flicker = false;
                return true;
            case 2:
                //going down
					 if (player.getMapPosX() < 300){
                      player.setMapPosX(player.getMapPosX() + 100);
                }
                player.setCurrentMapLocation(29);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(34);
                flicker = false;
                return true;
            case 4:
                //going left
               player.setCurrentMapLocation(20);
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
		  collisionPoints.addCollisionPoint(161,flicker);
        collisionPoints.addCollisionPoint(160,flicker);
        collisionPoints.addSmallCollisionPoint(10,52,flicker);
        collisionPoints.addSmallCollisionPoint(10,53,flicker);
        collisionPoints.addSmallCollisionPoint(11,53,flicker);
        collisionPoints.addSmallCollisionPoint(11,54,flicker);


        //House
        for(int i = 35; i < 49;i++){
            collisionPoints.addSmallCollisionPoint(52,i,flicker);
            collisionPoints.addSmallCollisionPoint(69,i,flicker);
        }

        for(int i = 52; i < 69;i++){
            collisionPoints.addSmallCollisionPoint(i,49,flicker);
            collisionPoints.addSmallCollisionPoint(i,34,flicker);
        }
        for(int i = 56; i < 64;i++){
            collisionPoints.addSmallCollisionPoint(i,32,flicker);
        }
        for(int i = 58; i < 62;i++){
            collisionPoints.addSmallCollisionPoint(i,31,flicker);
        }
        collisionPoints.addSmallCollisionPoint(55,33,flicker);
        collisionPoints.addSmallCollisionPoint(56,33,flicker);
        collisionPoints.addSmallCollisionPoint(65,33,flicker);
        collisionPoints.addSmallCollisionPoint(64,32,flicker);

        //tree left
        collisionPoints.addSmallCollisionPoint(35,20,flicker);
        collisionPoints.addSmallCollisionPoint(29,20,flicker);
        collisionPoints.addCollisionPoint(70,flicker);
        collisionPoints.addCollisionPoint(53,flicker);
        collisionPoints.addCollisionPoint(54,flicker);
        collisionPoints.addCollisionPoint(55,flicker);
        collisionPoints.addCollisionPoint(37,flicker);
        collisionPoints.addCollisionPoint(38,flicker);


        //tree top
        collisionPoints.addSmallCollisionPoint(44,10,flicker);
        collisionPoints.addSmallCollisionPoint(50,10,flicker);
        collisionPoints.addCollisionPoint(41,flicker);
        collisionPoints.addCollisionPoint(25,flicker);
        collisionPoints.addCollisionPoint(26,flicker);
        collisionPoints.addCollisionPoint(8,flicker);
        collisionPoints.addCollisionPoint(9,flicker);
        collisionPoints.addCollisionPoint(10,flicker);
        collisionPoints.addSmallCollisionPoint(40,5,flicker);
        collisionPoints.addSmallCollisionPoint(40,6,flicker);
        collisionPoints.addSmallCollisionPoint(40,7,flicker);
        collisionPoints.addSmallCollisionPoint(40,8,flicker);
        collisionPoints.addSmallCollisionPoint(41,8,flicker);
        collisionPoints.addSmallCollisionPoint(42,9,flicker);
        collisionPoints.addSmallCollisionPoint(43,10,flicker);
        collisionPoints.addSmallCollisionPoint(27,9,flicker);
        collisionPoints.addSmallCollisionPoint(28,8,flicker);
        collisionPoints.addSmallCollisionPoint(29,8,flicker);
        collisionPoints.addSmallCollisionPoint(30,7,flicker);
        collisionPoints.addSmallCollisionPoint(31,7,flicker);
        collisionPoints.addSmallCollisionPoint(32,7,flicker);
        collisionPoints.addSmallCollisionPoint(33,7,flicker);
        collisionPoints.addSmallCollisionPoint(34,8,flicker);
        collisionPoints.addSmallCollisionPoint(35,8,flicker);
        collisionPoints.addSmallCollisionPoint(36,8,flicker);
        collisionPoints.addSmallCollisionPoint(36,9,flicker);
        collisionPoints.addSmallCollisionPoint(37,10,flicker);
        collisionPoints.addSmallCollisionPoint(37,11,flicker);
        collisionPoints.addSmallCollisionPoint(38,11,flicker);
        collisionPoints.addSmallCollisionPoint(38,12,flicker);
        collisionPoints.addSmallCollisionPoint(39,12,flicker);
        collisionPoints.addSmallCollisionPoint(39,13,flicker);
        collisionPoints.addSmallCollisionPoint(39,14,flicker);


        //tree right
        collisionPoints.addCollisionPoint(76,flicker);
        collisionPoints.addCollisionPoint(59,flicker);
        collisionPoints.addCollisionPoint(60,flicker);
        collisionPoints.addCollisionPoint(61,flicker);
        collisionPoints.addCollisionPoint(44,flicker);



        collisionPoints.addSmallCollisionPoint(56,20,flicker);
        collisionPoints.addSmallCollisionPoint(56,21,flicker);
        collisionPoints.addSmallCollisionPoint(56,22,flicker);
        collisionPoints.addSmallCollisionPoint(57,23,flicker);
        collisionPoints.addSmallCollisionPoint(58,23,flicker);

        collisionPoints.addSmallCollisionPoint(57,14,flicker);
        collisionPoints.addSmallCollisionPoint(57,13,flicker);
        collisionPoints.addSmallCollisionPoint(58,12,flicker);
        collisionPoints.addSmallCollisionPoint(59,11,flicker);

        collisionPoints.addSmallCollisionPoint(68,14,flicker);
        collisionPoints.addSmallCollisionPoint(67,13,flicker);
        collisionPoints.addSmallCollisionPoint(66,12,flicker);
        collisionPoints.addSmallCollisionPoint(65,12,flicker);
        collisionPoints.addSmallCollisionPoint(65,11,flicker);

        collisionPoints.addSmallCollisionPoint(69,20,flicker);
        collisionPoints.addSmallCollisionPoint(69,21,flicker);
        collisionPoints.addSmallCollisionPoint(68,22,flicker);
        collisionPoints.addSmallCollisionPoint(67,23,flicker);
        collisionPoints.addSmallCollisionPoint(66,23,flicker);
        collisionPoints.addSmallCollisionPoint(65,23,flicker);
        collisionPoints.addSmallCollisionPoint(59,23,flicker);

        //Extra Details
            //Bush Right
        collisionPoints.addSmallCollisionPoint(70,47,flicker);
        collisionPoints.addSmallCollisionPoint(70,48,flicker);
        collisionPoints.addSmallCollisionPoint(70,49,flicker);
        collisionPoints.addSmallCollisionPoint(70,50,flicker);
        collisionPoints.addSmallCollisionPoint(69,50,flicker);
        collisionPoints.addSmallCollisionPoint(68,50,flicker);
        collisionPoints.addSmallCollisionPoint(67,50,flicker);
        collisionPoints.addSmallCollisionPoint(66,50,flicker);

        //Bush Left
        for(int i = 26; i <= 31; i++) {
            collisionPoints.addSmallCollisionPoint(i, 25, flicker);
        }
        collisionPoints.addSmallCollisionPoint(25,24,flicker);
        collisionPoints.addSmallCollisionPoint(25,23,flicker);
        collisionPoints.addSmallCollisionPoint(25,23,flicker);
        collisionPoints.addSmallCollisionPoint(26,22,flicker);
        collisionPoints.addSmallCollisionPoint(27,22,flicker);
        collisionPoints.addSmallCollisionPoint(27,22,flicker);
        collisionPoints.addSmallCollisionPoint(28,22,flicker);
        collisionPoints.addSmallCollisionPoint(29,22,flicker);

        //Rocks
        for(int i = 32; i < 38; i++){
            collisionPoints.addSmallCollisionPoint(i,35,flicker);
        }
        collisionPoints.addSmallCollisionPoint(32,34,flicker);
        collisionPoints.addSmallCollisionPoint(32,33,flicker);
        collisionPoints.addSmallCollisionPoint(33,33,flicker);
        collisionPoints.addSmallCollisionPoint(34,33,flicker);
        collisionPoints.addSmallCollisionPoint(35,32,flicker);
        collisionPoints.addSmallCollisionPoint(36,32,flicker);
        collisionPoints.addSmallCollisionPoint(37,32,flicker);
        collisionPoints.addSmallCollisionPoint(38,33,flicker);
        collisionPoints.addSmallCollisionPoint(38,34,flicker);

        //Tree Fallen
        for(int i = 60; i <= 67; i++) {
            collisionPoints.addSmallCollisionPoint(i, 8, flicker);
            collisionPoints.addSmallCollisionPoint(i, 5, flicker);
        }
        collisionPoints.addSmallCollisionPoint(67,6,flicker);
        collisionPoints.addSmallCollisionPoint(67,7,flicker);
        collisionPoints.addSmallCollisionPoint(59,6,flicker);
        collisionPoints.addSmallCollisionPoint(59,7,flicker);

    }


}

