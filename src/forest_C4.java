


public class forest_C4 extends extraFunctions {



    int direction;
    boolean flicker;
    forest_C4() {
        backgroundImage = loadImage("forest_C4.png");
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
                player.setCurrentMapLocation(7);
                flicker = false;
                return true;
            case 2:
                player.setCurrentMapLocation(9);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(15);
                flicker = false;
                return true;
            case 4:
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

        collisionPoints.addBoxCollision(0, 29, 79, 5, flicker);
        collisionPoints.addBoxCollision(0, 9, 79, 5, flicker);
        for (int i = 0; i <60; i ++) {
            collisionPoints.addSmallCollisionPoint(2, i, flicker);
        }


    }
}