
public class forest_C7 extends extraFunctions {

    int direction;
    boolean flicker;

    forest_C7() {
        backgroundImage = loadImage("forest_C7.png");
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
                player.setCurrentMapLocation(10);
                flicker = false;
                return true;
            case 2:
                player.setCurrentMapLocation(12);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(18);
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
        for (int i = 0; i <60; i ++) {
            collisionPoints.addSmallCollisionPoint(2, i, flicker);
        }

        for(int i = 0; i<80; i++){
            collisionPoints.addSmallCollisionPoint(i,49, flicker);
        }

        for(int i = 0; i<60; i++){
            collisionPoints.addSmallCollisionPoint(72,i, flicker);
        }
        collisionPoints.addBoxCollision(27, 0, 80-28, 0, flicker);
        collisionPoints.addBoxCollision(0, 0, 17, 0, flicker);


    }
}