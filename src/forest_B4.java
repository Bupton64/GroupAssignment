public class forest_B4 extends extraFunctions {
    int direction;
    boolean flicker;

    forest_B4() {
        backgroundImage = loadImage("forest_B4.png");
        direction = 0; //< DONT CHANGE
        flicker = true; //< DONT CHANGE
    }
    @Override
    public boolean updateMapMovement(Collision collisionPoints, Character player) {
        direction = collisionPoints.edgeCheck(player);
        switch (direction) {
            case 0:
                //do nothing
               return true;
            case 1:
                //going up
                player.setCurrentMapLocation(2);
                flicker = false;
                return true;
            case 2:
                //going down
                player.setCurrentMapLocation(4);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(8);
                flicker = false;
                return true;
            case 4:
                //going left
                //mapnum 1 left
                player.setCurrentMapLocation(0);
                flicker = false;
                return true;
        }
        return false;
    }
    @Override
    public void setUpCollision(Collision collisionPoints) {
        ////////////////////////////////////////////////////////////
        ///
        /// Collision
        ///
        ///////////////////////////////////////////////////////////

        collisionPoints.addBoxCollision(0, 0, 3, 1,flicker);
        collisionPoints.addBoxCollision(47, 0, 30, 59,flicker);
        collisionPoints.addBoxCollision(0, 14, 50, 15,flicker);

        //collisionPoints.addBoxCollision(0, 50, 5, 5,flicker);
        for(int i =0; i<6; i++) {
            collisionPoints.addSmallCollisionPoint(2, 49 + i, flicker);
        }
        for(int i =0; i<2; i++){
            collisionPoints.addSmallCollisionPoint(i, 49, flicker);
        }

    }
}