
public class forest_D1 extends extraFunctions {

    int direction;
    boolean flicker;

    forest_D1() {
        backgroundImage = loadImage("forest_D1.png");
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
                player.setCurrentMapLocation(13);
                flicker = false;
                return true;

            case 3:
                // going right
                player.setCurrentMapLocation(20);
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
        for(int i = 0; i<80; i++){
            collisionPoints.addSmallCollisionPoint(i,0, flicker);
        }
        for (int i = 0; i <60; i ++) {
            collisionPoints.addSmallCollisionPoint(2, i, flicker);
        }
        collisionPoints.addBoxCollision(17, 24, 40, 5,flicker);
        collisionPoints.addBoxCollision(0, 49, 13, 10,flicker);
        collisionPoints.addBoxCollision(32, 49, 20, 10,flicker);

    }
}