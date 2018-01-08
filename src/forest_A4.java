
public class forest_A4 extends extraFunctions {

    int direction;
    boolean flicker;

    forest_A4() {
        backgroundImage = loadImage("forest_A4.png");
        direction = 0; //< DONT CHANGE
        flicker = true; //< DONT CHANGE
    }

    //Add your sprite sheets required here

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
                flicker = false;
                return true;
            case 2:
                //going down
                player.setCurrentMapLocation(1);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(3);
                flicker = false;
                return true;
            case 4:
                //going left
                //mapnum 1 left
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
    public void setUpCollision(Collision collisionPoints) {
        for (int i = 0; i < 60; i++) {
            collisionPoints.addSmallCollisionPoint(2, i, flicker);
        }
        for (int i = 0; i < 80; i++) {
            collisionPoints.addSmallCollisionPoint(i, 0, flicker);
        }
        collisionPoints.addBoxCollision(58, 0, 5, 29, flicker);
        collisionPoints.addBoxCollision(58, 14, 20, 15, flicker);
        collisionPoints.addBoxCollision(72, 49, 5, 10, flicker);
        for (int i = 0; i < 6; i++) {
            collisionPoints.addSmallCollisionPoint(75, 49 + i, flicker);
        }
        for (int i = 75; i < 80; i++) {
            collisionPoints.addSmallCollisionPoint(i, 49, flicker);
        }


        ////////////////////////////////////
        ///
        ///   Draw
        ///
        ////////////////////////////////////

        //Draws Bridge textures
    }
}


