
public class forest_D8 extends extraFunctions {
    int direction;
    boolean flicker;

    forest_D8() {
        backgroundImage = loadImage("forest_D8.png");
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
                player.setCurrentMapLocation(18);
                flicker = false;
                return true;

            case 2:
                player.setCurrentMapLocation(20);
                flicker = false;
                return true;

            case 3:
                // going right
                player.setCurrentMapLocation(27);
                flicker = false;
                return true;

            case 4:
                player.setCurrentMapLocation(12);
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