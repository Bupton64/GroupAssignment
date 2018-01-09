
public class forest_B3 extends extraFunctions {

    int direction;
    boolean flicker;
    forest_B3() {
        backgroundImage = loadImage("forest_B3.png");
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
                //going up
                break;
            case 2:
                //going down
                player.setCurrentMapLocation(3);
                flicker = false;
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(7);
                flicker = false;
                return true;
            case 4:
                //going left
                //mapnum 1 left
                return true;
        }
        return false;
    }
    @Override
    public void setUpCollision(Collision collisionPoints) {
        ////////////////////////////////////////////////////////////
        ///
        /// Collision
        ///
        ///////////////////////////////////////////////////////////
        for (int i = 0; i <60; i ++) {
            collisionPoints.addSmallCollisionPoint(3, i, flicker);
        }
        for(int i = 0; i<80; i++){
            collisionPoints.addSmallCollisionPoint(i,0, flicker);
        }
        for(int i =4; i<100; i+=16){
            collisionPoints.addCollisionPoint(i, flicker);
        }
        for(int i =80; i<84; i++ ){
            collisionPoints.addCollisionPoint(i, flicker);
        }
        collisionPoints.addBoxCollision(38, 4, 5, 6, flicker);
        collisionPoints.addBoxCollision(62, 14, 5, 5, flicker);
        collisionPoints.addBoxCollision(48, 29, 5, 5, flicker);
        collisionPoints.addBoxCollision(8, 29, 5, 5, flicker);
        collisionPoints.addBoxCollision(46, 49, 33, 10, flicker);

    }
}