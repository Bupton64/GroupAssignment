
public class forest_F3 extends extraFunctions {
    int direction;
    boolean flicker;

    forest_F3() {
        backgroundImage = loadImage("forest_F3.png");
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
                player.setCurrentMapLocation(28);
                flicker = false;
                return true;

            case 2:
                player.setCurrentMapLocation(30);
                flicker = false;
                return true;

            case 3:
                // going right
                player.setCurrentMapLocation(34);
                flicker = false;
                return true;

            case 4:
                player.setCurrentMapLocation(22);
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