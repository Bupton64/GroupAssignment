
public class forest_C6 extends extraFunctions {


    int direction;
    boolean flicker;

    forest_C6() {
        backgroundImage = loadImage("forest_C6.png");
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
                player.setCurrentMapLocation(9);
                flicker = false;
                return true;
            case 2:
                player.setCurrentMapLocation(11);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(17);
                flicker = false;
                return true;
            case 4:
                player.setCurrentMapLocation(5);
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
        collisionPoints.addBoxCollision(0, 29, 17, 25, flicker);
        collisionPoints.addBoxCollision(0, 0, 2, 14, flicker);
        collisionPoints.addBoxCollision(22, 0, 5, 14, flicker);
        collisionPoints.addBoxCollision(62, 0, 17, 0, flicker);
        collisionPoints.addBoxCollision(27, 49, 80-28, 10, flicker);
        collisionPoints.addBoxCollision(27, 9, 80-28, 5, flicker);
        collisionPoints.addBoxCollision(57, 14, 5, 45, flicker);


    }
}