import java.awt.*;
import java.awt.event.*;


public class npc_plains_f8_oldman extends  NPC {

    npc_plains_f8_oldman(){
        setName("Julian");
        spriteSheet = loadImage("chara2.png");
        sprite = subImage(spriteSheet,364,288,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(28);
        setMapPos(200,200);
        setHostile(false);

        setMoveTimer(0);
        setMoveDelay(10);
        location = new double[2];
        setLocation(0,300);
        setLocation(1,200);
        loadImages();
        currentLocation =  1;
    }


    @Override
    public void loadImages(){
        super.loadImages();
        for(int i =0; i < 3;i++){
            spriteDown[i] = subImage(spriteSheet,312 + (52 * i), 288,52,72);
        }
        for(int i =0; i < 3;i++){
            spriteUp[i] = subImage(spriteSheet,312 + (52 * i), 504,52,72);
        }


        walkDuration = 0.32;
        npcDirection = Direction.down;

    }

    @Override
    public void setUpCollision(Collision collisionDetector,extraFunctions map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }


    public void updateCharMovement(double dt) {

        if (npcUp) {
            npcDirection = Direction.up;

            walkTimer += dt;
            if (walkTimer > walkDuration) {
                walkTimer -= walkDuration;
            };
        }
        if (npcDown) {
            npcDirection = Direction.down;

            walkTimer += dt;
            if (walkTimer > walkDuration) {

                walkTimer -= walkDuration;
            }
        }
    }


    public void npcAction(double dt,Collision collisionDetector){
            setMoveTimer(getMoveTimer() + dt);

            if(getMoveTimer() > getMoveDelay()){
                collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),false);
                if(currentLocation == 1) {
                    setMapPos(getMapPosX(), getMapPosY() + (20 * dt));
                    npcDown = true;
                    if (getMapPosY() > getLocation(0)) {
                        npcDown = false;
                        setMoveTimer(0);
                        currentLocation = 0;
                    }
                }else{
                    setMapPos(getMapPosX(), getMapPosY() - (20 * dt));
                    npcUp = true;
                    if (getMapPosY() < getLocation(1)) {
                        npcUp = false;
                        setMoveTimer(0);
                        currentLocation =1;
                    }
                }
                collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),true);
            }



    }

    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName){
        super.drawConvo(g, playerName,currentState, questName);
        drawText(110,450,"I'm Julian, the oldest NPC... uh I mean villager in this Town.", "Times New Roman",20,g);
    }



    public void drawNpcMovement(Graphics g){

      if (npcUp) {
            int j = getAnimationFrame(walkTimer, walkDuration, 3);
            drawImage(spriteUp[j], getMapPosX(), getMapPosY(), 50, 70,g);
        } else if (npcDown) {
            int j = getAnimationFrame(walkTimer, walkDuration, 3);
            drawImage(spriteDown[j], getMapPosX(), getMapPosY(), 50, 70,g);
        } else {
            drawImage(sprite,getMapPosX(),getMapPosY(),50,70,g);
        }
    }




}




