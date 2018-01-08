
public class forest_D2 extends extraFunctions {



    int direction;
    boolean flicker;

    forest_D2() {
        backgroundImage = loadImage("forest_D2.png");
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
                player.setCurrentMapLocation(12);
                flicker = false;
                return true;

            case 2:
                player.setCurrentMapLocation(14);
                flicker = false;
                return true;

            case 3:
                // going right
                player.setCurrentMapLocation(21);
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
        collisionPoints.addBoxCollision(0,0, 13, 59, flicker);
        collisionPoints.addBoxCollision(32,0, 20, 59, flicker);

    }
}