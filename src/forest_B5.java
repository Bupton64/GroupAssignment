public class forest_B5 extends extraFunctions {
    int direction;
    boolean flicker;

    forest_B5() {
        backgroundImage = loadImage("forest_B5.png");
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
                player.setCurrentMapLocation(3);
                flicker = false;
                return true;
            case 2:
                //going down
                player.setCurrentMapLocation(5);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(9);
                flicker = false;
                return true;
            case 4:
                //going left
                //mapnum 1 left
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

        collisionPoints.addBoxCollision(47, 0, 30, 59,flicker);
        for (int i = 0; i <60; i ++) {
            collisionPoints.addSmallCollisionPoint(2, i, flicker);
        }

    }
}