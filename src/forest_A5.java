public class forest_A5 extends extraFunctions {

    int direction;
    boolean flicker;

    forest_A5() {
        backgroundImage = loadImage("forest_A5.png");
        direction = 0; //< DONT CHANGE
        flicker = true; //< DONT CHANGE
    }
    @Override
    public boolean updateMapMovement(Collision collisionPoints, Character player) {
        direction = collisionPoints.edgeCheck(player);
        switch (direction) {
            case 0:
                //do nothing
                flicker = false;
                return true;
            case 1:
                //going up
                player.setCurrentMapLocation(0);
                flicker = false;
                return true;
            case 2:
                //going down
                return true;
            case 3:
                // going right
                player.setCurrentMapLocation(4);
                flicker = false;
                return true;
            case 4:
                //going left
                //mapnum 1 left
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
        for (int i = 0; i <60; i ++) {
           collisionPoints.addSmallCollisionPoint(2, i, flicker);
        }
       for(int i = 0; i<80; i++){
            collisionPoints.addSmallCollisionPoint(i,49, flicker);
        }
        collisionPoints.addBoxCollision(72, 0, 5, 55, flicker);

        ////////////////////////////////////
        ///
        ///   Draw
        ///
        ////////////////////////////////////

        //Draws Bridge textures
    }
}
