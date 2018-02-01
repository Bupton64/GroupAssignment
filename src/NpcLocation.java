public class  NpcLocation {
    int locationNum;
    double locationPosX;
    double locationPosY;
    String direction;
    double directionLength;
    int nextLocation;
    double moveSpeed;


    NpcLocation(){

    }

    public void setUp(int LocationNum,double LocationPosX, double LocationPosY, String Direction,double DirectionLength, int NextLocation, int MoveSpeed){
        this.locationNum = LocationNum;
        this.locationPosX = LocationPosX;
        this.locationPosY = LocationPosY;
        this.direction = Direction;
        this.directionLength = DirectionLength;
        this.nextLocation = NextLocation;
        this.moveSpeed = MoveSpeed;
    }



    public double getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(double moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public int getLocationNum() {
        return locationNum;
    }

    public void setLocationNum(int locationNum) {
        this.locationNum = locationNum;
    }

    public double getLocationPosX() {
        return locationPosX;
    }

    public void setLocationPosX(double locationPosX) {
        this.locationPosX = locationPosX;
    }

    public double getLocationPosY() {
        return locationPosY;
    }

    public void setLocationPosY(double locationPosY) {
        this.locationPosY = locationPosY;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public double getDirectionLength() {
        return directionLength;
    }

    public void setDirectionLength(double directionLength) {
        this.directionLength = directionLength;
    }

    public int getNextLocation() {
        return nextLocation;
    }

    public void setNextLocation(int nextLocation) {
        this.nextLocation = nextLocation;
    }
}
