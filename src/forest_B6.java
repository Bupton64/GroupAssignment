
public class forest_B6 extends extraFunctions {

    int direction;
    boolean flicker;


    forest_B6() {
        backgroundImage = loadImage("forest_B6.png");
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
                player.setCurrentMapLocation(4);
                flicker = false;
                return true;
            case 2:
                //going down
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(10);
                flicker = false;
                return true;
            case 4:
                //going left
                player.setCurrentMapLocation(1);
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
        public void setUpCollision(Collision collisionPoints) {
        collisionPoints.addBoxCollision(47, 0, 32, 15,flicker);
        collisionPoints.addBoxCollision(47, 29, 32, 20,flicker);
        for (int i = 0; i <60; i ++) {
            collisionPoints.addSmallCollisionPoint(2, i, flicker);
        }
        for(int i = 0; i<80; i++) {
            collisionPoints.addSmallCollisionPoint(i, 49, flicker);
        }

    }
}