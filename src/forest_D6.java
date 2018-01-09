
public class forest_D6 extends extraFunctions {
    int direction;
    boolean flicker;

    forest_D6() {
        backgroundImage = loadImage("forest_D6.png");
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
                player.setCurrentMapLocation(16);
                flicker = false;
                return true;

            case 2:
                player.setCurrentMapLocation(18);
                flicker = false;
                return true;

            case 3:
                // going right
                player.setCurrentMapLocation(25);
                flicker = false;
                return true;

            case 4:
                player.setCurrentMapLocation(10);
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