
public class forest_G5 extends extraFunctions {
    int direction;
    boolean flicker;

    forest_G5() {
        backgroundImage = loadImage("forest_G5.png");
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
                player.setCurrentMapLocation(35);
                flicker = false;
                return true;

            case 2:
                player.setCurrentMapLocation(37);
                flicker = false;
                return true;

            case 3:
                // going right
                player.setCurrentMapLocation(39);
                flicker = false;
                return true;

            case 4:
                player.setCurrentMapLocation(31);
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

    }
}