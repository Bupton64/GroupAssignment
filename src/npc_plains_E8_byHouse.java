import java.awt.*;
import java.awt.event.*;


public class npc_plains_E8_byHouse extends  NPC {

    npc_plains_E8_byHouse(){
        setName("Alyx");
        spriteSheet = loadImage("chara1.png");
        sprite = subImage(spriteSheet,52,288,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(20);
        setMapPos(80,180);
        setHostile(false);

        moveTimer = 0;
        moveDelay = 0.2;

        location = new double[2];
        setLocation(0,260);
        setLocation(1,80);
        loadImages();
        currentLocation= 1;
    }

    @Override
    public void loadImages(){
        super.loadImages();
        //Load Images here
        for(int i =0; i < 3;i++){
            spriteRight[i] = subImage(spriteSheet,0 + (52 * i), 432,52,72);
        }
        for(int i =0; i < 3;i++){
            spriteLeft[i] = subImage(spriteSheet,0 + (52 * i), 360,52,72);
        }


        walkDuration = 0.32;
        npcDirection = Direction.down;


    }

    @Override
    public void setUpCollision(Collision collisionDetector,extraFunctions map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }







    @Override
    public void updateNpcMovement(double dt,Collision collisionDetector){
        setMoveTimer(getMoveTimer() + dt);

        if(getMoveTimer() > getMoveDelay()){
            collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),false);
            if(currentLocation == 1) {
                setMapPos(getMapPosX() + (60 * dt), getMapPosY());
                npcRight = true;
                npcDirection = Direction.right;
                walkTimer += dt;
                if (walkTimer > walkDuration) {
                    walkTimer -= walkDuration;
                }
                if (getMapPosX() > getLocation(0)) {
                    npcRight = false;
                    setMoveTimer(0);
                    currentLocation= 0;
                }
            }else{
                setMapPos(getMapPosX() - (60 * dt), getMapPosY());
                npcLeft = true;
                npcDirection = Direction.left;
                walkTimer += dt;
                if (walkTimer > walkDuration) {
                    walkTimer -= walkDuration;
                }
                if (getMapPosX() < getLocation(1)) {
                    npcLeft = false;
                    setMoveTimer(0);
                    currentLocation = 1;
                }
            }
            collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),true);
        }

    }

    public void drawNpcMovement(Graphics g){

        if (npcLeft) {
            int j = getAnimationFrame(walkTimer, walkDuration, 3);
            drawImage(spriteLeft[j], getMapPosX(), getMapPosY(), 50, 70,g);
        } else if (npcRight) {
            int j = getAnimationFrame(walkTimer, walkDuration, 3);
            drawImage(spriteRight[j], getMapPosX(), getMapPosY(), 50, 70,g);
        } else {
            drawImage(sprite,getMapPosX(),getMapPosY(),50,70,g);
        }
    }

    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName){
        super.drawConvo(g, playerName,currentState, questName);
        drawText(110,450,"My business is ruined! I can't get any new supplies from the city", "Times New Roman",20,g);
        drawText(110,475,"now that Sevar has boxed us in!", "Times New Roman",20,g);
    }



}
