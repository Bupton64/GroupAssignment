
public class forest_C3 extends extraFunctions {

    int direction;
    boolean flicker;

    forest_C3() {
        backgroundImage = loadImage("forest_C3.png");
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
                player.setCurrentMapLocation(6);
                flicker = false;
                return true;
            case 2:
                player.setCurrentMapLocation(8);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(14);
                flicker = false;
                return true;
            case 4:
                player.setCurrentMapLocation(2);
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
        collisionPoints.addBoxCollision(7, 9, 25, 10,flicker);
        collisionPoints.addBoxCollision(27, 39, 25, 10,flicker);
        collisionPoints.addBoxCollision(0, 0, 3, 1,flicker);
        collisionPoints.addBoxCollision(73,0, 6, 18, flicker);
        collisionPoints.addBoxCollision(47,0, 32, 0, flicker);
        for(int i =0; i<6; i++) {
            collisionPoints.addSmallCollisionPoint(2, 49 + i, flicker);
        }
        for(int i =0; i<2; i++){
            collisionPoints.addSmallCollisionPoint(i, 49, flicker);
        }

    }
}