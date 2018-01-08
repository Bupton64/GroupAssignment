
public class forest_E3 extends extraFunctions {
    int direction;
    boolean flicker;

    forest_E3() {
        backgroundImage = loadImage("forest_E3.png");
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
                player.setCurrentMapLocation(21);
                flicker = false;
                return true;

            case 2:
                player.setCurrentMapLocation(23);
                flicker = false;
                return true;

            case 3:
                // going right
                player.setCurrentMapLocation(30);
                flicker = false;
                return true;

            case 4:
                player.setCurrentMapLocation(14);
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