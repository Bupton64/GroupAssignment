import java.awt.*;
import java.awt.event.KeyEvent;

public class NPC extends extraFunctions{

    NPC(){
        this.height = 70;
        this.width = 50;
    }

    private String name; //< Name of the object
    private double mapPosX; //<  NPC map position X
    private double mapPosY; //< NPC map position Y
    private double height; //< NPC display height
    private double width; //< NPC display width


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getName(){
        return name;
    }

    public void setName(String x){
        this.name = x;
    }


    public void setMapPosX(double mapPosX) {
        this.mapPosX = mapPosX;
    }

    public void setMapPosY(double mapPosY) {
        this.mapPosY = mapPosY;
    }


    public double getMapPosX(){
        return mapPosX;
    }

    public double getMapPosY(){
        return mapPosY;
    }



    /////////////////////////////////////////
    ///
    ///  Collision
    ///
    //////////////////////////////////////////



    public void setUpCollision(Collision collisionDetector, Map map){

    }



    /////////////////////////////////////////
    ///
    ///  Movement
    ///
    //////////////////////////////////////////


    Image spriteSheet; //< Npc SpriteSheet
    Image sprite; //< npc standard sprite

    Image[] spriteUp; //< Images for Upward Movement
    Image[] spriteDown; //< Images for Downward Movement
    Image[] spriteRight; //< Images for Right Movement
    Image[] spriteLeft; //< Images for Left Movement

    enum Direction {up,down,left,right}; //Can be used for change in direction image
    Direction npcDirection;

    boolean npcRight,npcLeft, npcUp, npcDown; //< used to decide which directional animation to play

    double walkTimer; //<Timer for Animation
    double walkDuration; //<Duration between animations
    double moveTimer; //Timer for When to Move on route
    double moveDelay; //Duration between Route Traveling

    NpcLocation[] Location;


    int numOfLocations; //< Number of total locations on path
    int currentLocation; //Npc Current Location on travel Route
    double distanceT = 0;//< Distance traveled in current Route


    public double getMoveTimer() {
        return moveTimer;
    }

    public void setMoveTimer(double moveTimer) {
        this.moveTimer = moveTimer;
    }

    public double getMoveDelay() {
        return moveDelay;
    }

    public void setMoveDelay(double moveDelay) {
        this.moveDelay = moveDelay;
    }

    public void loadImages(){
//        spriteLeft = new Image[3];
////        spriteRight = new Image[3];
////        spriteUp = new Image[3];
////        spriteDown = new Image[3];
        walkTimer = 0;

        npcDown = false;
        npcUp = false;
        npcLeft = false;
        npcRight = false;
    }





    public void updateNpcMovement(double dt,Collision collisionDetector){
    }


    public boolean startMovement(double dt){

        distanceT += Location[currentLocation].getMoveSpeed() * dt;
        if(distanceT < Location[currentLocation].getDirectionLength()) {
            if (Location[currentLocation].getDirection() == "right") {
                setMapPosX(getMapPosX() + (Location[currentLocation].getMoveSpeed() * dt));
                npcRight = true;
            } else if (Location[currentLocation].getDirection() == "left") {
                setMapPosX(getMapPosX() - (Location[currentLocation].getMoveSpeed() * dt));
                npcLeft = true;
            } else if (Location[currentLocation].getDirection() == "up") {
                setMapPosY(getMapPosY() - (Location[currentLocation].getMoveSpeed() * dt));
                npcUp = true;
            } else if (Location[currentLocation].getDirection() == "down") {
                setMapPosY(getMapPosY() + (Location[currentLocation].getMoveSpeed() * dt));
                npcDown = true;
            }
        }
        walkTimer += dt;
        if (walkTimer > walkDuration) {
            walkTimer -= walkDuration;
        }

        if(distanceT >= Location[currentLocation].getDirectionLength()){
            npcLeft = false;
            npcRight = false;
            npcUp = false;
            npcDown = false;
            setMoveTimer(0);
            distanceT = 0;
            return true;
        }
        return false;

    }




    public void drawNpcMovement(Graphics g){

        if (npcLeft) {
            int j = getAnimationFrame(walkTimer, walkDuration, 3);
            drawImage(spriteLeft[j], getMapPosX(), getMapPosY(), 50, 70,g);
        } else if (npcRight) {
            int j = getAnimationFrame(walkTimer, walkDuration, 3);
            drawImage(spriteRight[j], getMapPosX(), getMapPosY(), 50, 70,g);
        }  else if (npcUp) {
            int j = getAnimationFrame(walkTimer, walkDuration, 3);
            drawImage(spriteUp[j], getMapPosX(), getMapPosY(), 50, 70,g);
        }  else if (npcDown) {
            int j = getAnimationFrame(walkTimer, walkDuration, 3);
            drawImage(spriteDown[j], getMapPosX(), getMapPosY(), 50, 70,g);
        } else {
            drawImage(sprite,getMapPosX(),getMapPosY(),50,70,g);
        }
    }

    /////////////////////////////////////////
    ///
    ///  Convo
    ///
    //////////////////////////////////////////



     public int updateConvo(){
        return 0;
     }


    public void drawConvo(Graphics2D g,String playerName, Quest.questState  state, String questName){
        changeColor(black, g);
        drawSolidRectangle(100,400,600,150,g);
        changeColor(Color.white,g);
        drawRectangle(100,400,600,150,10,g);
        drawText( 110,425,getName() + ": ","Times New Roman",20,g);
    }


    public boolean keyPressed(KeyEvent e){
        return false;
    }











}
