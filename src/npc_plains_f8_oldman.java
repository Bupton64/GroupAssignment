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
        moveAmount = 300;
    }
    double moveAmount;
    @Override
    public void setUpCollision(Collision collisionDetector,extraFunctions map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }


    public void npcAction(double dt){
            setMoveTimer(getMoveTimer() + dt);

            if(getMoveTimer() > getMoveDuration()){
                setMapPos(getMapPosX(),getMapPosY() + (2 * dt));
                if(getMapPosY() > moveAmount){
                    setMoveTimer(0);
                }
            }

    }

    public void drawConvo(Graphics2D g, String playerName){
        super.drawConvo(g,playerName);
        drawText(110,450,"I'm Julian, the oldest NPC... uh I mean villager in this Town.", "Times New Roman",20,g);
    }








}




