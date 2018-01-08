
public class forest_F4 extends extraFunctions {
    int direction;
    boolean flicker;

    forest_F4() {
        backgroundImage = loadImage("forest_F4.png");
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
                player.setCurrentMapLocation(29);
                flicker = false;
                return true;

            case 2:
                player.setCurrentMapLocation(31);
                flicker = false;
                return true;

            case 3:
                // going right
                player.setCurrentMapLocation(35);
                flicker = false;
                return true;

            case 4:
                player.setCurrentMapLocation(23);
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