
public class forest_C5 extends extraFunctions {
    int direction;
    boolean flicker;
    forest_C5() {
        backgroundImage = loadImage("forest_C5.png");
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
                player.setCurrentMapLocation(8);
                flicker = false;
                return true;
            case 2:
                player.setCurrentMapLocation(10);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(16);
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
        collisionPoints.addBoxCollision(0, 3, 79, 5, flicker);
        for (int i = 0; i <60; i ++) {
            collisionPoints.addSmallCollisionPoint(2, i, flicker);
        }
        collisionPoints.addBoxCollision(22, 19, 5, 40, flicker);
        collisionPoints.addBoxCollision(22, 19, 57, 5, flicker);
        collisionPoints.addBoxCollision(62, 25, 15, 13, flicker);
        collisionPoints.addBoxCollision(62, 49, 15, 5, flicker);



    }
}