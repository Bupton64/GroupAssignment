

public class forest_C2 extends extraFunctions {

    int direction;
    boolean flicker;
    forest_C2() {
        backgroundImage = loadImage("forest_C2.png");
        direction = 0; //< DONT CHANGE
        flicker = true; //< DONT CHANGE
    }
    @Override
    public boolean updateMapMovement(Collision collisionPoints, Character player) {
        direction = collisionPoints.edgeCheck(player);
        switch (direction) {
            case 0:
                //do nothing
                break;
            case 1:
                return true;
            case 2:
                player.setCurrentMapLocation(7);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(13);
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
        collisionPoints.addBoxCollision(47, 0, 30, 59,flicker);
        collisionPoints.addBoxCollision(0, 23, 60, 10,flicker);
        for (int i = 0; i <60; i ++) {
            collisionPoints.addSmallCollisionPoint(2, i, flicker);
        }
        for(int i = 0; i<80; i++) {
            collisionPoints.addSmallCollisionPoint(i, 0, flicker);
        }


    }
}