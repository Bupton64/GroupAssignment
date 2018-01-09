
public class forest_E7 extends extraFunctions {
    int direction;
    boolean flicker;

    forest_E7() {
        backgroundImage = loadImage("forest_E7.png");
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
                player.setCurrentMapLocation(25);
                flicker = false;
                return true;

            case 2:
                player.setCurrentMapLocation(27);
                flicker = false;
                return true;

            case 3:
                // going right
                player.setCurrentMapLocation(32);
                flicker = false;
                return true;

            case 4:
                player.setCurrentMapLocation(18);
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