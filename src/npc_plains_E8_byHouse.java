import java.awt.*;
import java.awt.event.*;


public class npc_plains_E8_byHouse extends  NPC {

    npc_plains_E8_byHouse( ){
        setName("Tim Burr");
        spriteSheet = loadImage("chara1.png");
        sprite = subImage(spriteSheet,52,288,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(20);
        setMapPos(80,180);
        setHostile(false);

        moveTimer = 0;
        moveDuration = 0.1;

        locationOne = 260;
        locationTwo = 80;
        moveDirection = 1;
    }

    @Override
    public void setUpCollision(Collision collisionDetector,extraFunctions map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }

    @Override
    public void npcAction(double dt,Collision collisionDetector){
        setMoveTimer(getMoveTimer() + dt);

        if(getMoveTimer() > getMoveDuration()){
            collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),false);
            if(moveDirection == 1) {
                setMapPos(getMapPosX() + (60 * dt), getMapPosY());
                if (getMapPosX() > locationOne) {
                    setMoveTimer(0);
                    moveDirection = 2;
                }
            }else{
                setMapPos(getMapPosX() - (60 * dt), getMapPosY());
                if (getMapPosX() < locationTwo) {
                    setMoveTimer(0);
                    moveDirection =1;
                }
            }
            collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),true);
        }

    }

    public void drawConvo(Graphics2D g, String playerName){
        super.drawConvo(g,playerName);
        drawText(110,450,"MY NAME'S NOT THAT FUNNY OK!? ", "Times New Roman",20,g);
    }



}
