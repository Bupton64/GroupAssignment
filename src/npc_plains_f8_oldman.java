import java.awt.*;
import java.awt.event.*;


public class npc_plains_f8_oldman extends  NPC {

    npc_plains_f8_oldman( ){
        setName("Julian");
        spriteSheet = loadImage("chara2.png");
        sprite = subImage(spriteSheet,364,288,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(28);
        setMapPos(200,200);
        setHostile(false);
        setMoveTimer(0);
        setMoveDuration(10);
        locationOne = 300;
        locationTwo = 200;
        movedirection = 1;
    }
    double locationOne;
    double locationTwo;
    int movedirection;

    @Override
    public void setUpCollision(Collision collisionDetector,extraFunctions map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }


    public void npcAction(double dt,Collision collisionDetector){
            setMoveTimer(getMoveTimer() + dt);

            if(getMoveTimer() > getMoveDuration()){
                collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),false);
                if(movedirection == 1) {
                    setMapPos(getMapPosX(), getMapPosY() + (20 * dt));
                    if (getMapPosY() > locationOne) {
                        setMoveTimer(0);
                        movedirection = 2;
                    }
                }else{
                    setMapPos(getMapPosX(), getMapPosY() - (20 * dt));
                    if (getMapPosY() < locationTwo) {
                        setMoveTimer(0);
                        movedirection =1;
                    }
                }
                collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),true);
            }

    }

    public void drawConvo(Graphics2D g, String playerName){
        super.drawConvo(g,playerName);
        drawText(110,450,"I'm Julian, the oldest NPC... uh I mean villager in this Town.", "Times New Roman",20,g);
    }








}




