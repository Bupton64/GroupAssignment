
public class forest_D4 extends extraFunctions {
    int direction;
    boolean flicker;

    forest_D4() {
        backgroundImage = loadImage("forest_D4.png");
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
                player.setCurrentMapLocation(14);
                flicker = false;
                return true;

            case 2:
                player.setCurrentMapLocation(16);
                flicker = false;
                return true;

            case 3:
                // going right
                player.setCurrentMapLocation(23);
                flicker = false;
                return true;

            case 4:
                player.setCurrentMapLocation(8);
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
        collisionPoints.addBoxCollision(32,0, 20, 59, flicker);
        collisionPoints.addBoxCollision(0, 29, 18, 5, flicker);
        collisionPoints.addBoxCollision(0, 9, 18, 5, flicker);


    }
}